package carte;

import joueur.Joueur;

public abstract class Bataille extends Probleme{
    public Bataille(int nombre, Type type) {
        super(nombre, type);
    }

    @Override
    boolean appliquer(Joueur j) {
        if (j.getBatailles().isEmpty()) {
            if (!j.estPrioritaire()) {
                j.getBatailles().add(new Attaque(0, Type.FEU));
            } else {
                j.getBatailles().add(new Parade(0, Type.FEU));
            }
            return true;
        }
        return false;
    }

}
