/**
 * 
 */
package com.learn.restfulwebservicesconcepts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.restfulwebservicesconcepts.vo.HelloWorld;


/**
 * @author Ancil Hameed
 * 
 * Added : 14-Sep-2021, 11:05:04 am
 */

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World!");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello WOrld, %s", name));
	}
	
}
