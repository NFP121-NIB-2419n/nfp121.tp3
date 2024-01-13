package question2;


import java.util.Vector;
import question1.PilePleineException;
import question1.PileVideException;

public class Pile3 implements PileI {

    private Vector<Object> elements;

    public Pile3() {
        this.elements = new Vector<>();
    }

    @Override
    public void empiler(Object o) throws PilePleineException {
        elements.add(o);
    }

    @Override
    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        Object elementDepile = elements.lastElement();
        elements.removeElementAt(elements.size() - 1);
        return elementDepile;
    }

    @Override
    public Object sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return elements.lastElement();
    }

    @Override
    public int capacite() {
// La capacité n'est pas directement applicable à Vector, vous pouvez retourner Integer.MAX_VALUE ou une autre constante
        return Integer.MAX_VALUE;
    }

    @Override
    public int taille() {
        return elements.size();
    }

    @Override
    public boolean estVide() {
        return elements.isEmpty();
    }

    @Override
    public boolean estPleine() {
        // Vector ne sera jamais pleine alors la fonction retourne toujours false
        return false;
    }

    @Override
    public boolean equals(Object o) {
      
        Pile3 pile3 = (Pile3) o;

        return elements.equals(pile3.elements);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}