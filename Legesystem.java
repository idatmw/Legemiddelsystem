import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Legesystem {
    static private Scanner scanner = new Scanner(System.in);
    static private Scanner tallscanner = new Scanner(System.in);

    static private Lenkeliste<Lege> legeliste = new SortertLenkeliste<>();
    static private Lenkeliste<Pasient> pasientliste = new SortertLenkeliste<>();
    static private Lenkeliste<Resept> reseptliste = new SortertLenkeliste<>();
    static private Lenkeliste<Legemiddel> lmliste = new SortertLenkeliste<>();

    static private String[] valgListe = new String[] {
        "1. Tast 1 for aa faa en oversikt over hva som er registrert. ",
        "2. Tast 2 for aa registrere nye elementer.",
        "0. Tast 0 for aa avslutte programmet." };

    static private String[] lmabcliste = new String[] {
        "Legemiddel A",
        "Legemiddel B",
        "Legemiddel C", };

    static private String[] opprettObjektListe = new String[] {
        "Registrere ny pasient.",
        "Registrere ny lege.",
        "Registrere nytt legemiddel.",
        "Registrere ny resept."};


    static void oversiktOverAlleElementer() {
        System.out.println("\n*****Oversikt over pasienter i legesystemet*****");
        for (Pasient p : pasientliste) {
            System.out.println(p.getNavn());
        }
        System.out.println("\n*****Oversikt over leger i legesystemet*****");
        for (Lege l : legeliste) {
            System.out.println(l.getLegenavn());
        }
        System.out.println("\n*****Oversikt over alle legemidler*****");
        for (Legemiddel lm : lmliste) {
            System.out.println(lm.getNavn());
        }
        System.out.println("\n*****Oversikt over alle resepter*****");
        for (Resept r : reseptliste) {
            System.out.println(r.getLegemiddel());
        }
    }

    static void hentLegelisteMedResepter() {
        for (Lege l : legeliste) {
            l.skrivUtLegemidler();
        }
    }

    static Integer muligIntSomStr(String muligIntSomStr) {
        boolean stop = false;
        Integer resultat = null;

        while(!stop){
            try {
                resultat = Integer.parseInt(muligIntSomStr);
                return resultat;

            } catch (NumberFormatException e) {
                System.out.println(muligIntSomStr + " er ikke et gyldig tall. Proev paa nytt.");
                muligIntSomStr = scanner.nextLine();
                continue;
            }
        }
        return resultat;
    }

    static Double valgSomDouble(String beskrivelse) {

        System.out.println(beskrivelse);
        String input = scanner.nextLine();

        boolean stop = false;
        Double resultat = null;

        while(!stop){
            try {
                resultat = Double.parseDouble(input);
                return resultat;

            } catch (NumberFormatException e) {
                System.out.println(input + " er ikke et gyldig tall. Proev paa nytt.");
                input = scanner.nextLine();
                continue;
            }
        }
        return resultat;
    }

    static Integer valgSomInt(String beskrivelse) {
        System.out.println(beskrivelse);
        String input = scanner.nextLine();
        Integer resultat = muligIntSomStr(input);

        return resultat;
    }

    static String valgSomString(String beskrivelse) {
        System.out.println(beskrivelse);
        String resultat = scanner.nextLine();
        return resultat;
    }

    static Integer menyValg(String[] liste) {
        int counter = 1;
        for(String linje : liste){
            System.out.println(counter + ". " + linje);
            counter++;
        }

        Integer resultat = null;

        while(true){
            String input = scanner.nextLine();
            resultat = muligIntSomStr(input);

            if(resultat <= liste.length){
                return resultat;
            }
            System.out.println(resultat + " er ikke et gyldig menyvalg.");
        }
    }

    //Tar inn alt av strenger. Kunne ha forsikret om at bruker taster inn
    static void nyPasient() {
        System.out.println("---Registrering av ny pasient---");
        String navn = valgSomString("Hva heter du?");
        String fodselsnmr = valgSomString("Vennligst skriv inn ditt fodselsnummer: ");
        Pasient pasient = new Pasient(navn, fodselsnmr);
        pasientliste.leggTil(pasient);
        System.out.println("\n" + pasient);
        return;
    }

    static void nyLege() {
        System.out.println("---Registrering av ny lege/fastlege");
        String legenavn = valgSomString("Hva er legens navn? ");

        System.out.println("\nFastlegens avtalenummer?" +
        "\nTast 0 dersom han ikke har noe");
        String avtalenummerStr = scanner.nextLine();
        int avtalenummer = muligIntSomStr(avtalenummerStr);

        if(avtalenummer > 0) {
            Fastlege fastlege = new Fastlege(legenavn, avtalenummer);
            legeliste.leggTil(fastlege);
        } else {
            Lege lege = new Lege(legenavn);
            legeliste.leggTil(lege);
        }
    }

    static void nyResept() {
        System.out.println("\n---Opprette ny resept---");
        return;
    }

    static void nyttLegemiddel() {
        System.out.println("\n---Oppretting og registrering av et nytt legemiddel---");
        System.out.println("Oensker du aa opprette Legemiddel A, B eller C?");

        Integer valget = menyValg(lmabcliste);

        if(valget == 1) {

            String legemiddelnavn = valgSomString("Skriv inn navn paa legemiddelet: ");
            double pris = valgSomDouble("Skriv inn prisen paa '" +legemiddelnavn + "': ");
            int virkestoff = valgSomInt("Skriv inn mengde virkestoff(mg): ");
            int narkotiskStyrke = valgSomInt("Skriv inn narkotisk styrke: ");

            Legemiddel lma = new LegemiddelA(legemiddelnavn, pris, virkestoff, narkotiskStyrke);
            lmliste.leggTil(lma);

        } else if (valget == 2) {

            String legemiddelnavn = valgSomString("Skriv inn navn paa legemiddelet: ");
            double pris = valgSomDouble("Skriv inn prisen paa '" +legemiddelnavn + "': ");
            int virkestoff = valgSomInt("Skriv inn mengde virkestoff(mg): ");
            int vanedannendeStyrke = valgSomInt("Skriv inn narkotisk styrke: ");

            LegemiddelB lmb = new LegemiddelB(legemiddelnavn, pris, virkestoff, vanedannendeStyrke);
            lmliste.leggTil(lmb);

        } else if (valget == 3) {

            String legemiddelnavn = valgSomString("Skriv inn navn paa legemiddelet: ");
            double pris = valgSomDouble("Skriv inn prisen paa '" +legemiddelnavn + "': ");
            int virkestoff = valgSomInt("Skriv inn mengde virkestoff(mg): ");

            LegemiddelC lmc = new LegemiddelC (legemiddelnavn, pris, virkestoff);
            lmliste.leggTil(lmc);

        } else

        return;
    }

    public static void hoved() {
        System.out.println("***HOVEDMENY***");
        System.out.println("\nDine valg: ");
        Integer hovedmeny = menyValg(valgListe);

        if (hovedmeny < 1 || hovedmeny > valgListe.length-1){
            System.out.println("Du har naa avsluttet programmet");
            return;
        } else if(hovedmeny == 1) {
                oversiktOverAlleElementer();
        } else if(hovedmeny == 2) {

            System.out.println("\nVelg det du oensker aa opprette.");
            Integer opprettObjekt = menyValg(opprettObjektListe);

                if (opprettObjekt == 1) {
                    nyPasient();
                } else if (opprettObjekt == 2) {
                    nyLege();
                } else if (opprettObjekt == 3) {
                    nyttLegemiddel();
                } else if (opprettObjekt == 4) {
                    nyResept();
                }
        }
        System.out.println("\nTast '0' for aa avslutte programmet.\n" +
        "Tast et annet tall for aa fortsette.");
        int fortsette = tallscanner.nextInt();
        //Skrive et tall hoyere enn 0. 0 eller bokstaver vil avslutte prog.
        if (fortsette != 0) {
            hoved();
        }


    }

    public static void main(String[] args) {

        //Banner
        System.out.println("*****************************************************");
        System.out.println("************~Velkommen til Legesystemet~*************");
        System.out.println("*****************************************************");
        System.out.println("");
        hoved();
    }
}
            // }
            // else if (svar.equals("2")) {
            //     System.out.println("Velg det du oensker aa opprette." +
            //     "\n1. Registrere ny pasient." +
            //     "\n2. Registrere ny lege." +
            //     "\n3. Registrere nytt legemiddel." +
            //     "\n4. Registrere ny resept."+
            //     "\nTrykk enter for aa komme tilbake til hovedmenyen");
            //
            //     String opprettObjekt = scanner.nextLine();
            //     if (opprettObjekt.equals("1")) {
            //         nyPasient();
            //
            //     } else if (opprettObjekt.equals("2")) {
            //         nyLege();
            //
            //     } else {
            //
            //     }
            //     return;
            //
            // }



