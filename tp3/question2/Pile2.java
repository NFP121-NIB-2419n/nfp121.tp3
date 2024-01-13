package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    private Stack<Object> stk;

    public Pile2() {
        this.stk = new Stack<>();
    }

    @Override
    public void empiler(Object o) throws PilePleineException {
        stk.push(o);
    }

    @Override
    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    @Override
    public Object sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }

    @Override
    public int capacite() {
       
        return Integer.MAX_VALUE;
    }

    @Override
    public int taille() {
        return stk.size();
    }

    @Override
    public boolean estVide() {
        return stk.isEmpty();
    }

    @Override
    public boolean estPleine() {
        // la stack ne sera jamais pleine
        return false;
    }

    @Override
    public boolean equals(Object o) {
    
        Pile2 pile2 = (Pile2) o;

        return stk.equals(pile2.stk);
    }

    @Override
    public int hashCode() {
        return stk.hashCode();
    }

    @Override
    public String toString() {
        return stk.toString();
    }
}