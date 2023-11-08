package carte;

import joueur.Joueur;

public class Attaque extends Bataille{
    public Attaque(int nombre, Type type) {
        super(nombre, type);
    }

    @Override
    public String toString() {
        switch (getType()) {
            case CREVAISON -> {
                return "Crevaison";
            }
            case ACCIDENT -> {
                return "Accident";
            }
            case ESSENCE -> {
                return "Panne d'essence";
            }
            case FEU -> {
                return "Feu Rouge";
            }
        }
        return null;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Attaque) {
            Attaque carte = (Attaque) obj;
            return getType().equals(carte.getType());
        }
        return false;
    }

    @Override
    boolean appliquer(Joueur j) {
        if (super.appliquer(j) ){
            return true;
        }
        else {
            Bataille bataille = j.getBatailles().get(j.getBatailles().size() - 1);
            if (bataille instanceof Parade) {
                if ( ! j.getBottes().contains(new Botte(0, getType()))) {
                    j.getBatailles().add(this);
                    return true;
                }

            }
        }
        return false;
    }


}
