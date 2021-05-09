package com.zohaib.timetablegenerator.algorithm;

import org.springframework.stereotype.Service;

import com.zohaib.timetablegenerator.algorithm.basic.BasicAlgorithm;
import com.zohaib.timetablegenerator.algorithm.basic.model.Data;

@Service
public class AlgorithmService {

	public void runAlgorithm(Data data){
	
		BaseGeneticAlgorithm algorithm = new BasicAlgorithm(data);
		algorithm.run();
		
	}
}
