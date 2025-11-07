package inf353;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Tests pour la méthode indiceMot(String m) */
public class DictionaireIndiceMotTest {

    @Test
    public void indiceMotPresent() {
        DictionnaireNaif d = new DictionnaireNaif();
        String[] mots = {"aaa", "bbb", "ccc"};
        for (String mot : mots) d.ajouterMot(mot);
        assertEquals(0, d.indiceMot("aaa"));
        assertEquals(1, d.indiceMot("bbb"));
        assertEquals(2, d.indiceMot("ccc"));
    }

    @Test
    public void indiceMotAbsent() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("aaa");
        d.ajouterMot("bbb");
        assertEquals(-1, d.indiceMot("ddd"));
        assertEquals(-1, d.indiceMot(""));
    }

    @Test
    public void indiceMotApresVider() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("aaa");
        d.ajouterMot("bbb");
        d.vider();
        assertEquals(-1, d.indiceMot("aaa"));
    }
}