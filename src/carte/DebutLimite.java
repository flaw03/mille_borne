package carte;

public class DebutLimite extends Limite {

    public DebutLimite(int nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "LIMITE DE VITESSE";
    }

    public boolean equals(Object obj) {
        return obj instanceof DebutLimite ;
    }
}
