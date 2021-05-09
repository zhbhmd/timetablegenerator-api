package com.zohaib.timetablegenerator.algorithm.basic;

import com.zohaib.timetablegenerator.algorithm.basic.model.Data;


public class BasicPopulation {

    BasicIndividual[] individuals = new BasicIndividual[10];
    int fittestValue  = 0;

    //Initialize population
    public void initializePopulation(int size, Data data) {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new BasicIndividual(data);
        }
    }

    
    
    public int getFittestValue() {
		return fittestValue;
	}



	//Get the fittest individual
    public BasicIndividual getFittestIndividual() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].getFitnessValue()) {
                maxFit = individuals[i].getFitnessValue();
                maxFitIndex = i;
            }
        }
        fittestValue = individuals[maxFitIndex].getFitnessValue();
        return individuals[maxFitIndex];
    }

    //Get the second most fittest individual
    public BasicIndividual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].getFitnessValue() > individuals[maxFit1].getFitnessValue()) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].getFitnessValue() > individuals[maxFit2].getFitnessValue()) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].getFitnessValue()) {
                minFitVal = individuals[i].getFitnessValue();
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
        
        getFittestValue();
    }
}
