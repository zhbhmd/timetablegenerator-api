package com.zohaib.timetablegenerator.algorithm.basic;

import java.util.Random;

import com.zohaib.timetablegenerator.algorithm.basic.model.Data;

public class BasicIndividual {
	
	int fitness = 0;
    String[][] genes;

    
    public BasicIndividual(Data data) {
    	
    	Random rn = new Random();
    	genes = new String[data.getSlots().size()][data.getRooms().size()];
    	
    	int numberOfCourses = data.getCourses().size();
    	
        for (int i = 0; i < genes.length; i++) {
        	
        	for(int j = 0; j < genes[i].length; j++){
        		
        		genes[i][j] = data.getCourses().get(rn.nextInt() % numberOfCourses).getCode();
        		
        	}
        }

        fitness = 0;
    }



    public int getFitness() {
		return fitness;
	}



	public void setFitness(int fitness) {
		this.fitness = fitness;
	}



	public String[][] getGenes() {
		return genes;
	}



	public void setGenes(String[][] genes) {
		this.genes = genes;
	}



	//Calculate fitness
    public void calcFitness() {

        fitness = 0;

    }
}
