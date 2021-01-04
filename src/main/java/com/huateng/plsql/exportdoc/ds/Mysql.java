/**
 * 
 */
package com.huateng.plsql.exportdoc.ds;

import java.util.List;

import com.huateng.plsql.exportdoc.model.Index;
import com.huateng.plsql.exportdoc.model.MysqlTable;
import com.huateng.plsql.exportdoc.model.TableDesc;

/**
 * 获取Oracle的表相关信息
 * @author sam.pan
 *
 */
public class Mysql implements DBOperation{
	
	@Override
	public List<TableDesc> getGroupTable() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT TABLE_NAME as tableName,TABLE_COMMENT as comments,'Group','classifyName' FROM information_schema.TABLES WHERE table_schema='phonelive' ");
		
		return JdbcManager.queryForList(sql.toString(), null, new TableDescDao());
	}
	
	@Override
	public List<TableDesc> getUserTableBy(String classifyName) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT TABLE_NAME as tableName,TABLE_COMMENT as comments, 'classifyName' FROM information_schema.TABLES WHERE table_schema='phonelive' ");
		
		return JdbcManager.queryForList(sql.toString(), null, new TableDescDao());
	}
	
	@Override
	public List<TableDesc> getUserTable() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT TABLE_NAME as tableName,TABLE_COMMENT as comments, 'User', 'classifyName' FROM information_schema.TABLES WHERE table_schema='phonelive' ");
		
		return JdbcManager.queryForList(sql.toString(), null, new TableDescDao());
	}

	@Override
	public List<MysqlTable> getTable(String tableName) {
		StringBuilder sql = new StringBuilder(100);
		sql.append(" SELECT a.column_Name AS fieldName, a.column_comment AS fieldDesc,  ");
		sql.append(" a.COLUMN_TYPE AS fieldType, a.is_nullable AS fieldCheck ");
		sql.append(" FROM information_schema.COLUMNS a "); 
		sql.append(" WHERE a.table_schema = 'phonelive' AND a.table_name = ? "); 
		sql.append(" ORDER BY a.ordinal_position "); 

		return JdbcManager.queryForList(sql.toString(), new Object[]{tableName}, new TableDao());
	}

	@Override
	public List<Index> getIndex(String tableName) {
		StringBuilder sql = new StringBuilder(100);
		sql.append(" select a.TABLE_NAME AS tableName, ");
		sql.append(" a.column_comment AS indexName, ");
		sql.append(" a.column_Name AS columnName, ");
		sql.append(" CASE WHEN p.column_Name IS NULL THEN '' ELSE '主键' END AS indexType, ");
		sql.append(" CASE WHEN a.extra = 'auto_increment' THEN '自增' ELSE '' END AS indexCheck, ");
		sql.append(" '' as indexUsedDesc ");
		sql.append(" FROM information_schema.COLUMNS a ");
		sql.append(" LEFT JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE p ON a.table_schema = p.table_schema AND a.table_name = p.TABLE_NAME AND a.COLUMN_NAME = p.COLUMN_NAME AND p.constraint_name = 'PRIMARY' ");
		sql.append(" WHERE a.table_schema = 'phonelive' AND a.table_name = ? ");
		sql.append(" ORDER BY a.ordinal_position ");
		
		return JdbcManager.queryForList(sql.toString(), new Object[]{tableName}, new IndexDao());
	}
}
