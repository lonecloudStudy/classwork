package cn.classwork.base;

import cn.classwork.dao.UserDao;
import cn.classwork.dao.impl.UserDaoImpl;
/**
 * 基础service
 * @Title: BaseService.java
 * @Package cn.classwork.base
 * @version V1.0
 */
public class BaseService{

	protected UserDao userDao=new UserDaoImpl();
}
