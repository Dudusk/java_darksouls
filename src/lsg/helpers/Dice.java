package lsg.helpers;

import java.util.Random;

public class Dice {
    int faces;
    Random rnd;
    int nombre;

    int maxVal = Integer.MAX_VALUE;
    int minVal = Integer.MIN_VALUE;

    int arrayNombreDice[] = new int[50];

    public Dice(int faces) {
        this.faces = faces;
    }

    public void rollTest() {
        for (int i = 0 ; i<50 ; i++){
            rnd = new Random();
            nombre = rnd.nextInt(faces - 1);
            arrayNombreDice[i] = nombre;
        }
        //return nombre;
        for(Integer str : arrayNombreDice)
            System.out.print(str + " ");

        for(int i = 0; i < arrayNombreDice.length; i++){
            if(arrayNombreDice[i] < maxVal)
                maxVal = arrayNombreDice[i];
            if(arrayNombreDice[i] > minVal)
                minVal = arrayNombreDice[i];
        }

        System.out.println("\n\nMin : "+maxVal);
        System.out.println("Max : "+minVal);
    }

    public int roll() {
        rnd = new Random();
        nombre = rnd.nextInt(faces - 1);

        return nombre;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

}





