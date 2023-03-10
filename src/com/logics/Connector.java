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

    // This method saves the path of newly generated player file to the specific (player-FilePath) file
    public void savePlayerFilePath(String newPlayerPath, String fileName) {
        Pathfinder pf = new Pathfinder();
        pf.addNewPlayerFilePath(newPlayerPath, fileName);
    }

    // This method searches for the last saved path of a specific player file and returns it as a String
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

    // This method reads the last line from the diceRoll file and returns it as a String
    public String getLastDiceData() {
        String answer = "";
        DiceDataRW dd = new DiceDataRW();
        String a = ""+ dd.readDiceFile();
        // cuts the first and the last character from the String, which are the parantheses
        String b = a.substring(1, a.length()-1);
        // eleminates all the spaces from the String so there would be no problem in CSV file
        answer = b.replaceAll("\\s", "");
        return answer;
    }

    // This method gets the six generated random numbers and saves it into the diceRoll CSV file
    public void saveDiceData(String newDiceData) {
        DiceDataRW dd = new DiceDataRW();
        dd.writeToDiceFile(newDiceData);
    }

    //------------------------------------------------------------
    //---5.---------------Dice Rolling methods--------------------
    //------------------------------------------------------------

    // This method returns a String of Six ramdom numbers between 1 to 6.
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

    // This method checks if the given number is already crossed or not
    public boolean isNumberCrossed(String fileName, String color, String number) {
        boolean b = false;
        PlayerDataRW pd = new PlayerDataRW();
        b = pd.checkIfNumberIsCrossed(fileName, color, number);
        return b;
    }

    // This method gets the player name, color and the chosen number and crosses it in the file
    public String crossANumber(String fileName, String color, String number) {
        String answer = "";
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.crossANumberInBoard(fileName, color, number);
        return answer;
    }

    // This method gives an ArrayList of last elements of each row from player file
    // these elements are used to calculate the number of penalties
    public ArrayList<String> getPenaltyArray(String fileName) {
        ArrayList<String> answer = new ArrayList<>();
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.checkThePenalties(fileName);
        return answer;
    }

    //------------------------------------------------------------
    //---7.------------Calculations methods-----------------------
    //------------------------------------------------------------

    // This method calculates the number of penalties for the given player/file name
    public int getPenaltyNumbers(String fileName) {
        int answer = 0;
        Calculations cal = new Calculations();
        answer = cal.calculatePenaltiesPoints(fileName);
        return answer;
    }

    public boolean checkGameEnd(int playersCount){
        Calculations cal = new Calculations();
        boolean end = false;
        if (cal.checkIfAnyPlayerHasFourPenalties(playersCount) || cal.checkIfTwoRowsAreDisabled(playersCount)){
            end = true;
        }
        return end;
    }

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