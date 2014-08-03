package net.shangtech.framework.spring;

import java.util.List;

import net.shangtech.framework.Page;

public interface IBaseService<T> {
	void add(T entity);
	T find(int id);
	void delete(int id);
	void update(T entity);
	List<T> find();
	List<T> find(String hql, Object...values);
	Page<T> find(Page<T> page);
	List<T> find(String orderBy);
	List<T> find(int start, int limit, String hql, Object...values);
	Page<T> find(Page<T> page, String orderBy);
	T findUnique(String hql, Object...values);
	int count(String hql, Object...values);
	List<Object> executeSql(final String sql, final Object...values);
	Object gather(String queryString, Object...values);
}
