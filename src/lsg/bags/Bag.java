package lsg.bags;

import java.util.HashSet;
import java.util.Iterator;

import lsg.consumables.Consumable;

/**
 * Cette classe définit le sac du hero
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class Bag extends HashSet<Collectible>{

    private int capacity;
    private int weight;
    private HashSet<Collectible> items;

    /**
     * Constructeu de la classe
     * @param capacity
     */
    public Bag(int capacity) {
        this.capacity = capacity;
    }

    /**
     * GETTER/SETTER
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Ajoute un item dans le sac
     * @param item
     */
    public void push(Collectible item) {
    	
    	weight = getTotalWeight();
    	
        if((capacity - weight) == 0) {
            System.out.println("Your bag is full");
        } else if (weight + item.getWeight() <= capacity) {
        	weight += item.getWeight();
        	items.add(item);
        }
    }

    /**
     * Supprimer un objet du sac
     * @param item
     * @return item
     */
    public Collectible pop (Collectible item) {
    	
    	
    	
    	return item;
    }

    /**
     * Pour connapitre ce que contient le sac
     * @param item
     * @return
     */
    public boolean contains (Collectible item) {
    	Collectible tableau[] = getItems();
    	
    	for (int i = 0; i<tableau.length; i++) {
    		if(item.getClass().getSimpleName() == tableau[i].getClass().getSimpleName()) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * Connaitre les objets dans le sac
     * @return
     */
    public Collectible[] getItems(){
    	Collectible itemsOfBag[] = {};
    	
    	Collectible ligne;
        int i = 0;
        Iterator<Collectible> itr = iterator();
        
        while(itr.hasNext()){
        	i++;
        	ligne = itr.next();
        	itemsOfBag[i] = ligne;
        	System.out.println(ligne);  
        }
    	
    	return itemsOfBag;
    }
    
    /**
     * Calcul la totalité du poids du sac
     * @return total
     */
    private int getTotalWeight() {
    	int total = 0;
    	
    	Collectible ligne;
        int i = 0;
        Iterator<Collectible> itr = iterator();
        
        while(itr.hasNext()){
        	i++;
        	ligne = itr.next();
        	total = ligne.getWeight();
        	System.out.println(ligne.getWeight());  
        }
    	
    	return total;
    }

    /**
     * Retourne le sac en texte
     */
    @Override
    public String toString() {
		return null;
    }
}
