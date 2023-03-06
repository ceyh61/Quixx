package com.logics;

public class Connector {
    
    public boolean redRowComplete;
    public boolean yellowRowComplete;
    public boolean greenRowComplete;
    public boolean blueRowComplete;
    
    public Connector() {
        redRowComplete = true;
        yellowRowComplete = false;
        greenRowComplete = false;
        blueRowComplete = true;
    }

    //------------------------------------------------------------
    //---Content:-------------------------------------------------
    //---1. Database methods -------------------------------------
    //---2. Pathfinder methods -----------------------------------
    //---3. Player input methods ---------------------------------
    //---4. Booking methods --------------------------------------
    //---5. User methods -----------------------------------
    //---6. Utility methods --------------------------------------
    //------------------------------------------------------------


    //------------------------------------------------------------
    //---1.---------------Datbase methods-------------------------
    //------------------------------------------------------------

    // This method gets the number of players and create CSV files for each player
    public void createPlayerFiles(int numberOfPlayers) {
        GameDataBase gDB = new GameDataBase();
        gDB.createPlayerFiles(numberOfPlayers);
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

    public String getPlayerFilePath(String fileName) {
        String answer = "";
        Pathfinder pf = new Pathfinder();
        answer = pf.getLastSavedFilePath(fileName);
        return answer;
    }

    //------------------------------------------------------------
    //---3.---------------Player input methods--------------------
    //------------------------------------------------------------

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
   
    //------------------------------------------------------------
    //---4.---------------Calculation methods--------------------
    //------------------------------------------------------------
    
    // This method checks if the game should end
    public boolean checkIfGameEnds(){
        boolean check = false;
        Calculations calculation = new Calculations();

        if(calculation.checkIfAnyPlayerHasFourPenalties()){
            check = true;
        } else if (calculation.checkIfTwoRowsAreDisabled()){
            check = true;
        }

        return check;
    }
    //------------------------------------------------------------
    //---5.---------------GameLogic methods--------------------
    //------------------------------------------------------------

    public boolean isRedRowComplete() {
        return redRowComplete;
    }

    public boolean isYellowRowComplete() {
        return yellowRowComplete;
    }

    public boolean isGreenRowComplete() {
        return greenRowComplete;
    }

    public boolean isBlueRowComplete() {
        return blueRowComplete;
    }
}
