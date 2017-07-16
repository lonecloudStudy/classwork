package cn.classwork.service;

import java.sql.SQLException;

import cn.classwork.entity.User;

public interface UserService{
	

	boolean checkType(String type, String value) throws SQLException;

	void saveUser(User user);

}
