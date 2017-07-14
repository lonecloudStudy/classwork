package cn.classwork.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginName=" + loginName + ", sex=" + sex + ", registerTime="
				+ registerTime + ", address=" + address + ", tel=" + tel + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2890698071035784694L;

	private int id;//id
	
	private String name;//用户名字
	
	private String loginName;//用户的登录名
	
	private String password;//用户的密码
	
	private String sex;//性别
	
	private Date registerTime;//注册时间
	
	private String address;//地址
	
	private String tel;//电话

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
