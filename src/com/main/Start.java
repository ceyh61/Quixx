package com.main;

import java.io.File;
import java.util.ArrayList;

import com.UI.*;
import com.logics.*;

public class Start {

    private static final String PATH_FOLDER  = "src\\com\\databases\\paths\\";
    private static final String PLAYER1_FILE = "src\\com\\databases\\players\\player01-";
    private static final String PLAYER2_FILE = "src\\com\\databases\\players\\player02-";
    private static final String PLAYER3_FILE = "src\\com\\databases\\players\\player03-";
    private static final String PLAYER4_FILE = "src\\com\\databases\\players\\player04-";
    private static final String PLAYER5_FILE = "src\\com\\databases\\players\\player05-";
    private static final String DICE_FILE    = "src\\com\\databases\\dice\\diceRoll-";
    
    public static void toWelcomePage (){
        new Welcome();
    }

    public static void testCreatePlayerFiles (){
        Connector cnn = new Connector();
        cnn.createPlayerFiles(5);
    }

    public static void testCreateOnePlayerFiles (String playerName){
        Connector cnn = new Connector();
        cnn.createOnePlayerFiles(playerName);;
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
        answer = cnn.getLastFilePath(st);
        return answer;
    }
/* 
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
*/
    public static String testgetDiceData (){
        String answer = "";
        Connector cnn = new Connector();
        answer = cnn.getLastDiceData();
        return answer;
    }

    public static String testing1 (){
        String answer = "";
        ArrayList<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("melon");
        answer = ""+list;
        return answer;
    }
    public static String testing2 (){
        String answer = "";
        Connector cnn = new Connector();
        answer = cnn.getLastDiceData();
        return answer;
    }

    public static void testSaveDice(String diceData) {
        Connector cnn = new Connector();
        cnn.saveDiceData(diceData);
    }

    public static String testRollingDice(){
        String answer = "";
        Connector cnn = new Connector();
        answer = cnn.getDiceRollingResult();
        return answer;
    }

/*     
    public static String testReadPlayerData(String fileName){
        String answer = "";
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.getPlayerBoardData(fileName);
        return answer;
    }
*/    

    public static String testGetOneNumber(String fileName, String color, String number){
        String answer = "";
        Connector cnn = new Connector();
        answer = cnn.get_A_Number(fileName, color, number);
        return answer;
    }

    public static ArrayList<String> testGetOneLine(String fileName, String color) {
        ArrayList<String> answer = new ArrayList<>();
        Connector cnn = new Connector();
        answer = cnn.get_A_Line(fileName, color) ;
        return answer;
    }

    public static boolean testIsNumCrossed(String fileName, String color, String number){
        boolean answer = false;
        Connector cnn = new Connector();
        answer = cnn.isNumberCrossed(fileName, color, number);
        return answer;
    }
/* 
    public static String testGetACrossedLine(String fileName, String color, String number){
        String answer = "";
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.createALineWithCrossedNumber(fileName, color, number);
        return answer;
    }
*/
    public static String testCrossANumber(String fileName, String color, String number){
        String answer = "";
        Connector cnn = new Connector();
        answer = cnn.crossANumber(fileName, color, number);
        return answer;
    }
/* 
    public static ArrayList<String> testNumberOfPenalties(String fileName){
        ArrayList<String> answer = new ArrayList<>();
        PlayerDataRW pd = new PlayerDataRW();
        answer = pd.checkThePenalties(fileName);
        return answer;
    }
*/
    public static int testGetPenaltyNumber(String fileName){
        int answer = 0;
        Connector cnn = new Connector();
        answer = cnn.getPenaltyNumbers(fileName);
        return answer;
    }

    public static void main(String[] args) throws Exception{
        //toWelcomePage();
        //System.out.println(testing1());
        //System.out.println(testing2());
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
        //System.out.println(testgetLastPath(DICE_FILE));
        //System.out.println(testNameValidation("PLAYERFILE"));
        //System.out.println(testNameLength("PLAYERFILE"));
        //System.out.println(testgetDiceData());
        //testSaveDice("1,1,1,1,1,1");
        //System.out.println(testRollingDice());
        //System.out.println(testReadPlayerData("p1"));
        //System.out.println(testGetOneNumber("p1", "red", "2"));
        //System.out.println(testGetOneLine("p1", "blu"));
        //System.out.println(testIsNumCrossed("p1", "red", "5"));
        //testCreateOnePlayerFiles("p2");
        //System.out.println(testGetACrossedLine("p1", "red", "10"));
        //System.out.println(testCrossANumber("p1", "blu", "10"));
        //System.out.println(testNumberOfPenalties("p1"));
        //System.out.println(testGetPenaltyNumber("p1"));
    }

}
