package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.classwork.base.BaseServlet;
import cn.classwork.util.JsonMsgUtils;
@WebServlet("/getUser")
public class GetUserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object user = req.getSession().getAttribute("user");
		JsonMsgUtils.jsonData(user, resp);
	}
}
