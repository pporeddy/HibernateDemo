package org.hibernate.primarykey;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetailsPrimaryKey user = new UserDetailsPrimaryKey();
		// We are not providing primary key. Hibernate will create a sequence and will follow it.
		user.setName("Sai"); 
		UserDetailsPrimaryKey user2 = new UserDetailsPrimaryKey();
		user2.setName("Krishna");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		// Fetch the object which is persisted in previous session
		
		user = null;
		// No need of creating session factory again it should be created once { its resource intense}
		
		session= sessionfactory.openSession();
		user = (UserDetailsPrimaryKey) session.get(UserDetailsPrimaryKey.class, 1);
		System.out.println("User Name : "+user.getName());
	}

}
