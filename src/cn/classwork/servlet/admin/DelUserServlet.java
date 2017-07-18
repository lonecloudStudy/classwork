package cn.classwork.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
/**
 * 管理员删除用户
 * @Title: DelUserServlet.java
 * @Package cn.classwork.servlet.admin
 * @date 2017年7月18日 下午6:46:26
 * @version V1.0
 */
@WebServlet("/delUser")
public class DelUserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService.deleteUserById(req.getParameter("id"));
	}
}
