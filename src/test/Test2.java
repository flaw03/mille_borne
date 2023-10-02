package test;

import carte.*;
import jeu.Sabot;

public class Test2 {
    public static void main(String[] args) {
 ;
        Carte feuRouge = new Attaque(2,Type.FEU);
        Carte feuRouge1 = new Attaque(3, Type.FEU);
        Carte panneEssence = new Attaque(34,Type.ESSENCE);
        Carte essence = new Parade(242,Type.ESSENCE);

        if (feuRouge.equals(feuRouge1)){
            System.out.println("Test Attaque true : bon");
        }
        else {
            System.out.println("Test Attaque true : erreur");
        }

        if (feuRouge.equals(panneEssence)){
            System.out.println("Test Attaque false : erreur");
        }
        else {
            System.out.println("Test Attaque false : bon");
        }

        if (essence.equals(panneEssence)){
            System.out.println("Test Bataille (parade/Attaque) : erreur  " );
        }else {
            System.out.println("Test Bataille (parade/Attaque) : bon  " );
        }



    }
}
