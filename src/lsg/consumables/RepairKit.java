package lsg.consumables;

import lsg.weapons.Weapon;

public class RepairKit extends Consumable {

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
