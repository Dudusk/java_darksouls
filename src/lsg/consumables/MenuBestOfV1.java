package lsg.consumables;

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
public class MenuBestOfV1 {

    private int MAX_CONSUMABLE = 5;
    Consumable[] menu = new Consumable[MAX_CONSUMABLE];



    /**
     * Constructeur
     */
    public MenuBestOfV1() {
        menu[0] = new Hamburger();
        menu[1] = new Wine();
        menu[2] = new Americain();
        menu[3] = new Coffe();
        menu[4] = new Whisky();
    }



    /**
     * Retourne le menu en string.
     * @return ligne
     */
    public String listeMenu() {
        String ligne = "";

        for (int i = 0; i < menu.length; i++) {
            ligne = (i+1) + ": " + menu[i];
            System.out.println(ligne);
        }
        
        menu[1].use();
        
        return ligne;
    }



    @Override
    public String toString() {
    	System.out.println(getClass().getSimpleName() + " :");
        return String.format("" + getClass().getSimpleName() + "\n" + listeMenu());
        //getClass().getSimpleName() + "\n" + listeMenu();
    }


    /**
     * Creer un menu et liste son contenu
     * @param args
     */
    public static void main(String[] args) {
        MenuBestOfV1 menu = new MenuBestOfV1();
        menu.toString();
    }
}
