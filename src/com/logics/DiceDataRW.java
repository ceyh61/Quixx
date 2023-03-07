package com.logics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DiceDataRW {
    
    private static final String COMMA_DELIMITER = ",";
    private static final String DICE_FILE    = "src\\com\\databases\\dice\\diceRoll-";
    private ArrayList<String> diceResultList = new ArrayList<>();

    private static final int DICE_WH1 = 0;
    private static final int DICE_WH2 = 1;
    private static final int DICE_RED = 2;
    private static final int DICE_YEL = 3;
    private static final int DICE_GRE = 4;
    private static final int DICE_BLU = 5;

    protected DiceDataRW() {
    }

    protected String readDiceFile() {
        String answer = "";
        Connector cnn = new Connector();
        String path = cnn.getLastFilePath(DICE_FILE);
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(path));
            String csvLine = "";
            while ( (csvLine = bReader.readLine()) != null ) {
                String[] dataLine = csvLine.split(COMMA_DELIMITER);
                diceResultList.clear();
                // saving the data of dices into an Arraylist
                diceResultList.add(dataLine[DICE_WH1]);
                diceResultList.add(dataLine[DICE_WH2]);
                diceResultList.add(dataLine[DICE_RED]);
                diceResultList.add(dataLine[DICE_YEL]);
                diceResultList.add(dataLine[DICE_GRE]);
                diceResultList.add(dataLine[DICE_BLU]);
                
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        answer = ""+diceResultList;
        return answer;
    }
    
    // This method saves/add the dice data into (diceRoll) file
    protected void writeToDiceFile(String newDiceData) {
        Connector cnn = new Connector();
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(cnn.getLastFilePath(DICE_FILE), true));
            bWriter.write("\n"+newDiceData);
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
