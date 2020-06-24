package gec.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	public Serializable save(T entity);

	public boolean delete(T entity);

	public boolean update(T entity);
	
	public List<T> find(T condition);
	
	public T findById(Integer id);

	// param... 可变参数 , 相当于 object[]    getByHQL("from Emp","jack","clerk",1000)
	// 返回单个对象（封装当前类别 ）
	// select e from Emp e where e.ename like ? and e.job=?
	// new Object[]{"%A%","CLERK"}
	// select e from Emp e
	// JDBCUTIL.executeQuery(String sql,Object[] args);
	public T getByHQL(String hqlString, Object... values);

	public List<T> getListByHQL(String hqlString, Object... values);
	//单值查询   select count()
	public Object uniqueResult(String sqlString, Object... values);
}
