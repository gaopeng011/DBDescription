package com.huateng.plsql.exportdoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import com.huateng.plsql.exportdoc.ds.Mysql;
import com.huateng.plsql.exportdoc.model.MysqlTable;
import com.huateng.plsql.exportdoc.model.TableDesc;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Mysql mysql = new Mysql();
		List<TableDesc> tables = mysql.getGroupTable();
		File file = new File("E:\\work\\dbInfomation.doc");
		try {
			// 设置纸张大小
			Document document = new Document(PageSize.A4);
			
			RtfWriter2.getInstance(document, new FileOutputStream(file));
			document.open();
			// 三、检验数据 -标题
			String title3Content = "一、数据库表信息";
			document.add(TextFormat.formatTitle(title3Content));
			
			document.add(TextFormat.formatTitle("数据库表信息"));
			//表格
			Table table1 = TextFormat.creatTableCatalog();
			for (TableDesc tableDesc : tables) {
				table1.addCell(new Cell(tableDesc.getTableName()));
				table1.addCell(new Cell(tableDesc.getComments()));
				
			}
			document.add(table1);
			
			for (TableDesc tableDesc : tables) {
				document.add(TextFormat.formatTitle(tableDesc.getComments() + tableDesc.getTableName()));
				
				List<MysqlTable> tableinfo = mysql.getTable(tableDesc.getTableName());
				Table docTableInfo = TextFormat.creatTableInfo();
				for (MysqlTable tableDesc2 : tableinfo) {
					docTableInfo.addCell(new Cell(tableDesc2.getFieldName()));
					docTableInfo.addCell(new Cell(tableDesc2.getFieldDesc()));
					docTableInfo.addCell(new Cell(tableDesc2.getFieldType()));
					docTableInfo.addCell(new Cell(tableDesc2.getFieldCheck()));
				}
				document.add(docTableInfo);
			}
			
			
			document.close();
			// 得到输入流
			// wordFile = new ByteArrayInputStream(baos.toByteArray());
			// baos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("文件写入成功："+ file.getPath());
    }
    
    
}
