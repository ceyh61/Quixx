package com.logics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerDataRW {

    private static final String PLAYER1_FILE = "src\\com\\databases\\players\\player01-";
    private static final String PLAYER2_FILE = "src\\com\\databases\\players\\player02-";
    private static final String PLAYER3_FILE = "src\\com\\databases\\players\\player03-";
    private static final String PLAYER4_FILE = "src\\com\\databases\\players\\player04-";
    private static final String PLAYER5_FILE = "src\\com\\databases\\players\\player05-";
    private static final String DICE_FILE    = "src\\com\\databases\\dice\\diceRoll-";
    
    private static final String COMMA_DELIMITER = ",";
    private static final String CROSSED_SYMBOL = "X";

    private static final int LINE_RED_INDEX = 0;
    private static final int LINE_YEL_INDEX = 1;
    private static final int LINE_GRE_INDEX = 2;
    private static final int LINE_BLU_INDEX = 3;

    private static final int RED_2_INDEX = 0;
    private static final int RED_3_INDEX = 1;
    private static final int RED_4_INDEX = 2;
    private static final int RED_5_INDEX = 3;
    private static final int RED_6_INDEX = 4;
    private static final int RED_7_INDEX = 5;
    private static final int RED_8_INDEX = 6;
    private static final int RED_9_INDEX = 7;
    private static final int RED_10_INDEX = 8;
    private static final int RED_11_INDEX = 9;
    private static final int RED_12_INDEX = 10;
    private static final int RED_LOCK_INDEX = 11;
    private static final int RED_PENALTY_INDEX = 12;

    private static final int YEL_2_INDEX = 0;
    private static final int YEL_3_INDEX = 1;
    private static final int YEL_4_INDEX = 2;
    private static final int YEL_5_INDEX = 3;
    private static final int YEL_6_INDEX = 4;
    private static final int YEL_7_INDEX = 5;
    private static final int YEL_8_INDEX = 6;
    private static final int YEL_9_INDEX = 7;
    private static final int YEL_10_INDEX = 8;
    private static final int YEL_11_INDEX = 9;
    private static final int YEL_12_INDEX = 10;
    private static final int YEL_LOCK_INDEX = 11;
    private static final int YEL_PENALTY_INDEX = 12;

    private static final int GRE_2_INDEX = 10;
    private static final int GRE_3_INDEX = 9;
    private static final int GRE_4_INDEX = 8;
    private static final int GRE_5_INDEX = 7;
    private static final int GRE_6_INDEX = 6;
    private static final int GRE_7_INDEX = 5;
    private static final int GRE_8_INDEX = 4;
    private static final int GRE_9_INDEX = 3;
    private static final int GRE_10_INDEX = 2;
    private static final int GRE_11_INDEX = 1;
    private static final int GRE_12_INDEX = 0;
    private static final int GRE_LOCK_INDEX = 11;
    private static final int GRE_PENALTY_INDEX = 12;

    private static final int BLU_2_INDEX = 10;
    private static final int BLU_3_INDEX = 9;
    private static final int BLU_4_INDEX = 8;
    private static final int BLU_5_INDEX = 7;
    private static final int BLU_6_INDEX = 6;
    private static final int BLU_7_INDEX = 5;
    private static final int BLU_8_INDEX = 4;
    private static final int BLU_9_INDEX = 3;
    private static final int BLU_10_INDEX = 2;
    private static final int BLU_11_INDEX = 1;
    private static final int BLU_12_INDEX = 0;
    private static final int BLU_LOCK_INDEX = 11;
    private static final int BLU_PENALTY_INDEX = 12;

    private ArrayList<ArrayList<String>> playerBoardList = new ArrayList<>();

    private ArrayList<String> pRedLine = new ArrayList<>();
    private ArrayList<String> pYelLine = new ArrayList<>();
    private ArrayList<String> pGreLine = new ArrayList<>();
    private ArrayList<String> pBluLine = new ArrayList<>();

    public PlayerDataRW() {
    }

    // This method saves the booking data into (BookingData) CSV file
    private void writeToPlayerFile(String playerName, String newLine) {
        String s = getPlayerFileIndex(playerName);
        Connector cnn = new Connector();
        String path = cnn.getLastFilePath(s);
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(path, true));
            bWriter.write("\n"+newLine);
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method gets the file name and then reads it
    // while reading the file saves the file data in 4 different ArrayList 
    // each ArrayList contains the data of one color
    private void readPlayersFile(String fileName) {
        Connector cnn = new Connector();
        String path = cnn.getLastFilePath(fileName);
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(path));

            String csvLine = "";
            int lineCount = 0;
            while ( (csvLine = bReader.readLine()) != null ) {
                String[] dataLine = csvLine.split(COMMA_DELIMITER);
                lineCount++;

                if (lineCount == 1) {
                    pRedLine.add(dataLine[RED_2_INDEX]);
                    pRedLine.add(dataLine[RED_3_INDEX]);
                    pRedLine.add(dataLine[RED_4_INDEX]);
                    pRedLine.add(dataLine[RED_5_INDEX]);
                    pRedLine.add(dataLine[RED_6_INDEX]);
                    pRedLine.add(dataLine[RED_7_INDEX]);
                    pRedLine.add(dataLine[RED_8_INDEX]);
                    pRedLine.add(dataLine[RED_9_INDEX]);
                    pRedLine.add(dataLine[RED_10_INDEX]);
                    pRedLine.add(dataLine[RED_11_INDEX]);
                    pRedLine.add(dataLine[RED_12_INDEX]);
                    pRedLine.add(dataLine[RED_LOCK_INDEX]);
                    pRedLine.add(dataLine[RED_PENALTY_INDEX]);
                } 
                else if (lineCount == 2) {
                    pYelLine.add(dataLine[YEL_2_INDEX]);
                    pYelLine.add(dataLine[YEL_3_INDEX]);
                    pYelLine.add(dataLine[YEL_4_INDEX]);
                    pYelLine.add(dataLine[YEL_5_INDEX]);
                    pYelLine.add(dataLine[YEL_6_INDEX]);
                    pYelLine.add(dataLine[YEL_7_INDEX]);
                    pYelLine.add(dataLine[YEL_8_INDEX]);
                    pYelLine.add(dataLine[YEL_9_INDEX]);
                    pYelLine.add(dataLine[YEL_10_INDEX]);
                    pYelLine.add(dataLine[YEL_11_INDEX]);
                    pYelLine.add(dataLine[YEL_12_INDEX]);
                    pYelLine.add(dataLine[YEL_LOCK_INDEX]);
                    pYelLine.add(dataLine[YEL_PENALTY_INDEX]);
                }
                else if (lineCount == 3) {
                    pGreLine.add(dataLine[GRE_12_INDEX]);
                    pGreLine.add(dataLine[GRE_11_INDEX]);
                    pGreLine.add(dataLine[GRE_10_INDEX]);
                    pGreLine.add(dataLine[GRE_9_INDEX]);
                    pGreLine.add(dataLine[GRE_8_INDEX]);
                    pGreLine.add(dataLine[GRE_7_INDEX]);
                    pGreLine.add(dataLine[GRE_6_INDEX]);
                    pGreLine.add(dataLine[GRE_5_INDEX]);
                    pGreLine.add(dataLine[GRE_4_INDEX]);
                    pGreLine.add(dataLine[GRE_3_INDEX]);
                    pGreLine.add(dataLine[GRE_2_INDEX]);
                    pGreLine.add(dataLine[GRE_LOCK_INDEX]);
                    pGreLine.add(dataLine[GRE_PENALTY_INDEX]);
                } 
                else if (lineCount == 4) {
                    pBluLine.add(dataLine[BLU_12_INDEX]);
                    pBluLine.add(dataLine[BLU_11_INDEX]);
                    pBluLine.add(dataLine[BLU_10_INDEX]);
                    pBluLine.add(dataLine[BLU_9_INDEX]);
                    pBluLine.add(dataLine[BLU_8_INDEX]);
                    pBluLine.add(dataLine[BLU_7_INDEX]);
                    pBluLine.add(dataLine[BLU_6_INDEX]);
                    pBluLine.add(dataLine[BLU_5_INDEX]);
                    pBluLine.add(dataLine[BLU_4_INDEX]);
                    pBluLine.add(dataLine[BLU_3_INDEX]);
                    pBluLine.add(dataLine[BLU_2_INDEX]);
                    pBluLine.add(dataLine[BLU_LOCK_INDEX]);
                    pBluLine.add(dataLine[BLU_PENALTY_INDEX]);
                }
            }
            // adding all ArrayLists to the one ArrayList 
            // the new/2D ArrayList will save other ArrayLists as its elements
            playerBoardList.add(pRedLine);
            playerBoardList.add(pYelLine);
            playerBoardList.add(pGreLine);
            playerBoardList.add(pBluLine);
            
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerBoardData(String fileName) {
        String a = "";
        String path = getPlayerFileIndex(fileName);
        readPlayersFile(path);
        a = ""+playerBoardList;
        return a;
    }

    // method receives 3 inputs: file name, color, and the number to be crossed 
    // method finds the specific number and checks if it is already marked or not
    // if not then marks the number (replaces it with an x/X)
    protected String readOnlyOneNumber(String fileName, String color, String number) {
        String answer = "";
        ArrayList<String> aList = new ArrayList<>();
        // reads and finds the correct line (red, yellow, green or blue)
        aList = readOnlyOneLine(fileName, color);
        // finds the correct index of the chosen number in then ArrayList
        int c = getNumberIndex(color, number);
        answer = aList.get(c);
        return answer;
    }

    
    // method receives 2 input: file name and the color 
    // it returns the requested line as an ArrayList back
    protected ArrayList<String> readOnlyOneLine(String fileName, String color) {
        ArrayList<String> answer = new ArrayList<>();
        String path = getPlayerFileIndex(fileName);
        // first puts all the player file data into ArrayLists
        readPlayersFile(path);
        int i = getColorIndex(color);
        if (i == 0) {
            answer = pRedLine;
        } 
        else if (i == 1){
            answer = pYelLine;
        }
        else if (i == 2){
            answer = pGreLine;
        }
        else if (i == 3){
            answer = pBluLine;
        }
        return answer;
    }

    private String createALineWithCrossedNumber(String fileName, String color, String number) {
        String answer = "";
        int i = getNumberIndex(color, number);
        ArrayList <String> aL = new ArrayList<>();
        aL = readOnlyOneLine(fileName, color);
        aL.set(i, CROSSED_SYMBOL);
        answer = ""+aL;
        // cuts the first and the last character from the String, which are the parantheses
        answer = answer.substring(1, answer.length()-1);
        return answer;

    }
    protected String crossANumberInBoard(String fileName, String color, String number) {
        String answer = "";
        boolean b = checkIfNumberIsCrossed(fileName, color, number);
        if (b == false) {
            String newLine = createALineWithCrossedNumber(fileName, color, number);
            answer = saveChangesIntoPlayerFile(fileName, color, number, newLine);
        } else {
            answer = "Number is already Crossed!";
        }
        return answer;
    }

    private String saveChangesIntoPlayerFile(String fileName, String color, String number, String newLine) {
        String answer = "";
        int c = getColorIndex(color);
        String s = getPlayerFileIndex(fileName);
        Connector cnn = new Connector();
        String currentPath = cnn.getLastFilePath(s);
        cnn.createOnePlayerFiles(s);

        try {
            BufferedReader file_out = new BufferedReader(new FileReader(currentPath));
            String csvLine = "";
            int count = 0;
            while ( (csvLine = file_out.readLine()) != null ) {
                count++;
                // checks for the color/line that is needed to be rewritten
                if (count == c) {
                    // writes the new line instead of the old one
                    writeToPlayerFile(fileName, newLine);
                }else{
                    // writes back the old lines into the file
                    writeToPlayerFile(fileName, csvLine);
                }
            }
            file_out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cnn.deleteOneFile(currentPath);
        answer = "Number "+number+" is Crossed!";
        return answer;
    }

    // This method checks if the number is already crossed or not
    // Input: file name, color, number
    // Output:(true = number is already crossed) 
    protected boolean checkIfNumberIsCrossed(String fileName, String color, String number) {
        boolean b = false;
        String num = readOnlyOneNumber(fileName, color, number);
        if (num.equalsIgnoreCase("X") ) {
            b = true;
        }
        return b;
    }

    // method returns the Path of a given player
    private String getPlayerFileIndex(String fileName) {
        String answer = "";
        if (fileName.equalsIgnoreCase("p1")) {
            answer = PLAYER1_FILE;
        }
        if (fileName.equalsIgnoreCase("p2")) {
            answer = PLAYER2_FILE;
        }
        if (fileName.equalsIgnoreCase("p3")) {
            answer = PLAYER3_FILE;
        }
        if (fileName.equalsIgnoreCase("p4")) {
            answer = PLAYER4_FILE;
        }
        if (fileName.equalsIgnoreCase("p5")) {
            answer = PLAYER5_FILE;
        }
        if (fileName.equalsIgnoreCase("dc")) {
            answer = DICE_FILE;
        }
        return answer; 
    }

    // method returns the index in given color
    private int getColorIndex(String color) {
        int i = 0;
        if (color.equalsIgnoreCase("red")) {
            i = LINE_RED_INDEX;
        }
        if (color.equalsIgnoreCase("yel")) {
            i = LINE_YEL_INDEX;
        }
        if (color.equalsIgnoreCase("gre")) {
            i = LINE_GRE_INDEX;
        }
        if (color.equalsIgnoreCase("blu")) {
            i = LINE_BLU_INDEX;
        }
        return i; 
    }

    // method returns the index in given number of a specific color
    private int getNumberIndex(String color, String number) {
        int i = 0;
        int c = getColorIndex(color);

        if (c == 0 || c == 1) {
            switch (number) {
                case ("2"): i = RED_2_INDEX;
                    break;
                case ("3"): i = RED_3_INDEX;
                    break;
                case ("4"): i = RED_4_INDEX;
                    break;
                case ("5"): i = RED_5_INDEX;
                    break;
                case ("6"): i = RED_6_INDEX;
                    break;
                case ("7"): i = RED_7_INDEX;
                    break;
                case ("8"): i = RED_8_INDEX;
                    break;
                case ("9"): i = RED_9_INDEX;
                    break;
                case ("10"): i = RED_10_INDEX;
                    break;
                case ("11"): i = RED_11_INDEX;
                    break;
                case ("12"): i = RED_12_INDEX;
                    break;
                case ("L"): i = RED_LOCK_INDEX;
                    break;
                case ("P"): i = RED_PENALTY_INDEX;
                    break;
                default:
                    break;
            }
        }
        if (c == 2 || c == 3) {
            switch (number) {
                case ("2"): i = GRE_2_INDEX;
                    break;
                case ("3"): i = GRE_3_INDEX;
                    break;
                case ("4"): i = GRE_4_INDEX;
                    break;
                case ("5"): i = GRE_5_INDEX;
                    break;
                case ("6"): i = GRE_6_INDEX;
                    break;
                case ("7"): i = GRE_7_INDEX;
                    break;
                case ("8"): i = GRE_8_INDEX;
                    break;
                case ("9"): i = GRE_9_INDEX;
                    break;
                case ("10"): i = GRE_10_INDEX;
                    break;
                case ("11"): i = GRE_11_INDEX;
                    break;
                case ("12"): i = GRE_12_INDEX;
                    break;
                case ("L"): i = GRE_LOCK_INDEX;
                    break;
                case ("P"): i = GRE_PENALTY_INDEX;
                    break;
                default:
                    break;
            }
        }
        return i; 
    }
}
