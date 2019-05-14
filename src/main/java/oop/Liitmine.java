package oop;

import java.util.Scanner;

public class Liitmine extends Tehted {

    private String tehe = " + ";

    public Liitmine(int arv1, int arv2) {
        super(arv1, arv2);
    }

    @Override
    public String toString() {
        return super.getArv1() + this.tehe + super.getArv2();
    }

    public int Summeerimine(){
        return super.getArv1() + super.getArv2();

    }


}
