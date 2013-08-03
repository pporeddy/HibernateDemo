package org.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetailsOne2One user = new UserDetailsOne2One();
		user.setUserName("Sai");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bike");
		user.setVehicle(vehicle);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

	}

}
