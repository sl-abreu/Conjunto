/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

import java.util.Iterator;

/**
 *
 * @author robot
 */
public class Conjunto {

    
    
    public static <T> String imprimeConj(ConjuntoADT<T> c){
        StringBuilder cad=new StringBuilder();
        Iterator<T> it=c.iterator();
        
        while(it.hasNext())
            cad.append(it.next().toString()).append("\n");
        return cad.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConjuntoA<Integer> c1=new ConjuntoA();
        ConjuntoA<Integer> c2=new ConjuntoA();
        ConjuntoA<String> c3=new ConjuntoA();
        ConjuntoA<String> c4=new ConjuntoA();
        
        int i;
        for(i=1;i<=10;i++)
            c1.agrega(i);
        for(i=5;i<=15;i++)
            c2.agrega(i);
        c3.agrega("rojo");
        c3.agrega("verde");
        c3.agrega("azul");
        c4.agrega("blanco");
        c4.agrega("azul");
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        
        //System.out.println(c2.interseccion(c1));
        System.out.println(c2.unionR(c1));
        
        //System.out.println(c3.interseccion(c4));
        System.out.println(c4.unionR(c3));
        
//        System.out.println(c2.diferencia(c1).toString());
//        System.out.println(c3.diferencia(c4).toString());
    }
    
}
