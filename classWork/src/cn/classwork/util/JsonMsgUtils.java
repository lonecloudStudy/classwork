package cn.classwork.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.classwork.dto.JsonMessage;

public class JsonMsgUtils {
	/**
	 * 返回成功消息
	 * @Description: 
	 * @param msg
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public static void successMsg(String msg,HttpServletResponse response) throws IOException{
		response.getWriter().print(JSON.toJSONString(new JsonMessage(JsonMessage.SUCCESS,msg)));
	}

	/**
	 * 返回失败的消息
	 * 
	 * @Description:
	 * @param msg
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public static void errorMsg(String msg,HttpServletResponse response) throws IOException {
		response.getWriter().print(JSON.toJSONString(new JsonMessage(JsonMessage.SUCCESS,msg)));
	}
}
