package src;


import java.util.ArrayList;

public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes

    public Roll(String formula) {
       

    }

    public Roll(int diceValue, int nbRoll, int modifier) {
        int res = 0;
        for(int i = 0; i < nbRoll; i++){
            res += diceValue;
        }
    }

    public int makeRoll(RollType rollType) {
        if(rollType == RollType.NORMAL){

        }
        if(rollType == RollType.ADVANTAGE){

        }
        if(rollType == RollType.DISADVANTAGE){

        }

        return 0;
    }

}
