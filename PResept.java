public class PResept extends HvitResept {
    private static int reit = 3;

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    public String getTypeResept() {
        return "P-Resept";
    }

    public double PReseptPris() {
        double pris = this.prisAaBetale() - 116;

        if (pris <= 0) {
            return 0;
        } else {
            return pris;
        }
    }

    public String toString() {
        return " Pasient ID: " + this.getPasientId()
                + "\n Utskrivende lege: " + this.getUtskrivendeLege()
                + "\n Legemiddel: " + this.getLegemiddel()
                + "\n Reseptfarge: " + this.farge()
                + "\n Type resept: " + this.getTypeResept()
                + "\n Pris aa betale: " + this.PReseptPris()
                + "\n Resept ID: " + this.getReseptId()
                + "\n Reit: " + this.getReit()
                + "\n";
    }
}
