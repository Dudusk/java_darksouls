package characters;

import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Weapons;

public class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private int degats;

    //private Sword sword = new Sword();
    private Weapons playerWeapon = new ShotGun();
    private Weapons monsterWp = new Claw();

    private Dice dice = new Dice(101);

    /**
     * METHODES
     * Constructeur
     */
    public Character() {
        this.name= "character";
    }


    /**
     * Attaque avec l'arme
     */

    private int attackWith(Weapons weapon) {

        //Get la précision
        int precision = this.dice.roll();
        //int degats;

        if (weapon.isBroken()) {
            System.out.println("L'arme < " + weapon.getName() + " > est cassée !");
            return 0;
        }
        if (precision == 0) {
            degats = weapon.getMinDamage();
        } else if (precision == 100) {
            degats = weapon.getMaxDamage();
        } else {
            degats = Math.round(((precision / 100f) * (weapon.getMaxDamage() - weapon.getMinDamage())) + weapon.getMinDamage());
        }

        // baisse de la stamina après chaque coup
        if (this.stamina >= weapon.getStamCost()) {
            this.stamina -= weapon.getStamCost();
        } else {
            float pourcentage = this.stamina / weapon.getStamCost() * 100;
            this.stamina = 0;
            degats = Math.round(pourcentage * degats);
        }
        //System.out.println("Precision : " + precision);
        System.out.println("Attaque avec " + weapon + " > " + degats);
        weapon.use();
        getHitWith(degats);
        return degats;
    }
    
    public void attack(){
        if (getClass().getName().equals("characters.Hero")) {
            attackWith(playerWeapon);
        } else {
            attackWith(monsterWp);
        }
    }


    /**
     * Enl�ve de la vie
     */

    public int getHitWith(int value){
        life = (getLife() < 0) ? 0 : getLife() - value ;
        if(getLife() < 0) {
    		setLife(0);
    	}
        return value;
    }

    
    /**
     * Affichage des stats
     */
    
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

    
    /**
     * GETTERS ET SETTERS
     */

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public Weapons getWeapon() {
        return playerWeapon;
    }

    public void setWeapon(Weapons weapon) {
        this.playerWeapon = weapon;
    }

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