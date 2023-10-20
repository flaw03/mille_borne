package main;

import carte.Carte;

import java.util.Iterator;
import java.util.ListIterator;

public interface Main {

    void prendre(Carte carte);

    void jouer(Carte carte);

    ListIterator<Carte> itearator();
}
