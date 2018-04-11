package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapons;

import java.util.Scanner;

public class LearningSoulsGame {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero();
        Monster monster = new Monster();
        
        hero.printStats();
        monster.printStats();
        System.out.println("------------");

        for (int i=0; i<5; i++) {
            //hero.attackWith(sword);
        	
        	hero.printStats();
            if(hero.isAlive() && monster.isAlive()) {
            	hero.attack();
            	hero.getHitWith(monster.getDegats());
            	monster.getHitWith(hero.getDegats());
            }
            
        	monster.printStats();
            if(monster.isAlive()) {
            	monster.attack();
            	hero.getHitWith(monster.getDegats());
            	monster.getHitWith(hero.getDegats());
            }
            
        }

//        Dice dice = new Dice(50);
//        dice.rollTest();
    }


    public static void refresh () {

    }

}