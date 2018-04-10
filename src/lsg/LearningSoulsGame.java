package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

import java.util.Scanner;

public class LearningSoulsGame {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero();
        Monster monster = new Monster();
        Sword sword = new Sword();
        hero.printStats();

        for (int i=0; i<5; i++) {
            hero.attack();
            //hero.attackWith(sword);
            hero.printStats();
            monster.printStats();
        }


//
//        Monster monster2 = new Monster();
//        monster2.printStats();
//        Monster monster3 = new Monster();
//        monster3.printStats();
//        hero.isAlive();

//        Dice dice = new Dice(50);
//        dice.rollTest();
    }


    public static void refresh () {

    }

}