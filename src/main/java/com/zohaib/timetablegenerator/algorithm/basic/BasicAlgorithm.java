package com.zohaib.timetablegenerator.algorithm.basic;

import java.util.Random;

import com.zohaib.timetablegenerator.algorithm.BaseGeneticAlgorithm;
import com.zohaib.timetablegenerator.algorithm.basic.model.Data;
import com.zohaib.timetablegenerator.algorithm.onesandzeros.Individual;

public class BasicAlgorithm {
	
	BasicPopulation population = new BasicPopulation();
	BasicIndividual fittest;
	BasicIndividual secondFittest;
    int generationCount = 0;
    Data data;
  
    public void run(Data data){
        Random rn = new Random();

        

        //Initialize population
        population.initializePopulation(10,data);

        //Calculate fitness of each individual
        population.calculateFitness();

        System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittestValue());

        //While population gets an individual with maximum fitness
        while (generationCount < 20) {
            ++generationCount;

            //Do selection
            selection();

            //Do crossover
            crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%10 < 3) {
                mutation();
            }

            //Add fittest offspring to population
            addFittestOffspring();

            //Calculate new fitness value
            population.calculateFitness();

            System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittestValue());
        }

        System.out.println("\nSolution found in generation " + generationCount);
        System.out.println("Fitness: "+population.getFittestIndividual().getFitnessValue());
        System.out.print("Genes: ");
        for (int i = 0; i < 500; i++) {
            System.out.print(population.getFittestIndividual().genes[i]);
        }
        
        for (int i = 0; i < fittest.getGenes().length; i++) {
        	
        	for(int j = 0; j < fittest.getGenes().length; j++){
        		System.out.print(fittest.getGenes()[i][j]);
        		System.out.println("  ");
        		
        	}
        	
        	System.out.println(System.lineSeparator());
        }

        System.out.println("");

    
    }
    
	//Selection

    public void selection() {

        //Select the most fittest individual
        fittest = population.getFittestIndividual();

        //Select the second most fittest individual
        secondFittest = population.getSecondFittest();
    }

    //Crossover

    public void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPointX = rn.nextInt(population.individuals[0].genes.length);
        int crossOverPointY = rn.nextInt(population.individuals[0].genes[0].length);
        
        //Swap values among parents
        for (int i = 0; i < crossOverPointX; i++) {
        	for (int j = 0; j < crossOverPointY; j++) {
	            String temp = fittest.getGenes()[i][j];
	            fittest.getGenes()[i][j] = secondFittest.getGenes()[i][j];
	            secondFittest.getGenes()[i][j] = temp;
        	}   
        }

    }

    //Mutation

    public void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPointX = rn.nextInt(population.individuals[0].genes.length);
        int mutationPointY = rn.nextInt(population.individuals[0].genes[0].length);

        //Flip values at the mutation point
        
 
       	fittest.getGenes()[mutationPointX][mutationPointY] = data.getCourses().get(rn.nextInt() % data.getCourses().size()).getCode();


        mutationPointX = rn.nextInt(population.individuals[0].genes.length);
        mutationPointY = rn.nextInt(population.individuals[0].genes[0].length);


        secondFittest.getGenes()[mutationPointX][mutationPointY] = data.getCourses().get(rn.nextInt() % data.getCourses().size()).getCode();



    }

    //Get fittest offspring
    BasicIndividual getFittestOffspring() {
        if (fittest.getFitnessValue() > secondFittest.getFitnessValue()) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = getFittestOffspring();
    }
}