/*
        Pasient pasient = new Pasient("Harald", "123123");
        Pasient pasient1 = new Pasient("Jens", "123232");
        Pasient pasient2 = new Pasient("Henrikke", "232323");
        Pasient pasient3 = new Pasient("Mikael", "23232");
        Pasient pasient4 = new Pasient("Carolina", "323232");

        Lege lege = new Lege("Dr. Amundsen");
        Lege lege1 = new Lege("Dr. Burkeland");
        Lege lege2 = new Lege("Dr. Storsaether");
        Fastlege fastlege = new Fastlege("Dr. Thorsvik", 123);
        Fastlege fastlege1 = new Fastlege("Dr. Herulf", 1232);

        LegemiddelA legemA = new LegemiddelA("LegemiddelA", 23.2, 500, 5);
        LegemiddelB legemB = new LegemiddelB("LegemiddelB", 323, 400, 4);
        LegemiddelC legemC = new LegemiddelC("LegemiddelC", 123, 300);
        LegemiddelC legemC2 = new LegemiddelC("LegemiddelC2", 321, 300);

        Resept hresept = new HvitResept(legemC, lege, pasient, 2);
        Resept mresept = new Militaerresept(legemB, lege2, pasient1, 3);
        Resept presept = new PResept(legemC2, fastlege, pasient2);
        Resept bresept = new BlaaResept(legemB, fastlege1, pasient3, 3);

        legeliste.leggTil(lege);
        legeliste.leggTil(lege1);
        legeliste.leggTil(lege2);
        legeliste.leggTil(fastlege);
        legeliste.leggTil(fastlege1);

        lege.leggTilResept(hresept);
        lege.leggTilResept(mresept);
        pasientliste.leggTil(pasient4);
        pasientliste.leggTil(pasient);
        pasientliste.leggTil(pasient1);
        pasientliste.leggTil(pasient2);
        pasientliste.leggTil(pasient3);

        pasient.leggTilResept(bresept);
        pasient.leggTilResept(mresept);
        pasient.leggTilResept(hresept);
        pasient4.leggTilResept(presept);
        pasient4.leggTilResept(mresept);*/
