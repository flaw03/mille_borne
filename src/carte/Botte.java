package carte;

import joueur.Joueur;

public class Botte extends Probleme{
    public Botte(int nombre, Type type) {
        super(nombre, type);
    }

    @Override
    public String toString() {
        switch (getType()){
            case FEU -> {
                return "VÉHICULE PRIORITAIRE";
            }
            case ESSENCE -> {
                return "CITERNE D’ESSENCE";
            }
            case ACCIDENT -> {
                return "AS DU VOLAN";
            }
            case CREVAISON -> {
                return "INCREVABLE";
                }
            }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Botte carte) {
            return getType().equals(carte.getType());
        }
        return false;
    }

    @Override
    boolean appliquer(Joueur j) {
        j.getBottes().add(this);
        Carte carte = j.getBatailles().get(j.getBottes().size() - 1);
        if (carte instanceof Attaque attaque) {
            j.getBatailles().remove(attaque);
        }
        return true;
    }
}
