package lsg.weapons;

public class Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    private static String DURABILITY_STAT_STRING = "durability";

    public Weapon(){
        super();
    }

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    public void use(){
        setDurability(1);
    }

    public boolean isBroken(){
        return getDurability() <= 0;
    }

    /*
     *
     * Surcharge de toString pour descriptif de l'arme
     *
     * */

    @Override
    public String toString() {
        return getName() + " (Min: " + getMinDamage() + ", Max: " + getMaxDamage() + ", Stam: " + getStamCost() +
                "," + DURABILITY_STAT_STRING + ":" + getDurability() + ")";
    }

    /*
     *
     * Getters
     *
     * */

    public void setDurability(int durability) {
        this.durability -= durability;
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
