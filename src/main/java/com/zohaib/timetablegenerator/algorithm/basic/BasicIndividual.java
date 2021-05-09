package com.zohaib.timetablegenerator.algorithm.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.zohaib.timetablegenerator.algorithm.basic.model.Course;
import com.zohaib.timetablegenerator.algorithm.basic.model.Data;

public class BasicIndividual {
	
	double fitnessValue = 0;
    String[][] genes;

    
    public BasicIndividual(Data data) {
    	
    	Random rn = new Random();
    	genes = new String[data.getSlots().size()][data.getRooms().size()];
    	
    	int numberOfCourses = data.getCourses().size();

        for (int i = 0; i < genes.length; i++) {
        	
        	for(int j = 0; j < genes[i].length; j++){
        		
        		genes[i][j] = data.getCourses().get(rn.nextInt(numberOfCourses)).getCode();
        		
        	}
        }

        fitnessValue = 0;
    }



    public double getFitnessValue() {
		return fitnessValue;
	}



	public String[][] getGenes() {
		return genes;
	}



	public void setGenes(String[][] genes) {
		this.genes = genes;
	}



	//Calculate fitness
    public void calcFitness(Data data) {

        for (int i = 0; i < genes.length; i++) {       	
        	for(int j = 0; j < genes[i].length; j++){       		
            	for(int k = 0; k < genes[i].length; k++){
            		if(k != j)
            			compareChromosome(data,genes[i][j],genes[i][k]);
            		
            	}       		
        	}
        }

        fitnessValue = 1/fitnessValue;
    }
    
    private void compareChromosome(Data data, String courseCode, String otherCourseCode) {
    	Course course = data.getCourses().stream().filter(c -> c.getCode().equalsIgnoreCase(courseCode)).findFirst().get();
    	Course otherCourse = data.getCourses().stream().filter(c -> c.getCode().equalsIgnoreCase(otherCourseCode)).findFirst().get();
    	
    	if(course.getTeacher().equalsIgnoreCase(otherCourse.getTeacher())) {
    		fitnessValue++;
    	}else {
            ArrayList<String> listOne = (ArrayList<String>) course.getStudentGroups();
            ArrayList<String> listTwo = (ArrayList<String>) otherCourse.getStudentGroups();
            Collections.sort(listOne);
            Collections.sort(listTwo);
            
            if(listOne.equals(listTwo))
            	fitnessValue++;
    	}
    }
    
}
