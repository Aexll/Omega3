package inf353;

import static org.junit.Assert.*;
import org.junit.Test;

import inf353.Dictionnaire;

public class DictionaireNaifTest_contient {

@Test
public void contient()
{
  DictionnaireNaif d = new DictionnaireNaif();

  String[] mots = { "aaa" , "abc","ccc" , "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "ababab", "bbbbbb" , "a" ,"b" ,"c" };
  for (String mot : mots) {
      d.ajouterMot(mot);
  }

  d.print();

  assertEquals("Le dictionnaire contient: aaa", true, d.contient("aaa"));
  assertEquals("Le dictionnaire contient: un mot de longeur 39", true, d.contient("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
  assertEquals("Le dictionnaire contient: un mot de longeur 40", false, d.contient("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
  assertEquals("Le dictionnaire contient le mot vide: ", false, d.contient(""));
  assertEquals("Le dictionnaire contient: un mot de longeur > 40", false, d.contient("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));

  }
}
