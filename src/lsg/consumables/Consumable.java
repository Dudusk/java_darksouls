package lsg.consumables;

public class Consumable {

    private String name;
    private int capacity;
    private String stat;


    public String getName() {
        return name;
    }


    /**
     * Constructeur de Consumable
     */
    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;

    }


    /**
     * GETTERS AND SETTERS
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }


    @Override
    public String toString() {

            return  name + "[" + capacity + stat + " point(s) ]";
    }

}

