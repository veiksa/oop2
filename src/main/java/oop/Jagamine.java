package oop;

public class Jagamine extends Tehted {
    private String tehe = " / ";

    public Jagamine(int arv1, int arv2){
        super(arv1, arv2);
        if (arv1 >= arv2){
            super.setArv1(arv1);
            super.setArv2(arv2);
        }else{
            super.setArv1(arv2);
            super.setArv2(arv1);
        }
    }

    @Override
    public String toString() {
        return super.getArv1() + this.tehe + super.getArv2();
    }

    public int jagamisTehe(){
        return super.getArv1() / super.getArv2();

    }
}
