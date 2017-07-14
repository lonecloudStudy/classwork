package cn.classwork.dto;

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
