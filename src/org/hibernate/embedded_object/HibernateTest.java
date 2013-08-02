package org.hibernate.embedded_object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetailsEmbedded_Object user = new UserDetailsEmbedded_Object();
		// We are not providing primary key. Hibernate will create a sequence and will follow it.
		user.setName("Sai"); 
		// If i want to change the default names of Embedded object i can directly change the names of columns 
		// in the class.
		Address homeAddress1 = new Address();
		// If i want 2 embedded objects of same type home and office address
		// I can't use this directly because there will be column name conflict.
		Address officeAddress1 = new Address();
		officeAddress1.setCity("New Orleans");
		officeAddress1.setPincode("70148");
		officeAddress1.setState("LA");
		officeAddress1.setStreet("Orleans Parish");
		
		Address officeAddress2 = new Address();
		officeAddress2.setCity("1New Orleans");
		officeAddress2.setPincode("170148");
		officeAddress2.setState("1LA");
		officeAddress2.setStreet("1Orleans Parish");
		
		homeAddress1.setCity("Hyderabad");
		homeAddress1.setState("Telangana");
		homeAddress1.setStreet("Hitech City");
		homeAddress1.setPincode("505001");
		user.setAdress(homeAddress1);
		user.setOfficeAdress(officeAddress1);
		
		UserDetailsEmbedded_Object user2 = new UserDetailsEmbedded_Object();
		user2.setName("Krishna");
		homeAddress1.setStreet("IIT Hyderabad");
		user2.setAdress(homeAddress1);
		user2.setOfficeAdress(officeAddress2);
		
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
		user = (UserDetailsEmbedded_Object) session.get(UserDetailsEmbedded_Object.class, 1);
		System.out.println("User Name : "+user.getName());
	}

}
