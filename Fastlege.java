public class Fastlege extends Lege implements Kommuneavtale {
    private int avtalenummer;

    public Fastlege(String navn, int avtalenummer) {
        super(navn);
        this.avtalenummer = avtalenummer;
    }

    public int getKommuneavtale(){
        return avtalenummer;
    }

    public String toString() {
        return "Fastlegens navn: Dr. " + getLegenavn()
                + "\nAvtalenummer: " + getKommuneavtale();
    }

}
