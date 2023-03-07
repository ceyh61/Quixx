package com.logics;

import java.util.ArrayList;

public class GameLogic {

    private static final int NUMBER_DICES = 6;

    public GameLogic(){

    }
    private int getRandomNumberBetweenOneAndSix(){
        return (int)(Math.random()*6 +1);
    }

    public ArrayList<Integer> createDiceArrayList(){
        ArrayList<Integer> diceResults = new ArrayList<Integer>();
        boolean redRow = new Connector().isRedRowComplete();
        boolean greenRow = new Connector().isYellowRowComplete();
        boolean yellowRow = new Connector().isGreenRowComplete();
        boolean blueRow = new Connector().isBlueRowComplete();

        for(int i=0;i<NUMBER_DICES;i++) {
            if (redRow && i == 2) {
                diceResults.add(0);
            } else if (yellowRow && i == 3) {
                diceResults.add(0);
            } else if (greenRow && i == 4) {
                diceResults.add(0);
            } else if (blueRow && i == 5) {
                diceResults.add(0);
            } else {
                diceResults.add(getRandomNumberBetweenOneAndSix());
            }
        }
        return diceResults;
    }
}
