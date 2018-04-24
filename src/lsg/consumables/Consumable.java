package lsg.consumables;

public class Consumable {

    private String name;
    private int capacity;
    private int stat;


    public String getName() {
        return name;
    }


    public Consumable() {
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

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }


    @Override
    public String toString() {

            return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", name + "[" + capacity + stat + " point(s) ]");
    }

}

