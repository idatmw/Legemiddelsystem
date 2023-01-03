import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Hovedmeny {

    private static Scanner scanner = new Scanner(System.in);
    private static Scanner tallscanner = new Scanner(System.in);

    private static Lenkeliste<Lege> legeliste = new SortertLenkeliste<>();
    private static Lenkeliste<Pasient> pasientliste = new SortertLenkeliste<>();
    private static Lenkeliste<Resept> reseptliste = new SortertLenkeliste<>();
    private static Lenkeliste<Legemiddel> lmliste = new SortertLenkeliste<>();
    private static int resepterPaaVanedannendeLm = 0;


    private static String[] valgListe = new String[] {
        "Tast 1 for aa faa en oversikt over hva som er registrert. ",
        "Tast 2 for aa registrere nye elementer.",
        "Tast 3 for aa bruke en resept fra listen til en pasient. ",
        "Tast 4 for aa se en statistikk om elementene i systemet",
        "Tast 0 for aa avslutte programmet." };

    private static String[] lmabcliste = new String[] {
        "Legemiddel A",
        "Legemiddel B",
        "Legemiddel C", };

    private static String[] opprettObjektListe = new String[] {
        "Registrere ny pasient.",
        "Registrere ny lege.",
        "Registrere nytt legemiddel.",
        "Registrere ny resept."};

    private static String[] reseptvalgliste = new String[] {
        "Hvit resept.",
        "Militaerresept",
        "P-Resept",
        "Blaa resept"};

    // Metode som forsikrer at bruker taster inn tall og ikke bokstaver.
    // Catch metode som vil be bruker om å prøve på nytt!
    static Integer muligIntSomStr(String muligIntSomStr) {
        boolean stop = false;
        Integer resultat = null;

        // Så lenge bruker har oppgitt et String tall, da skal det gjøres om til tall.
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

    // Metode som forsikrer at bruker taster inn tall og ikke bokstaver.
    // Tar inn beskrivelse av hva programmet krever fra bruker.
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

    // Metode som tar inn et tall. Gjenbruk av kode muligIntSomStr,
    // som forsikrer at bruker ikke taster inn tall.
    // Parameter beskrivelse, som tar inn beskrivelse av hva programmet krever fra bruker.
    static Integer valgSomInt(String beskrivelse) {
        System.out.println(beskrivelse);
        String input = scanner.nextLine();
        Integer resultat = muligIntSomStr(input);

        return resultat;
    }

    // Parameter beskrivelse, som tar inn beskrivelse av hva programmet krever fra bruker.
    static String valgSomString(String beskrivelse) {
        System.out.println(beskrivelse);
        String resultat = scanner.nextLine();
        return resultat;
    }

    //
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


    //?? Implementere dette i selve nyResept()?
    static Integer menyValgLegemiddel(Lenkeliste<Legemiddel> liste) {
        int counter = 0;
        for (Legemiddel l : liste) {
            System.out.println(counter + ". " + l.getNavn());
            counter++;
        }

        Integer resultat = null;

        while(true){
            String input = scanner.nextLine();
            resultat = muligIntSomStr(input);

            if(resultat <= liste.stoerrelse()){
                return resultat;
            }
            System.out.println(resultat + " er ikke et gyldig menyvalg.");
        }
    }

    static Integer menyValgLege(Lenkeliste<Lege> liste) {
        int counter = 0;
        for (Lege l : liste) {
            System.out.println(counter + ". " + l.getLegenavn());
            counter++;
        }

        Integer resultat = null;;

        while(true){
            String input = scanner.nextLine();
            resultat = muligIntSomStr(input);

            if(resultat <= liste.stoerrelse()){
                return resultat;
            }
            System.out.println(resultat + " er ikke et gyldig menyvalg.");
        }
    }

    static Integer menyValgPasient(Lenkeliste<Pasient> liste) {
        int counter = 0;
        for (Pasient p : liste) {
            System.out.println(counter + ". " + p.getNavn() + " (fnr: " + p.getFodselsnummer() + ")");
            counter++;
        }

        Integer resultat = null;;

        while(true){
            String input = scanner.nextLine();
            resultat = muligIntSomStr(input);

            if(resultat <= liste.stoerrelse()){
                return resultat;
            }
            System.out.println(resultat + " er ikke et gyldig menyvalg.");
        }
    }

    static Integer menyValgResept(Lenkeliste<Resept> liste) {
        int counter = 0;
        for (Resept r : liste) {
            System.out.println(counter + ". " + r.getLegemiddelNavn() + " (Reit: " + r.getReit() + ")");
            counter++;
        }

        Integer resultat = null;;

        while(true){
            String input = scanner.nextLine();
            resultat = muligIntSomStr(input);

            if(resultat <= liste.stoerrelse()){
                return resultat;
            }

            System.out.println(resultat + " er ikke et gyldig menyvalg.");
        }
    }

    static void oversiktOverAlleElementer() {
        System.out.println("\n*****Oversikt over pasienter i legesystemet*****");
        for (Pasient p : pasientliste) {
            System.out.println(p.getNavn() + " (fnr: " + p.getFodselsnummer() + ")");
        }
        System.out.println("\n*****Oversikt over leger i legesystemet*****");
        for (Lege l : legeliste) {
            System.out.println("Dr. " + l.getLegenavn());
        }
        System.out.println("\n*****Oversikt over alle legemidler*****");
        for (Legemiddel lm : lmliste) {
            System.out.println(lm.getNavn());
        }
        System.out.println("\n*****Oversikt over alle resepter*****");
        for (Resept r : reseptliste) {
            System.out.println(r.getLegemiddelNavn());

        }
    }

    //Tar inn alt av strenger. Kunne ha forsikret om at bruker taster inn
    static void nyPasient() {
        System.out.println("\n---Registrering av ny pasient---");
        String navn = valgSomString("Hva heter du?");
        String fodselsnmr = valgSomString("Vennligst skriv inn ditt fodselsnummer: ");
        Pasient pasient = new Pasient(navn, fodselsnmr);
        pasientliste.leggTil(pasient);
        System.out.println("\n" + pasient);
        return;
    }

    static void nyLege() {
        System.out.println("\n---Registrering av ny lege/fastlege");
        String legenavn = valgSomString("Hva er legens navn? ");

        System.out.println("\nFastlegens avtalenummer?" +
        "\nTast 0 dersom han ikke har noe");

        String avtalenummerStr = scanner.nextLine();
        // Kaller på metode som forsikrer at bruker skriver inn tall.
        int avtalenummer = muligIntSomStr(avtalenummerStr);

        if(avtalenummer > 0) {
            Fastlege fastlege = new Fastlege(legenavn, avtalenummer);
            legeliste.leggTil(fastlege);
        } else {
            Lege lege = new Lege(legenavn);
            legeliste.leggTil(lege);
        }
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

    static void nyResept() {
        System.out.println("\n---Opprette ny resept---");
        System.out.println("Hvilken type resept oensker du aa opprette?");
        Integer reseptvalg = menyValg(reseptvalgliste);

        int reit = 3;
        Integer legemiddelvalg = menyValgLegemiddel(lmliste);
        Legemiddel valgtlegemiddel = lmliste.hent(legemiddelvalg);

        System.out.println("\nVelg utskrivende lege");
        Integer legevalg = menyValgLege(legeliste);
        Lege valgtlege = legeliste.hent(legevalg);

        System.out.println("\nHvilken pasient er resepten til?");
        Integer pasientvalg = menyValgPasient(pasientliste);
        Pasient valgtpasient = pasientliste.hent(pasientvalg);

        if(reseptvalg == 1) {
            Resept hresept = new HvitResept(valgtlegemiddel, valgtlege, valgtpasient, reit);
            valgtpasient.leggTilResept(hresept);
            valgtlege.leggTilResept(hresept);

        } else if (reseptvalg == 2) {
            Resept mresept = new Militaerresept(valgtlegemiddel, valgtlege, valgtpasient, reit);
            valgtpasient.leggTilResept(mresept);
            valgtlege.leggTilResept(mresept);

        } else if (reseptvalg == 3) {
            Resept presept = new PResept(valgtlegemiddel, valgtlege, valgtpasient);
            valgtpasient.leggTilResept(presept);
            valgtlege.leggTilResept(presept);

        } else if (reseptvalg == 4) {
            Resept bresept = new BlaaResept(valgtlegemiddel, valgtlege, valgtpasient, reit);
            valgtpasient.leggTilResept(bresept);
            valgtlege.leggTilResept(bresept);
        }

    }

    static void brukResept() {
        System.out.println("Hvilken pasient oensker du aa se resepter for? ");
        Integer velgpasient = menyValgPasient(pasientliste);
        Pasient valgtpasient = pasientliste.hent(velgpasient);

        Stabel<Resept> reseptlisteforpas = valgtpasient.hentReseptliste();

        Integer velgresept = menyValgResept(reseptlisteforpas);
        Resept valgtresept = reseptlisteforpas.hent(velgresept);

        // Maa lagre i variabel for saa aa bruke.
        boolean bruk = valgtresept.bruk();

        if (bruk != false) {
            System.out.println("Antall reit etter bruk paa " + valgtresept.getLegemiddelNavn() + ": " + valgtresept.getReit());
        } else {
            System.out.println("Kunne ikke bruke resept paa " + valgtresept.getLegemiddelNavn() + " (ingen gjenvaerende reit)");
        }
    }

    static void seStatistikk() {
        int vanedannendeMilitaer = 0;
        int utskrevneVanedannende = 0;
        int legeNarkotisk = 0;
        int pasientVanedannende = 0;
        //Totalt antall utskrevne resepter på vanedannende legemidler.
        for (Resept r : reseptliste) {
            r.getLegemiddel();
            if(r.getLegemiddel() instanceof LegemiddelB) {
                utskrevneVanedannende++;
            }
        }
        System.out.println("Totalt antall resepter på vanedannende legemidler: " + utskrevneVanedannende);

        for (Resept r : reseptliste) {
            if(r instanceof Militaerresept)
            r.getLegemiddel();
            if(r.getLegemiddel() instanceof LegemiddelB){
                vanedannendeMilitaer++;
            }
        }
        System.out.println("Totalt antall militaerresepter på vanedannende legemidler: " + vanedannendeMilitaer);

        for (Lege l : legeliste) {
            l.hentReseptliste();
            for(Resept r : l.hentReseptliste()) {
                if (r.getLegemiddel() instanceof LegemiddelA) {
                    legeNarkotisk++;
                }
            }
        }
        System.out.println("Leger som har skrevet ut minste én resept på narkotiske legemidler: " + legeNarkotisk);

        for (Pasient p : pasientliste) {
            p.hentReseptliste();
            for(Resept r : p.hentReseptliste()) {
                if (r.getLegemiddel() instanceof LegemiddelA) {
                    pasientVanedannende++;
                }
            }
        }
        System.out.println("Pasienter som har resept på narkotiske legemidler: ");
    }

        //Totalt antall utskrevne resepter på vanedannende legemidler.
        // Antall vanedannende resepter utskrevne til militære
        // Statistikk om mulig misbruk av narkotika :
            // navn på alle leger som har skrevet ut minst én resept på narkotisk legemiddel og antall resept per lege
            //Liste opp navn på alle pasienter som har minst en gyldig resept på narkotisk legemiddel. antall nark per pasient.

    static void objekter(){
        Pasient pasient = new Pasient("Jens Hans Olsen", "11111143521");
        Pasient pasient1 = new Pasient("Petrolina Swiq", "24120099343");
        Pasient pasient2 = new Pasient("Sven Svendsen", "10111224244");
        Pasient pasient3 = new Pasient("Juni Olsen", "21049563451");

        Lege lege = new Lege("Dr. Cox");
        Lege lege1 = new Lege("Dr. Wilson");
        Lege lege2 = new Lege("Dr. Hillestad Lovold");
        Fastlege fastlege = new Fastlege("Dr. House", 12345);

        LegemiddelA legemA = new LegemiddelA("Predizol", 450, 75, 8);
        LegemiddelB legemB = new LegemiddelB("Paralgin Forte", 65, 400, 5);
        LegemiddelC legemC = new LegemiddelC("Placebo Pianissimo", 10, 0);
        LegemiddelC legemC2 = new LegemiddelC("Ibux", 240, 200);

        Resept bresept = new BlaaResept(legemA, lege, pasient2, 3);
        Resept hresept = new HvitResept(legemC, lege2, pasient3, 10000);
        Resept presept = new PResept(legemB, fastlege, pasient1);
        Resept mresept = new Militaerresept(legemC2, lege2, pasient3, 2);

        legeliste.leggTil(lege);
        legeliste.leggTil(lege1);
        legeliste.leggTil(lege2);
        legeliste.leggTil(fastlege);

        pasientliste.leggTil(pasient);
        pasientliste.leggTil(pasient1);
        pasientliste.leggTil(pasient2);
        pasientliste.leggTil(pasient3);

        lmliste.leggTil(legemA);
        lmliste.leggTil(legemB);
        lmliste.leggTil(legemC);
        lmliste.leggTil(legemC2);

        reseptliste.leggTil(hresept);
        reseptliste.leggTil(mresept);
        reseptliste.leggTil(presept);
        reseptliste.leggTil(bresept);

        pasient.leggTilResept(bresept);
        pasient.leggTilResept(mresept);
        pasient.leggTilResept(hresept);
        pasient.leggTilResept(presept);

    }

        //Integer resept = valgSomInt("Hva oensker du resept paa? ");

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

        } else if(hovedmeny == 3) {
            brukResept();

        } else if(hovedmeny == 4) {
            seStatistikk();
        }

        System.out.println("\nTast '0' for aa avslutte programmet.\n" +
        "Tast et annet tall for aa fortsette.");
        int fortsette = tallscanner.nextInt();
        //Skrive et tall hoyere enn 0. 0 eller bokstaver vil avslutte prog.
        if (fortsette != 0) {
            hoved();
        }
    }

    static String banner() {
        System.out.println("*****************************************************");
        System.out.println("************~Velkommen til Legesystemet~*************");
        System.out.println("*****************************************************");
        System.out.println("");
        return "";
    }

    public static void main(String[] args) {
        objekter();
        banner();
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
