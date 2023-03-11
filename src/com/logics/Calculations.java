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

    // method gets the file/player name and calls for the penalty list from the Connector class
    // it calculates the penalties and returns it as an integer
    protected int calculatePenaltiesPoints(String fileName){
        int points = 0;
        ArrayList <String> penaltyList = new ArrayList<>();
        Connector cnn = new Connector();
        penaltyList = cnn.getPenaltyArray(fileName);
        for (int i = 0; i < penaltyList.size(); i++) {
            if(penaltyList.get(i).equalsIgnoreCase("Y")) {
                points++;
            }
        }
        return points;
    }

    protected int calculateAllPointsOfPlayer(String fileName){
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
