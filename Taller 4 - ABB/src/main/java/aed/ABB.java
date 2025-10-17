package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    private Nodo root;
    private Int length;

    private class Nodo {
        public Nodo padre;
        public Nodo hijoMayor;
        public Nodo hijoMenor;
        public T val;

        public void Nodo(T val){
            this.val = val;

        }

    }

    public ABB() {
        root = null;
        length = 0;
    }

    public int cardinal() {
        return length;
    }

    public T minimo(){
        Nodo actual =  root;
        while (actual.hijoMenor != null){
            actual = hijoMenor;
        };
        return actual.val;
    }

    public T maximo(){
        Nodo actual =  root;
        while (actual.hijoMayor != null){
            actual = hijoMayor;
        };
        return actual.val;    }

    public void insertar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }


    private pertenceRecursivo(Nodo nodo, T elem){
        if (nodo == )
        if (t > nodo.val){
            return pertenece(nodo.hijoMayor, elem);
        }

        if (t < nodo.val){
            return pertenece(nodo.hijoMayor, elem);
        }
    };


    public boolean pertenece(T elem){
        Nodo actual =  root;
        return pertenceRecursivo(actual, elem);
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
