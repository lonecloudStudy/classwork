package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
/**
 * 更新用户的信息
 * @Title: UpdateUserServlet.java
 * @Package cn.classwork.servlet
 * @date 2017年7月18日 下午6:47:55
 * @version V1.0
 */
@WebServlet("/updateUserInfo")
public class UpdateUserServlet extends BaseServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.updateUser(coverUpdateUser(request));
			JsonMsgUtils.successMsg("成功更新", response);
		} catch (Exception e) {
			JsonMsgUtils.errorMsg("系统错误", response);
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
