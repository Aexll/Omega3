package inf353;

public class DictionnaireNaif implements Dictionnaire {

    
    public int N = 100; // nombre max de mots
    public char[] t; // tableau des caractères
    public int l; // longueur actuelle du tableau des mots

    public DictionnaireNaif() {
        this.t = new char[this.N * 40];
        this.l = 0;
    }
    
    public void print() {
        for (int i = 0; i < l; i++) {
            int j = i * 40;
            System.out.print("["+i+"]:");
            while (t[j] != '\0') {
                System.out.print(t[j]);
                j++;
            }
            System.out.println();
        }
    }

    @Override
    public void vider() {
        this.l = 0;
    }

    @Override
    public void ajouterMot(String m) {
        int i = 0;
        while(i!= m.length()) {
            t[i + l * 40] = m.charAt(i);
            i++;
        }
        t[i + l * 40] = '\0';
        l = l + 1;    
        return;
    }

    @Override
    public int indiceMot(String m) {
        return 0;
    }

    @Override
    public String motIndice(int i) {            
        String w = "";
        int j = 0;
        while(t[i*40+j]!='\0'){
            w=w+t[i*40+j];
            j=j+1;
        }
        return w;
        
    }

    @Override
    public boolean contient(String m) {
        if(this.l == 0){
            return false;
        }else{
            int i = 0;
            while (i < l) {
                int debut = i * 40;
                // trouver la longueur réelle du mot dans le dictionnaire
                int longueurMotDico = 0;
                while (longueurMotDico < 39 && t[debut + longueurMotDico] != '\0') {
                    longueurMotDico = longueurMotDico + 1;
                }

                // comparer les longueurs : mot paramètre doit correspondre exactement
                if (m.length() == longueurMotDico) {
                    int j = 0;
                    // comparer caractère par caractère
                    while (j < m.length() && t[debut + j] == m.charAt(j)) {
                        j = j + 1;
                    }
                    if (j == m.length()) {
                        return true; // mot trouvé
                    }
                }

                i = i + 1; // passer au mot suivant
            }

            return false; // mot non trouvé
        }
    }


    @Override
    public int nbMots() {
        int i=0,j=0;
        while(i!=l){
            j=40*i;
            while(t[j]!='\0'){
                j=j+1;
            }
            i=i+1;
        }
        return i;
    }


    private boolean estPrefix(String p, String mot){

        if (p.length() > mot.length()) return false;

        int i = 0;

        while(i!=p.length() && mot.charAt(i)==p.charAt(i))
        {
            i = i + 1;
        }

        return i==p.length();
    }

    @Override
    public boolean contientPrefixe(String p) {
        int i=0;

        while( i!=l && !estPrefix(p,motIndice(i)))
        {
            i = i + 1;
        }

        return !(i==l);
    }

    @Override
    public String plusLongPrefixeDe(String mot) {

        int i=0;
        String best="";

        while(i!=l)
        {
            String p = motIndice(i);
            if(estPrefix(p, mot) && p.length()>best.length())
            {
                best=p;
            }
            i = i + 1;
        }

        return best;
    }

}
