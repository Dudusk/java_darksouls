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

        for (int i=0; i<5; i++) {
            hero.attack();
            //hero.attackWith(sword);
            hero.printStats();
        }

        System.out.println("\n---------------\n");

        Monster monster = new Monster();
        for (int i=0; i<5; i++) {
            monster.printStats();
            monster.attack();
        }

//        Monster monster2 = new Monster();
//        monster2.printStats();
//        Monster monster3 = new Monster();
//        monster3.printStats();
//        hero.isAlive();

//        Dice dice = new Dice(50);
//        dice.rollTest();
    }

}