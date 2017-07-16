package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;

@WebServlet("register")
public class RegisterServlet extends BaseServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = coverUser(request);
		userService.saveUser(user);
	}
	/**
	 * 整合user
	 * @Description: 
	 * @param request
	 * @return
	 */
	private User coverUser(HttpServletRequest request){
		User user=new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setIdcard(request.getParameter("idcard"));
		user.setFullname(request.getParameter("fullname"));
		return user;
	}
}
