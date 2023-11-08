package carte;

import joueur.Joueur;

public class Parade extends Bataille{
    public Parade(int nombre, Type type) {
        super(nombre, type);
    }

    @Override
    public String toString() {
       switch (getType()){
           case ACCIDENT -> {
               return "Réparation";
           }
           case CREVAISON -> {
               return "Roue de Secours";
           }
           case ESSENCE -> {
               return "Essence";
           }
           case FEU -> {
               return "Feu vert";
           }
       }
       return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Parade) {
            Parade carte = (Parade) obj;
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
            if (bataille instanceof Attaque) {
                if ( ! j.getBottes().contains(new Botte(0, getType()))) {
                    if (bataille.getType().equals(getType())) {
                        j.getBatailles().add(this);
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
