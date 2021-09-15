/**
 * 
 */
package com.learn.restfulwebservicesconcepts.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ancil Hameed
 * 
 *         Added : 15-Sep-2021, 11:02:05 am
 */
@RestController
public class VersioningController {

	// Start - URI Versioning
	@GetMapping("/person/v1")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping("/person/v2")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Jim", "Morrison"));
	}

	// Start - Param Versioning
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramVersioning1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramVersioning2() {
		return new PersonV2(new Name("Jim", "Morrison"));
	}

	// Start - Header Versioning
	@GetMapping(value = "/person/header", headers = "API-VERSION=1")
	public PersonV1 headerVersioning1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "/person/header", headers = "API-VERSION=2")
	public PersonV2 headerVersioning2() {
		return new PersonV2(new Name("Jim", "Morrison"));
	}

	// Start - MIME Type Versioning
	@GetMapping(value = "/person/produces", produces = "API-VERSION/1")
	public PersonV1 producesVersioning1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "/person/produces", produces = "API-VERSION/2")
	public PersonV2 proVersioning2() {
		return new PersonV2(new Name("Jim", "Morrison"));
	}

}
