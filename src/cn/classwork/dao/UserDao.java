package cn.classwork.dao;

import java.sql.SQLException;

import cn.classwork.base.BaseDao;
import cn.classwork.entity.User;
/**
 * 用户Dao层接口
 * @Title: UserDao.java
 * @Package cn.classwork.dao
 * @date 2017年7月19日 上午12:06:39
 * @version V1.0
 */
public interface UserDao extends BaseDao<User>{
	
	/**
	 * 返回true为有这个用户
	 * @Description: 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	boolean checkUser(String username) throws SQLException;
	/**
	 * 登录检查
	 * @Description: 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	User checkLogin(String username, String password) throws  Exception;
	/**
	 * 添加用户
	 * @Description: 
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 更新密码
	 * @Description: 
	 * @param id
	 * @param pwd
	 */
	void updatePwd(int id,String pwd);

}
