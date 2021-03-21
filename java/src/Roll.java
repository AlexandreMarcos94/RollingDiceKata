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
    private Integer temp;
    private String[] form;

    public Roll(String formula) {


        if(formula.matches("/([0-9]?[d][0-9]([+]|[-])?[0-9]?)/")){

            form = formula.split("d");
            Integer nbRoll = Integer.parseInt(form[0]);
            Integer dicevalue = Integer.parseInt(form[1]);
            System.out.print(nbRoll);
            System.out.print(dicevalue);

        } else {

           System.out.println(formula.matches("/([0-9]?[d][0-9]([+]|[-])?[0-9]?)/"));
            res = -1;
        }

    }



    public Roll(int diceValue, int nbRoll, int modifier) {
        unD = new Dice(diceValue);
        diceValue = unD.rollDice();
        if(diceValue < 1 || nbRoll < 1 ){
            res = -1;
        } else {
            for (int i = 0; i < nbRoll; i++) {
                res += diceValue;
            }
            res += modifier;
            if(res < -1){
                res = 0;
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
