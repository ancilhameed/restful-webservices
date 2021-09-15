/**
 * 
 */
package com.learn.restfulwebservicesconcepts.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.restfulwebservicesconcepts.exceptions.UserNotFoundException;
import com.learn.restfulwebservicesconcepts.vo.User;
import com.learn.restfulwebservicesconcepts.vo.dao.UserDaoService;

/**
 * @author Ancil Hameed
 * 
 * Added : 15-Sep-2021, 12:13:16 am
 */

@RestController
public class UserController {

	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	//HATEOAS Example
	public EntityModel<User> retrieveUser(@PathVariable long id){
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException(" -> id "+id);
		}
		//If we want to add useful links to our GET /users API then we need to use HATEOAS
		//We'll make use of EntityModel to return our Resource with useful links 
		EntityModel<User> userEntityModel = EntityModel.of(user);
		
		//If we just return EntityModel we wont get links, for adding links we need WebMvcLinkBuilder
		//It has 2 static methods linkTo and methodOn, which we'll use 
		WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		//Instead of Hard Coding the URL we creates a link using method name, now we need to set it to EntityModel
		userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));
		
		return userEntityModel;
	}
	
	@PostMapping("/users")
	//Validation Example
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		//@Valid in javax validation API is used to validate RequestBody
		
		User save = userDaoService.save(user);
		
		//We need to send the CRETAED status code in HTTP Response
		//Hence we would make use of ResponseEntity(extention of HTTPEntity)
		
		//ServletUriComponentsBuilder, will give us the URI of current request
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(save.getId()).toUri();

		//Below would send HTTP 201 which is appropriate code for CREATED
		return ResponseEntity.created(location).build();	}
}
