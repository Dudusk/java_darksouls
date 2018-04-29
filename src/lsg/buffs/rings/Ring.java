package lsg.buffs.rings;

import characters.Hero;
import lsg.buffs.BuffItem;

/**
 * Cette classe définit les caractéristiques de base d'une ring
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public abstract class Ring extends BuffItem {
	
	protected int power ; 
	protected Hero hero ;
	
	/**
	 * Constructeur de la class parente Ring
	 * @param name
	 * @param power
	 */
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}
	
	/**
	 * Setter Hero
	 * @param hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	/**
	 * Getter hero
	 * @return hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * getter/setter 
	 * @return hero
	 */
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	
	
}
