/**
 * 
 */
package com.learn.restfulwebservicesconcepts.vo;

/**
 * @author Ancil Hameed
 * 
 * Added : 14-Sep-2021, 11:09:27 am
 */
public class HelloWorld {

	
	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}
	
	
}
