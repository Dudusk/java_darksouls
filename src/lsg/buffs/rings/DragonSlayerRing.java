package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring{
	
	/**
	 * Constructeur de la classe
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}
	
	/**
	 * Override pour connaître la force du buff
	 * @return power
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	
	/**
	 * Connaître si le personnage à la ring
	 * @return bool(false)
	 */
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ; 
		}
		return false ;
	}
	
}
