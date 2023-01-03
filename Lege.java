//For å bruke den generiske SortertLenkeliste så må man implementere Comparable.
public class Lege implements Comparable<Lege> {

    private String legenavn;
    private Lenkeliste<Resept> reseptliste;

    public Lege(String navn) {
        legenavn = navn;
        reseptliste = new Lenkeliste<Resept>();
    }

    public String getLegenavn() {
        return legenavn;
    }

    public int compareTo(Lege andre) {
        int res = this.getLegenavn().compareTo(andre.getLegenavn());
        return res;
    }

    //Legge til resepter i lenkelista og hente ut resepter
    public void leggTilResept(Resept resept) {
        reseptliste.leggTil(resept);
    }

    public Lenkeliste<Resept> hentReseptliste() {
        return reseptliste;
    }

    public void skrivUtLegemidler() {
        for(Resept r : hentReseptliste()) {
            System.out.println("Utskrevne resepter: " + r.getLegemiddel().getNavn());
        }
    }

    public String toString() {
        return "Legens navn: Dr. " + legenavn;
    }

}

    //     return reseptliste;
    //     }

        /*

         public int compareTo(Lege andre)
        //Må være inni hvis sjekken slår inn;
        if (this.getLegenavn().compareTo(andre.getLegenavn()) < 0) {
            return ;
        }else if (this.getLegenavn().compareTo(andre.getLegenavn()) > 0) {
            return;
        }
        // else ppå slutten!
        // Dette er en ncondition!
        //else (this.getLegenavn().compareTo(andre.getLegenavn()))
        else {
            return 0;
        }
*/
