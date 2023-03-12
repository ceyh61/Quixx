package com.logics;

import java.util.ArrayList;
import java.util.Arrays;

public class GameProcess {
    private String activePlayer;
    private ArrayList<String> passivePlayer = new ArrayList<String>();
    ArrayList<String> playerlist = new ArrayList<String>();
    private int countWindows;
    public GameProcess(int playersCount){
        this.countWindows = 0;
        for (int i = 0; i < playersCount; i++) {
            String playerName = "p" + (i + 1);
            playerlist.add(playerName);
        }
        this.activePlayer = playerlist.get(0);
    }

    /*protected cycle(int playersCount){

    }*/

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
        if (playerlist.size()>=(oldActivePlayerIndex+1)){
            newActivePlayerIndex = oldActivePlayerIndex+1;
        }

        activePlayer = playerlist.get(newActivePlayerIndex);
    }

}
