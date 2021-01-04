/**
 * 
 */
package com.huateng.plsql.exportdoc.word;

import org.junit.Test;

import com.huateng.plsql.exportdoc.ds.Mysql;

/**
 * @author pansen
 *
 */
public class WordServiceTest {

	@Test
	public void testCreateWord(){
		WordService service = new WordService();
		service.setDbOperation(new Mysql());
//		service.setDbOperation(new Oracle());
		service.createWord();
	}
}
