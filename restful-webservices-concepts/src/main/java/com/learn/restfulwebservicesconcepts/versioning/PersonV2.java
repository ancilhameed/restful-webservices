/**
 * 
 */
package com.learn.restfulwebservicesconcepts.versioning;

/**
 * @author Ancil Hameed
 * 
 * Added : 15-Sep-2021, 10:57:44 am
 */
public class PersonV2 {

	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

	public PersonV2() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
