package carte;

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
}
