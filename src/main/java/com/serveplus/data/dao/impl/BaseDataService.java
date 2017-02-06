package com.serveplus.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.serveplus.data.dao.ParameterMap;
public class BaseDataService<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected  Class<T> genericType; 
	
	protected BaseDataService() {
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDataService.class); // spring function to get the actual class of 'T'
		

	}
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
	public List<T> getResultList(String hql){
		Session session = getSession();
		List results = session
				.createQuery(hql).list();
		session.close();
		return results;
	}
	public void remove(T t){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.delete(t);
		tx.commit();
		session.close();
	}
	public void removeAll(Set<T> items){
		for(T item:items){
			remove(item);
		}
	}
	public List<T> getAll(){
		List<T> results = getResultList("from "+genericType.getName());
		return results;
	}
	public T findById(Long id){
		Session session = getSession();
		T object = (T) session.get( genericType, id);
		session.close();
		return object;
	}
	private void setParameters(Query query,ParameterMap parameterMap){
		HashMap<String, Object> actualMap = parameterMap.getParameterMap();
		Set<Entry<String, Object>> entrySet = actualMap.entrySet();
		for(Entry<String, Object> entry:entrySet){
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
			
		}
		
		HashMap<String, List> actualMap2 = parameterMap.getParameterListMap();
		if(actualMap2!=null){
		Set<Entry<String, List>> entrySet2 = actualMap2.entrySet(); 
		for(Entry<String, List> entry:entrySet2){
			String key = entry.getKey();
			List value = entry.getValue();
			query.setParameterList(key, value);
			
		}
		}
	}
	public List<T> getResultList(String hql,ParameterMap parameterMap){
		Session session = getSession();
		Query query = session
				.createQuery(hql);
		setParameters(query,parameterMap);
		List results = query.list();
		session.close();
		return results;
	}
	
	public T getOneResult(String hql,ParameterMap parameterMap){
		Session session = getSession();
		Query query = session
				.createQuery(hql);
		setParameters(query,parameterMap);
		List results = query.list(); 
		session.close();
		if(results!=null && results.size()==1)
			return (T) results.get(0);
		else
			return null;
	}
	public void save(T object){
		Session session = getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		session.close();
	}
	public void saveAll(List<T> objects){
		for(T object:objects){
			save(object);
		}
	}
	public void saveAll(Set<T> objects){
		for(T object:objects){
			save(object);
		}
	}
}
