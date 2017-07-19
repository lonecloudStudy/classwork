package cn.classwork.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
/**
 * 管理员添加用户
 * @Title: AddUserServlet.java
 * @Package cn.classwork.servlet.admin
 * @date 2017年7月18日 下午5:28:49
 * @version V1.0
 */
@WebServlet("/addUser")
public class AddUserServlet extends BaseServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = coverObj(User.class, req);
			userService.addUser(user);
			JsonMsgUtils.successMsg("保存成功", resp);
		} catch (Exception e) {
			JsonMsgUtils.errorMsg("系统错误", resp);
			e.printStackTrace();
		}
	}
}
