package com.zohaib.timetablegenerator.algorithm;

import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

	void runAlgorithm(){
	
		GeneticAlgorithm algorithm = new GeneticAlgorithm();
		algorithm.run();
		
	}
}
