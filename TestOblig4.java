public class TestOblig4 {
    public static void main(String[] args) {

        Stabel<Resept> resepter = new Stabel<>();

        LegemiddelC lmc = new LegemiddelC("LegemiddelC" , 123 , 10);
        LegemiddelC lmc2 = new LegemiddelC("LM 2" , 123 , 10);

        Lege lege1 = new Lege("Dr. Paus");
        Lege lege = new Lege("Dr. Ueland");
        Pasient ida = new Pasient("Ida", "261192");
        Resept resept = new PResept(lmc, lege, ida);
        Resept resept2 = new PResept(lmc2, lege, ida);

        resepter.leggPaa(resept);
        resepter.leggPaa(resept2);
        System.out.println(lege.compareTo(lege));
        System.out.println(ida);
        System.out.println("Teste" + resepter.iterator());
        for (Resept r : resepter){
            System.out.println("yo" + r.getLegemiddel());
        }
        lege.leggTilResept(resept);
        lege.leggTilResept(resept2);
        lege.hentReseptliste();

        Lege lege2 = new Lege("Dr. 3");
        Lege lege3 = new Lege("Dr. 22");
        Lege lege4 = new Lege("Dr. 1");
        Lege lege5 = new Lege("Dr. 6");

        Lenkeliste<Lege> legeliste = new SortertLenkeliste<>();
        legeliste.leggTil(lege);
        legeliste.leggTil(lege1);
        legeliste.leggTil(lege2);
        legeliste.leggTil(lege3);
        legeliste.leggTil(lege4);
        legeliste.leggTil(lege5);

        for (Lege l : legeliste){
            System.out.println(l.getLegenavn());
        }
    }
}
