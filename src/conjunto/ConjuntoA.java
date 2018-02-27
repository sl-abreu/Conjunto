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
public class ConjuntoA<T> implements ConjuntoADT<T> {
    private T[] conjunto;
    private int cardinalidad;
    private final int MAX=50;    

    public ConjuntoA() {
        conjunto=(T[]) new Object[MAX];
        cardinalidad=0;
    }
    
    @Override
    public int getCardinalidad(){
        return cardinalidad;
    }
    @Override
    public boolean agrega(T dato){
        
    }
    @Override
    public T quita(T dato){
        int i=posDato(dato);
        T res=null;
        
        if(i<cardinalidad){
            res=conjunto[i];
            cardinalidad--;
            conjunto[i]=conjunto[cardinalidad];
            conjunto[cardinalidad]=null;
        }
        return res;
    }
    @Override
    public boolean contiene(T dato){
        Iterator<T> it=iterator();
        boolean res=false;
        
        while(it.hasNext() && !res)
            res=it.next().equals(dato);
        return res;
    }
    @Override
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto,cardinalidad);
    }
    
    private int posDato(T dato){
        int i=0;
        
        while(i<cardinalidad && !conjunto[i].equals(dato))
            i++;
        return i;
    }
}
