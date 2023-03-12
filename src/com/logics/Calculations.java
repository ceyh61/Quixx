package com.logics;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculations {

    private static final String[] POINTS_ARRAY = {"0", "1", "3", "6", "10", "15", "21", "28", "36", "45", "55", "66", "78"};

    public Calculations(){

    }

    protected int calculateRedPoints(String fileName){
        int points = 0;
        int countCross = 0;

        Connector cn = new Connector();
        ArrayList <String> redRow = cn.get_A_Line(fileName, "red");
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

    protected int calculateYellowPoints(String fileName){
        int points = 0;
        int countCross = 0;


        Connector cn = new Connector();
        ArrayList <String> yellowRow = cn.get_A_Line(fileName, "yel");
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

    protected int calculateGreenPoints(String fileName){
        int points = 0;
        int countCross = 0;

        Connector cn = new Connector();
        ArrayList <String> greenRow = cn.get_A_Line(fileName, "gre");
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

    protected int calculateBluePoints(String fileName){
        int points = 0;
        int countCross = 0;

        Connector cn = new Connector();
        ArrayList <String> blueRow = cn.get_A_Line(fileName, "blu");
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
                points-= 5;
            }
        }
        return points;
    }

    public int calculateAllPointsOfPlayer(String fileName){
        int redPoints = calculateRedPoints(fileName);
        System.out.println(redPoints);
        int yellowPoints = calculateYellowPoints(fileName);
        int greenPoints = calculateGreenPoints(fileName);
        int bluePoints = calculateBluePoints(fileName);
        int penaltyPoints = calculatePenaltiesPoints(fileName);
        int playersPoints = redPoints+yellowPoints+greenPoints+bluePoints+penaltyPoints;

        return playersPoints;
    }
    public boolean checkIfAnyPlayerHasFourPenalties(int playersCount){
        boolean check = false;
        ArrayList <String> penaltyList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < playersCount; i++) {
            String fileName = "p" + (i+1);
            Connector cn = new Connector();
            penaltyList = cn.getPenaltyArray(fileName);
            for (int j = 0; j < penaltyList.size(); j++) {
                if(penaltyList.get(j).equalsIgnoreCase("Y")) {
                    counter++;
                }
            }

            if (counter ==4){
                check = true;
                break;
            }
            counter = 0;
        }

        return check;
    }
    public boolean checkIfTwoRowsAreDisabled(int playersCount){
        boolean check = false;
        int counter = 0;
        for (int i = 0; i < playersCount; i++) {
            String fileName = "p" + (i + 1);
            Connector cn = new Connector();
            if (cn.isNumberCrossed(fileName, "red", "12")) {
                counter++;
            }

            if (cn.isNumberCrossed(fileName, "yel", "12")) {
                counter++;
            }

            if (cn.isNumberCrossed(fileName, "gre", "2")) {
                counter++;
            }

            if (cn.isNumberCrossed(fileName, "blu", "2")) {
                counter++;
            }
        }

        if (counter>=2){
            check = true;
        }

        return check;
    }
}
