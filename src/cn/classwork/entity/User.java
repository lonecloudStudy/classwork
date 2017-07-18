package cn.classwork.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", email=" + email + ", fullname=" + fullname + ", idcard=" + idcard + ", registertime="
				+ registertime + ", logintime=" + logintime + ", registerIp=" + registerIp + ", sex=" + sex
				+", address=" + address + ", qq=" + qq + ", tel=" + tel + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2890698071035784694L;

	private int id;//id
	
	private String username;//用户名字
	
	private String nickname;//用户名字
	
	private String password;//用户的密码
	
	private String email;//电子邮件
	
	private String fullname;
	
	private String idcard;
	
	private Date registertime;
	
	private Date logintime;
	
	private String registerIp;
	
	private String sex;//性别
	
	
	private String address;//地址
	
	private String qq;//QQ
	
	private String tel;//电话

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
