public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
    //Kall på leggTil(T x) skal sette inn elementer i sortert rekkefølge (fra minst til stoerst)
    // kall på fjern() skal ta  det største elementet ut.

    // Overrider metoden fra lenkelista;

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node tmp = start;

        if (start == null) {
            start = nyNode;
            siste = nyNode;
        }

        else if (x.compareTo(tmp.data) < 0) {
            nyNode.neste = tmp;
            start = nyNode;
        }

        else if (x.compareTo(siste.data) > 0) {
            siste.neste = nyNode;
            siste = nyNode;
        }

        else {
            for (Node n = start; n.neste != null; n = n.neste) {
                if (x.compareTo(n.neste.data) < 0) {
                    nyNode.neste = n.neste;
                    n.neste = nyNode;
                    break;
                }
            }
        }
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();

    }

    public T fjern() {
        return super.fjern(stoerrelse() - 1);
    }
}

        /*

        if (start == null) {
            throw new UgyldigListeIndeks(-1);
        }

        // Håndter liste av en
        if (start.neste == null) {
            start = null;
            return null;
        }

        // Håndter liste av to
        if (start.neste == siste) {
            start.neste = null;
            siste = null;
            return siste.data;
        }

        // Finn nest siste
        Node tmp = start;

        while (tmp.neste.neste != null) {
            tmp = tmp.neste;
        }

        // Nullstill siste i nest siste
        tmp.neste = null;

        // Nullstill siste
        siste = null;

        // Sett ny siste til nest siste
        siste = tmp;

        return siste.data;
    }*/