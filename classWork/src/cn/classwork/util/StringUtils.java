package cn.classwork.util;

public class StringUtils {
	/**
	 * 判断字符串是不是空或者空字符串
	 * @Description: 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrBlank(String str){
		return str==null||str.trim().equals("");
	}
	public static boolean isNotNullAndBlank(String str){
		return !isNullOrBlank(str);
	}
}
