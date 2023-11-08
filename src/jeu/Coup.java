package jeu;

import carte.Attaque;
import carte.Carte;
import carte.DebutLimite;
import joueur.Joueur;

import java.util.HashSet;

public class Coup {
    private Carte carte;
    private Joueur cible;

    public Coup(Carte carte, Joueur cible) {
        this.carte = carte;
        this.cible = cible;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Joueur getCible() {
        return cible;
    }

    public void setCible(Joueur cible) {
        this.cible = cible;
    }

    public boolean estValide(Joueur j) {
        return  (carte instanceof Attaque || carte instanceof DebutLimite)
                && ! cible.equals(j);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coup coup) {
            return carte.equals(coup.carte) && cible.equals(coup.getCible());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int resultat = carte.hashCode() ;
        if (cible != null) {
            resultat += cible.hashCode();
        }
        return 31 * resultat;
    }
}
