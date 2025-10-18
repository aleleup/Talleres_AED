package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    private Nodo root;
    private int length;

    private class Nodo {
        public Nodo padre;
        public Nodo hijoMayor;
        public Nodo hijoMenor;
        public T val;

        public Nodo(T val){
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
            actual = actual.hijoMenor;
        };
        return actual.val;
    }

    public T maximo(){
        Nodo actual =  root;
        while (actual.hijoMayor != null){
            actual = actual.hijoMayor;
        };
        return actual.val;   
    
    }


    private Nodo buscarNodoDeValor(Nodo actual, T elem){
        //Arrancando en root te encuentro el valor de valor elem. De no existir retorno null;
        if (actual == null) return null;
        if (elem.compareTo(actual.val) == 0) return actual;
        if (elem.compareTo(actual.val) > 0) {
            return buscarNodoDeValor(actual.hijoMayor,elem);
        }
        if (elem.compareTo(actual.val) < 0) {
            return buscarNodoDeValor(actual.hijoMenor,elem);
        }
        return null;

    }

    public void insertar(T elem){
        if (root != null){
         insertarRecursivo(root, elem);
         return;
        };
        root = new Nodo(elem); 
        length++;
    };

    private void insertarRecursivo(Nodo nodo, T elem ){

        if (elem.compareTo(nodo.val) == 0) return;

        if (elem.compareTo(nodo.val) > 0){
            if (nodo.hijoMayor == null){
                Nodo nuevoNodo = new Nodo(elem);
                nodo.hijoMayor = nuevoNodo;
                nuevoNodo.padre = nodo;
                length++;

            } else{
                insertarRecursivo(nodo.hijoMayor, elem);
            }

        };


        if (elem.compareTo(nodo.val) < 0){
            if (nodo.hijoMenor == null){
                Nodo nuevoNodo = new Nodo(elem);
                nodo.hijoMenor = nuevoNodo;
                nuevoNodo.padre = nodo;
                length++;

            } else{
                insertarRecursivo(nodo.hijoMenor, elem);
            }
        }
    };

    public boolean pertenece(T elem){
        Nodo nodoABuscar = buscarNodoDeValor(root, elem);
        return nodoABuscar!= null && nodoABuscar.val == elem;
    }

    // private Boolean pertenceRecursivo(Nodo nodo, T elem){
    //     if (nodo == null) return false;

    //     if (elem.compareTo(nodo.val) == 0) return true;

    //     if (elem.compareTo(nodo.val) > 0){
    //         return pertenceRecursivo(nodo.hijoMayor, elem);
    //     }

    //     if (elem.compareTo(nodo.val) < 0){
    //         return pertenceRecursivo(nodo.hijoMenor, elem);
    //     }

    //     return false;
    // };


    public void eliminar(T elem){
        Nodo nodoAEliminar = buscarNodoDeValor(root, elem); 
        
        if (!tieneUnaDescendencia(nodoAEliminar)){
            nodoAEliminar = null;
        }; 
        if (tieneUnaDescendencia(nodoAEliminar)){
            sucesorDadoTomaLugar(nodoAEliminar, hijoMenorOMayor(nodoAEliminar));
        }
        if (tieneDosDescendencia(nodoAEliminar)){
            sucesorDadoTomaLugar(nodoAEliminar, inmediateSucesor(nodoAEliminar));
        }
        length--;
    };
    private Boolean tieneUnaDescendencia(Nodo nodoAEliminar){

        return ((nodoAEliminar.hijoMayor != null && nodoAEliminar.hijoMenor == null) 
            ||  (nodoAEliminar.hijoMenor != null && nodoAEliminar.hijoMayor == null));
    };
    
    private Boolean tieneDosDescendencia(Nodo nodoAEliminar){
        return nodoAEliminar.hijoMayor != null && nodoAEliminar.hijoMenor != null;
    };


    private Nodo hijoMenorOMayor(Nodo actual){
        if (actual.hijoMayor != null) return actual.hijoMayor;
        return actual.hijoMenor;
    };

    private void sucesorDadoTomaLugar(Nodo nodoAEliminar, Nodo sucesor){
        Nodo padreDelNodoAEliminar = nodoAEliminar.padre;
        // Nodo sucesor = inmediateSucesor(nodoAEliminar);
        if (padreDelNodoAEliminar == null ) root = sucesor;
        if ( padreDelNodoAEliminar.hijoMenor != null && padreDelNodoAEliminar.hijoMenor.val.compareTo(nodoAEliminar.val) == 0){
            padreDelNodoAEliminar.hijoMenor = sucesor;
            
        } else {
            padreDelNodoAEliminar.hijoMayor = sucesor;
        };
        
        sucesor.padre = padreDelNodoAEliminar;
    };

    
    private Nodo inmediateSucesor(Nodo actual){

        return actual;
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
