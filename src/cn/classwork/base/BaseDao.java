package cn.classwork.base;

import java.io.Serializable;
import java.util.List;
/**
 * 基础的数据库DB操作接口
 * @Title: BaseDao.java
 * @Package cn.classwork.base
 * @version V1.0
 * @param <T>
 */
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
	 * @throws Exception 
	 */
	T findById(int id) throws Exception;
	/**
	 * 查找全部
	 * @return
	 * @throws Exception 
	 */
	List<T> findAll() throws Exception;
}
