package com.toeiconline.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenergicDao <ID extends Serializable, T>{
	 List<T> findAll();
	 T update(T entity);
	 void save(T entity);
	 T findById(ID id);
	 Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
	 Integer delete(List<ID> ids);
	 Integer delete2(Object object);
	 Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
