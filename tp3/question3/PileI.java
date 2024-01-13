package question3;

import question1.PilePleineException;
import question1.PileVideException;

public interface PileI<T> {

    int CAPACITE_PAR_DEFAUT = 6;

    void empiler(T o) throws PilePleineException;

    T depiler() throws PileVideException;

    T sommet() throws PileVideException;

    int capacite();

    int taille();

    boolean estVide();

    boolean estPleine();

    boolean equals(Object o);

    int hashCode();

    String toString();
}
