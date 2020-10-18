package ru.ncedu.guesser;

public class Word {
    String w;

    static class Ch {
        char val;
        boolean f;

        public Ch(char a){
            val = a;
            f = false;
        }

        public void checkGuess(char a){
            if (a == val) f = true;
        }

        public char print(){
            if (f)return val;
            return '-';
        }

        public void reset(){
            f = false;
        }

        public boolean check(){
            return f;
        }
    }

    Ch[] wc;

    public Word(String s){
        w = s;
        wc = new Ch[s.length()];
        for (int i = 0; i<s.length(); i++)
        {
            wc[i] = new Ch(s.charAt(i));
        }
    }

    public String print(){
        StringBuilder res= new StringBuilder();
        for (int i = 0; i<w.length(); i++){
            res.append(wc[i].print());
        }
        return res.toString();
    }

    public void checkChar(char a){
        for (int i = 0; i<w.length(); i++){
            wc[i].checkGuess(a);
        }
    }

    public boolean checkWord(String a){
        return a.trim().equals(w);
    }

    public boolean checkWhole(){
        boolean res = true;
        for (int i = 0; i<w.length(); i++){
            if (!wc[i].check())res = false;
        }
        return res;
    }

}
