package org.hibernate.primarykey;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_KEY") 
public class UserDetailsPrimaryKey {
	// Primary key in the table
	// Natural vis Surrogate key
	// Natural Key user has to pass the key
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	// Hibernate will create primary key  
	// strategy AUTO/IDENTITY/SEQUENCE/TABLE refer documentation 
	private int useId;	
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
	
}
