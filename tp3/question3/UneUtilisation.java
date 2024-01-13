package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        try{
        Pile2<PolygoneRegulier> p1 = new Pile2<>(10); 
        Pile2<Pile2<PolygoneRegulier>> p2 = new Pile2<>(10);
 
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println("La pile p1 = " + p1);

     
        p2.empiler(p1);
        System.out.println("La pile p2 = " + p2);

    }
    catch(Exception e){
        
        System.out.println("L'erreur est:" + e.getMessage());
    }
}
}
