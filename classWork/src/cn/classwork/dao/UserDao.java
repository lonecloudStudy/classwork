package cn.classwork.dao;

import java.sql.SQLException;

import cn.classwork.base.BaseDao;
import cn.classwork.entity.User;

public interface UserDao extends BaseDao<User>{

	boolean checkUser(String username) throws SQLException;
}
