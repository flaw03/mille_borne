package main;

import carte.Carte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MainAsListe implements Main {

    ArrayList<Carte> cartes;

    public MainAsListe() {
        cartes = new ArrayList<>();
    }

    @Override
    public void prendre(Carte carte) {
        cartes.add(carte);
    }

    @Override
    public void jouer(Carte carte) {
        assert cartes.contains(carte);
        cartes.remove(carte);

    }

    @Override
    public ListIterator<Carte> itearator() {
        return cartes.listIterator();
    }
}
