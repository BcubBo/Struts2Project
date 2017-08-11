package util;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.HouseUser;
import util.HibernateSessionFactory;

public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] asdf){
		 Session session = HibernateSessionFactory.getSession();
		 Query q = session.createQuery("From HouseUser");
		 List<HouseUser> list =q.list();
		 for(HouseUser user : list){
			 
			 System.out.println(user.getRealname());
		 }
		 
	}
	
}
