package cn.classwork.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils {

	private static final String PREFIX = "/WEB-INF/pages";

	/**
	 * 请求转发
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void forwardUrl(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		System.out.println(url);
		String urlx = PREFIX + url;
		request.getRequestDispatcher(urlx).forward(request, response);
	}
}
