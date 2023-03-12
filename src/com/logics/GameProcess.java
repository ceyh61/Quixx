package com.logics;

import java.util.ArrayList;
import java.util.Arrays;

public class GameProcess {
    private String activePlayer;
    private ArrayList<String> passivePlayer = new ArrayList<String>();
    ArrayList<String> playerlist = new ArrayList<String>();
    public GameProcess(int playersCount){
        this.activePlayer = null;
        for (int i = 0; i < playersCount; i++) {
            String playerName = "p" + (i + 1);
            playerlist.add(playerName);
        }
    }

    /*protected cycle(int playersCount){

    }*/

    public String getActivePlayer(){
            if (activePlayer == null){
            activePlayer = playerlist.get(0);
        }

        return activePlayer;
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
