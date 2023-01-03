public class Legemiddel implements Comparable<Legemiddel>{
    private String navn;
    private double pris;
    private int virkestoff;
    private int id;
    private static int idCount = 0;

    public Legemiddel(String navn, double pris, int virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id=idCount;
        idCount++;
    }

    public int getCounterId() {
        return id;
    }

    public String getNavn(){
        return navn;
    }

    public double getPris(){
        return pris;
    }

    public int getVirkestoff(){
        return virkestoff;
    }

    public double settNyPris(double nyPris){
        pris = nyPris;
        return pris;

    }

    public int compareTo(Legemiddel andre) {
        int res = this.getNavn().compareTo(andre.getNavn());
        return res;
    }

    public String toString() {
        return " Navn: " + this.getNavn()
                + "\n Pris: " + this.getPris()
                + "\n Virkestoff: " + this.getVirkestoff() + " mg"
                + "\n ID: " + this.getCounterId() + "\n";
                }



}
