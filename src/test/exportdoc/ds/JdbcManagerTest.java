/**
 * 
 */
package com.huateng.plsql.exportdoc.ds;

import org.junit.Test;

/**
 * @author pansen
 *
 */
public class JdbcManagerTest {

	@Test
	public void testSql(){
		try {
			JdbcManager.executeSql("SELECT 1 FROM DUAL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
