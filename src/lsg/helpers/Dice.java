package lsg.helpers;

import java.util.Random;

/**
 * Cette classe dzfinit les caractéristiques et methodes de la classe Dice, qui permet de lancer un dé calculant la précision de l'attaque du character.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pave
 */
public class Dice {
    int faces;
    Random rnd;
    int nombre;

    int maxVal = Integer.MAX_VALUE;
    int minVal = Integer.MIN_VALUE;

    int arrayNombreDice[] = new int[50];



    /**
     * Constructeur
     * @param faces
     */
    public Dice(int faces) {
        this.faces = faces;
    }



    /**
     * Une methode test
     */
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


    /**
     * Permet d'obtenir le resultat du lancer de dé
     * @return nombre
     */
    public int roll() {
        rnd = new Random();
        nombre = rnd.nextInt(faces - 1);

        return nombre;
    }


    /**
     * GETTER AND SETTER
     * @param faces
     */
    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

}





