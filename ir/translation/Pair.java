package ir.translation;

public class Pair<T,V> {

    T fst;
    V snd;

    public Pair(T a, V b) {
        this.fst = a;
        this.snd = b;
    }

    public T getFst() {
        return fst;
    }

    public V getSnd() {
        return snd;
    }
}
