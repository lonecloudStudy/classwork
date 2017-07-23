package cn.classwork.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.classwork.base.BaseService;
import cn.classwork.entity.User;
import cn.classwork.service.UserService;
/**
 * 用户服务实现层
 * @Title: UserServiceImpl.java
 * @Package cn.classwork.service.impl
 * @version V1.0
 */
public class UserServiceImpl extends BaseService implements UserService {

	@Override
	public boolean checkType(String type, String value) throws SQLException {
		switch (type) {
		case "username":
			return userDao.checkUser(value);
		default:
			break;
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public User checkLogin(String username, String password) throws Exception {
		return userDao.checkLogin(username, password);
	}

	@Override
	public User updateUser(User user) throws Exception {
		// 查询数据库中数据
		User user2 = userDao.findById(user.getId());
		if (user2 != null) {
			User coverupdateUser = coverupdateUser(user2, user);
			userDao.update(coverupdateUser);
			return coverupdateUser;
		}
		return user2;
	}

	private User coverupdateUser(User source, User target) {
		if (source != null && target != null) {
			// 判断电话不为空
			if (target.getTel() != null) {
				// 设置新的电话号码
				source.setTel(target.getTel());
			}
			// 判断昵称不为空
			if (target.getNickname() != null) {
				// 设置新的昵称
				source.setNickname(target.getNickname());
			}
			// 判断性别不为空
			if (target.getSex() != null) {
				// 设置新的性别
				source.setSex(target.getSex());
			}
			// 判断qq不为空
			if (target.getQq() != null) {
				// 设置新的qq号码
				source.setQq(target.getQq());
			}
			// 判断地址不为空
			if (target.getAddress() != null) {
				// 设置新的地址
				source.setAddress(target.getAddress());
			}
			// 判断密码不为空
			if (target.getPassword() != null) {
				// 设置新的密码
				source.setPassword(target.getPassword());
			}
			// 判断邮箱不为空
			if (target.getEmail() != null) {
				// 设置新的邮
				source.setEmail(target.getEmail());
			}
			// 判断真实名字不为空
			if (target.getEmail() != null) {
				// 设置新的真实名字
				source.setFullname(target.getFullname());
			}
			// 判断真实名字不为空
			if (target.getUsername() != null) {
				// 设置新的真实名字
				source.setUsername(target.getUsername());
			}
			// 判断真实名字不为空
			if (target.getNickname() != null) {
				// 设置新的真实名字
				source.setNickname(target.getNickname());
			}
		}
		return source;
	}

	@Override
	public List<User> findAllUser() throws Exception {
		return userDao.findAll();
	}

	@Override
	public void deleteUserById(String idStr) {
		if (idStr != null) {
			int id = Integer.parseInt(idStr);
			userDao.deleteById(id);
		}

	}

	@Override
	public void addUser(User user) {
		// 设置默认密码
		user.setPassword("123456");
		// 设置注册时间
		user.setRegistertime(new Date());
		// 设置登录时间
		user.setLogintime(new Date());
		userDao.addUser(user);
	}

	@Override
	public void updatePwd(int id, String pwd) {
		userDao.updatePwd(id, pwd);
	}

}
