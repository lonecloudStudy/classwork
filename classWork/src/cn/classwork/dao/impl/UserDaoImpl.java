package cn.classwork.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.classwork.dao.UserDao;
import cn.classwork.entity.User;
import cn.classwork.util.DBUtils;

public class UserDaoImpl implements UserDao {
	
	static final String TABLENAME="tbl_user";

	@Override
	public User save(User entity) {
		return null;
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
		String sql="select username from "+TABLENAME+"where username= ?";
		ResultSet resultSet = DBUtils.Query(sql, username);
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

}
