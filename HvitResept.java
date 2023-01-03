public class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge(){
        return "Hvit";
    }

    @Override
    public double prisAaBetale() {
        return getLegemiddel().getPris();
    }

    public String toString() {
        return " Pasient ID: " + this.getPasientId()
                + "\n Utskrivende lege: " + this.getUtskrivendeLege()
                + "\n" + this.getLegemiddel()
                + "\n Reseptfarge: " + this.farge()
                + "\n Pris aa betale: " + this.prisAaBetale()
                + "\n Resept ID: " + this.getReseptId()
                + "\n Reit: " + this.getReit()
                + "\n ";
    }

}
