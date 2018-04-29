package lsg.bags;

import java.util.HashSet;

public class Bag {

    private int capacity;
    private int weight;
    private HashSet<Collectible> items;


    public Bag(int capacity) {
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }


    public void push(Collectible item) {
        if((capacity - weight) == 0) {
            System.out.println("Your bag is full");
        }
    }


    public Collectible pop(Collectible item){

    }


    public boolean contains(Collectible item) {

    }

    public Collectible[] getItems(){

    }


    public String toString() {

    }
}
