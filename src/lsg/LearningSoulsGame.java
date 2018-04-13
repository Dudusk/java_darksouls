package lsg;

import characters.Hero;
import characters.Monster;
import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.helpers.Dice;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

import java.util.Scanner;

public class LearningSoulsGame {
	
	public static void main(String[] args) {
		
		Hero hero = new Hero();
		hero.setArmorItem(new BlackWitchVeil(), 1);
		Monster monster = new Monster();
		

		System.out.println("------------");
				
		

		while(hero.isAlive() && monster.isAlive() && hero.getStamina() > 0 && monster.getStamina() > 0) {
			hero.fight1v1();
			monster.getHitWith(hero.getDegats());
			monster.fight1v1();
			hero.getHitWith(monster.getDegats());
		}
		
		if(!monster.isAlive()) {
			System.out.println("\n--- \t" + hero.getName() + " WINS !!! \t ---");
		} else if(!hero.isAlive()) {
			System.out.println("\n--- \t" + monster.getName() + " WINS !!! \t ---");
		}
			
		
		
		//hero.setArmorItem(blackMachin, 1);
    	//hero.setArmorItem(new DragonSlayerLeggings(), 2);
    	
    	//hero.getArmor();
		
		
//		for (int i = 0; i < 5; i++) {
//			
//			// Le héro
//			hero.refresh();
//			if (hero.isAlive() && monster.isAlive()) {
//				hero.attack();
//				monster.getHitWith(hero.getDegats());
//			}
//
//			// Le monstre
//			monster.refresh();
//			if (monster.isAlive() && hero.isAlive()) {
//				monster.attack();
//				hero.getHitWith(monster.getDegats());
//			}
//			
			
//
//		}
		
	}
	
}