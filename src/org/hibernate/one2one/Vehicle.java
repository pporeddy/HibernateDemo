package org.hibernate.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="VEHICLE_ONE2ONE")
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String VehicleName;
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
