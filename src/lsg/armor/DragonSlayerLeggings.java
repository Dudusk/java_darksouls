package lsg.armor;

import lsg.bags.Collectible;

/**
 * Cette classe définit les caractéristiques d'une armure
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class DragonSlayerLeggings extends ArmorItem implements Collectible{
	
	/**
	 * Constructeur de la classe
	 */
	public DragonSlayerLeggings(){
		super("Dragon Smayer Leggings", 10.2);
	}

	/**
	 * Permet de retourner le poids de l'armure
	 */
	@Override
	public int getWeight(){
		return 3;
	}
}
