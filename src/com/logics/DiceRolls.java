package com.logics;

import java.util.ArrayList;

public class DiceRolls {
    
    private static final int NUMBER_OF_DICES = 6;
    private ArrayList<Integer> diceList = new ArrayList<>();
    
    protected DiceRolls() {
    }

    protected String rollTheDices() {
        String answer = "";
        for (int i = 0; i < NUMBER_OF_DICES; i++) {
            int randomNo = ( (int) (Math.random()*6) ) + 1;
            diceList.add(randomNo);
        }

        String a = ""+diceList;
        // cuts the first and the last character from the String, which are the parantheses
        String b = a.substring(1, a.length()-1);
        // eleminates all the spaces from the String so there would be no problem in CSV file
        answer = b.replaceAll("\\s", "");
        return answer;
    }

    protected String checkDiceAvalability() {
        String answer = "";
        return answer;
    }
}
