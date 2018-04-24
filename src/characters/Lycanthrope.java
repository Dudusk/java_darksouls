package characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {
	
	public Lycanthrope() {
		super();
		setName("Lycanthrope");
		setWeapon(new Claw());
		setSkinThickness(30);
	}
	
}
