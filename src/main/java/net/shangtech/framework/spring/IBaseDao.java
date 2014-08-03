package net.shangtech.framework.spring;

import java.util.List;

public interface IBaseDao<T> {
	void insert(T entity);
	void delete(int id);
	void update(T entity);
	T find(int id);
	List<T> findAll(String orderBy);
	List<T> findAll();
	List<T> findAll(final int start, final int limit, String orderBy);
	List<T> findAll(final int start, final int limit);
	List<T> find(String hql, Object...values);
	T findUnique(String hql, Object...values);
	List<T> find(final int start, final int limit, String hql, final Object...values);
	Object gather(String queryString, Object...values);
	int countAll();
	int count(String hql, Object...values);
	void execute(String queryString, Object...values);
	List<Object> executeSql(final String sql, final Object...values);
}
