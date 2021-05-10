package com.zohaib.timetablegenerator.algorithm.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    	Map<String, Integer> sessionCountMap = new HashMap<String,Integer>();
    	fitnessValue = 0;
    	
    	
        for (int i = 0; i < genes.length; i++) {       	
        	for(int j = 0; j < genes[i].length; j++){       		
            	for(int k = 0; k < genes[i].length; k++){
            		if(k != j)
            			detectConflicts(data,genes[i][j],genes[i][k]);
            		
            	}
            	
            	//tallyCount(sessionCountMap,genes[i][j]);
        	}
        }


        //checkCount(data,sessionCountMap);
        
        if(fitnessValue == 0)
        {
            fitnessValue = 1;	
        }
        else {
        	fitnessValue = 1-(fitnessValue/(data.getRooms().size()*data.getSlots().size()));	
        }

    }
    
    private void tallyCount(Map<String, Integer> sessionCountMap, String courseCode) {
    	sessionCountMap.put(courseCode, sessionCountMap.getOrDefault(courseCode, 0) + 1);
    	System.out.println("CourseCode: " +courseCode + ", Count: " +sessionCountMap.get(courseCode) );
    }
    
    private void checkCount(Data data, Map<String, Integer> sessionCountMap) {

    	sessionCountMap.remove("C0");
    		
		sessionCountMap.forEach(
	              (k, v) -> {
	            	  Course course = data.getCourses().stream().filter(c -> c.getCode().equalsIgnoreCase(k)).findFirst().get();
	            	  if(course.getSessionCount() != v)
	            		  fitnessValue++;
	              }
	          );
    }
    
    private void detectConflicts(Data data, String courseCode, String otherCourseCode) {
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
