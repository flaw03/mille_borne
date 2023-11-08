package carte;

import joueur.Joueur;

public class FinLimite extends Limite{
    public FinLimite(int nombre) {
        super(nombre);
    }


    @Override
    public String toString() {
        return "FIN DE LIMITE DE VITESSE";
    }

    public boolean equals(Object obj) {
        return obj instanceof FinLimite ;
    }
    @Override
    boolean appliquer(Joueur j) {
        if (!j.estPrioritaire()) {
            Limite limite = j.getLimites().get(j.getLimites().size() - 1);
            if (limite instanceof DebutLimite) {
                j.getLimites().add(this);
                return true;
            }
        }
        return false;
    }
}
