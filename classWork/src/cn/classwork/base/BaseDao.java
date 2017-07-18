package cn.classwork.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> extends Serializable {

	/***
	 * 保存
	 * @param entity
	 * @return
	 */
	T save(T entity) ;
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	void update(T entity);
	/**
	 * 删除
	 * @param id
	 */
	void deleteById(int id);
	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	T findById(int id);
	/**
	 * 查找全部
	 * @return
	 * @throws Exception 
	 */
	List<T> findAll() throws Exception;
}
