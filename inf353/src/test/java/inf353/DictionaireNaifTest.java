package inf353;

import static org.junit.Assert.*;
import org.junit.Test;

import inf353.Dictionnaire;

public class DictionaireNaifTest {

@Test
public void contientPrefixeTest()
{
  DictionnaireNaif d = new DictionnaireNaif();

  String[] mots = { "aaa" , "abc","ccc" , "aaaaaaaaaa", "ababab", "bbbbbb" , "a" ,"b" ,"c" };
  for (String mot : mots) {
      d.ajouterMot(mot);
  }

  d.print();

  System.out.println("mot indice:" + d.motIndice(0) );
  System.out.println("mot indice:" + d.motIndice(1) );

  System.err.println("Test contientPrefixe:");
  String[] tests_true = { };
  for (String t : tests_true) {
      System.err.print(t + ": ");
      System.err.println(d.contientPrefixe(t));
  }
  System.err.println("Tests qui doivent échouer:");
  String[] tests_false = { "yyy", "xyz" , "z" , "ba"};
  for (String t : tests_false) {
      System.err.print(t + ": ");
      System.err.println(d.contientPrefixe(t));
  }


  System.err.println("Test plusLongPrefixeDe");
  System.out.println("--------");
  String[] tests_plp = { "aab" , "ababa", "cccc", "aaaaaa", "b", "c", "d"};
  for (String t : tests_plp) {
      System.err.print(t + ": ");
      System.err.println(d.plusLongPrefixeDe(t));
  }

  System.out.println("--------");

   // Tests (Bekaye)

    @Test
    public void testNbMotsVide() {
        assertEquals(0, dico.nbMots(), "Un dictionnaire vidé doit contenir 0 mot.");
    }

    @Test
    public void testNbMotsApresAjouts() {
        dico.ajouterMot("chat");
        dico.ajouterMot("chien");
        dico.ajouterMot("oiseau");
        assertEquals(3, dico.nbMots(), "Le dictionnaire devrait contenir 3 mots.");
    }

    @Test
    public void testMotIndiceValide() {
        dico.ajouterMot("pomme");
        dico.ajouterMot("banane");
        dico.ajouterMot("cerise");

        String mot = dico.motIndice(1);
        assertNotNull(mot, "motIndice() ne doit pas renvoyer null.");
        assertTrue(mot.equals("pomme") || mot.equals("banane") || mot.equals("cerise"),
                   "Le mot renvoyé doit être un des mots ajoutés.");
    }


}







 