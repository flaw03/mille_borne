package carte;

import joueur.Joueur;

public class DebutLimite extends Limite {

    public DebutLimite(int nombre) {
        super(nombre);
    }

    @Override
    boolean appliquer(Joueur j) {
        if (!j.estPrioritaire()) {
            Limite limite = j.getLimites().get( j.getLimites().size() -1 );
            if (! ( limite instanceof DebutLimite)) {
                j.getLimites().add(this);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "LIMITE DE VITESSE";
    }

    public boolean equals(Object obj) {
        return obj instanceof DebutLimite ;
    }
}
