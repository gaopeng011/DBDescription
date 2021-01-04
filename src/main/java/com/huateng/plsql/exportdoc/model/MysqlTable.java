/**
 * 
 */
package com.huateng.plsql.exportdoc.model;

/**
 * 表
 * @author sam.pan
 *
 */
public class MysqlTable {
	private String tableName;//表名
	private String fieldName;//英文
	private String fieldDesc;//中文
	private String fieldType;//类型
	private String fieldCheck;//约束
	private String fieldValueDesc;//取值说明
	private String fieldUsedDesc;//使用说明
	
	
	public String toString(){
		return "{" + tableName + "," + fieldName + "," + fieldDesc + "," + fieldType + "," + fieldCheck + "," + fieldValueDesc + "," + fieldUsedDesc + "}";
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getFieldDesc() {
		return fieldDesc;
	}


	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}


	public String getFieldType() {
		return fieldType;
	}


	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}


	public String getFieldCheck() {
		return fieldCheck;
	}


	public void setFieldCheck(String fieldCheck) {
		this.fieldCheck = fieldCheck;
	}


	public String getFieldValueDesc() {
		return fieldValueDesc;
	}


	public void setFieldValueDesc(String fieldValueDesc) {
		this.fieldValueDesc = fieldValueDesc;
	}


	public String getFieldUsedDesc() {
		return fieldUsedDesc;
	}


	public void setFieldUsedDesc(String fieldUsedDesc) {
		this.fieldUsedDesc = fieldUsedDesc;
	}
	
}
