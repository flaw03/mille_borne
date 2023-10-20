package joueur;

import carte.*;
import main.Main;
import main.MainAsListe;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Joueur {

    private String nom;
    private ArrayList<Limite> limites ;
    private ArrayList<Bataille> batailles;
    private ArrayList<Borne> bornes;
    private ArrayList<Botte> bottes;

    private Main main;


    public Joueur(String nom) {
        this.nom = nom;
        limites = new ArrayList<>();
        batailles = new ArrayList<>();
        bornes  = new ArrayList<>();
        bottes = new ArrayList<>();
        main = new MainAsListe();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Joueur){
            Joueur joueur2 = (Joueur) obj;
            return joueur2.getNom().equals(getNom());
        }
        return false;
    }
    public String getNom() {
        return nom;
    }

    public void donner(Carte carte) {
        main.prendre(carte);

    }

    public Carte prendreCarte(List<Carte> sabot) {
        if (sabot.isEmpty()) {
            return null;
        }
        Carte carte = sabot.get(0);
        donner(carte);
        return carte;
    }

    public int getKM() {
        int somme = 0;
        for (Borne borne : bornes) {
            somme += borne.getKm();
        }
        return somme;
    }

    public int getLimite(){
        if (!limites.isEmpty() ||
                limites.get(0) instanceof FinLimite
                || (!bottes.isEmpty() && bottes.get(0).getType().equals(Type.FEU) )
        ){
            return 200;
        }
        return 50;
    }

    public boolean getPrioritaire() {
        if (!bottes.isEmpty()){
            return bottes.get(0).getType().equals(Type.FEU);
        }
        return false;
    }

    public boolean estBloque(){

        if (batailles.isEmpty() && getPrioritaire()) {
            return false;
        }
        
        if (carte instanceof Parade parade){
            return !(parade.getType().equals(Type.FEU) || getPrioritaire());
        }
        else if (carte instanceof Attaque attaque) {
            Botte botte = new Botte(0, attaque.getType());
            if (attaque.getType().equals(Type.FEU) && getPrioritaire()) {
                return false;
            }
            if (bottes.contains(botte) && getPrioritaire()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Limite> getLimites() {
        return limites;
    }

    public ArrayList<Bataille> getBatailles() {
        return batailles;
    }

    public ArrayList<Borne> getBornes() {
        return bornes;
    }

    public ArrayList<Botte> getBottes() {
        return bottes;
    }

}
