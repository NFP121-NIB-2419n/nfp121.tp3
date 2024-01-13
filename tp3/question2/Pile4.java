package question2;

import question1.PilePleineException;
import question1.PileVideException;

public class Pile4 implements PileI, Cloneable {
    private Maillon stk;
    private int capacite;
    private int nombre;

    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = this.element;
            return m;
        }
    }

    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    @Override
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();

        Maillon nouveauMaillon = new Maillon(o, stk);
        stk = nouveauMaillon;
        nombre++;
    }

    @Override
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();

        Object elementDepile = stk.element();
        stk = stk.suivant();
        nombre--;

        return elementDepile;
    }

    @Override
    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();

        return stk.element();
    }

    @Override
    public boolean estVide() {
        return nombre == 0;
    }

    @Override
    public boolean estPleine() {
        return nombre == capacite;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        Maillon maillonActuel = stk;

        while (maillonActuel != null) {
            s.append(maillonActuel.element());
            if (maillonActuel.suivant() != null) {
                s.append(", ");
            }
            maillonActuel = maillonActuel.suivant();
        }

        s.append("]");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pile4)) return false;

        Pile4 autrePile = (Pile4) o;

        if (nombre != autrePile.nombre || capacite != autrePile.capacite) return false;

        Maillon maillonActuel = stk;
        Maillon autreMaillonActuel = autrePile.stk;

        while (maillonActuel != null && autreMaillonActuel != null) {
            if (!maillonActuel.element().equals(autreMaillonActuel.element())) {
                return false;
            }
            maillonActuel = maillonActuel.suivant();
            autreMaillonActuel = autreMaillonActuel.suivant();
        }

        return maillonActuel == null && autreMaillonActuel == null;
    }

    @Override
    public int capacite() {
        return capacite;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int taille() {
        return nombre;
    }
}
