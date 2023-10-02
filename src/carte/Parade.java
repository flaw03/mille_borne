package carte;

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
}
