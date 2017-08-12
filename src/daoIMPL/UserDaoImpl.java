package daoIMPL;

import java.util.List;

import org.hibernate.Session;

import dao.IBaseDao;
import entity.HouseUser;
import util.HibernateSessionFactory;
import util.Page;

public class UserDaoImpl extends BaseDaoImpl<HouseUser> {

	@Override
	public Session getSession() {
		
		return super.getSession();
		//获取会话
		
		

	}

	@Override
	public void closeSession() {


	}
///////////////////////////



/*	@Override
	public Object findById(Class clazz, Integer id) {
		
		return null;
	}

	@Override
	public List findAll() {
		
		return null;
	}

	@Override
	public List findAll(Class clazz) {
		
		return null;
	}

	@Override
	public List findByHql(String hql) {
		
		return null;
	}

	@Override
	public List findByProperty(String className, String propertyName, Object value) {
		
		return null;
	}

	@Override
	public Object[] findPageByHql(String hql, String hqlCount, int page, int pageSize) {
		
		return null;
	}

	@Override
	public Page findPageByHql(String hql, String hqlCount, Page page) {
		
		return null;
	}*/

}
