package cn.classwork.base;

import javax.servlet.http.HttpServlet;

import cn.classwork.service.UserService;
import cn.classwork.service.impl.UserServiceImpl;

public class BaseServlet extends HttpServlet {
	

	protected UserService userService=new UserServiceImpl();
	
}
