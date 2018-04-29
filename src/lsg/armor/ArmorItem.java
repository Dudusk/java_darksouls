package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{

	private String name;
	private double armorValue;
	
	
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
	 * Surcharge de la m�thode toString
	 */
	@Override
	public String toString() {
            return name + "(" + armorValue + ")";
	}



	@Override
	public int getWeight(){
		return 4;
	}
}
