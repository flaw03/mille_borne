package carte;

public abstract class  Probleme extends Carte{

    private Type type;

    public Type getType() {
        return type;
    }

    public Probleme(int nombre, Type type) {
        super(nombre);
        this.type = type;
    }

}
