package aed;

public class ABB<T extends Comparable<T>> {
    /* ¡COMPLETAR! */

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

    public class HandleABB {
        /* ¡COMPLETAR! */
    }


    private Nodo minimoAPartirDe(Nodo nuevoNodo){
        Nodo sucesor = nuevoNodo;

        while(sucesor.hijoMenor != null) {
            sucesor = sucesor.hijoMenor;
        }

        return sucesor;
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

    public HandleABB insertar(T elem){
        if (root != null){
            insertarConWhile(elem);
            // return;
        };
        root = new Nodo(elem); 
        length++;
        throw new UnsupportedOperationException("No implementado aún");
    }

     private void insertarConWhile(T elem){
        Nodo nodo = root;
        Boolean buscando = true;
        while (buscando){
            if (elem.compareTo(nodo.val) == 0) {buscando = false;}
            if (elem.compareTo(nodo.val) > 0){
                if (nodo.hijoMayor == null){
                    Nodo nuevoNodo = new Nodo(elem);
                    nodo.hijoMayor = nuevoNodo;
                    nuevoNodo.padre = nodo;
                    buscando = false;
                    length++;
            } else{
                nodo = nodo.hijoMayor;
            }
            } if (elem.compareTo(nodo.val) < 0){
            if (nodo.hijoMenor == null){
                Nodo nuevoNodo = new Nodo(elem);
                nodo.hijoMenor = nuevoNodo;
                nuevoNodo.padre = nodo;
                buscando = false;
                length++;
            } else{
                nodo = nodo.hijoMenor;
            }
    }}}

    public boolean pertenece(T elem){
        Nodo nodoABuscar = buscarNodoDeValor(root, elem);
        return nodoABuscar != null && elem.compareTo(nodoABuscar.val) == 0;
    }
    private Nodo buscarNodoDeValor(Nodo raizRelativa, T elem){
        Nodo actual = raizRelativa;
        Boolean buscado = true;
        while (buscado){
            if (actual == null || elem.compareTo(actual.val) == 0) buscado = false;
            else if (elem.compareTo(actual.val) > 0) {
                actual = actual.hijoMayor;
            }
            else if (elem.compareTo(actual.val) < 0) {
                actual = actual.hijoMenor; 

                }
        }
        return actual;
    }

    public void eliminar(T elem){
        Nodo nodoAEliminar = buscarNodoDeValor(root, elem); 
        
        if (noTieneDescendencia(nodoAEliminar)){
            Nodo padreDelNodoAEliminar =  nodoAEliminar.padre;
            if (padreDelNodoAEliminar == null) root = null;
            else if ( padreDelNodoAEliminar.hijoMenor == nodoAEliminar){
                padreDelNodoAEliminar.hijoMenor = null;
            }
            else if (padreDelNodoAEliminar.hijoMayor == nodoAEliminar) {
                padreDelNodoAEliminar.hijoMayor = null;
            }
        }
        else if (tieneSoloUnaDescendencia(nodoAEliminar)){

            Nodo sucesor = hijoMenorOMayor(nodoAEliminar);
            asignarPadreCorrectamente(nodoAEliminar, sucesor);
        }
       else if (tieneDosDescendencias(nodoAEliminar)){

            Nodo sucesor = minimoAPartirDe(nodoAEliminar.hijoMayor);
            asiganrHijosDeSucesor(sucesor);
            asignarPadreCorrectamente(nodoAEliminar, sucesor);
            sucesor.hijoMenor = nodoAEliminar.hijoMenor;
            if (nodoAEliminar.hijoMenor != null) nodoAEliminar.hijoMenor.padre = sucesor;

            sucesor.hijoMayor = nodoAEliminar.hijoMayor;
            if (nodoAEliminar.hijoMayor != null) nodoAEliminar.hijoMayor.padre = sucesor;


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
    
    private Boolean tieneDosDescendencias(Nodo nodoAEliminar){
        return nodoAEliminar.hijoMayor != null && nodoAEliminar.hijoMenor != null;
    };

    private void asiganrHijosDeSucesor(Nodo sucesor){
        if (sucesor.padre.hijoMenor == sucesor){
            sucesor.padre.hijoMenor = sucesor.hijoMayor;
        } else{
            sucesor.padre.hijoMayor = sucesor.hijoMayor;
        }
        if (sucesor.hijoMayor != null){
            sucesor.hijoMayor.padre = sucesor.padre;
        }
        sucesor.hijoMayor = null;

    }

    private Nodo hijoMenorOMayor(Nodo actual){
        if (actual.hijoMayor != null) return actual.hijoMayor;
        return actual.hijoMenor;
    };

    private void asignarPadreCorrectamente(Nodo nodoAEliminar, Nodo sucesor){
        Nodo padreDelNodoAEliminar = nodoAEliminar.padre;
        // Nodo sucesor = inmediatoSucesor(nodoAEliminar);
        if (padreDelNodoAEliminar == null ) {
            root = sucesor;
        }
        else if ( padreDelNodoAEliminar.hijoMenor == nodoAEliminar){
            padreDelNodoAEliminar.hijoMenor = sucesor;
        }
         else if (padreDelNodoAEliminar.hijoMayor == nodoAEliminar) {
            padreDelNodoAEliminar.hijoMayor = sucesor;
        }
        
        sucesor.padre = padreDelNodoAEliminar;
    };

    
    private Nodo inmediatoSucesor(Nodo actual){

        if (actual.hijoMayor != null){
            Nodo hijoMayor = actual.hijoMayor;

            return minimoAPartirDe(hijoMayor);
        };
        Nodo sucesor = buscandoSucesorEnPadres(actual);
        return sucesor;
    }


    private Nodo buscandoSucesorEnPadres(Nodo nuevoNodo){
        Boolean buscando = true;
        Nodo sucesor = nuevoNodo;
        if (sucesor.padre == null);
        while (buscando){
            if (sucesor.padre == null || sucesor.padre.hijoMenor == sucesor ){
                buscando = false;
            } 
            sucesor = sucesor.padre;
        }
        return sucesor;
    }
    @Override
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