package carte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static utils.Utils.melanger;

public class JeuDeCartes {

    private ArrayList<Carte> cartes = new ArrayList<>();
    private final ArrayList<Carte> tabCartesBase = new ArrayList<>();
    public JeuDeCartes() {

        tabCartesBase.add(new Botte(1,Type.FEU));
        tabCartesBase.add(new Botte(1,Type.ESSENCE));
        tabCartesBase.add(new Botte(1,Type.CREVAISON));
        tabCartesBase.add(new Botte(1,Type.ACCIDENT));

        tabCartesBase.add(new Parade(14, Type.FEU));
        tabCartesBase.add(new Parade(6, Type.ESSENCE));
        tabCartesBase.add(new Parade(6, Type.CREVAISON));
        tabCartesBase.add(new Parade(6, Type.ACCIDENT));
        tabCartesBase.add(new FinLimite(6));

        tabCartesBase.add(new Attaque(5, Type.FEU));
        tabCartesBase.add(new Attaque(3, Type.ESSENCE));
        tabCartesBase.add(new Attaque(3, Type.CREVAISON));
        tabCartesBase.add(new Attaque(3, Type.ACCIDENT));
        tabCartesBase.add(new DebutLimite(4));

        tabCartesBase.add(new Borne(10, 25));
        tabCartesBase.add(new Borne(10, 50));
        tabCartesBase.add(new Borne(10, 75));
        tabCartesBase.add(new Borne(12, 100));
        tabCartesBase.add(new Borne(4, 200));

        for (Carte carte: tabCartesBase ) {
            for (int i = 0 ; i < carte.getNombre() ;i++){
                cartes.add(carte);
            }
        }

        cartes = melanger(cartes);
    }

    public void afficherCartes() {
        for (Carte carte:
             cartes) {
            System.out.println(carte + "\n");
        }
    }

    public boolean checkCount(){
        for (Carte carte: tabCartesBase ) {
            if (Collections.frequency(cartes, carte) != carte.getNombre()){
                return false ;
            }
        }
        return true;
    }



}
