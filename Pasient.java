public class Pasient implements Comparable<Pasient>{
    private String navn;
    private String fodselsnummer;
    private int pasId;
    private static int pasIdCounter = 0;
    //Husk å opprette liste i konstruktøren!!
    private Stabel<Resept> reseptliste;

    public Pasient(String navn, String fodselsnummer) {
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        reseptliste = new Stabel<Resept>();
        //this.reseptliste = reseptliste;
        pasId = pasIdCounter;
        pasIdCounter++;
    }

    public String getNavn() {
        return navn;
    }

    public String getFodselsnummer() {
        return fodselsnummer;
    }

    public int getPasId() {
        return pasId;
    }
    //Det skal både være mulig å legge til nye resepter og hente ut hele reseptlisten.

    public void leggTilResept(Resept resept) {
        reseptliste.leggPaa(resept);
    }

    public Stabel<Resept> hentReseptliste() {
        return reseptliste;
    }

    public void skrivUtLegemidler() {
        for (Resept r : hentReseptliste()) {
            System.out.println("Resepter: " + r.getLegemiddel().getNavn());
        }
    }

    public int compareTo(Pasient andre) {
        int res = this.getNavn().compareTo(andre.getNavn());
        return res;
    }

    public String toString() {
        return "Navn: " + navn +
                "\nFodselsnummer: " + fodselsnummer +
                "\nPasient ID: " + pasId;
               // "\nReseptliste: " + reseptliste;
    }

}
