package org.hibernate.annotations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUseId(1);
		user.setName("Sai");
		user.setJoinDate(new Date());
		user.setAdress("USA");
		user.setDescription("Nothing");
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		// Fetch the object which is persisted in previous session
		
		user = null;
		// No need of creating session factory again it should be created once { its resource intense}
		
		session= sessionfactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name : "+user.getName());
	}

}
