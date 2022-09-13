import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // variabile Jucator
        int sanatate = 100;
        int atacDeteriorare = 50;
        int nrPotiuni = 3;
        int valoareRegenerarePotiune = 30;
        int sansaPotiune = 50; //procentaj

        // variabile inamic

        String[] inamici = {"Zmeul", "Balaurul", "Warrior", "Lupul cel Rau"};
        int maxSanatateInamic = 75;
        int atacDeteriorareInamic = 25;

        boolean running = true;
        System.out.println("Bine ai venit in temnita!");

        GAME:
        while (running) {
            System.out.println("-------------------------------------");

            int sanatateInamic = rand.nextInt(maxSanatateInamic);
            String inamic = inamici[rand.nextInt(inamici.length)];

            System.out.println("\t# " + inamic + " a aparut!!!# ");

            while (sanatateInamic > 0) {
                System.out.println("\tSanatatea ta este " + sanatate);
                System.out.println("\tSanatatea inamicului " + inamic + " este " + sanatateInamic);
                System.out.println("\t Ce ai vrea sa faci? ");
                System.out.println("\t1. Ataca! ");
                System.out.println("\t2. Bea potiunea ");
                System.out.println("\t3. FUGI!!! ");

                String input = in.nextLine();

                if (input.equals("1")) {
                    //cod pt actiunea "ataca"
                    int deteriorareProdusa = rand.nextInt(atacDeteriorare);
                    int deteriorarePrimita = rand.nextInt(atacDeteriorareInamic);

                    sanatateInamic -= deteriorareProdusa;
                    sanatate -= deteriorarePrimita;
                    System.out.println("\tL-ai lovit pe " + inamic + " cu " + deteriorareProdusa + " deteriorare");
                    System.out.println("\tAi primit " + deteriorarePrimita + " deteriorare ");

                    if (sanatate < 1) {
                        System.out.println("\tAi fost lovit mortal, nu mai poti continua!");
                        break;
                    }

                } else if (input.equals("2")) {
                    //cod pt actiunea "bea potiune"
                    if (nrPotiuni > 0) {
                        sanatate += valoareRegenerarePotiune;
                        nrPotiuni--;
                        System.out.println("\tAi baut o potiune. Te-ai vindecat cu " + valoareRegenerarePotiune +
                                "\n\tAcum ai " + sanatate + " sanatate. " +
                                "\n\tTi-au ramas " + nrPotiuni + " potiuni.");

                    } else {
                        System.out.println("\tNu mai ai potiuni! Invinge un inamic ca sa mai castigi potiuni.");
                    }

                } else if (input.equals("3")) {
                    //cod pt actiunea "fugi"
                    System.out.println("\tAi fugit de " + inamic);
                    continue GAME;

                } else {
                    // cod pt optiune invalida
                    System.out.println("\tComanda invalida!");
                }
            }
            if (sanatate < 1) {
                System.out.println("\tA fost crunta lupta in temnita. Esti prea slabit sa mai continui!!!");
                break;
            }
            System.out.println("-------------------------------------");
            System.out.println(" # " + inamic + " a fost invins! ");
            System.out.println(" # Ai " + sanatate + " sanatate ");

            if (rand.nextInt(100) > sansaPotiune) {
                nrPotiuni++;
                System.out.println(" # Ai castigat o potiune pe urma infrangerii lui " + inamic);
                System.out.println(" # Mai ai " + nrPotiuni + " potiuni");
            }

            System.out.println("\tCe ai vrea sa faci in continuare?");
            System.out.println("1. Lupta continua!");
            System.out.println("2. Termin jocul!");
            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Comanda invalida!");
                input = in.nextLine();
            }

            switch (input) {
                case "1": {
                    System.out.println("# Continua aventura!");
                    break;
                }
                case "2": {
                    System.out.println("\nAi ales sa iesi din Temnita. Drum bun!");
                    break GAME;
                }

            }

        }
        System.out.println("################################");
        System.out.println(" ### Multumim de joc!### ");
        System.out.println("#################################");
    }
}