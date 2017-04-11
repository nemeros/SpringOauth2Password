package com.api.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {

	@RequestMapping(path="user", method=RequestMethod.GET)
	public ResponseEntity<String> getHello(){
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
	
	@RequestMapping(path="hello", method=RequestMethod.GET)
	public ResponseEntity<String> getHello1(){
		return new ResponseEntity<String>("hello low", HttpStatus.OK);
	}
}
