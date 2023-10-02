package carte;

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

}
