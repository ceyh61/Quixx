package com.logics;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculations {

    private static final String[] POINTS_ARRAY = {"0", "1", "3", "6", "10", "15", "21", "28", "36", "45", "55", "66", "78"};
    
    public Calculations(){

    }

    protected int calculateRedPoints(ArrayList<String> redRow){
        int points = 0;
        int countCross = 0;

        ArrayList <String> pointList = new ArrayList<>();
        // adding all the point from a normal Array to an ArrayList for simple calculations
        pointList.addAll(Arrays.asList(POINTS_ARRAY));

        // counts the number of the crossed numbers 
        for(int i = 0 ; i < redRow.size() ; i++){
            if (redRow.get(i).contains("X")){
                countCross++;
            }
        }
        // finds the corresponding point from the list and returns it. 
        points = Integer.parseInt(pointList.get(countCross));

        return points;
    }

    protected int calculateYellowPoints(ArrayList<String> yellowRow){
        int points = 0;
        int countCross = 0;

        ArrayList <String> pointList = new ArrayList<>();
        // adding all the point from a normal Array to an ArrayList for simple calculations
        pointList.addAll(Arrays.asList(POINTS_ARRAY));

        // counts the number of the crossed numbers 
        for(int i = 0 ; i < yellowRow.size() ; i++){
            if (yellowRow.get(i).contains("X")){
                countCross++;
            }
        }
        // finds the corresponding point from the list and returns it. 
        points = Integer.parseInt(pointList.get(countCross));

        return points;
    }

    protected int calculateGreenPoints(ArrayList<String> greenRow){
        int points = 0;
        int countCross = 0;

        ArrayList <String> pointList = new ArrayList<>();
        // adding all the point from a normal Array to an ArrayList for simple calculations
        pointList.addAll(Arrays.asList(POINTS_ARRAY));

        // counts the number of the crossed numbers 
        for(int i = 0 ; i < greenRow.size() ; i++){
            if (greenRow.get(i).contains("X")){
                countCross++;
            }
        }
        // finds the corresponding point from the list and returns it. 
        points = Integer.parseInt(pointList.get(countCross));

        return points;
    }

    protected int calculateBluePoints(ArrayList<String> blueRow){
        int points = 0;
        int countCross = 0;

        ArrayList <String> pointList = new ArrayList<>();
        // adding all the point from a normal Array to an ArrayList for simple calculations
        pointList.addAll(Arrays.asList(POINTS_ARRAY));

        // counts the number of the crossed numbers 
        for(int i = 0 ; i < blueRow.size() ; i++){
            if (blueRow.get(i).contains("X")){
                countCross++;
            }
        }
        // finds the corresponding point from the list and returns it. 
        points = Integer.parseInt(pointList.get(countCross));

        return points;
    }


    protected int calculatePenaltiesPoints(ArrayList<String> redRow,ArrayList<String> yellowRow,ArrayList<String> greenRow,ArrayList<String> blueRow){
        int points = 0;

        if(redRow.get(12) == "P"){
            points -=5;
        }
        if(yellowRow.get(12) == "P"){
            points -=5;
        }
        if(greenRow.get(12) == "P"){
            points -=5;
        }
        if(blueRow.get(12) == "P"){
            points -=5;
        }

        return points;
    }
    protected int calculateAllPointsOfPlayer(ArrayList<String> redRow,ArrayList<String> yellowRow,ArrayList<String> greenRow,ArrayList<String> blueRow){
        int redPoints = calculateRedPoints(redRow);
        int yellowPoints = calculateYellowPoints(yellowRow);
        int greenPoints = calculateGreenPoints(greenRow);
        int bluePoints = calculateBluePoints(blueRow);
        int penaltyPoints = calculatePenaltiesPoints(redRow,yellowRow,greenRow,blueRow);
        int playersPoints = redPoints+yellowPoints+greenPoints+bluePoints+penaltyPoints;

        return playersPoints;
    }
    protected boolean checkIfAnyPlayerHasFourPenalties(){
        boolean check = false;


        return check;
    }
    protected boolean checkIfTwoRowsAreDisabled(){
        boolean check = false;

        return check;
    }
}
