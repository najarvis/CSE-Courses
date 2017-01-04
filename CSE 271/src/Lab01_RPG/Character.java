package Lab01_RPG;

import java.util.Random;


public class Character {
/* 
 * The main character class. All other character classes derive from this.
 */

    // I could create probably 20 more variables but ain't no one got time for that.
    String name;
    int level;
    int xp;
    int STR;
    int DEX;
    int CHR;
    int CON;
    int INT;
    int WIS;
    int AC;
    int battlesWon;
    int speed;
    int hitPoints;
    static boolean print = false;

    public Character(String name) {
    /*
     * The default constructor. This only takes a name then randomly generates
     * the other attributes.
     */

        this.name = name;
        speed = 4;
        battlesWon = 0;
        hitPoints = 10;
        AC = 12;

        randomlyGenerate();
    }

    public Character(String name, int STR, int DEX, int CON, int CHR, int INT, int WIS) {
    /*
     * This constructor takes the name and also the main 6 parameters for more customization.
     */

        this.name = name;
        speed = 4;
        battlesWon = 0;
        hitPoints = 10;
        AC = 12;
        
        setSTR(STR);
        setDEX(DEX);
        setCON(CON);
        setCHR(CHR);
        setINT(INT);
        setWIS(WIS);
    }

    private void randomlyGenerate(){
    /*
     * Randomly generate the main 6 attributes
     * Using the standard 15, 14, 13, 12, 10, 8
     */
        Random rnd = new Random();
        int[] values = {15, 14, 13, 12, 10, 8};
        for (int i = 0; i < values.length; i++) {
            int index = rnd.nextInt(values.length);
            int a = values[index];
            values[index] = values[i];
            values[i] = a;
        }

        // The array should be shuffled now
        setSTR(values[0]);
        setDEX(values[1]);
        setCHR(values[2]);
        setCON(values[3]);
        setINT(values[4]);
        setWIS(values[5]);

    }

    public void fightCharacter(Character other) {
    /* 
     * The main code for fighting another character.
     */

        if (print) {
            System.out.println(name + " attacks " + other.name + "!");
        }

        int roll = DiceRoll.rollDice("1d20");
        if (roll + getAbilityModifier(getSTR()) > other.AC + other.getAbilityModifier(other.getDEX()) || roll == 20) {
            // Hit


            // Assume we just have a longsword
            int damage = DiceRoll.rollDice("1d8");
            if (print) {
                System.out.println("Hit!");
                System.out.println(name + " deals " + damage + " damage!");
            }
            // Actually take away the damage dealt to the other's hitpoints.
            other.hitPoints -= damage;

        } else {
            if (print) { System.out.println("Miss!"); }
        }

        if (print) { System.out.println(""); }
    }

    // Maybe a bit overkill for the lab
    public int getAbilityModifier(int abilityValue){
        return (abilityValue - 10) / 2;
    }

    public void run() {
        speed = 10;
    }

    public void walk() {
        speed = 4;
    }

    public boolean talk(Character other) {
    /* 
     * The charisma check function. Returns a true if you roll higher (with your modifier) than their charisma.
     */
        
        return (DiceRoll.rollDice("1d20") + getAbilityModifier(CHR) > other.CHR);
    }

    private void setSTR(int newSTR){
        STR = cap(newSTR, 1, 20);
    }

    public int getSTR(){
        return STR;
    }

    private void setDEX(int newDEX){
        DEX = cap(newDEX, 1, 20);
    }

    public int getDEX(){
        return DEX;
    }

    private void setCHR(int newCHR){
        CHR = cap(newCHR, 1, 20);
    }

    public int getCHR(){
        return CHR;
    }
    
    private void setCON(int newCON){
        CON = cap(newCON, 1, 20);
    }

    public int getCON(){
        return CON;
    }
    
    private void setINT(int newINT){
        INT = cap(newINT, 1, 20);
    }

    public int getINT(){
        return INT;
    }
    
    private void setWIS(int newWIS){
        WIS = cap(newWIS, 1, 20);
    }

    public int getWIS(){
        return WIS;
    }

    private int cap(int value, int low, int high) {
        return Math.min(Math.max(low, value), high);
    }
}
