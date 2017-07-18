package cn.classwork.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.classwork.base.impl.BaseDaoImpl;
import cn.classwork.dao.UserDao;
import cn.classwork.entity.User;
import cn.classwork.util.DBUtils;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	static final String TABLENAME = " tbl_user ";

	@Override
	public User save(User entity) {
		String sql = "insert into " + TABLENAME
				+ "(username,password,email,fullname,idcard,registertime,registerIp) values(?,?,?,?,?,?,?)";
		DBUtils.execute(sql, entity.getUsername(), entity.getPassword(), entity.getEmail(), entity.getFullname(),
				entity.getIdcard(), entity.getRegistertime(), entity.getRegisterIp());
		return entity;
	}

	@Override
	public void update(User entity) {
		String sql = "update " + TABLENAME + "set " + "tel = ?, nickname= ?,sex =?,qq =?,address= ? where id = ?";
		DBUtils.execute(sql, entity.getTel(), entity.getNickname(),entity.getSex(), entity.getQq(), entity.getAddress(),
				entity.getId());
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from" + TABLENAME + "where id = ?";
		DBUtils.execute(sql, id);
	}

	@Override
	public User findById(int id) throws Exception {
		ResultSet resultSet = DBUtils.Query("select * from "+TABLENAME+"where id = ?", id);
		return coverUser(resultSet);
	}

	@Override
	public List<User> findAll() throws Exception {
		String sql = "select * from " + TABLENAME;
		ResultSet resultSet = DBUtils.Query(sql);
		return coverAllUser(resultSet);
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

	@Override
	public User checkLogin(String username, String password) throws Exception {
		String sql = "select * from " + TABLENAME + "where username = ? and password = ?";
		System.out.println(sql);
		ResultSet resultSet = DBUtils.Query(sql, username, password);
		if (resultSet != null && resultSet.next()) {
			return coverUser(resultSet);
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into " + TABLENAME
				+ "(username,password,email,fullname,idcard,registertime,registerIp,loginTime,tel,nickname,qq,sex,address) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtils.execute(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getFullname(),
				user.getIdcard(), user.getRegistertime(), user.getRegisterIp(),user.getLogintime(), user.getTel(), user.getNickname(),
				user.getQq(), user.getSex(), user.getAddress());
	}

}
