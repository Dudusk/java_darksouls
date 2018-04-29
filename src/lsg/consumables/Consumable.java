package lsg.consumables;

import characters.Hero;
import lsg.bags.Collectible;

/**
 * Cette classe dzfinit les caractéristiques et methodes d'un Consumable.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pave
 */
public class Consumable implements Collectible{

    private String name;
    private int capacity;
    private String stat;



    /**
     * Constructeur
     */
    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;

    }



    /**
     * utiliser un consummable
     * @return capacity
     */
    public int use() {
    	System.out.println("\n#### " + name + " a �t� utilis�. ####\n");
    	capacity = 0;
    	return capacity;
    }



    /**
     * GETTERS AND SETTERS
     * @param name
     */
    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    /**
     * GETTERS AND SETTERS
     * @param capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    /**
     * GETTERS AND SETTERS
     * @param stat
     */
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }



    @Override
    public String toString() {

            return  name + " [ " + capacity + " " + stat + " point(s) ]";
    }



    @Override
    public int getWeight(){
        return 1;
    }

}

