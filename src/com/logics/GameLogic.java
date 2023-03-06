import java.util.ArrayList;

public class GameLogic {

    private static final int NUMBER_DICES = 6;

    public GameLogic(){

    }
    private int getRandomNumberBetweenOneAndSix(){
        return (int)(Math.random()*6 +1);
    }

    public ArrayList<Integer> rollDice(int NUMBER_DICES){
        ArrayList<Integer> diceResults = new ArrayList<Integer>();

        for(int i=0;i<NUMBER_DICES;i++){
            diceResults.add(getRandomNumberBetweenOneAndSix());
        }
        return diceResults;
    }
}
