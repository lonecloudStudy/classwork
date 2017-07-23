package cn.classwork.util;
/**
 * String 工具类
 * @Title: StringUtils.java
 * @Package cn.classwork.util
 * @version V1.0
 */
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
	/**
	 * 判断是不是所有字符串为空
	 * @Description: 
	 * @param strings
	 * @return
	 */
	public static boolean isAllNotNull(String... strings){
		for (String string : strings) {
			if(isNullOrBlank(string)){
				return false;
			}
		}
		return true;
	}
}
