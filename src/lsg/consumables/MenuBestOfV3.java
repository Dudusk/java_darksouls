package lsg.consumables;

import java.util.HashSet;
import java.util.Iterator;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

/**
 * Cette classe dzfinit les caractéristiques et methodes d'une classe executable : Menu, groupement de plusieurs consumables.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pave
 */
public class MenuBestOfV3 extends HashSet<Consumable> {

    /**
     * Constructeur
      */
    public MenuBestOfV3() {
    	add(new Hamburger());
    	add(new Wine());
    	add(new Americain());
    	add(new Coffe());
    	add(new Whisky());
    }



    /**
     * Retourne le menu en string.
     * @return ligne
     */
    public String listeMenu() {
        String ligne = "";
        int i = 0;
        Iterator<Consumable> itr= iterator();
        
        while(itr.hasNext()){
        	i++;
        	ligne = i + ": " + itr.next();
        	System.out.println(ligne);  
        }  
        
        return ligne;
    }



    @Override
    public String toString() {
    	System.out.println(getClass().getSimpleName() + " :");
        return String.format(getClass().getSimpleName() + "\n" + listeMenu());
        //getClass().getSimpleName() + "\n" + listeMenu();
    }



    /**
     * Creer un menu et liste son contenu
     * @param args
     */
    public static void main(String[] args) {
    	MenuBestOfV3 menu = new MenuBestOfV3();
        menu.toString();
    }
	
	
}
