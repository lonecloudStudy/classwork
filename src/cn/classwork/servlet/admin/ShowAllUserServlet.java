package cn.classwork.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;

@WebServlet("/getAllUser")
public class ShowAllUserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<User> users = userService.findAllUser();
			JsonMsgUtils.jsonData(users, resp);
		} catch (Exception e) {
			JsonMsgUtils.errorMsg("系统错误", resp);
			e.printStackTrace();
		}
	}
}
