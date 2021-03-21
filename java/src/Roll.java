package src;

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
    private Boolean isN = false;
    private int res = 0;
    private String[] temp;
    private String[] form;

    public Roll(String formula) {

        if(formula.matches("^([0-9]+[d][0-9]+)$")){         // Check if the formula have the good format
            form = formula.split("d");                      // Split the formula to get values
            this.nbRoll = Integer.parseInt(form[0]);
            this.diceValue = Integer.parseInt(form[1]);
            this.modifier = 0;

            }

        if(formula.matches("^([d][0-9]+)$")) {
            form = formula.split("d");
            this.nbRoll = 1;
            this.modifier = 0;
            this.diceValue = Integer.parseInt(form[1]);

        }

        if(formula.matches("^([d][0-9]+([+]|[-])[0-9]+)$")){
            form = formula.split("d");
            temp = form[1].split("[+-]");
            this.nbRoll = 1;
            this.modifier = Integer.parseInt(temp[1]);
            this.diceValue = Integer.parseInt(temp[0]);

        }

        if(formula.matches("^[0-9]+([d][0-9]+([+]|[-])[0-9]+)$")) {
            form = formula.split("d");
            if(formula.contains("-")){                          // Verify if the formula content have a - to set the modifier negative
                isN = Boolean.TRUE;

            }
            this.temp = form[1].split("[+-]");
            this.modifier = Integer.parseInt(temp[1]);
            if(isN){
                this.modifier = -this.modifier;                 // Set the modifier negative
            }
            this.nbRoll = Integer.parseInt(form[0]);
            this.diceValue = Integer.parseInt(temp[0]);
        }
    }



    public Roll(int diceValue, int nbRoll, int modifier) {
        this.diceValue = diceValue;
        this.nbRoll = nbRoll;
        this.modifier = modifier;
    }

    public int makeRoll(RollType rollType) {

        this.unD = new Dice( this.diceValue);
        if( this.diceValue < 1 ||  this.nbRoll < 1 ){           // Wrong value
            this.res = -1;
        } else {
            for (int i = 0; i <  this.nbRoll; i++) {
                this.res += this.unD.rollDice();                // Throw a dice or multiple dice
            }
            this.res +=  this.modifier;
            if( this.res < -1){
                this.res = 0;
            }
        }
        return  this.res;
    }

}
