package com.zohaib.timetablegenerator.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgorithmController {

	@Autowired
	AlgorithmService algorithmService;
	
	@GetMapping("/")
	String getHelloWorld() {
		return "Hello, World";
	}
	
	@GetMapping("/algorithm")
	void runAlgorithm() {
		//algorithmService.runAlgorithm();
	}
	
	
}
