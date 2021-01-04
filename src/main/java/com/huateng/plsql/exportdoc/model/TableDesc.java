/**
 * 
 */
package com.huateng.plsql.exportdoc.model;

/**
 * 表格描述
 * @author sam.pan
 *
 */
public class TableDesc {
	private String tableNumber;//项目编号
	private String tableName;//表名
	private String comments;//描述
	private String classifyName;//分类 
	
	public String toString(){
		return "{" +tableName+ ","+comments+"}";
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	
}
