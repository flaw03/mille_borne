package joueur;

import carte.*;
import jeu.Coup;
import main.Main;
import main.MainAsListe;


import java.util.*;

public class Joueur {

    private String nom;
    private final ArrayList<Limite> limites;
    private final ArrayList<Bataille> batailles;
    private final ArrayList<Borne> bornes;
    private final TreeSet<Botte> bottes;
//    ensemble de carte

    private final Main main;


    public Joueur(String nom) {
        this.nom = nom;
        limites = new ArrayList<>();
        batailles = new ArrayList<>();
        bornes = new ArrayList<>();
        bottes = new TreeSet<>();
        main = new MainAsListe();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Joueur joueur2) {
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
        Carte carte = sabot.remove(sabot.size() - 1);
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

    public int getLimite() {
        if (limites.isEmpty()
                || limites.get(limites.size() - 1) instanceof FinLimite
                || estPrioritaire()) {
            return 200;
        }
        return 50;
    }

    public boolean estPrioritaire() {
        return bottes.contains(new Botte(0, Type.FEU));
    }

    public boolean estBloque() {

        if (batailles.isEmpty()) {
            return estPrioritaire();
        }
        Carte carte = batailles.get(batailles.size() - 1);
        if (carte instanceof Parade parade) {
            if (parade.getType().equals(Type.FEU)) {
                return false;
            } else if (estPrioritaire()) {
                return false;
            }
        } else if (carte instanceof Attaque attaque) {
            if (estPrioritaire()) {
                if (attaque.getType().equals(Type.FEU)) {
                    return false;
                } else if (bottes.contains(new Botte(0, attaque.getType()))) {
                    return false;
                }
            }
        }
        return true;
    }


    public HashSet<Coup> coupsPossible(List<Joueur> participants) {
        HashSet<Coup> ensembleCoups = new HashSet<>();
        for (Joueur joueur :
                participants) {
            ListIterator<Carte> carteIterator = main.itearator();
            for (Carte carte = carteIterator.next(); carteIterator.hasNext(); carte = carteIterator.next()) {
                Coup coup = new Coup(carte, joueur);
                if (coup.estValide(joueur)) {
                    ensembleCoups.add(coup);
                }
            }
        }
        return ensembleCoups;
    }

    public HashSet<Coup> coupsParDefault() {
        HashSet<Coup> ensembleCoups = new HashSet<>();
        ListIterator<Carte> carteIterator = main.itearator();
        for (Carte carte = carteIterator.next(); carteIterator.hasNext(); carte = carteIterator.next()) {
            Coup coup = new Coup(carte, null);
            if (coup.estValide(null)) {
                ensembleCoups.add(coup);
            }
        }
        return ensembleCoups;
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

    public TreeSet<Botte> getBottes() {
        return bottes;
    }


}
