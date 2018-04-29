package lsg.consumables;

import lsg.weapons.Weapon;

/**
 * Cette classe dzfinit les caractéristiques et methodes du consumable : Repairkit.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pave
 */
public class RepairKit extends Consumable {

	/**
	 * Constructeur
	 */
	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int use() {
		// TODO Auto-generated method stub
		setCapacity(getCapacity()-1);
		//Weapon.durability-1;
		return -1;
	}

}
