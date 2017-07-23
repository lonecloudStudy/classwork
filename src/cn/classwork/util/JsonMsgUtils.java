package cn.classwork.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.classwork.dto.JsonMessage;
/**
 * json操作工具类
 * @Title: JsonMsgUtils.java
 * @Package cn.classwork.util
 * @version V1.0
 */
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
		response.setContentType("text/json");
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
		response.setContentType("text/json");
		response.getWriter().print(JSON.toJSONString(new JsonMessage(JsonMessage.ERROR,msg)));
	}
	public static void jsonData(Object object,HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.getWriter().print(JSON.toJSONString(object,SerializerFeature.WriteDateUseDateFormat));
	}
}
