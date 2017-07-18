package cn.classwork.base.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.classwork.base.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	Class<T> entityClass = null;

	public BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<T>) p[0];
		}
	}

	/**
	 * 装配Bean
	 * 
	 * @Description:
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	protected T coverUser(ResultSet resultSet) throws Exception {
		if (resultSet.next()) {
			return bulidObject(resultSet);
			
		}
		return null;
	}
	/**
	 * 将结果集组装成List
	 * @Description: 
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	protected List<T> coverAllUser(ResultSet resultSet) throws Exception {
		List<T> datas = new ArrayList<>();
		while (resultSet.next()) {
			datas.add(bulidObject(resultSet));
		}
		return datas;
	}

	private T bulidObject(ResultSet resultSet) throws Exception {
		T t = entityClass.newInstance();
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals("serialVersionUID")) {
				continue;
			}
			field.setAccessible(true);
			field.set(t, resultSet.getObject(field.getName()));
		}
		return t;
	}
}
