package src;
import java.util.ArrayList;

public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes

    private int diceValue;
    private int nbRoll;
    private int modifier;
    private Dice unD;
    private int res;

    public Roll(String formula) {


    }



    public Roll(int diceValue, int nbRoll, int modifier) {
        unD = new Dice(diceValue);
        diceValue = unD.rollDice();
        if(diceValue < 1 || nbRoll < 1 || modifier < 0){
            res = -1;
        } else {
            for (int i = 0; i < nbRoll; i++) {

                res += diceValue;
            }
        }
    }

    public int makeRoll(RollType rollType) {
        if(rollType == RollType.NORMAL){
            nbRoll = 1;
        }
        if(rollType == RollType.ADVANTAGE){
            nbRoll = 2;
        }
        if(rollType == RollType.DISADVANTAGE){
            nbRoll = 2;
        }

        return res;
    }

}
