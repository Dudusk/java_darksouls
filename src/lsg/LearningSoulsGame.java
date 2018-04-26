package lsg;

import characters.Hero;
import characters.Lycanthrope;
import characters.Monster;
import lsg.armor.BlackWitchVeil;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.rings.RingOfSwords;
import lsg.buffs.talismans.MoonStone;
import lsg.buffs.talismans.NoonGift;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Coffe;
import lsg.weapons.ShotGun;
import lsg.weapons.Weapon;

public class LearningSoulsGame {
	
	public static void main(String[] args) {
		
		Hero hero = new Hero();
		hero.setArmorItem(new BlackWitchVeil(), 1);
		hero.setArmorItem(new BlackWitchVeil(), 3);
		Monster monster = new Monster();
		
		hero.setRing(new RingOfSwords(), 1);
		hero.setTalisman(new NoonGift(), 1);
		monster.setTalisman(new NoonGift(), 1);
		
		// hero.use(new Coffe());
		
		hero.use(new Coffe());
		

		System.out.println("------------");
				
		

		while(hero.isAlive() && monster.isAlive() && hero.getStamina() > 0 && monster.getStamina() > 0) {
			hero.fight1v1();
			monster.getHitWith(hero.getDegats());
			monster.fight1v1();
			hero.getHitWith(monster.getDegats());
		}
		
		if(!monster.isAlive() || monster.getStamina() <= 0) {
			System.out.println("\n--- \t" + hero.getName() + " WINS !!! (Stam Monster: " + monster.getStamina() + " | MonsterLife:  " + monster.getLife() + ") \t ---");
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
	
	public void createExhaustedHero() {
		Hero hero = new Hero();
		
		hero.getHitWith(99);
		hero.setWeapon(new Weapon("Grosse arme", 0, 0, 1000, 100));
	}
	
	public void aTable() {
		MenuBestOfV4 menu = new MenuBestOfV4();
		Hero hero;
		
		//hero.use(menu.listeMenu());
	}
	
}