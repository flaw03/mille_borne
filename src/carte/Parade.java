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
}
