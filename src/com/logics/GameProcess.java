package com.logics;

import java.util.ArrayList;

public class GameProcess {
    private String activePlayer;
    private ArrayList<String> passivePlayer = new ArrayList<String>();
    private ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<String> playerlist = new ArrayList<String>();
    private int countWindows;
    public GameProcess(int playersCount){//, String[] playerNames){
        this.countWindows = 0;
        for (int i = 0; i < playersCount; i++) {
            String playerName = "p" + (i + 1);
            playerlist.add(playerName);
        }
        this.activePlayer = playerlist.get(0);
    }

    public ArrayList<String> savePlayerNames(ArrayList<String> playerNames){
        this.nameList = playerNames;
        return nameList;
    }
    public ArrayList<String> getPlayerNames(){
        return this.nameList;
    }

    public String getActivePlayerName(){
        String answer = "";
        String p = getActivePlayer();
        if (p.equalsIgnoreCase("p1")) {
            answer = getPlayerNames().get(0);
        }
        if (p.equalsIgnoreCase("p2")) {
            answer = getPlayerNames().get(1);
        }
        if (p.equalsIgnoreCase("p3")) {
            answer = getPlayerNames().get(2);
        }
        if (p.equalsIgnoreCase("p4")) {
            answer = getPlayerNames().get(3);
        }
        if (p.equalsIgnoreCase("p5")) {
            answer = getPlayerNames().get(4);
        }
        return answer; 
    }
    public String getPassivePlayerName(String playerName){
        String answer = "";
        String p = playerName;
        if (p.equalsIgnoreCase("p1")) {
            answer = getPlayerNames().get(0);
        }
        if (p.equalsIgnoreCase("p2")) {
            answer = getPlayerNames().get(1);
        }
        if (p.equalsIgnoreCase("p3")) {
            answer = getPlayerNames().get(2);
        }
        if (p.equalsIgnoreCase("p4")) {
            answer = getPlayerNames().get(3);
        }
        if (p.equalsIgnoreCase("p5")) {
            answer = getPlayerNames().get(4);
        }
        return answer;
    }

    public String getActivePlayer(){
        return activePlayer;
    }

    public int getCountWindows(){
        return countWindows;
    }

    public int addCountWindows(){
        countWindows++;
        return countWindows;
    }

    public int resetCountWindows(){
        countWindows = 0;
        return countWindows;
    }

    public ArrayList<String> getPassivePlayer(){
        passivePlayer = new ArrayList<>();
        for (String pl: playerlist) {
            if (pl!=activePlayer){
                passivePlayer.add(pl);
            }
        }
        return passivePlayer;
    }
    public ArrayList<String> getPlayerlist(){
        return playerlist;
    }
    public void nextRound(){
        int oldActivePlayerIndex = playerlist.indexOf(getActivePlayer());
        int newActivePlayerIndex = 0;
        if (playerlist.size()>(oldActivePlayerIndex+1)){
            newActivePlayerIndex = oldActivePlayerIndex+1;
        }

        activePlayer = playerlist.get(newActivePlayerIndex);
    }

}
