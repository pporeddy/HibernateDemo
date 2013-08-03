package org.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetailsOne2Many user = new UserDetailsOne2Many();
		user.setUserName("Sai");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bike");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car");
		
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

	}

}
