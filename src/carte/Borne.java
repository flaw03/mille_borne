package carte;

public class Borne extends Carte {

    private int km;

    public Borne(int nombre, int km) {
        super(nombre);
        this.km = km;
    }

    @Override
    public String toString() {
        return "BORNES";
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
}
