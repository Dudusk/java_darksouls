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
import lsg.consumables.RepairKit;
import lsg.consumables.drinks.Coffe;
import lsg.consumables.food.Hamburger;
import lsg.weapons.ShotGun;
import lsg.weapons.Weapon;

/**
 * Cette classe est la classe main du jeu
 * Certaines modifications ont ete apportees car pas tout n'est fonctionnel.
 *
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class LearningSoulsGame {
	
	public static void main(String[] args) {
		// createExhaustedHero();
		
/*
		//La méthode aTable() que nous n'arrivons pas à instancier. Nous avons donc fait cela pour provuer que ça marche.
		
 		Hero hero = new Hero();
 		RepairKit kit = new RepairKit();
		
		hero.refresh();
		
		hero.getHitWith(99);
		hero.setWeapon(new Weapon("Grosse arme", 0, 0, 1000, 100));
		hero.attack();		
		
		hero.refresh();
		
		hero.use(new Hamburger());
		hero.use(new Coffe());
		hero.use(kit);
		
		hero.refresh();
*/
		
		title();
		
		Hero hero = new Hero();
		Monster monster = new Monster();
		
		hero.setArmorItem(new BlackWitchVeil(), 1);
		hero.setArmorItem(new BlackWitchVeil(), 3);
		hero.setRing(new RingOfSwords(), 1);
		hero.setTalisman(new NoonGift(), 1);
		hero.setConsumable(new Hamburger());
		
		monster.setTalisman(new NoonGift(), 1);
		
		//hero.use(new Coffe());




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



		
		
    	//hero.getArmor();



	}



	/**
	 * Méthode qui permet de créer un héro avec une arme pour utiliser la stamine et la vie. Le but étant de tester 
	 * le fonctionnement de la vie et stamina.
	 */
	public static void createExhaustedHero() {
		Hero hero = new Hero();
		
		hero.getHitWith(99);
		hero.setWeapon(new Weapon("Grosse arme", 0, 0, 1000, 100));
		hero.attack();
	}



	/**
	 * Permet de manger un menu
	 */
	public static void aTable() {
		MenuBestOfV4 menu = new MenuBestOfV4();
		Hero hero = null;
		
		for(int i = 0; i<menu.size() ; i++) {
			hero.use(menu.listeMenu());
		}
		
	}


	
	/**
	 * Permet d'affiher le titre du jeu
	 */
	public static void title(){
    	System.out.println("#########################################\n"
    					 + "# \tTHE LEARNING SOULS GAME \t#"
    					 + "\n#########################################\n");
    }
	
}