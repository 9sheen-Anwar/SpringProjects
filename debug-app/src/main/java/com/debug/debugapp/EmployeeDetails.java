package com.debug.debugapp;

import org.springframework.web.client.RestTemplate;

public class EmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			final String uri = "http://localhost:8080/springrestexample/employees.json";


		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);

		    System.out.println(result);

	}

}
