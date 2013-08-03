package org.hibernate.one2one;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_ONE2MANY") 
public class UserDetailsOne2One {
	
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int useId;
	private String userName;
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
