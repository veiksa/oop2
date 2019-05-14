package oop;

public class Peameetod {
    public static void main(String[] args) {

        Parameetrid teheteJaPiirArv = new Parameetrid(5, 10);
        int piirArv = teheteJaPiirArv.getPiirArv();
        int teheteArv = teheteJaPiirArv.getTeheteArv();


        int i = 0;
        int oigedVastamised = 0;
        int valedVastamised = 0;
        long startTime = System.currentTimeMillis();

        while (i < teheteArv){
            JuhuslikudNumbrid arvud = new JuhuslikudNumbrid(teheteJaPiirArv);

            if (i % 2 == 0) {

                Liitmine tehe = new Liitmine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                System.out.println();
                int kasutajaSisend = tehe.userInput();

                if (tehe.Summeerimine() == kasutajaSisend){
                    System.out.println();
                    System.out.println("Õige vastus");
                    oigedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Vale vastus");
                    System.out.println("Õige vastus on " + tehe.Summeerimine());
                    valedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }


                i++;
            }else{
                Lahutamine tehe = new Lahutamine(arvud.getJuhuslikNumber1(), arvud.getJuhuslikNumber2());
                System.out.println("Kui palju on " + tehe.toString());
                System.out.println();
                int kasutajaSisend = tehe.userInput();

                if (tehe.Lahutustehe() == kasutajaSisend){
                    System.out.println();
                    System.out.println("Õige vastus");
                    oigedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Vale vastus");
                    System.out.println("Õige vastus on " + tehe.Lahutustehe());
                    valedVastamised += 1;
                    System.out.println("Õigesti vastamisi: " + oigedVastamised);
                    System.out.println("Valesti vastamisi: " + valedVastamised);
                    System.out.println();
                }


                i++;

            }


        }
        long endTime = System.currentTimeMillis();

        long vastamiseKestvus = (endTime - startTime)/(60*1000);

        System.out.println("=====================");
        System.out.println("Koik vastatud");
        System.out.println();
        System.out.println("Õigesti vastamisi: " + oigedVastamised);
        System.out.println("Valesti vastamisi: " + valedVastamised);
        System.out.println();
        System.out.println("aega kulus " + vastamiseKestvus + " minutit.");





    }
}
