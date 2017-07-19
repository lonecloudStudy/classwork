package cn.classwork.dto;
/**
 * json数据封装
 * @Title: JsonMessage.java
 * @Package cn.classwork.dto
 * @date 2017年7月19日 上午12:07:05
 * @version V1.0
 */
public class JsonMessage {
	
	public final static String SUCCESS="success";
	
	public final static String ERROR="error";
	
	public String  code;
	
	public String message;
	

	public JsonMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
