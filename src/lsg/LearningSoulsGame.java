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



        for (int i=0; i<5; i++) {
            //hero.attackWith(sword);
            hero.printStats();
            monster.printStats();
            hero.getHitWith(monster.getDegats());
            monster.getHitWith(hero.getDegats());
            hero.attack();
            monster.attack();

        }

//        Dice dice = new Dice(50);
//        dice.rollTest();
    }


    public static void refresh () {

    }

}