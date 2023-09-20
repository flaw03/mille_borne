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
}
