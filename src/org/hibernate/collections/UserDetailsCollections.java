package org.hibernate.collections;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_COLLECTION") 
public class UserDetailsCollections {
	
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int useId;
	@ElementCollection
	private Set<Address> listOfAdress = new HashSet();
	
	
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
	public Set<Address> getListOfAdress() {
		return listOfAdress;
	}
	public void setListOfAdress(Set<Address> listOfAdress) {
		this.listOfAdress = listOfAdress;
	}
}
