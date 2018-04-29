package lsg.buffs;

import java.util.Locale;

import characters.Hero;
import characters.Monster;
import lsg.armor.ArmorItem;
import lsg.bags.Collectible;

public abstract class BuffItem implements Collectible{
	
	private String name ; 
	
	
	/**
	 * Constructeur d'un buff
	 * @param name
	 */
	public BuffItem(String name) {
		this.name = name ;
	}
	
	/**
	 * Abstract Class of BuffItem
	 * @return name
	 */
	public abstract float computeBuffValue() ;
	

	/**
	 * Getter de name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Override de la m�thode toString()
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}


	@Override
	public int getWeight(){
		return 1;
	}
	
}
