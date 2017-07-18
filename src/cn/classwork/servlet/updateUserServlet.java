package cn.classwork.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
@WebServlet("/updateInfo")
public class updateUserServlet extends BaseServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userService.updateUser(coverUpdateUser(request));
	}
	/**
	 * 整合user
	 * 
	 * @Description:
	 * @param request
	 * @return
	 */
	private User coverUpdateUser(HttpServletRequest request) {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setTel(request.getParameter("tel"));
		user.setNickname(request.getParameter("nickname"));
		user.setSex(request.getParameter("sex"));
		user.setQq(request.getParameter("qq"));
		user.setAddress(request.getParameter("address"));
		return user;
	}
}
