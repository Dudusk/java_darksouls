package characters;

import java.util.Scanner;

import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public abstract class Character {
    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

    private int degats;

    //private Sword sword = new Sword();
    //private Weapon playerWeapon = new ShotGun();
    private Weapon playerWeapon = new Sword();
    private Weapon monsterWp = new Claw();
    private Dice dice = new Dice(101);
    
    private int attack;

    private static String LIFE_STAT_STRING = "life";
    private static String STAM_STAT_STRING = "stamina";
    private static String PROTECT_STAT_STRING = "protection";
    private static String BUFF_STAT_STRING = "buff";



   
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
    private int attackWith(Weapon weapon) {
    	
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

    	if (computeProtection() >= 100) {
    		value = 0;
	    } else {
    		value = Math.round(value * (1 - (computeProtection()/100)));
	    }

        life = (getLife() < 0) ? 0 : getLife() - value ;
        if(getLife() < 0) {
			setLife(0);
		}

        return value;
    }
    
    
    /**
     * Permet de boire, remet donc de la stamina en utilisant un consumable
     * @param consumable
     */
    private void drink(Consumable consumable) {
    	consumable.use();
    	System.out.println(consumable.getStat());
    	//stamina = (stamina + consumable.getCapacity() > maxStamina) ? stamina = maxStamina : stamina + consumable.getCapacity();
    	stamina += consumable.getCapacity();
    	System.out.println(getName() + " drinks " + consumable.getStat());
    	
    }
    
    /**
     * Permet de manger, remet donc de la vie en utilisant un consumable
     * @param consumable
     */
    private void eat(Consumable consumable) {
    	consumable.use();
    	System.out.println(consumable.getStat());
    	life = (life + consumable.getCapacity() > maxLife) ? life = maxLife : life + consumable.getCapacity();
    	
    	System.out.println(getName() + " eats " + consumable.getStat());
    	
    }
    
    
    public void use(Consumable consumable) {
    	if(consumable instanceof Drink) {
    		drink(consumable);
    	} else {
    		eat(consumable);
    	}
    	
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
            return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, LIFE_STAT_STRING + ":" + life,
                    STAM_STAT_STRING + ":" + stamina, "PROTECTION: " + computeProtection() + "\t BUFF: " + computeBuff(), "(ALIVE)");
        }
        else {
            return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "[" + getClass().getSimpleName()+ "]", name, LIFE_STAT_STRING + ":" + life,
                    STAM_STAT_STRING + ":" + stamina, "PROTECTION: " + computeProtection() + "\t BUFF: " + computeBuff(), "(DEAD)");
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

    public Weapon getWeapon() {
        return playerWeapon;
    }

    public void setWeapon(Weapon weapon) {
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