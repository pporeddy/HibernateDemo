package org.hibernate.proxyobjects;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


//Entity name will be default {class name}, we use entity name in HQL
@Entity 
//This annotation used to set Table name {The name of table in entity}
@Table (name="USER_DETAILS_PROXY") 
public class UserDetailsProxyObjects {
	
	// Surrogate Key hibernate will create a primary key for us. 
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int useId;
	private String userName;
	
	@ElementCollection (fetch=FetchType.EAGER)
	// Change the default name of the table.
	@JoinTable (name="USER_ADDRESS_PROXY",
				joinColumns=@JoinColumn(name="USER_ID")
				)
		private Collection<Address> listOfAddress = new ArrayList<>();	
	
	
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public Collection<Address> getListOfAdress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAdress) {
		this.listOfAddress = listOfAdress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
