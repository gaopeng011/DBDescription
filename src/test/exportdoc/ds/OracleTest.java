/**
 * 
 */
package com.huateng.plsql.exportdoc.ds;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.huateng.plsql.exportdoc.model.Index;
import com.huateng.plsql.exportdoc.model.MysqlTable;
import com.huateng.plsql.exportdoc.model.TableDesc;

/**
 * Oracle信息获取测试
 * @author sam.pan
 *
 */
public class OracleTest {
	
	@Test
	public void testUserTable(){
		Mysql oracle = new Mysql();
		List<TableDesc> userTable = oracle.getUserTable();
		Assert.assertNotNull(userTable);
		
		System.err.println(userTable);
	}

	@Test
	public void testTable(){
		Mysql oracle = new Mysql();
		List<MysqlTable> table = oracle.getTable("sys_account");
		
		Assert.assertNotNull(table);
		
		System.err.println(Arrays.toString(table.toArray()));
	}
	
	
	@Test
	public void testIndex(){
		Mysql oracle = new Mysql();
		List<Index> index = oracle.getIndex("APM_T_PHISH_URL");
		
		Assert.assertNotNull(index);
		
		System.err.println(Arrays.toString(index.toArray()));
	}
}
