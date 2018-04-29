package lsg.buffs.rings;

import characters.Hero;
import lsg.weapons.Sword;

/**
 * Cette classe définit les caractéristiques de la ring
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class RingOfSwords extends Ring{
	
	/**
	 * Constructeur de la classe
	 */
	public RingOfSwords() {
		super("Ring of Swords", 10) ;
	}



	/**
	 * Override pour conna�tre la force du buff
	 * @return power
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && (hero.getWeapon() instanceof Sword) )  return power ;
		else return 0f ;
	}


	/**
	 * Un test...
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		Hero hero = new Hero() ;
		RingOfSwords r = new RingOfSwords() ;
		hero.setRing(r, 1);
		hero.setWeapon(new Sword());
		System.out.println(r);
	}
}
