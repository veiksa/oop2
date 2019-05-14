package oop;

public class Parameetrid {
    private int teheteArv;
    private int piirArv;
    private int oigeidVastuseid = 0;
    private int valesidVastuseid = 0;

    public Parameetrid(int teheteArv, int piirArv) {
        this.teheteArv = teheteArv;
        this.piirArv = piirArv;
    }

    public int getTeheteArv() {
        return teheteArv;
    }

    public void setTeheteArv(int teheteArv) {
        this.teheteArv = teheteArv;
    }

    public int getPiirArv() {
        return piirArv;
    }

    public void setPiirArv(int piirArv) {
        this.piirArv = piirArv;
    }

    public int getOigeidVastuseid() {
        return oigeidVastuseid;
    }

    public void setOigeidVastuseid(int oigeidVastuseid) {
        this.oigeidVastuseid = oigeidVastuseid;
    }

    public int getValesidVastuseid() {
        return valesidVastuseid;
    }

    public void setValesidVastuseid(int valesidVastuseid) {
        this.valesidVastuseid = valesidVastuseid;
    }

    @Override
    public String toString() {
        return "Parameetrid{" +
                "teheteArv=" + teheteArv +
                ", piirArv=" + piirArv +
                ", oigeidVastuseid=" + oigeidVastuseid +
                ", valesidVastuseid=" + valesidVastuseid +
                '}';
    }
}
