/**
 * 
 */
package com.learn.restfulwebservicesconcepts.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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

	//MessageSource is automatically configured by Spring Boot for us
	@Autowired
	private MessageSource messageSource;
	
	
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
	
	@GetMapping("/hello-world-internationalized")
	//Internationalization Example
	public HelloWorld helloWorldInternationalized(@RequestHeader(name ="Accept-Language", required = false) Locale locale) {
		
	//For supposrting multiple languages we would require something like below configuration bt we cannot hardcode it below
	//So we use Spring Message Bundle
		
		//en = Hello World
		//nl = Geode Morgen
		//fr = Bonjour
		return new HelloWorld(messageSource.getMessage("good.morning.message",null, "Default Message", locale));
	}
	
}
