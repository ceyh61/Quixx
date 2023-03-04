package com.logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GameDataBase {

    private static final String PLAYER_FOLDER = "src\\com\\databases\\players\\";
    private static final String DICE_FOLDER   = "src\\com\\databases\\dice\\";
    private static final String PLAYER1_FILE = "src\\com\\databases\\players\\player1-";
    private static final String PLAYER2_FILE = "src\\com\\databases\\players\\player2-";
    private static final String PLAYER3_FILE = "src\\com\\databases\\players\\player3-";
    private static final String PLAYER4_FILE = "src\\com\\databases\\players\\player4-";
    private static final String PLAYER5_FILE = "src\\com\\databases\\players\\player5-";
    private static final String DICE_FILE    = "src\\com\\databases\\dice\\diceHistory-";
    
    public GameDataBase() {
    }

    // General Database methods:
    // -------------------------
    // -------------------------

    // This method returns the current date
    protected String getTheCurrentDate() {
        String currentDate = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        currentDate = formatter.format(date);
        return currentDate;
    }

    // This method returns the current time
    protected String getTheCurrentTime() {
        String currentTime = "";
        LocalTime time = LocalTime.now();  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");  
        currentTime = time.format(formatter);  
        return currentTime;
    }

    // Player Database methods:
    // ------------------------
    // ------------------------

    // This method creates a unique path for new database file by using date and time 
    private String createPath_ForPlayerFile (String playerName) {
        String answer = "";
        LocalDateTime date = LocalDateTime.now();
        String st1 = ""+date;
        String st2 = st1.replace(':', '-');
        String st3 = st2.substring(0, 19);
        answer = playerName+st3+".csv";
        try {
            Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return answer;
    }

    // This method creates a CSV file with the given path for storing players data
    private void createOnePlayerFile(String playerName) {
        String path = createPath_ForPlayerFile(playerName);
        Connector cnn = new Connector();
        cnn.savePlayerFilePath(path, playerName);

        String inputDates = 
            "1,2,3,4,5,6,7,8,9,10,11,12,13"+
            "\n2,3,4,5,6,7,8,9,10,11,12,Lock,penalty"+
            "\n2,3,4,5,6,7,8,9,10,11,12,Lock,penalty"+
            "\n12,11,10,9,8,7,6,5,4,3,2,Lock,penalty"+
            "\n12,11,10,9,8,7,6,5,4,3,2,Lock,penalty";   
        File csvFile = new File(path);
        FileWriter fileWriter;
        try  {
            fileWriter = new FileWriter(csvFile);
            fileWriter.write(inputDates);
            fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    // This method creates a CSV file with the given path for storing rolled dice data
    // the file will have one line/Header (ID,Job,FirstName,LastName,Email,Password)
    private void createDiceFile(String diceFile) {
        String path = createPath_ForPlayerFile(diceFile);
        //LogicAdministrator admin = new LogicAdministrator();
        //admin.saveUserDBpath(path);
        String inputDates = "The Following is the history of rolled dices in the game!";   
        File csvFile = new File(path);
        FileWriter fileWriter;
        try  {
            fileWriter = new FileWriter(csvFile);
            fileWriter.write(inputDates);
            fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    // This method gets the number of players that wants to play and creates CVS files accordingly
    protected void createPlayerFiles(int playerNumber) {

        switch (playerNumber) {
            case (1):   createOnePlayerFile(PLAYER1_FILE);
                        createDiceFile(DICE_FILE);
                break;
            case (2):   createOnePlayerFile(PLAYER1_FILE);
                        createOnePlayerFile(PLAYER2_FILE);
                        createDiceFile(DICE_FILE);
                break;    
            case (3):   createOnePlayerFile(PLAYER1_FILE);
                        createOnePlayerFile(PLAYER2_FILE);
                        createOnePlayerFile(PLAYER3_FILE);
                        createDiceFile(DICE_FILE);
                break;
            case (4):   createOnePlayerFile(PLAYER1_FILE);
                        createOnePlayerFile(PLAYER2_FILE);
                        createOnePlayerFile(PLAYER3_FILE);
                        createOnePlayerFile(PLAYER4_FILE);
                        createDiceFile(DICE_FILE);
                break;
            case (5):   createOnePlayerFile(PLAYER1_FILE);
                        createOnePlayerFile(PLAYER2_FILE);
                        createOnePlayerFile(PLAYER3_FILE);
                        createOnePlayerFile(PLAYER4_FILE);
                        createOnePlayerFile(PLAYER5_FILE);
                        createDiceFile(DICE_FILE);
                break;
            default:
                break;
        }
    }

    // This method gets the database file path as String and if found deletes it
    protected void deleteAllPlayerFiles() {
        String folderPath = PLAYER_FOLDER;

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Get an array of all files in the folder
        File[] files = folder.listFiles();

        // Loop through the files and delete each one
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    // This method gets the dice file path as String and if found deletes it
    protected void deleteDiceHistoryFiles() {
        String folderPath = DICE_FOLDER;
        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }




}
