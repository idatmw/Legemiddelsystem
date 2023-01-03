public class LegemiddelC extends Legemiddel{

    public LegemiddelC(String navn, double pris, int virkestoff) {
        super(navn, pris, virkestoff);

    }

    public String toString() {
        return "Legemiddel: " + this.getNavn()
                + "\nPris: " + this.getPris()
                + "\nVirkestoff: " + this.getVirkestoff() + " mg"
                + "\nID: " + this.getCounterId() + "\n";


    }



}
