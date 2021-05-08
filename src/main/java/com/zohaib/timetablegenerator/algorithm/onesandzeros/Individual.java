package com.zohaib.timetablegenerator.algorithm.onesandzeros;

import java.util.Random;

public class Individual {
	int fitness = 0;
    int geneLength = 500;
    int[] genes = new int[geneLength];


    public Individual() {
        Random rn = new Random();

        //Set genes randomly for each individual
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength-1; i++) {
            if (genes[i] != genes[i+1]) {
                ++fitness;
            }
        }
    }
}
