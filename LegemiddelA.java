public class LegemiddelA extends Legemiddel {
    private int narkotiskStyrke;

    public LegemiddelA(String navn, double pris, int virkestoff, int narkotiskStyrke){
        super(navn, pris, virkestoff);
        this.narkotiskStyrke = narkotiskStyrke;
    }

    public int getNarkotiskStyrke(){
        return narkotiskStyrke;
    }


    public String toString() {
        return " Navn: " + this.getNavn()
                + "\nPris: " + this.getPris()
                + "\nVirkestoff: " + this.getVirkestoff() + " mg"
                + "\nNarkotisk styrke: " + this.getNarkotiskStyrke()
                + "\nID: " + this.getCounterId() + "\n";


    }
}
