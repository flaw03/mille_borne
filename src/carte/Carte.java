package carte;

import joueur.Joueur;

public abstract class Carte {
    private final int nombre;


    public Carte(int nombre) {
        this.nombre = nombre;
    }

    public int getNombre() {
        return nombre;
    }

    abstract boolean appliquer(Joueur j);

}


