package src;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private int res = 0;
    private String[] temp;
    private String[] form;

    public Roll(String formula) {

        if(formula.matches("^([0-9]+[d][0-9]+)$")){
            System.out.println("cdc");
            form = formula.split("d");
            nbRoll = Integer.parseInt(form[0]);
            diceValue = Integer.parseInt(form[1]);
            modifier = 0;

            }

        if(formula.matches("^([d][0-9]+)$")) {
            System.out.println("dc");
            form = formula.split("d");
            nbRoll = 1;
            modifier = 0;
            diceValue = Integer.parseInt(form[1]);

        }

        if(formula.matches("^([d][0-9]+([+]|[-])[0-9]+)$")){
            System.out.println("dc+c");
            form = formula.split("d");
            temp = form[1].split("[+-]");
            nbRoll = 1;
            modifier = Integer.parseInt(temp[1]);
            diceValue = Integer.parseInt(temp[0]);

        }

        if(formula.matches("^[0-9]+([d][0-9]+([+]|[-])[0-9]+)$")) {
            System.out.println("cdc+c");
            form = formula.split("d");
            temp = form[1].split("[+-]");
            nbRoll = Integer.parseInt(form[0]);
            modifier = Integer.parseInt(temp[1]);
            diceValue = Integer.parseInt(temp[0]);

        }

        System.out.println(diceValue);
        System.out.println(modifier);
        System.out.println(nbRoll);

    }



    public Roll(int diceValue, int nbRoll, int modifier) {
        this.diceValue = diceValue;
        this.nbRoll = nbRoll;
        this.modifier = modifier;
    }

    public int makeRoll(RollType rollType) {

        this.unD = new Dice( this.diceValue);
        if( this.diceValue < 1 ||  this.nbRoll < 1 ){
            this.res = -1;
        } else {
            for (int i = 0; i <  this.nbRoll; i++) {
                this.res += this.unD.rollDice();
            }
            this.res +=  this.modifier;
            if( this.res < -1){
                this.res = 0;
            }
        }
        System.out.println("nb" + nbRoll);
        return  this.res;
    }

}
