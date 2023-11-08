package joueur;

import carte.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    Joueur joueur = new Joueur("Joueur 1");
    @Test
    void getKM() {
        joueur.getBornes().add(new Borne(2,25));
        joueur.getBornes().add(new Borne(2,25));
        joueur.getBornes().add(new Borne(2,25));
        assertEquals(joueur.getKM(),75);

        joueur.getBornes().add(new Borne(2,50));
        joueur.getBornes().add(new Borne(2,50));
        joueur.getBornes().add(new Borne(2,50));
        assertEquals(joueur.getKM(),225);

        joueur.getBornes().add(new Borne(2,50));
        joueur.getBornes().add(new Borne(2,50));
        joueur.getBornes().add(new Borne(2,50));

        assertEquals(joueur.getKM(),375);




        joueur.getBornes().add(new Borne(2,100));
        assertEquals(joueur.getKM(),475);
        joueur.getBornes().add(new Borne(2,100));
        joueur.getBornes().add(new Borne(2,100));
        assertEquals(joueur.getKM(),675);
    }

    @Test
    void getLimite() {
//        cas pile limite vide
        assertEquals(joueur.getLimite(),200);
        joueur.getLimites().add(new FinLimite(40));
//        cas fin de limite en tete de pile
        assertEquals(joueur.getLimite(),200);
        joueur.getLimites().add(new DebutLimite(40));
//        cas debut de limite en tete de pile
        assertEquals(joueur.getLimite(),50);
        joueur.getBottes().add(new Botte(2, Type.FEU));
//        cas debut de limit en tete de pile et vehicule prioritaire
        assertEquals(joueur.getLimite(),200);


    }

    @Test
    void estBloque() {
        assertFalse(joueur.estBloque());
        joueur.getBatailles().add(new Attaque(0, Type.FEU));
        assertTrue(joueur.estBloque());
        joueur.getBottes().add(new Botte(0, Type.FEU));
        assertFalse(joueur.estBloque());
        joueur.getBatailles().add(new Attaque(0, Type.ACCIDENT));
        assertTrue(joueur.estBloque());
        joueur.getBottes().add(new Botte(0, Type.ACCIDENT));
        assertFalse(joueur.estBloque());
        joueur.getBatailles().add(new Attaque(0, Type.ESSENCE));
        assertTrue(joueur.estBloque());
        joueur.getBottes().add(new Botte(0, Type.ESSENCE));
        assertFalse(joueur.estBloque());

        joueur.getBottes().remove(new Botte(0, Type.FEU));
        joueur.getBottes().remove(new Botte(0, Type.ACCIDENT));
        joueur.getBottes().remove(new Botte(0, Type.ESSENCE));
        assertTrue(joueur.estBloque());
        joueur.getBatailles().add(new Parade(0,Type.FEU));
        assertFalse(joueur.estBloque());

    }
}