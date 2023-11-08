package carte;

import joueur.Joueur;

public class Borne extends Carte {

    private final int km;

    public Borne(int nombre, int km) {
        super(nombre);
        this.km = km;
    }

    @Override
    public String toString() {
        return "BORNES " + km ;
    }

    public int getKm() {
        return km;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Borne) {
            Borne carte = (Borne) obj;
            return getKm() == carte.getKm();
        }
        return false;
    }

    @Override
    boolean appliquer(Joueur j) {
        if (j.estBloque()
        || km < j.getLimite()
        ||km + j.getKM() < 1000) {
            j.getBornes().add(this);
            return true;
        }
        return false;
    }
}
