package carte;

public class Botte extends Probleme{
    public Botte(int nombre, Type type) {
        super(nombre, type);
    }

    @Override
    public String toString() {
        switch (getType()){
            case FEU -> {
                return "VÉHICULE PRIORITAIR";
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

}
