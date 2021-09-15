/**
 * 
 */
package com.learn.restfulwebservicesconcepts.vo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learn.restfulwebservicesconcepts.vo.User;

/**
 * @author Ancil Hameed
 * 
 *         Added : 14-Sep-2021, 11:42:06 am
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

	private long userCount = 5l;

	public List<User> findAll() {
		return listOfUsers;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		listOfUsers.add(user);
		return user;
	}

	public User findOne(long id) {
		for (User user : listOfUsers) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
