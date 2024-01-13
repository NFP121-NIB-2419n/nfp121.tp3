package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T> {
    private Stack<T> stk;
    private int capacite;

    public Pile2(int taille) {
        if (taille <= 0)
            throw new IllegalArgumentException("La taille doit être supérieure à zéro");
        this.stk = new Stack<>();
        this.capacite = taille;
    }

    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    public int capacite() {
        return capacite;
    }

    public int taille() {
        return stk.size();
    }

    public boolean estVide() {
        return stk.isEmpty();
    }

    public boolean estPleine() {
        return stk.size() == capacite;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pile2)) return false;

        Pile2<?> pile2 = (Pile2<?>) o;

        return stk.equals(pile2.stk);
    }

    public int hashCode() {
        return stk.hashCode();
    }

    public String toString() {
        return stk.toString();
    }
}
