/**
 * 
 */
package com.learn.restfulwebservicesconcepts.vo;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Ancil Hameed
 * 
 * Added : 14-Sep-2021, 11:40:30 am
 */

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min = 2, message = "Name should be minimum 2 characters.")
	private String name;
	
	@Past(message="Birth date cannot be in future.")
	private Date birthDate;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public User(Long id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	
}
