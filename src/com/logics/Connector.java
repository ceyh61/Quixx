package com.logics;

public class Connector {
    
    public Connector() {
    }

    //------------------------------------------------------------
    //---Content:-------------------------------------------------
    //---1. Database methods -------------------------------------
    //---2. Pathfinder methods -----------------------------------------
    //---3. Room methods -----------------------------------------
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
        answer = pf.getLastFilePath_OfPlayer(fileName);
        return answer;
    }
}
