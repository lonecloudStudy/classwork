package cn.classwork.service;

import java.sql.SQLException;

public interface UserService{
	

	boolean checkType(String type, String value) throws SQLException;

}
