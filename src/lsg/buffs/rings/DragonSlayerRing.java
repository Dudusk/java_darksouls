package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

/**
 * Cette classe définit les caractéristiques de cette ring
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class DragonSlayerRing extends Ring{
	
	/**
	 * Constructeur de la classe
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}
	
	/**
	 * Override pour conna�tre la force du buff
	 * @return power
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	
	/**
	 * Conna�tre si le personnage � la ring
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
