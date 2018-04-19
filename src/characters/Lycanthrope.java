package characters;

import lsg.weapons.Claw;
import lsg.weapons.Weapons;

public class Lycanthrope extends Monster {
	
	public Lycanthrope() {
		super();
		setName("Lycanthrope");
		setWeapon(new Claw());
		setSkinThickness(30);
	}
	
}
