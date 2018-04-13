package lsg.armor;

public class ArmorItem {

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
	 * Surcharge de la méthode toString
	 */
	@Override
	public String toString() {
            return name + "(" + armorValue + ")";
	}
}
