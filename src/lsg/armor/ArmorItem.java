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
<<<<<<< HEAD
	 * Surcharge de la méthode toString
=======
	 * Surcharge de la m�thode toString
>>>>>>> 6e459a2250b5d14d8a45f633d5991855abc1ad43
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
