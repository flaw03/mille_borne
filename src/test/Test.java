package test;

import carte.*;
import jeu.Sabot;

public class Test {
    public static void main(String[] args) {
        Sabot sabot = new Sabot(110);
        Carte borne = new Borne(4,10);
        Carte accident = new Attaque(4, Type.ACCIDENT);
        Carte feuRouge = new Attaque(2,Type.FEU);
        Carte feuVert = new Parade(2, Type.FEU);
        Carte asDuVolant = new Botte(4, Type.ACCIDENT);
        sabot.ajouterCarte(borne);
        sabot.ajouterFamilleCarte(accident,feuRouge,feuVert,asDuVolant);

        System.out.println("Je pioche " + sabot.piocher());
        System.out.println("Je pioche " + sabot.piocher());
        System.out.println("Je pioche " + sabot.piocher());

    }
}
