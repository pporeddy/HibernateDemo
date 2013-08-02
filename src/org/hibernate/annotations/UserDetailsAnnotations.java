package org.hibernate.annotations;
/*
 * @author Prithvi Krishna Poreddy
 * Introduction to Hiberante 
 */

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity // Entity name will be default {class name}, we use entity name in HQL
@Table (name="USER_DETAILS_ANNOTATIONS") // This annotation used to set Table name {The name of table in entity}
public class UserDetailsAnnotations {
	@Id // Primary key in the table
	// Annotations can be kept at getter as Hibernate use getter to take value 
	private int useId;	
	@Basic // Apply's hibernate basic to map java to sql types
	private String name;
	// If we need only date in the time stamp then use Temporal, if vice versa use Temporal time
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	private String Adress;
	// Hibernate by default will make Strings into varchar 255 if the Description is longer than 255 its a problem
	// to eliminate that problem we have Lob {Large Object}. CLOB/ BLOB { Char or Byte LOB}. It will take appropriate length.
	@Lob
	private String description;
	// Transient or static fields will not be persisted in database because they will be same for all objects
	@Transient
	private String email;
	
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
