package characters;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JFrame;

import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

public abstract class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private int degats;

    //private Sword sword = new Sword();
    //private Weapons playerWeapon = new ShotGun();
    private Weapons playerWeapon = new Sword();
    private Weapons monsterWp = new Claw();
    private Dice dice = new Dice(101);
    
    private int attack;

   
	/**
     * METHODES
     * Constructeur
     */
    public Character() {
        this.name= "character";
    }


   
    /**
     * Attaque avec l'arme
     * @param weapon
     * @return
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


        // baisse de la stamina apres chaque coup
        if (this.stamina >= weapon.getStamCost()) {
            this.stamina -= weapon.getStamCost();
            this.attack = this.degats;
        } else {
            float pourcentage = this.stamina / weapon.getStamCost() * 100;
            this.stamina = 0;
            degats = Math.round(pourcentage * degats);
        }

        if (computeBuff()>0) {
            degats = Math.round(degats + (degats * (computeBuff()/100f)));
        }

        //System.out.println("Precision : " + precision);
        System.out.println(" !!! " + getName() + " attaque son adversaire avec " + weapon.getName() + " (ATK : " + attack + " | DMG: " + degats + ") !!!" );
        //System.out.println("Attaque avec " + weapon + " > " + degats);
        if(isAlive()) {
        	weapon.use();
        }
        return degats;
    }
    
    /**
     * Attaque
     */
    public void attack(){
        if (getClass().getName().equals("characters.Hero")) {
        	setWeapon(playerWeapon);
        	attackWith(playerWeapon);
        } else {
        	setWeapon(monsterWp);
        	attackWith(monsterWp);
        }
    }
    
    
    public void refresh() {
		printStats();
	}

    
    public void fight1v1() {
    	System.out.println("---> Hit enter \t key for \t next move >\r");
    	Scanner sc = new Scanner(System.in);
    	
    	String enterkey = sc.nextLine();
    	
    	// Touche entr�e
    	while(!enterkey.equals("")) {
    		System.out.println("---> Hit enter \t key for \t next move >\r");
    		enterkey = sc.nextLine();
    	}
    	
	    if(enterkey.equals("")){
	        attack();
	    }
    }
    
    /**
     * C'est bof par ici, not used
     */
    public void init() {
    	Hero hero = new Hero();
    	Monster monster = new Monster();
    	
    	hero.setWeapon(playerWeapon);
    	monster.setWeapon(monsterWp);
    }
    
    public void play_v1() {
    	init();
    	fight1v1();
    }
    

    /**
     * Enl�ve de la vie
     */

    public int getHitWith(int value){
        life = (getLife() < 0) ? 0 : getLife() - value ;
        if(getLife() < 0) {
    		setLife(0);
    	}

        if (computeProtection() >= 100) {
            degats = 0;
        } else {

        }
        
        //Check les maths 4.6
//        if(computeProtection() < 100) {
//        	value = (int) computeProtection() / value * 100;
//        } else {
//        	value = 0;
//        }
        
        return value;
    }

    
    /**
     * Affichage des stats
     */
    
    public void printStats() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        if (isAlive()) {
            return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, "LIFE:" + life,
                    "STAMINA:" + stamina, "PROTECTION: " + computeProtection() + "\t BUFF: " + computeBuff(), "(ALIVE)");
        }
        else {
            return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, "LIFE:" + life,
                    "STAMINA:" + stamina, "PROTECTION: " + computeProtection() + "\t BUFF: " + computeBuff(), "(DEAD)");
        }
    }

    public boolean isAlive() {
        return getLife() > 0;
    }

    
    //Classe abstraite � impl�menter
    
    public abstract float computeProtection();
    public abstract float computeBuff();
    
    
    /**
     * GETTERS ET SETTERS
     */
    
    public int getAttack() {
		return attack;
	}

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