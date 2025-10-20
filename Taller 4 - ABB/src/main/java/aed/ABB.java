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
        Nodo nodoMinimo = minimoAPartirDe(root);
        return nodoMinimo.val;
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
        //elem ya está en ABB
        if (elem.compareTo(nodo.val) == 0) return;
        // elem > nodo.val --> (nodo.hijoMayor == null --> se agrega elem como hijo mayor de nodo) v (nodo.hijoMayor != null --> recursividad con nodo.hijoMayor)
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
        // elem < nodo.val --> (nodo.hijoMenor == null --> se agrega elem como hijo Menor de nodo) v (nodo.hijoMenor != null --> recursividad con nodo.hijoMenor)
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

    public void eliminar(T elem){
        Nodo nodoAEliminar = buscarNodoDeValor(root, elem); 
        if (noTieneDescendencia(nodoAEliminar)){
            nodoAEliminar = null;
        }; 
        if (tieneSoloUnaDescendencia(nodoAEliminar)){
            sucesorDadoTomaLugar(nodoAEliminar, hijoMenorOMayor(nodoAEliminar));
        }
        if (tieneDosDescendencia(nodoAEliminar)){
            Nodo sucesor = inmediatoSucesor(nodoAEliminar);
            sucesorDadoTomaLugar(nodoAEliminar, sucesor);
            sucesor.hijoMenor = nodoAEliminar.hijoMenor;
        }
        length--;
    };
    private Boolean noTieneDescendencia(Nodo nodo){
        return nodo.hijoMayor == null && nodo.hijoMenor == null;
    }
    private Boolean tieneSoloUnaDescendencia(Nodo nodoAEliminar){
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
        // Nodo sucesor = inmediatoSucesor(nodoAEliminar);
        if (padreDelNodoAEliminar == null ) {
            root = sucesor;
        }
        else if ( padreDelNodoAEliminar.hijoMenor != null && padreDelNodoAEliminar.hijoMenor.val.compareTo(nodoAEliminar.val) == 0){
            padreDelNodoAEliminar.hijoMenor = sucesor;
        } else {
            padreDelNodoAEliminar.hijoMayor = sucesor;
        };
        
        sucesor.padre = padreDelNodoAEliminar;
    };

    
    private Nodo inmediatoSucesor(Nodo actual){
        if (actual.hijoMayor != null){
            Nodo hijoMayor = actual.hijoMayor;
            return minimoAPartirDe(hijoMayor);
        };
        return buscandoSucesorEnPadres(actual);
    }

    private Nodo minimoAPartirDe(Nodo nuevoNodo){
        Nodo sucesor = nuevoNodo;
        while(sucesor.hijoMenor != null) {
            sucesor = sucesor.hijoMenor;
        };
        return sucesor;
    }

    private Nodo buscandoSucesorEnPadres(Nodo nuevoNodo){
        Boolean buscando = true;
        Nodo sucesor = nuevoNodo;
        while (buscando){
            if (sucesor.padre == null || sucesor.padre.hijoMenor == sucesor ){
                buscando = false;
            } 
            sucesor = sucesor.padre;
        }
        System.out.println(sucesor.val);
        return sucesor;
    }

    

    public String toString(){
        int cant = 0;
        if (root == null) {return "{}";}

        Nodo actual =  buscarNodoDeValor(root, minimo());
        String res = "{";
        while (cant < length - 1){
            res += actual.val + ",";
            actual = inmediatoSucesor(actual);
            cant++;
        } 
        res+= actual.val + "}";


        return res;

    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            return inmediatoSucesor(_actual) != null;
        }
    
        public T siguiente() {
            if (_actual == null){
                _actual = buscarNodoDeValor(root, minimo());
            }
            else _actual = inmediatoSucesor(_actual);

            return _actual.val;
        }
        public ABB_Iterador(){
            _actual = null;
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
