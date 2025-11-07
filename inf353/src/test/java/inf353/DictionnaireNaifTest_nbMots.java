package inf353;

import static org.junit.Assert.*;
import org.junit.Test;

import inf353.Dictionnaire;

public class DictionnaireNaifTest_nbMots {

    @Test
    public void testNbMotsVide() {
        DictionnaireNaif dico = new DictionnaireNaif();
        assertEquals(0, dico.nbMots(), "Un dictionnaire vidé doit contenir 0 mot.");
    }

    @Test
    public void testNbMotsApresAjouts() {
        DictionnaireNaif dico = new DictionnaireNaif();
        dico.ajouterMot("chat");
        dico.ajouterMot("chien");
        dico.ajouterMot("oiseau");
        assertEquals(3, dico.nbMots(), "Le dictionnaire devrait contenir 3 mots.");
    }

}
