package cn.classwork.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.util.JsonMsgUtils;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			userService.deleteUserById(req.getParameter("id"));//删除用户
			JsonMsgUtils.successMsg("删除成功", resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JsonMsgUtils.errorMsg("删除失败", resp);
		}
	}
}
