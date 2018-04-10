package characters;

import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

public class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private Sword sword = new Sword();

    private Dice dice = new Dice(101);

    /*
     * METHODES
     * Constructeur
     */
    public Character() {
        this.name= "character";
    }


    /*
     * Lance le dé avec 101 faces
     */
    public int precisionHero(){
        return dice.roll();
    }

    /*
     * Attaque avec l'arme
     */

    public void attackWith(Weapons weapon){

        System.out.println(weapon);

        if(weapon.isBroken()){
            System.out.println("L'arme < " + weapon.getName() + " > est cassée !");
        } else {
            weapon.use();
            //Get la précision
            int precision = this.precisionHero();
            int degats = 3;
            System.out.println("Precision : " + precision);
            System.out.println("Attaque avec " + weapon + " > " + Math.round(degats));
        }

    }

    public void printStats() {
        System.out.println(toString());
    }

    public String toString() {
        if (isAlive()) {
            return String.format("%-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, "LIFE:" + life,
                    "STAMINA:" + stamina, "(ALIVE)");
        }
        else {
            return String.format("%-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, "LIFE:" + life,
                    "STAMINA:" + stamina, "(DEAD)");
        }
    }

    public boolean isAlive() {
        return getLife() > 0;
    }

    /*
     * GETTERS ET SETTERS
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }
}