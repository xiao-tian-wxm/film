package gec.dao.Impl;

import gec.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected Class getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Serializable save(T entity) {
		return this.getCurrentSession().save(entity);

	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delete(T entity) {
		try {
			this.getCurrentSession().delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean update(T entity) {
		try {
			this.getCurrentSession().update(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override //实例查询
	public List<T> find(T condition) {
		Criteria criteria = this.getCurrentSession().createCriteria(getEntityClass());
		//该查询方式,是通过实例查询,如果实例中有属性值,会根据对应的属性值添加条件
		criteria.add(Example.create(condition));
		return criteria.list();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public T findById(Integer id) {
		T load = (T) this.getCurrentSession().get(getEntityClass(), id);
		return load;
	}
	
//	public T get(Class<T> entityClass, Serializable id) {
//		T ret = (T) this.getCurrentSession().get(entityClass, id);
//		return ret;
//	}

	/**
	 * <根据HQL语句查找唯一实体>
	 * 
	 * @param hqlString
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询实体
	 *      Object[])
	 */
	@Transactional(readOnly=true)
	@Override  //  "from Auction a a.name=? and a.xxx=?"  
	public T getByHQL(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);  //设置占位符
			}
		}
		T t = (T) query.uniqueResult();
		return t;
	}

	/**
	 * <根据HQL语句，得到对应的list>
	 * 
	 * @param hqlString
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询多个实体的List集合
	 *      Object[])
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<T> getListByHQL(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override //单值查询
	public Object uniqueResult(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.uniqueResult();
	}
}
