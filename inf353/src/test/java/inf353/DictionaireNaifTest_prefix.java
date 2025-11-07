package inf353;

import static org.junit.Assert.*;
import org.junit.Test;

import inf353.Dictionnaire;

public class DictionaireNaifTest_prefix {

@Test
public void contientPrefixeTest()
{
    DictionnaireNaif d = new DictionnaireNaif();

    String[] mots = { "aaa" , "abc","ccc" , "aaaaaaaaaa", "ababab", "bbbbbb" , "a" ,"b" ,"c" };
    for (String mot : mots) {
        d.ajouterMot(mot);
    }

    // Tests des prefixes existants
    assertTrue(d.contientPrefixe("a"));
    assertTrue(d.contientPrefixe("ab"));
    assertTrue(d.contientPrefixe("abc"));
    assertTrue(d.contientPrefixe("aaaa"));
    assertTrue(d.contientPrefixe("b"));
    assertTrue(d.contientPrefixe("bb"));
    assertTrue(d.contientPrefixe("c"));

    // Tests des prefixes non existants
    assertFalse(d.contientPrefixe("d"));
    assertFalse(d.contientPrefixe("ac"));
    assertFalse(d.contientPrefixe("ba"));
    assertFalse(d.contientPrefixe("aaaab"));
    assertFalse(d.contientPrefixe("ababababa"));
    
}

}
