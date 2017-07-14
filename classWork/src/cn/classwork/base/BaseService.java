package cn.classwork.base;

import cn.classwork.dao.UserDao;
import cn.classwork.dao.impl.UserDaoImpl;

public class BaseService{

	protected UserDao userDao=new UserDaoImpl();
}
