package cn.classwork.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
/**
 * 管理员更新用户信息
 * @Title: UpdateUserServlet.java
 * @Package cn.classwork.servlet.admin
 * @date 2017年7月18日 下午6:32:30
 * @version V1.0
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = coverObj(User.class, req);
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
