package cn.classwork.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.classwork.base.BaseService;
import cn.classwork.entity.User;
import cn.classwork.service.UserService;

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
	public User updateUser(User user) {
		// 查询数据库中数据
		User user2 = userDao.findById(user.getId());
		if (user2 != null) {
			User coverupdateUser = coverupdateUser(user, user2);
			userDao.update(coverupdateUser);
			return coverupdateUser;
		}
		return user2;
	}

	private User coverupdateUser(User source, User target) {
		if (source != null && target != null) {
			// 判断电话不为空
			if (source.getTel() != null && target.getTel() != null && source.getTel().equals(target.getTel())) {
				// 设置新的电话号码
				source.setTel(target.getTel());
			}
			// 判断昵称不为空
			if (source.getNickname() != null && target.getNickname() != null
					&& source.getNickname().equals(target.getNickname())) {
				// 设置新的昵称
				source.setNickname(target.getNickname());
			}
			// 判断性别不为空
			if (target.getSex() != null) {
				if (source.getSex() != null && source.getSex().equals(target.getSex())) {
					// 设置新的性别
					source.setSex(target.getSex());
				}
			}
			// 判断qq不为空
			if (target.getQq() != null) {
				if (source.getQq() != null && source.getQq().equals(target.getQq())) {
					// 设置新的qq号码
					source.setQq(target.getQq());
				}
			}
			// 判断地址不为空
			if (target.getAddress() != null) {
				if (source.getAddress() != null && source.getAddress().equals(target.getAddress())) {
					// 设置新的地址
					source.setAddress(target.getAddress());
				}
			}
			// 判断电话不为空
			if (target.getPassword()!=null) {
				if (source.getPassword() != null && source.getPassword().equals(target.getPassword())) {
					// 设置新的电话号码
					source.setPassword(target.getPassword());
				}
			}
		}
		return source;
	}

	@Override
	public List<User> findAllUser() throws Exception {
		return userDao.findAll();
	}

}
