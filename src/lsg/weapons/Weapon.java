package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.RepairKit;

/**
 * Cette classe définit les caractéristiques de base d'une arme
 *
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class Weapon implements Collectible{
    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    public static String DURABILITY_STAT_STRING = "durability";

    /**
     * Constructeur
     */
    public Weapon(){
        super();
    }



    /**
     * Constructeur de la classe avec parametres
     * @param name
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     * @param durability
     */
    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }



    /**
     * Méthode qui enlève 1 de durabilité à l'arme
     */
    public void use(){
        setDurability(durability -1);
    }



    /**
     * Méthode qui permet de savoir si l'arme est cassée ou non
     * @return
     */
    public boolean isBroken(){
        return getDurability() <= 0;
    }



    /**
     * Reparation d'une arme avec le kit
     * @param kit
     */
    public void repairWith(RepairKit kit) {
    	durability += 1;
    	kit.use();
    }
    


    /**
     * Surcharge de toString pour descriptif de l'arme
     * */
    @Override
    public String toString() {
        return getName() + " (Min: " + getMinDamage() + ", Max: " + getMaxDamage() + ", Stam: " + getStamCost() +
                "," + DURABILITY_STAT_STRING + ":" + getDurability() + ")";
    }



    /**
     * Permet de connaitre le poids d'unr arme
     */
    @Override
    public int getWeight(){
        return 2;
    }



    /**
     * Getters/setters
     * @param name
     * @param durability
     * @param minDamage
     * @param maxDamage
     * @param stamCost
     */
    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }

    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public int getDurability() {
        return durability;
    }
}
