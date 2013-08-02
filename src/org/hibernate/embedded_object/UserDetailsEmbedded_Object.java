package org.hibernate.embedded_object;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_EMBEDDED_OBJECT") 
public class UserDetailsEmbedded_Object {
	
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	// Hibernate will create primary key  
	// strategy AUTO/IDENTITY/SEQUENCE/TABLE refer documentation 
	
	private int useId;
	@Embedded // Not mandatory because we made Address Class @Embeddable it takes column names from the class
	private Address adress;
	// I need to have different column names for office address 
	// I need to override the column names { it will not take default values if i override}
	// If we need to override multiple entries we need to have @AttributeOverrides in that we can nest @AttributeOverride
	@Embedded 
	@AttributeOverrides({
	@AttributeOverride (name="street",
						column=@Column(name="OFFICE_STREET")),
	@AttributeOverride (name="city",
						column=@Column(name="OFFICE_CITY")),
	@AttributeOverride (name="state",
						column=@Column(name="OFFICE_STATE")),
	@AttributeOverride (name="pincode",
						column=@Column(name="OFFICE_PIN")),
						
	})
	private Address officeAdress;
	
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public Address getOfficeAdress() {
		return officeAdress;
	}
	public void setOfficeAdress(Address officeAdress) {
		this.officeAdress = officeAdress;
	}
	
}
