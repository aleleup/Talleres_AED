package aed;

public class ListaEnlazada<T> {
    private Nodo nodoActual;
    private int longitudLista;

    private class Nodo {
       public T anterior;
       public T valor;
       public T siguiente;

       public Nodo(T v) { valor = v; }

       public void asignarPunteros(T an, T sig){ anterior = an;  siguiente = sig;}

    }

    public ListaEnlazada() {
        nodoActual = new Nodo(null);
        nodoActual.asignarPunteros(null, null);
        longitudLista = 0;
    }

    public int longitud() {
        return longitudLista;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.asignarPunteros(null, nodoActual.valor);
        longitudLista++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.asignarPunteros( nodoActual.valor, null );
        longitudLista++;    
    }

    public T obtener(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ListaIterador{
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ListaIterador iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
