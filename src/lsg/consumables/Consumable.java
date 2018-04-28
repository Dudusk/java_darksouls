package lsg.consumables;

import characters.Hero;

public class Consumable {

    private String name;
    private int capacity;
    private String stat;


    /**
     * Constructeur de Consumable
     */
    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;

    }
    
    /**
     * M�thode qui est d�clanch� quand on utilise un consommable
     * @return
     */
    public int use() {
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

}

