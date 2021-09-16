package com.toeiconline.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.toeiconline.common.constant.Constant;
import com.toeiconline.common.utils.HibernateUtis;
import com.toeiconline.dao.GenergicDao;

public class AbstractDao<ID extends Serializable , T> implements GenergicDao<ID, T> {
	
	private Class<T> persistenceClass;	//tên class
	public String getPersistenceClassName() {
		return persistenceClass.getSimpleName();
	}
	
	public AbstractDao() {
		this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return HibernateUtis.getSessionFactory().openSession();
	}
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		Transaction transaction= null;
		Session session = getSession();
		try {
			transaction = session.beginTransaction();
			StringBuilder sql= new StringBuilder("from ");
			sql.append(this.getPersistenceClassName());
			Query query = session.createQuery(sql.toString());
			list= query.list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public T update(T entity) {
		Transaction transaction= null;
		Session session= null;
		T result= null;
		try {
			session= getSession();
			transaction= session.beginTransaction();
			result= (T) session.merge(entity);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
		return result;
	}

	public void save(T entity) {
		Session session= null;
		Transaction transaction= null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			session.close();
			e.printStackTrace();
		}

	}

	public T findById(ID id) {
		T result=null;
		Session session= null;
		Transaction transaction= null;
		try {
			session= getSession();
			transaction= session.beginTransaction();
			result= (T) session.get(persistenceClass, id);
			if(result==null) {
				System.out.println("NOT FOUND"+id);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		return result;
	}

	public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
		Session session= null;
		Transaction transaction= null;
		List<T> results= null;
		Object count= 0;
		StringBuilder sql= new StringBuilder();
		StringBuilder sqlCount= new StringBuilder("select count(*) ");
		try {
			session = getSession();
			transaction= session.beginTransaction();
			sql.append("from ");
			sql.append(this.getPersistenceClassName());
			if(property!=null && value!=null) {
				sql.append(" where ").append(property).append(" = :value");
			}
			if(sortExpression != null && sortDirection!= null) {
				sql.append(" order by ").append(sortExpression);
				if(sortExpression.equals(Constant.SORT_ASC)) {
					sql.append(" asc");
				}else
					sql.append(" desc");
			}
			Query query1= session.createQuery(sql.toString());
			if(property!=null && value!=null) {
				query1.setParameter("value", value);
			}
			if(offset!=null && offset>=0) {
				query1.setFirstResult(offset);
			}
			if(limit!=null &&limit >0) {
				query1.setMaxResults(limit);
			}
			results = query1.list();
			count = results.size();
//			sqlCount.append(" from ").append(this.getPersistenceClassName());
//			if(property!=null && value!=null) {
//				sqlCount.append(" where ").append(property).append(" = :value");
//			}
//			Query query2= session.createQuery(sqlCount.toString());
//			if(property!=null && value!=null) {
//				query2.setParameter("value", value);
//			}
//			count =  query2.list().get(0);
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return new Object[] {count, results};
	}

	public Integer delete(List<ID> ids) {
		Session session= null;
		Transaction transaction= null;
		Integer count= 0;
		try {
			session= getSession();
			transaction= session.beginTransaction();
			StringBuilder sql= new StringBuilder("DELETE FROM ");
			sql.append(this.getPersistenceClassName());
			sql.append(" WHERE id IN (:ids)");
			Query query = session.createQuery(sql.toString());
			query.setParameterList("ids", ids);
			 query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		
			// TODO: handle exception
		}
		finally {
			session.close();
		}
		return count;
	}

	public Integer delete2(Object object) {
		Session session= null;
		Transaction transaction= null;
		Integer count= 0;
		try {
			session= getSession();
			transaction= session.beginTransaction();
			Query query= null;
			try {
				StringBuilder sql= new StringBuilder("DELETE FROM ");
				sql.append(this.getPersistenceClassName());
				sql.append(" WHERE id IN (:ids)");
				query = session.createQuery(sql.toString());
				query.setParameterList("ids", (Collection) object);
			} catch (Exception e) {
				StringBuilder sql= new StringBuilder("DELETE FROM ");
				sql.append(this.getPersistenceClassName());
				sql.append(" WHERE id = :id");
				query = session.createQuery(sql.toString());
				query.setParameter("id", object);
			}	
			 query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			// TODO: handle exception
		}
		finally {
			session.close();
		}
		return count;
	}


}
