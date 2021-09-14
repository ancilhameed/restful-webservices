/**
 * 
 */
package com.learn.restfulwebservicesconcepts.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Ancil Hameed
 * 
 * Added : 14-Sep-2021, 11:42:06 am
 */
@Component
public class UserDaoService {

	private static List<User> listOfUsers = new ArrayList<>();
	
	static {
		listOfUsers.add(new User(1L, "Ancil", new Date()));
		listOfUsers.add(new User(2L, "Shivam", new Date()));
		listOfUsers.add(new User(3L, "Abhishek", new Date()));
		listOfUsers.add(new User(4L, "Arpit", new Date()));
		listOfUsers.add(new User(4L, "Kuku", new Date()));
	}
}
