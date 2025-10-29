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

}

}
