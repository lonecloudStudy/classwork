package cn.classwork.service;

import java.sql.SQLException;
import java.util.List;

import cn.classwork.entity.User;

public interface UserService{
	
	/**
	 * 根据类型校验用户
	 * @Description: 
	 * @param type
	 * @param value
	 * @return
	 * @throws SQLException
	 */
	boolean checkType(String type, String value) throws SQLException;
	/**
	 * 保存用户
	 * @Description: 
	 * @param user
	 */
	void saveUser(User user);
	/**
	 * 登录校验
	 * @Description: 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	User checkLogin(String username, String password) throws Exception;
	/**
	 * 更新用户
	 * @Description: 
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	User updateUser(User user) throws Exception;
	/**
	 * 查找用户
	 * @Description: 
	 * @return
	 * @throws Exception
	 */
	List<User> findAllUser() throws Exception;
	/**
	 * 删除用户
	 * @Description: 
	 * @param idStr
	 */
	void deleteUserById(String idStr);
	/**
	 * 添加新用户
	 * @Description: 
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 更新密码
	 * @Description: 
	 * @param pwd
	 */
	void updatePwd(String pwd);

}
