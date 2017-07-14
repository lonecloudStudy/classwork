package cn.classwork.test;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import cn.classwork.util.DBUtils;


public class DBUtilsTest {
	
	@Test
	public void DbTest() throws Exception{
		Connection connection = DBUtils.getConnection();
		Assert.assertNotNull(connection);
	}
}
