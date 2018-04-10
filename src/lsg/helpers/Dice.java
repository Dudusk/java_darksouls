package lsg.helpers;

import java.util.Random;

public class Dice {
    int faces;
    Random rnd;
    int nombre;



    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll() {
        rnd = new Random();
        nombre = rnd.nextInt(faces - 1);
        System.out.println(nombre);
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        System.out.println("min :" + min);
        System.out.println("max :" + max);
        return nombre;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

}
