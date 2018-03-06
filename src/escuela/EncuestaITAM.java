/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela;

import conjunto.ConjuntoA;
import conjunto.ConjuntoADT;

/**
 *
 * @author robot
 */
public class EncuestaITAM {
    
    public static String cadInglesFrances(ConjuntoADT<String> eng, ConjuntoADT<String> fra){
        return eng.interseccion(fra).toString();
    }
    public static int numSoloIngles(ConjuntoADT<String> eng, ConjuntoADT<String> fra, ConjuntoADT<String> otro){
        return eng.diferencia(fra.union(otro)).getCardinalidad();
    }
    public static String cadTresIdiomas(ConjuntoADT<String> eng, ConjuntoADT<String> fra, ConjuntoADT<String> otro){
        return eng.interseccion(fra.interseccion(otro)).toString();
    }
    
    public static void main(String[] args) {
        ConjuntoA<String> eng=new ConjuntoA(),fra=new ConjuntoA(),otro=new ConjuntoA();
        String[] nom={"Rusell","Erwino","Alberto","Isaac"};
        
        for(int i=0;i<nom.length;i++)
            eng.agrega(nom[i]);
        fra.agrega("Rusell");
        fra.agrega("Alberto");
        otro.agrega("Alberto");
        System.out.println(cadInglesFrances(eng,fra));
        System.out.println(""+numSoloIngles(eng,fra,otro));
        System.out.println(cadTresIdiomas(eng,fra,otro));
    }
}
