package cn.classwork.service.impl;

import java.sql.SQLException;

import cn.classwork.base.BaseService;
import cn.classwork.entity.User;
import cn.classwork.service.UserService;

public class UserServiceImpl extends BaseService implements UserService{

	@Override
	public boolean checkType(String type,String value) throws SQLException {
		switch (type) {
		case "username":
			return userDao.checkUser(value);
		default:
			break;
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

}
