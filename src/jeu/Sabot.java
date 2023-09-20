package jeu;

import carte.Carte;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot {
    private Carte[] cartes;
    private int nbrCarte;

    private class Iterateur implements Iterator<Carte> {
        private int indiceIterateur = 0;
        private int nombreOperationsReference = nbrCarte;
        private boolean nextEffectue = false;

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
                cartes[i] = cartes[i++];
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
            throw new ArrayIndexOutOfBoundsException;
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

}
