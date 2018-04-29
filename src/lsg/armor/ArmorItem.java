package lsg.armor;

import lsg.bags.Collectible;

/**
 * Cette classe définit les caractéristiques de base d'une armure.
 *
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class ArmorItem implements Collectible{

	private String name;
	private double armorValue;



	/**
	 * Constructeur de la classe
	 * @param name
	 * @param value
	 */
	public ArmorItem(String name, double value) {
		this.name = name;
		this.armorValue = value;
	}
	


	/**
	 * Getters/setters
	 * @return
	 */
	public String getName() {
        return name;
    }
	
	public double getArmorValue() {
        return armorValue;
    }


	
	/**
	 * Surcharge de la methode toString
	 */
	@Override
	public String toString() {
            return name + "(" + armorValue + ")";
	}



	/**
	 * Permet de retourner le poids de l'armure
	 */
	@Override
	public int getWeight(){
		return 4;
	}
}
