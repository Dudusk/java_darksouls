package characters;

import lsg.weapons.Claw;

/**
 * Cette classe définit les caractéristiques du Lycanthrope. 
 * Elle herite de la classe Monster
 *
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class Lycanthrope extends Monster {

	/**
	 * Constructeur
	 */
	public Lycanthrope() {
		super();
		setName("Lycanthrope");
		setWeapon(new Claw());
		setSkinThickness(30);
	}
	
}
