package cn.classwork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.dto.JsonMessage;
import cn.classwork.service.UserService;
import cn.classwork.util.JsonMsgUtils;
import cn.classwork.util.StringUtils;

@WebServlet("/checkUser")
public class checkServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取校验的名字
		String type=req.getParameter("type");
		String value=req.getParameter("value");
		if (StringUtils.isNotNullAndBlank(type)) {
			try {
				boolean checkType = userService.checkType(type,value);
				if (checkType==true) {
					JsonMsgUtils.errorMsg("该用户已经被注册", resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JsonMsgUtils.errorMsg("系统错误", resp);
			}
		}else{
			JsonMsgUtils.errorMsg("“输入错误", resp);
		}
	}
}
