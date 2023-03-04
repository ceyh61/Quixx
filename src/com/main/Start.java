package com.main;

import java.io.File;

import com.UI.*;
import com.logics.*;

public class Start {

    private static final String PATH_FOLDER  = "src\\com\\databases\\paths\\";
    private static final String PLAYER1_FILE = "src\\com\\databases\\players\\player1-";
    
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

    public static void testgetLastPath (String fileName){
        String st = fileName;
        Connector cnn = new Connector();
        cnn.getPlayerFilePath(st);
    }

    public static void main(String[] args) throws Exception{
        //toWelcomePage();
        //testCreatePlayerFiles();
        //testDeletePlayerFiles();
        //testCreatePathFiles();
        testDeletePathFiles();
        //testgetPath_PlayerPathFile(PLAYER1_FILE);
        //test();
        //System.out.println(testgetPath_PlayerPathFile(PLAYER1_FILE));
    }

}
