package oop;

public class JuhuslikudNumbrid {
    private int juhuslikNumber1;
    private int juhuslikNumber2;


    public JuhuslikudNumbrid(Parameetrid piirarv) {
        this.juhuslikNumber1 = (int) (Math.random() * piirarv.getPiirArv());
        this.juhuslikNumber2 = (int) (Math.random() * (piirarv.getPiirArv() - this.juhuslikNumber1));
    }

    @Override
    public String toString() {
        return "" + juhuslikNumber1 + " " + juhuslikNumber2;
    }

    public int getJuhuslikNumber1() {
        return juhuslikNumber1;
    }

    public int getJuhuslikNumber2() {
        return juhuslikNumber2;
    }
}
