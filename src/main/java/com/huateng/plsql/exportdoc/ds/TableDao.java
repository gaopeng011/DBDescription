/**
 * 
 */
package com.huateng.plsql.exportdoc.ds;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import com.huateng.plsql.exportdoc.model.MysqlTable;

/**
 * 表格
 * @author sam.pan
 *
 */
public class TableDao extends AbstractDao<MysqlTable> {

	@Override
	public MysqlTable mapping(ResultSet rs) throws SQLException {
		MysqlTable table = new MysqlTable();
		table.setFieldName(rs.getString("fieldName"));
		String fieldDesc = rs.getString("fieldDesc");
		
		fieldDesc = StringUtils.replace(fieldDesc, "（", "(");
		fieldDesc = StringUtils.replace(fieldDesc, "）", ")");
		table.setFieldDesc(fieldDesc);
		table.setFieldType(rs.getString("fieldType"));
		table.setFieldCheck(rs.getString("fieldCheck"));
		return table;
	}
}
