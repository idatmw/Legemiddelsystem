public abstract class Resept implements Comparable<Resept> {
    private Legemiddel legemiddel;
    private Lege utskrivendeLege;
    private Pasient pasientId;
    private int reit;
    private int reseptId;
    private static int reseptIdCount = 0;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        this.reseptId = reseptIdCount;
        reseptIdCount++;
    }

    public int getReseptId(){
        return reseptId;
    }

    //Returnerer Legemiddelets toString();
    public Legemiddel getLegemiddel() {
        return legemiddel;
    }

    //Returnerer kun navn;
    public String getLegemiddelNavn() {
        return legemiddel.getNavn();
    }

    public String getUtskrivendeLege() {

        return utskrivendeLege.getLegenavn();
    }

    public Pasient getPasientId() {
        return pasientId;
    }

    public int getReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit <= 0 ) {
            return false;
        } else {
            reit--;
            return true;
        }
    }

    @Override
    public int compareTo(Resept andre) {
        int res = this.getLegemiddel().compareTo(andre.getLegemiddel());
        return res;
    }


    //Disse må implementeres i subklassene
    abstract public String farge();
    abstract public double prisAaBetale();
}
