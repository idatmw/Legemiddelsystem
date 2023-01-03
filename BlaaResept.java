public class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge(){
        return "Blå";
    }

    @Override
    public double prisAaBetale() {
        return getLegemiddel().getPris() * 0.25;
    }

    public String toString() {
        return " Pasient ID: " + this.getPasientId()
                + "\n Utskrivende lege: " + this.getUtskrivendeLege()
                + "\n Legemiddel: " + this.getLegemiddel()
                + "\n Reseptfarge: " + this.farge()
                + "\n Pris aa betale: " + this.prisAaBetale()
                + "\n Resept ID: " + this.getReseptId()
                + "\n Reit: " + this.getReit()
                + "\n ";
    }

}


