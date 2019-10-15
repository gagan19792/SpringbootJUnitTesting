package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWordApi {
	
	@GetMapping
	public String helloWorld() {
		return "Hello World!....";
	}
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Hello json() {
		return new Hello("Gagan", "Ubbey", 40);
	}
	
	private class Hello{
		private String fName;
		public Hello(String fName, String lName, int age) {
			super();
			this.fName = fName;
			this.lName = lName;
			this.age = age;
		}
		private String lName;
		private int age;
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}

}
