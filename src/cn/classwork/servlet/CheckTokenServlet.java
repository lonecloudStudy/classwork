package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.util.JsonMsgUtils;
/**
 * 查询用户是否登录
 * @Title: CheckOuthServlet.java
 * @Package cn.classwork.servlet
 * @author lonecloud
 * @date 2017年7月18日 下午2:55:29
 * @version V1.0
 */
@WebServlet("/checkToken")
public class CheckTokenServlet extends BaseServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object user = req.getSession().getAttribute("user");
		if (user!=null) {
			JsonMsgUtils.jsonData(user, resp);
		}else{
			JsonMsgUtils.errorMsg("用户未登录", resp);
		}
	}
}
