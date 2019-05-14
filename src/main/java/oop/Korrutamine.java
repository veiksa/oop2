package oop;

public class Korrutamine extends Tehted{
    private String tehe = " * ";

    public Korrutamine(int arv1, int arv2){
        super(arv1, arv2);
    }

    @Override
    public String toString() {
        return super.getArv1() + this.tehe + super.getArv2();
    }

    public int korrutusTehe(){
        return super.getArv1() * super.getArv2();

    }
}
