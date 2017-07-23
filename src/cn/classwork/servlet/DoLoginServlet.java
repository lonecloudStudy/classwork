package cn.classwork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
import cn.classwork.util.StringUtils;
/**
 * 校验登录
 * @Title: DoLoginServlet.java
 * @Package cn.classwork.servlet
 * @author lonecloud
 * @date 2017年7月18日 下午6:47:05
 * @version V1.0
 */
@WebServlet("/doLogin")
public class DoLoginServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");//获取参数
		String password = req.getParameter("password");
		if (!StringUtils.isAllNotNull(username, password)){//判断字符串为空
			JsonMsgUtils.errorMsg("用户名或者密码为空", resp);
		} else {
			try {
				User user = userService.checkLogin(username, password);//后台校验是否登录
				if (user == null) {
					JsonMsgUtils.errorMsg("该用户不存在或者密码错误", resp);
				} else {
					req.getSession().setAttribute("user", user);//将用户放入session中
					JsonMsgUtils.successMsg("登录成功", resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
				JsonMsgUtils.errorMsg("系统错误", resp);
			}
		}

	}
}
