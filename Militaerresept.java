public class Militaerresept extends HvitResept {
    public Militaerresept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    public String getTypeResept() {
        return "Militærresept";
    }

    public double militaerPris() {
        return this.prisAaBetale() - this.prisAaBetale();
    }

    public String toString() {
        return " Pasient ID: " + this.getPasientId()
                + "\n Utskrivende lege: " + this.getUtskrivendeLege()
                + "\n Legemiddel: " + this.getLegemiddel()
                + "\n Reseptfarge: " + this.farge()
                + "\n Type resept: " + this.getTypeResept()
                + "\n Pris aa betale: " + this.militaerPris()
                + "\n Resept ID: " + this.getReseptId()
                + "\n Reit: " + this.getReit()
                + "\n";
    }


}
