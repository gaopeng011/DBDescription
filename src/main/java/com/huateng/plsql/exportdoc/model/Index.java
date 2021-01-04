/**
 * 
 */
package com.huateng.plsql.exportdoc.model;

/**
 * 索引
 * @author sam.pan
 *
 */
public class Index {
	private String tableName;//表名
	private String indexName;//名称
	private String columnName;//字段名
	private String indexType;//类型
	private String indexCheck;//约束
	private String indexUsedDesc;//用途
	
	public String toString(){
		return "{" + tableName + "," + indexName + "," + columnName + "," + indexType + "," + indexCheck + "," + indexUsedDesc + "}";
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public String getIndexCheck() {
		return indexCheck;
	}

	public void setIndexCheck(String indexCheck) {
		this.indexCheck = indexCheck;
	}

	public String getIndexUsedDesc() {
		return indexUsedDesc;
	}

	public void setIndexUsedDesc(String indexUsedDesc) {
		this.indexUsedDesc = indexUsedDesc;
	}
	
}
