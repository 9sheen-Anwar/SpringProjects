package com.rest.webservices.restfullwebservices.helloworldcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	//@RequestMapping(method=RequestMethod.GET, path="/hello")
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hellobean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

}
