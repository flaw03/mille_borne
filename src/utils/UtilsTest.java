package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Utils.*;

class UtilsTest {
    private  ArrayList<Integer> liste = new ArrayList<>();
    private  ArrayList<Integer> liste2 = new ArrayList<>();
    private  ArrayList<Integer> liste3 = new ArrayList<>();

    @BeforeEach
    void init(){
        liste.add(1);
        liste.add(1);
        liste.add(2);
        liste.add(3);

        liste2.add(1);
        liste2.add(4);
        liste2.add(3);
        liste2.add(2);

        liste3.add(1);
        liste3.add(1);
        liste3.add(3);
        liste3.add(2);
        liste3.add(1);
    }
    @Test
    void TestExtraire() {
        ArrayList<Integer> copil1 = new ArrayList<>(liste);
        Integer e = extraire(liste);
        assertNotEquals(copil1,liste);
        assertEquals(copil1.size()-1 , liste.size());
    }



    @Test
    void Testmelanger() {

    }

    void testMelangerListe() {

    }


    @Test
    void testRassembler() {
        ArrayList<Integer> copil1 = new ArrayList<>();
        ArrayList<Integer> copil2 = new ArrayList<>(liste2);
        ArrayList<Integer> copil3 = new ArrayList<>();
        copil1.add(1);
        copil1.add(2);
        copil1.add(1);
        copil1.add(3);
        copil1 = rassembler(copil1);
        assertEquals(copil1,liste);

        copil2 = rassembler(copil2);
        assertEquals(copil2,liste2);£

        copil3.add(1);
        copil3.add(1);
        copil3.add(1);
        copil3.add(3);
        copil3.add(2);

        liste3 = rassembler(liste3);
        assertEquals(copil3,liste3);

    }
}