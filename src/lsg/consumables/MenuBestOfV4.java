package lsg.consumables;

import java.util.Iterator;
import java.util.LinkedHashSet;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {
	
 	
    public MenuBestOfV4() {
    	add(new Hamburger());
    	add(new Wine());
    	add(new Americain());
    	add(new Coffe());
    	add(new Whisky());
    }

    public Consumable listeMenu() {
        Consumable ligne = null;
        int i = 0;
        Iterator<Consumable> itr= iterator();
        
        while(itr.hasNext()){
        	i++;
        	ligne = itr.next();
        	System.out.println(i + ": " + ligne);
        }  
        
        return ligne;
    }

    @Override
    public String toString() {
    	System.out.println(getClass().getSimpleName() + " :");
        return String.format(getClass().getSimpleName() + "\n" + listeMenu());
        //getClass().getSimpleName() + "\n" + listeMenu();
    }

    public static void main(String[] args) {
    	MenuBestOfV4 menu = new MenuBestOfV4();
        menu.toString();
    }
	
	
}
