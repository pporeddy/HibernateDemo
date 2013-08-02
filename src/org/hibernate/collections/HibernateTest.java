package org.hibernate.collections;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetailsCollections user = new UserDetailsCollections();
		// We are not providing primary key. Hibernate will create a sequence and will follow it.
		user.setName("Sai"); 
		// If i want to change the default names of Embedded object i can directly change the names of columns 
		// in the class.
		Address homeAddress1 = new Address();
		Address officeAddress1 = new Address();
		Address officeAddress2 = new Address();
		// If i want 2 embedded objects of same type home and office address
		// I can't use this directly because there will be column name conflict.
		
		officeAddress1.setCity("New Orleans");
		officeAddress1.setPincode("70148");
		officeAddress1.setState("LA");
		officeAddress1.setStreet("Orleans Parish");
		
		
		officeAddress2.setCity("1New Orleans");
		officeAddress2.setPincode("170148");
		officeAddress2.setState("1LA");
		officeAddress2.setStreet("1Orleans Parish");
		
		homeAddress1.setCity("Hyderabad");
		homeAddress1.setState("Telangana");
		homeAddress1.setStreet("Hitech City");
		homeAddress1.setPincode("505001");
		
		user.getListOfAdress().add(officeAddress2);
		user.getListOfAdress().add(officeAddress1);
		user.getListOfAdress().add(homeAddress1);
		
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
		user = (UserDetailsCollections) session.get(UserDetailsCollections.class, 1);
		System.out.println("User Name : "+user.getName());
	}

}
