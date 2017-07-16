package cn.classwork.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.classwork.dao.UserDao;
import cn.classwork.entity.User;
import cn.classwork.util.DBUtils;

public class UserDaoImpl implements UserDao {

	static final String TABLENAME = " tbl_user ";

	@Override
	public User save(User entity) {
		String sql = "insert into " + TABLENAME + "(username,password,email,fullname,idcard,registertime,registerIp) values(?,?,?,?,?,?,?)";
		DBUtils.execute(sql, entity.getUsername(),entity.getPassword(),entity.getEmail(),entity.getIdcard(),entity.getRegistertime(),entity.getRegisterIp());
		return entity;
	}

	@Override
	public void update(User entity) {

	}

	@Override
	public void deleteById(int id) {

	}

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public boolean checkUser(String username) throws SQLException {
		String sql = "select username from " + TABLENAME + "where username = ?";
		System.out.println(sql);
		ResultSet resultSet = DBUtils.Query(sql, username);
		if (resultSet != null && resultSet.next()) {
			return true;
		}
		return false;
	}

}
