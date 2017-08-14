package daoIMPL;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IBaseDao;
import util.HibernateSessionFactory;
import util.Page;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	private Log log = LogFactory.getLog(this.getClass());
	private Class<T> entityClass;
	Logger logger = (Logger)LogManager.getLogger();
    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
    	entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}	
	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void save(T instance) {
		log.debug("saving "+instance+" instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(instance);
			tx.commit();
			logger.debug("save successful");
		} catch (RuntimeException re) {
			tx.rollback();
			logger.error("save failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	@Override
	public void delete(T instance) {
		logger.debug("deleting "+instance+" instance");
		Transaction tx = this.getSession().beginTransaction();
		try {
			getSession().delete(instance);
			tx.commit();
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	@Override
	public void update(T instance) {
		logger.debug("updating "+instance+" instance");
		Transaction tx = this.getSession().beginTransaction();
		try {
			getSession().update(instance);
			tx.commit();
			logger.debug("update successful");
		} catch (RuntimeException re) {
			tx.rollback();
			logger.error("update failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object findById(Class clazz, Integer id) {
		logger.debug("getting "+clazz+" instance with id: " + id);
		try {
			//Hibernate.initialize(District.class);
			Object o = this.getSession().get(clazz,id);
			return o;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		logger.debug("getting "+entityClass+" List All ");
		try {
			String hql = "FROM "+entityClass;
			Query queryObject = this.getSession().createQuery(hql);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			logger.error("find by HQL ", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findAll(Class clazz) {
		logger.debug("getting "+clazz+" List All ");
		try {
			String c = clazz.toString();
			String hql = "FROM "+c.substring(c.lastIndexOf(".")+1,c.length());
			Query queryObject = this.getSession().createQuery(hql);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			logger.error("find by HQL ", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	/**
	 * 根据对象名和对象属性查询数据
	 * @param className
	 * @param propertyName
	 * @param value
	 * @return 实体对象列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String className,String propertyName, Object value) {
		logger.debug("finding "+className+" instance with property: " + propertyName + ", value: " + value);
		
		try {
			String hql = "FROM "+className+" as o WHERE o."+propertyName+" = ?";
			Query queryObject = this.getSession().createQuery(hql);
			queryObject.setParameter(0, value);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	/**
	 * 根据HQL查询数据
	 * @param hql
	 * @return 实体对象列表
	 */
	@SuppressWarnings("rawtypes")
	public List findByHql(String hql) {
		logger.debug(hql);
		logger.debug(hql);
		
		try {
			logger.debug("进入查询语句前端");
			Query queryObject = this.getSession().createQuery(hql);
			logger.debug(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			logger.error("find by HQL ", re);
			throw re;
		} finally{
			closeSession();
		}
	}
	
	/**
	 * 获取分页对象，实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @param page 需要显示数据的页码
	 * @param pageSize 每页数据量
	 * @return Object[0]当前页的数据列表List ,Object[1]总页数，Object[2]总数量
	 */
	@SuppressWarnings("rawtypes")
	public Object[] findPageByHql(final String hql, String hqlCount, final int page, final int pageSize) {
		logger.debug(hql);
		List list = new ArrayList();
		Long total = new Long(0);
		Integer totalPage = 0;
		try {
			//1、根据hql语句查询指定数据
			Query qList = this.getSession().createQuery(hql);
			qList.setFirstResult(page * pageSize);
			qList.setMaxResults(pageSize);
		    list = qList.list();
		    
			//2、根据hql语句查询总记录数
		    List listCount = findByHql(hqlCount);
			if(listCount!=null && listCount.size()>0){
				total = (Long)listCount.get(0);
			}
			
			//3、根据总记录数计算出总页数
			totalPage = (int) Math.ceil((double) total.longValue() / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
		return new Object[] { list, totalPage, total };
	}
	
	/**
	 * 获取分页对象，实现分页获取数据的功能
	 * @param hql 查询数据的HQL
	 * @param page 分页对象
	 * @return page 分页对象
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page findPageByHql(final String hql, String hqlCount, Page page) {
		logger.debug(hql);
		try {
			if(page !=null){
				//1、根据hql语句查询指定数据
				Query qList = this.getSession().createQuery(hql);
				qList.setFirstResult(page.getStartRow());
				qList.setMaxResults(page.getSize());
			    page.setList(qList.list());//将数据集合保存到page对象
			    
				//2、根据hql语句查询总记录数
			    List listCount = findByHql(hqlCount);
				if(listCount!=null && listCount.size()>0){
					page.setTotalCount(Integer.parseInt(String.valueOf(listCount.get(0))));//将总记录数保存到page对象
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSession();
		}
		
		return page;
	}
	
}