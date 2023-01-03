public class Stabel<T> extends Lenkeliste<T> {

    public void leggPaa(T x){
        super.leggTil(x);
    }

    public T taAv() {
        return super.fjern(stoerrelse()-1);

    }
}
