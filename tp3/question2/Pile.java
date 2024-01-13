package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    public final static int TAILLE_PAR_DEFAUT = 5;
    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object obj) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = obj;
        this.ptr++;
    }

     public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
      if (estVide())
            throw new PileVideException();
       return zone[ptr];     
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        return ptr + TAILLE_PAR_DEFAUT;
    }

     public boolean estVide() {
        return ptr == 0;
    }


   public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object [] o1) {
   
   if (o1 == null || zone == null || o1.length != zone.length) {
        return false;
    }
    for (int i = 0; i < o1.length; i++) {
        if (o1[i] != zone[i]) {
            return false;
        }
    }

    return true;
    
    
    }

    // fonction fournie
    public int hashCode() {
        // le lien https://www.javaworld.com/javaworld/jw-01-1999/jw-01-object-p2.html
        // dans la classroom est invalide
        
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}