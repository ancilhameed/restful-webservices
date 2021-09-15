/**
 * 
 */
package com.learn.restfulwebservicesconcepts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learn.restfulwebservicesconcepts.vo.SomeBean;

/**
 * @author Ancil Hameed
 * 
 *         Added : 15-Sep-2021, 10:39:30 am
 */
@RestController
public class FilteringController {

	@GetMapping("/filtering")
	// In response Only give me filed1 and filed2
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");

		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1",
				"field2");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",
				simpleBeanPropertyFilter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

	@GetMapping("/filtering-list")
	// In response Only give me filed1 and filed2
	public MappingJacksonValue retrieveSomeBeanList() {
		List<SomeBean> listOfSomeBean = Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field1", "field2", "field3"));
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",
				simpleBeanPropertyFilter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(listOfSomeBean);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}
}
