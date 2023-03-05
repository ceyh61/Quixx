package com.main;

import java.io.File;

import com.UI.*;
import com.logics.*;

public class Start {

    private static final String PATH_FOLDER  = "src\\com\\databases\\paths\\";
    private static final String PLAYER1_FILE = "src\\com\\databases\\players\\player01-";
    private static final String PLAYER2_FILE = "src\\com\\databases\\players\\player02-";
    private static final String PLAYER3_FILE = "src\\com\\databases\\players\\player03-";
    private static final String PLAYER4_FILE = "src\\com\\databases\\players\\player04-";
    private static final String PLAYER5_FILE = "src\\com\\databases\\players\\player05-";
    
    public static void toWelcomePage (){
        new Welcome();
    }

    public static void testCreatePlayerFiles (){
        Connector cnn = new Connector();
        cnn.createPlayerFiles(5);
    }

    public static void testDeletePlayerFiles (){
        Connector cnn = new Connector();
        cnn.deletePlayerFiles();
        cnn.deleteDiceFiles();
    }

    public static void testCreatePathFiles (){
        Connector cnn = new Connector();
        cnn.createPathFiles(5);;
    }

    public static void testDeletePathFiles (){
        Connector cnn = new Connector();
        cnn.deletePathFiles();
    }

    public static String testgetPath_PlayerPathFile(String fileName) {
        String answer = "";
        String FirstSevenLetter = fileName.substring(fileName.length()-8);
        String str1 = "";
        File file = new File(PATH_FOLDER);
        String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                str1 = ""+fileList[i];
                if (str1.contains(FirstSevenLetter)) {
                    answer = PATH_FOLDER+fileList[i];
                }
            }
        return answer;
    }

    public static void test() {
        String st1 = ""+PLAYER1_FILE;
        String st2 = "player1-FilePaths-2023-03-04T14-13-29.csv";
        if(st1.contains(st2)){
            System.out.println(st1+st2);
        }
    }

    public static String testgetLastPath (String fileName){
        String answer = "";
        String st = fileName;
        Connector cnn = new Connector();
        answer = cnn.getPlayerFilePath(st);
        return answer;
    }

    public static boolean testNameValidation (String playerName){
        boolean answer = false;
        Connector cnn = new Connector();
        answer = cnn.nameCharacterCheck(playerName);
        return answer;
    }

    public static boolean testNameLength (String playerName){
        boolean answer = false;
        Connector cnn = new Connector();
        answer = cnn.nameLengthCheck(playerName);
        return answer;
    }

    public static void main(String[] args) throws Exception{
        //toWelcomePage();
        //testCreatePlayerFiles();
        //testDeletePlayerFiles();
        //testCreatePathFiles();
        //testDeletePathFiles();
        //testgetPath_PlayerPathFile(PLAYER1_FILE);
        //test();
        //System.out.println(testgetPath_PlayerPathFile(PLAYER1_FILE));
        //System.out.println(testgetLastPath(PLAYER1_FILE));
        //System.out.println(testgetLastPath(PLAYER2_FILE));
        //System.out.println(testgetLastPath(PLAYER3_FILE));
        //System.out.println(testgetLastPath(PLAYER4_FILE));
        //System.out.println(testgetLastPath(PLAYER5_FILE));
        System.out.println(testNameValidation("PLAYERFILE"));
        System.out.println(testNameLength("PLAYERFILE"));
    }

}
