package org.hibernate.one2many;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_ONE2MANY") 
public class UserDetailsOne2Many {
	
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int useId;
	private String userName;
	@OneToMany 
	// Join table is used to specify which column to use from tables
	// It can also be used to change name of newly created table
	// join column is the user
	// inverse join column is vehicle 
	@JoinTable(name ="USER_VEHICLE_MAP",
			joinColumns=@JoinColumn(name="USER_ID"),
			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
			)
	private Collection<Vehicle> vehicle = new ArrayList<>();
	
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
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
