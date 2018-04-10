package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;

public class LearningSoulsGame {

    public static void main(String[] args){
        Hero hero = new Hero();
        hero.printStats();
        hero.lanceDesHero();

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