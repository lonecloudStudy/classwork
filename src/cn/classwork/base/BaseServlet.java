package cn.classwork.base;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import cn.classwork.service.UserService;
import cn.classwork.service.impl.UserServiceImpl;

public class BaseServlet extends HttpServlet {

	protected UserService userService = new UserServiceImpl();

	protected <T> T coverObj(Class<T> clazz, HttpServletRequest request) throws Exception {
		T t = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals("serialVersionUID")) {
				continue;
			}
			field.setAccessible(true);
			String str = request.getParameter(field.getName());
			if (str != null) {
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
