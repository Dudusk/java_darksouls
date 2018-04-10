package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

public class LearningSoulsGame {

    public static void main(String[] args){
        Hero hero = new Hero();
        Sword sword = new Sword();
        hero.printStats();
        hero.precisionHero();

        for (int i=0; i<5; i++) {
            hero.attackWith(sword);
        }
        Monster monster = new Monster();
        monster.printStats();
        Monster monster2 = new Monster();
        monster2.printStats();
        Monster monster3 = new Monster();
        monster3.printStats();
        hero.isAlive();

//        Dice dice = new Dice(50);
//        dice.rollTest();
    }

}