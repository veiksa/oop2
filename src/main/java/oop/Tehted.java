package oop;

import java.util.Scanner;

public class Tehted {
    private int arv1;
    private int arv2;

    public Tehted(int arv1, int arv2) {
        this.arv1 = arv1;
        this.arv2 = arv2;
    }

    public int userInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Sisesta taisarv ");
        int yourNumber;
        if(scan.hasNextInt()) {
            yourNumber = scan.nextInt();
            //System.out.println(yourNumber);
            return yourNumber;
        }else{
            yourNumber = userInput();
        }
        return yourNumber;

    }

    public int getArv1() {
        return arv1;
    }

    public void setArv1(int arv1) {
        this.arv1 = arv1;
    }

    public int getArv2() {
        return arv2;
    }

    public void setArv2(int arv2) {
        this.arv2 = arv2;
    }
}
