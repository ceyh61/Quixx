package com.logics;

import java.util.ArrayList;

public class Connector {
    
    public Connector() {
    }

    //------------------------------------------------------------
    //---Content:-------------------------------------------------
    //---1. Database methods -------------------------------------
    //---2. Pathfinder methods -----------------------------------
    //---3. Player input methods ---------------------------------
    //---4. Dice Read/Write methods ------------------------------
    //---5. Dice Rolling methods ---------------------------------
    //---6. Player Data Read/Write methods -----------------------
    //---7. Calculations methods ---------------------------------
    //------------------------------------------------------------


    //------------------------------------------------------------
    //---1.---------------Datbase methods-------------------------
    //------------------------------------------------------------

    // This method gets the number of players and create CSV files for each player
    public void createPlayerFiles(int numberOfPlayers) {
        GameDataBase gDB = new GameDataBase();
        gDB.createPlayerFiles(numberOfPlayers);
    }

    // This method gets the name of players and creates an empty CSV file
    public void createOnePlayerFiles(String playerName) {
        GameDataBase gDB = new GameDataBase();
        gDB.createOneEmptyFile(playerName);;
    }

    // This method deletes all the files in the players folder
    public void deletePlayerFiles() {
        GameDataBase gDB = new GameDataBase();
        gDB.deleteAllPlayerFiles();
    }

    // This method deletes all the files in the dice folder
    public void deleteDiceFiles() {
        GameDataBase gDB = new GameDataBase();
        gDB.deleteDiceHistoryFiles();
    }

    // This method gets a path and deletes the given file 
    public void deleteOneFile(String deletePath) {
        GameDataBase gDB = new GameDataBase();
        gDB.deleteOnePlayerFile(deletePath);
    }

    //------------------------------------------------------------
    //---2.---------------Pathfinder methods----------------------
    //------------------------------------------------------------

    // This method gets the number of players and create one file for each player
    // to store their scoreboard file paths after they are edited/write
    public void createPathFiles(int numberOFPlayers) {
        Pathfinder pf = new Pathfinder();
        pf.createPathStorageFiles(numberOFPlayers);
    }

    // This method deletes all the files in the Paths folder
    public void deletePathFiles() {
        Pathfinder pf = new Pathfinder();
        pf.deleteAllPathStorageFiles();
    }

    public void savePlayerFilePath(String newPlayerPath, String fileName) {
        Pathfinder pf = new Pathfinder();
        pf.addNewPlayerFilePath(newPlayerPath, fileName);
    }

    public String getLastFilePath(String fileName) {
        String answer = "";
        Pathfinder pf = new Pathfinder();
        answer = pf.getLastSavedFilePath(fileName);
        return answer;
    }

    //------------------------------------------------------------
    //---3.---------------Player input methods--------------------
    //------------------------------------------------------------
/* 
    // This method checks if a player name is between 1-10 characters
    public boolean nameLengthCheck(String playerName) {
        NameValidation nv = new NameValidation();
        boolean b = nv.isName_Length_Valid(playerName);
        return b;
    }

    // This method checks if a players name contains only letter 
    public boolean nameCharacterCheck(String playerName) {
        NameValidation nv = new NameValidation();
        boolean b = nv.isName_Character_Valid(playerName);
        return b;
    }
*/
    // This method checks if a player name is between 1-10 characters
    // and checks if a players name contains only letter 
    public String validateName(String fileName) {
        String answer = "";
        Pathfinder pf = new Pathfinder();
        answer = pf.getLastSavedFilePath(fileName);
        return answer;
    }

    //------------------------------------------------------------
    //---4.---------------Dice Read/Write methods-----------------
    //------------------------------------------------------------

    public String getLastDiceData() {
        String answer = "";
        DiceDataRW dd = new DiceDataRW();
        answer = dd.readDiceFile();
        return answer;
    }

    public void saveDiceData(String newDiceData) {
        DiceDataRW dd = new DiceDataRW();
        dd.writeToDiceFile(newDiceData);
    }

    //------------------------------------------------------------
    //---5.---------------Dice Rolling methods--------------------
    //------------------------------------------------------------

    public String getDiceRollingResult() {
        String answer = "";
        DiceRolls dr = new DiceRolls();
        answer = dr.rollTheDices();
        return answer;
    }

    //------------------------------------------------------------
    //---6.------------Player Data Read/Write methods-------------
    //------------------------------------------------------------

    // This method gets the (file name, color type and chosen number)
    // returns the number as a String
    public String get_A_Number(String fileName, String color, String number) {
        String answer = "";
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.readOnlyOneNumber(fileName, color, number);
        return answer;
    }

    // This method gets the file name and color and returns all numbers of that color
    public ArrayList<String> get_A_Line(String fileName, String color) {
        ArrayList<String> answer = new ArrayList<>();
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.readOnlyOneLine(fileName, color);
        return answer;
    }

    public boolean isNumberCrossed(String fileName, String color, String number) {
        boolean b = false;
        PlayerDataRW pd = new PlayerDataRW();
        b = pd.checkIfNumberIsCrossed(fileName, color, number);
        return b;
    }

    public String crossANumber(String fileName, String color, String number) {
        String answer = "";
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.crossANumberInBoard(fileName, color, number);
        return answer;
    }

    //------------------------------------------------------------
    //---7.------------Calculations methods-----------------------
    //------------------------------------------------------------

    public boolean isRedRowComplete() {
        boolean b = false;
        return b;
    }
    public boolean isYellowRowComplete() {
        boolean b = false;
        return b;
    }
    public boolean isGreenRowComplete() {
        boolean b = false;
        return b;
    }
    public boolean isBlueRowComplete() {
        boolean b = false;
        return b;
    }

}