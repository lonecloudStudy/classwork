package cn.classwork.base;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import cn.classwork.service.UserService;
import cn.classwork.service.impl.UserServiceImpl;
/**
 * 基础servlet类
 * @Title: BaseServlet.java
 * @Package cn.classwork.base
 * @version V1.0
 */
public class BaseServlet extends HttpServlet {//继承与HttpServlet

	protected UserService userService = new UserServiceImpl();
	/**
	 * 进行数据的封装
	 * @Description: 有对象
	 * @param clazz
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected <T> T coverObj(Class<T> clazz, HttpServletRequest request) throws Exception {
		T t = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals("serialVersionUID")) {
				continue;
			}
			field.setAccessible(true);
			String str = request.getParameter(field.getName());
			if (str != null&&!str.trim().equals("")) {
				if (field.getName().equals("id")) {
					field.set(t, Integer.parseInt(str));
				} else {
					field.set(t, request.getParameter(field.getName()));
				}
			}

		}
		return t;
	}
}
