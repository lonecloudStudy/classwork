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
/**
 * 获取用户信息
 * @Title: GetUserServlet.java
 * @Package cn.classwork.servlet
 * @version V1.0
 */
//前台请求地址为getUser
@WebServlet("/getUser")
public class GetUserServlet extends BaseServlet {//继承的是BaseServlet(按住ctrl/alt会出现渐变效果)

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object user = req.getSession().getAttribute("user");//从session中获取用户
		JsonMsgUtils.jsonData(user, resp);//然后将用户数据进行封装
	}
}
