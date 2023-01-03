public class LegemiddelB extends Legemiddel {
    private int vanedannendeStyrke;

    public LegemiddelB(String navn, double pris, int virkestoff, int vanedannendeStyrke) {
        super(navn, pris, virkestoff);
        this.vanedannendeStyrke = vanedannendeStyrke;
    }

    public int getVanedannendeStyrke() {
        return vanedannendeStyrke;
    }

    public String toString() {
        return " Navn: " + this.getNavn()
                + "\nPris: " + this.getPris()
                + "\nVirkestoff: " + this.getVirkestoff() + " mg"
                + "\nVanedannende styrke: " + this.getVanedannendeStyrke()
                + "\nID: " + this.getCounterId() + "\n";
    }
}
