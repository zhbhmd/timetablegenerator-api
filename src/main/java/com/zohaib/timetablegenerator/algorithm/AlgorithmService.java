package com.zohaib.timetablegenerator.algorithm;

import org.springframework.stereotype.Service;

import com.zohaib.timetablegenerator.algorithm.onesandzeros.OnesAndZeroesAlgorithm;

@Service
public class AlgorithmService {

	void runAlgorithm(){
	
		BaseGeneticAlgorithm algorithm = new OnesAndZeroesAlgorithm();
		algorithm.run();
		
	}
}
