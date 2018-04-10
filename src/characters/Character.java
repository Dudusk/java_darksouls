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

        //Get la précision
        int precision = this.precisionHero();
        // calcul des dégats
        int degats = ((precision/100) * weapon.getMaxDamage()) + weapon.getMinDamage();

        if(weapon.isBroken()){
            degats = 0;
            System.out.println("L'arme < " + weapon.getName() + " > est cassée !");
        } else {
            if (weapon.getStamCost() <= getStamina()) {
                degats = ((precision/100) * weapon.getMaxDamage()) + weapon.getMinDamage();
            }
            else if (weapon.getStamCost() > getStamina()) {
                degats = degats * ((weapon.getStamCost() - getStamina())) / weapon.getStamCost();
            }
            else {
                degats = 0;
            }

            weapon.use();
            System.out.println("Attaque avec " + weapon + " > " + Math.round(degats));
            System.out.println("Precision : " + precision);

            if(getStamina() < 0 || (getStamina() - weapon.getStamCost()) < 0){
                setStamina(0);
            } else {
                setStamina(getStamina() - weapon.getStamCost());
            }
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