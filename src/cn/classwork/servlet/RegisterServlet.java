package cn.classwork.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
/**
 * 注册界面servlet
 * @Title: RegisterServlet.java
 * @Package cn.classwork.servlet
 * @author lonecloud
 * @date 2017年7月23日 上午11:09:36
 * @version V1.0
 */
@WebServlet("/register")
public class RegisterServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");//获取参数
		try {
			if(username!=null&&userService.checkType("username", username)){//判断用户名是否被使用
				User user = coverUser(request);//封装用户
				try {
					userService.saveUser(user);//保存用户给数据库
					JsonMsgUtils.successMsg("注册成功", response);
				} catch (Exception e) {
					JsonMsgUtils.errorMsg("系统错误", response);
					e.printStackTrace();
				}
			}else{
				JsonMsgUtils.errorMsg("用户名不能为空", response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 整合user
	 * 
	 * @Description:
	 * @param request
	 * @return
	 */
	private User coverUser(HttpServletRequest request) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setIdcard(request.getParameter("idcard"));
		user.setFullname(request.getParameter("fullname"));
		user.setRegisterIp(request.getRemoteAddr());
		user.setRegistertime(new Date());
		user.setLogintime(new Date());
		return user;
	}
}
