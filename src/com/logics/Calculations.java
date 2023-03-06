import java.util.ArrayList;

public class Calculations {

    public Calculations(){

    }

    protected int calculateRedPoints(ArrayList<String> redRow){
        int points = 0;
        int countCross = 0;

        for(int i=0 ; i<redRow.size() ; i++){
            if (redRow.get(i).contains("X")){
                countCross++;
            }
        }

        if(countCross == 1){
            points = 1;
        } else if (countCross == 2) {
            points = 3;
        } else if (countCross == 3) {
            points = 6;
        } else if (countCross == 4) {
            points = 10;
        } else if (countCross == 5) {
            points = 15;
        } else if (countCross == 6) {
            points = 21;
        } else if (countCross == 7) {
            points = 28;
        } else if (countCross == 8) {
            points = 36;
        } else if (countCross == 9) {
            points = 45;
        } else if (countCross == 10) {
            points = 55;
        } else if (countCross == 11) {
            points = 66;
        } else if (countCross == 12) {
            points = 78;
        }

        return points;
    }
    protected int calculateYellowPoints(ArrayList<String> yellowRow){
        int points = 0;
        int countCross = 0;

        for(int i=0 ; i<yellowRow.size() ; i++){
            if (yellowRow.get(i).contains("X")){
                countCross++;
            }
        }

        if(countCross == 1){
            points = 1;
        } else if (countCross == 2) {
            points = 3;
        } else if (countCross == 3) {
            points = 6;
        } else if (countCross == 4) {
            points = 10;
        } else if (countCross == 5) {
            points = 15;
        } else if (countCross == 6) {
            points = 21;
        } else if (countCross == 7) {
            points = 28;
        } else if (countCross == 8) {
            points = 36;
        } else if (countCross == 9) {
            points = 45;
        } else if (countCross == 10) {
            points = 55;
        } else if (countCross == 11) {
            points = 66;
        } else if (countCross == 12) {
            points = 78;
        }

        return points;
    }
    protected int calculateGreenPoints(ArrayList<String> greenRow){
        int points = 0;
        int countCross = 0;

        for(int i=0 ; i<greenRow.size() ; i++){
            if (greenRow.get(i).contains("X")){
                countCross++;
            }
        }

        if(countCross == 1){
            points = 1;
        } else if (countCross == 2) {
            points = 3;
        } else if (countCross == 3) {
            points = 6;
        } else if (countCross == 4) {
            points = 10;
        } else if (countCross == 5) {
            points = 15;
        } else if (countCross == 6) {
            points = 21;
        } else if (countCross == 7) {
            points = 28;
        } else if (countCross == 8) {
            points = 36;
        } else if (countCross == 9) {
            points = 45;
        } else if (countCross == 10) {
            points = 55;
        } else if (countCross == 11) {
            points = 66;
        } else if (countCross == 12) {
            points = 78;
        }

        return points;
    }
    protected int calculateBluePoints(ArrayList<String> blueRow){
        int points = 0;
        int countCross = 0;

        for(int i=0 ; i<blueRow.size() ; i++){
            if (blueRow.get(i).contains("X")){
                countCross++;
            }
        }

        if(countCross == 1){
            points = 1;
        } else if (countCross == 2) {
            points = 3;
        } else if (countCross == 3) {
            points = 6;
        } else if (countCross == 4) {
            points = 10;
        } else if (countCross == 5) {
            points = 15;
        } else if (countCross == 6) {
            points = 21;
        } else if (countCross == 7) {
            points = 28;
        } else if (countCross == 8) {
            points = 36;
        } else if (countCross == 9) {
            points = 45;
        } else if (countCross == 10) {
            points = 55;
        } else if (countCross == 11) {
            points = 66;
        } else if (countCross == 12) {
            points = 78;
        }

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
