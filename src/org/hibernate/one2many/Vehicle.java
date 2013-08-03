package org.hibernate.one2many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name="VEHICLE_ONE2MANY")
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String VehicleName;
	
	// It is many to one 
	@ManyToOne
	private UserDetailsOne2Many user;
	
	
	
	public UserDetailsOne2Many getUser() {
		return user;
	}
	public void setUser(UserDetailsOne2Many user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return VehicleName;
	}
	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

}
