package com.logics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class Pathfinder {
    
    private static final String PATH_FOLDER        = "src\\com\\databases\\paths\\";
    private static final String P1_PATH_STORAGE    = "src\\com\\databases\\paths\\player1-FilePaths-";
    private static final String P2_PATH_STORAGE    = "src\\com\\databases\\paths\\player2-FilePaths-";
    private static final String P3_PATH_STORAGE    = "src\\com\\databases\\paths\\player3-FilePaths-";
    private static final String P4_PATH_STORAGE    = "src\\com\\databases\\paths\\player4-FilePaths-";
    private static final String P5_PATH_STORAGE    = "src\\com\\databases\\paths\\player5-FilePaths-";
    private static final String DICE_PATH_STORAGE  = "src\\com\\databases\\paths\\diceFilePaths-";


    protected Pathfinder() {
    }

    // This method creates a unique path for new (Path database) file
    // (Path Database): are used to store the paths of player and dice files 
    private String createPath_ForPathStorageFiles (String storageName) {
        String answer = "";
        LocalDateTime date = LocalDateTime.now();
        String st1 = ""+date;
        String st2 = st1.replace(':', '-');
        String st3 = st2.substring(0, 19);
        answer = storageName+st3+".csv";
        try {
            Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return answer;
    }

    // This method creates a CSV file to act as a storage for other database paths
    // Should be used only to create new files, if the files storing the paths for other
    // databases are damaged or for any reason is lost or deleted
    private void createOneFilePathStorage(String storageName) {
        String path = createPath_ForPathStorageFiles(storageName); 
        String inputDates = "Following are the saved paths of: "+ storageName +" files";   
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
    private void createDicePathFile(String dicePathStorage) {
        String path = createPath_ForPathStorageFiles(dicePathStorage);
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
    protected void createPathStorageFiles(int playerNumber) {

        switch (playerNumber) {
            case (1):   createOneFilePathStorage(P1_PATH_STORAGE);
                        createDicePathFile(DICE_PATH_STORAGE);
                break;
            case (2):   createOneFilePathStorage(P1_PATH_STORAGE);
                        createOneFilePathStorage(P2_PATH_STORAGE);
                        createDicePathFile(DICE_PATH_STORAGE);
                break;    
            case (3):   createOneFilePathStorage(P1_PATH_STORAGE);
                        createOneFilePathStorage(P2_PATH_STORAGE);
                        createOneFilePathStorage(P3_PATH_STORAGE);
                        createDicePathFile(DICE_PATH_STORAGE);
                break;
            case (4):   createOneFilePathStorage(P1_PATH_STORAGE);
                        createOneFilePathStorage(P2_PATH_STORAGE);
                        createOneFilePathStorage(P3_PATH_STORAGE);
                        createOneFilePathStorage(P4_PATH_STORAGE);
                        createDicePathFile(DICE_PATH_STORAGE);
                break;
            case (5):   createOneFilePathStorage(P1_PATH_STORAGE);
                        createOneFilePathStorage(P2_PATH_STORAGE);
                        createOneFilePathStorage(P3_PATH_STORAGE);
                        createOneFilePathStorage(P4_PATH_STORAGE);
                        createOneFilePathStorage(P5_PATH_STORAGE);
                        createDicePathFile(DICE_PATH_STORAGE);
                break;
            default:
                break;
        }
    }

    // This method gets the Paths file path as String and if found deletes it
    protected void deleteAllPathStorageFiles() {
        String folderPath = PATH_FOLDER;
        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    // This method returns the path of file containing (PathUser) in their names 
    // This file (PathUser) stores the paths of new USER_DATA file  
    public static String getPath_PlayerPathFile(String fileName) {
        String answer = "";
        String lastEightLetters = fileName.substring(fileName.length()-8);
        String str1 = "";
        File file = new File(PATH_FOLDER);
        String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                str1 = ""+fileList[i];
                if (str1.contains(lastEightLetters)) {
                    answer = PATH_FOLDER+fileList[i];
                }
            }
        return answer;
    }

    // This method saves/add the user data file path into the (PathUser) file
    protected void addNewPlayerFilePath(String newPlayerPath, String fileName) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(getPath_PlayerPathFile(fileName), true));
            bWriter.write("\n"+newPlayerPath);
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method returns the last line from the (player Path) file
    // the last line is the path of player file, where all player scores/points are stored
    protected String getLastFilePath_OfPlayer(String fileName) {
        String answer = "";
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(getPath_PlayerPathFile(fileName)));
                String csvLine = "";
                while ( (csvLine = bReader.readLine()) != null ) {
                    answer = csvLine;
                }
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return answer;
    }

}
