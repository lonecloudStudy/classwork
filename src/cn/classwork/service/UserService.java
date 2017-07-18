package cn.classwork.service;

import java.sql.SQLException;
import java.util.List;

import cn.classwork.entity.User;

public interface UserService{
	

	boolean checkType(String type, String value) throws SQLException;

	void saveUser(User user);

	User checkLogin(String username, String password) throws Exception;

	User updateUser(User user);

	List<User> findAllUser() throws Exception;

}
