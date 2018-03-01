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
        boolean res=contiene(dato);
        
        if(!res){
            if(cardinalidad==conjunto.length)
                expandCapacity();
            conjunto[cardinalidad]=dato;
            cardinalidad++;
        }
        return res;
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
    private void expandCapacity() {
        T[] nuevo=(T[]) new Object[conjunto.length*2];
        
        for(int i=0;i<cardinalidad;i++)
            nuevo[i]=conjunto[i];
        conjunto=nuevo;
    }

    @Override
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        if(otro!=null){
            ConjuntoADT<T> res=new ConjuntoA();
        
            if(this.cardinalidad<=otro.getCardinalidad()){
                for(int i=0;i<cardinalidad;i++)
                    if(otro.contiene(conjunto[i]))
                        res.agrega(conjunto[i]);
            }
            else{
                Iterator<T> it=otro.iterator();
                T aux;
            
                while(it.hasNext()){
                    aux=it.next();
                    if(this.contiene(aux))
                        res.agrega(aux);
                }
            }
            return res;
        }
        throw new NullPointerException();
    }
    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        if(otro!=null){
            ConjuntoADT<T> res=new ConjuntoA();
            Iterator<T> it=otro.iterator();
        
            for(int i=0;i<cardinalidad;i++)
                res.agrega(conjunto[i]);
            while(it.hasNext())
                res.agrega(it.next());
            return res;
        }
        throw new NullPointerException();
    }
    @Override
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        if(otro!=null){
            ConjuntoADT<T> res=new ConjuntoA();
            Iterator<T> it=otro.iterator();
        
            for(int i=0;i<cardinalidad;i++)
                res.agrega(conjunto[i]);
            while(it.hasNext())
                res.quita(it.next());
            return res;
        }
        throw new NullPointerException();
    }
    
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        for(int i=0;i<cardinalidad;i++)
            cad.append(conjunto[i].toString()).append("\n");
        return cad.toString();
    }
}
