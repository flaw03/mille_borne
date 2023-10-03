package jeu;

import carte.Botte;
import carte.Carte;
import carte.Type;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot {
    private final Carte[] cartes;
    private int nbrCarte;


    private class Iterateur implements Iterator<Carte> {
        private int indiceIterateur = 0;
        private int nombreOperationsReference = nbrCarte;
        private boolean nextEffectue = false;

        public Iterateur() {
        }

        public boolean hasNext() {
            return indiceIterateur < nbrCarte;
        }

        public Carte next() {
            verificationConcurrence();
            if (hasNext()) {
                Carte carte = cartes[indiceIterateur];
                indiceIterateur++;
                nextEffectue = true;
                return carte;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (nbrCarte < 1 || !nextEffectue) {
                throw new IllegalStateException();
            }
            verificationConcurrence();
            for (int i = indiceIterateur - 1; i< nbrCarte -1 ;i++){
                cartes[i] = cartes[i+1];
            }
            nombreOperationsReference--;
            nbrCarte--;
            indiceIterateur--;
            nextEffectue = false;
        }

        private void verificationConcurrence(){
            if (nbrCarte != nombreOperationsReference)
                throw new ConcurrentModificationException();
        }

    }

    public Sabot(int nbrCarteMax) {
        cartes = new Carte[nbrCarteMax];
        this.nbrCarte = 0;
    }

    public boolean estvide() {
        return nbrCarte == 0;
    }

    public void ajouterCarte(Carte carte) throws ArrayIndexOutOfBoundsException {
        if (nbrCarte >= cartes.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            cartes[nbrCarte] = carte;
            nbrCarte ++;
        }
    }

    public void ajouterFamilleCarte(Carte carte) {
        for (int i = 0; i<carte.getNombre();i++){
            ajouterCarte(carte);
        }
    }

    public void ajouterFamilleCarte(Carte... carteAjoute) {
        for (Carte carte : carteAjoute) {
            ajouterCarte(carte);
        }
    }

    public Carte piocher() throws IllegalArgumentException{
        Iterateur iterateur = new Iterateur();
        Carte carte =  iterateur.next();
        if (carte instanceof Botte && ((Botte) carte).getType() == Type.ACCIDENT) {
            throw new IllegalArgumentException();
        }
        iterateur.remove();
        return carte;
    }


}
