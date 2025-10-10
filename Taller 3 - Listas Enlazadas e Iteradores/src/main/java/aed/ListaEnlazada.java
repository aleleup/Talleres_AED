package aed;

public class ListaEnlazada<T>  {
    private Nodo primero;
    private Nodo ultimo;

    private int longitudLista;

    private class Nodo {
        public T valor;
        public Nodo siguiente;
        public Nodo anterior;
        public Nodo(T v) { 
            valor = v; 
        }

        public void asignarPunteros(Nodo an, Nodo sig){ anterior = an;  siguiente = sig;}

    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitudLista = 0;
    }

    public int longitud() {
        return longitudLista;
    }


    public void agregarAdelante(T elem) {
        Nodo nodoNuevo = new Nodo(elem); 
        if (primero == null && ultimo == null){
            nodoNuevo.asignarPunteros(null, null);
            primero = nodoNuevo;
            ultimo = nodoNuevo;
        }
        else{
            Nodo versionAnteriorAPrimero = primero;
            primero = nodoNuevo;
            primero.asignarPunteros(null, versionAnteriorAPrimero);
            versionAnteriorAPrimero.anterior = primero;
        };
        longitudLista++;
    }

    public void agregarAtras(T elem) {
        Nodo nodoNuevo = new Nodo(elem); 
        if (primero == null && ultimo == null){
            nodoNuevo.asignarPunteros(null, null);
            primero = nodoNuevo;
            ultimo = nodoNuevo;
        }
        else{
            // Nodo antePenultimoNodo = ultimo.anterior;
            Nodo versionAnteriorUltimo = ultimo;
            ultimo = nodoNuevo;
            ultimo.asignarPunteros(versionAnteriorUltimo, null);
            versionAnteriorUltimo.siguiente = ultimo;
        };
        longitudLista++;
    }

    private Nodo obtenerNodo(int i){
         Nodo nodoAObtener = primero;
        int j = 0;
        while (j < i){
            nodoAObtener = nodoAObtener.siguiente;
            j++;
        };
        return nodoAObtener;
    }

    public T obtener(int i) {
        return obtenerNodo(i).valor;
    }

    private void desconectarNodo (Nodo anteriorAEliminar, Nodo siguienteAEliminar){
         if (anteriorAEliminar != null){
            anteriorAEliminar.siguiente = siguienteAEliminar;
        }else{
            primero = siguienteAEliminar;
        }

        if (siguienteAEliminar != null){
            siguienteAEliminar.anterior = anteriorAEliminar;
        }else{
            ultimo = anteriorAEliminar;
        }
    }

    public void eliminar(int i) {
        Nodo nodoAEliminar = obtenerNodo(i);
        System.out.println(nodoAEliminar.valor);

        Nodo anteriorAEliminar = nodoAEliminar.anterior;
        Nodo siguienteAEliminar = nodoAEliminar.siguiente;
        desconectarNodo(anteriorAEliminar, siguienteAEliminar);
        longitudLista--;
        
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nodoAModificar = obtenerNodo(indice);
        nodoAModificar.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        int i = 0;
        while (i < lista.longitud()){
            agregarAtras(lista.obtener(i));
            i++;
        }
    }
    
    @Override
    public String toString() {
        String listaAImprimir = new String("[");
        int i = 0;
        while(i < longitudLista - 1){
            listaAImprimir += obtener(i) + ", ";
            i++;
        }

        listaAImprimir += ultimo.valor + "]";
        return listaAImprimir;
    }

    public class ListaIterador implements Iterador<T>{
    	// Completar atributos privados
        int posc = 0;
        public boolean haySiguiente() {
            return posc >=0 && posc < longitudLista;
        }
        
        public boolean hayAnterior() {
            return posc > 0 && posc <= longitudLista;
        }

        public T siguiente() {
            T valorADevolver = obtener(posc);
            posc++;
            return valorADevolver;
        }
        

        public T anterior() {
            posc--;
            T valorADevolver = obtener(posc);
            return valorADevolver;        }
    }
    public ListaIterador iterador() {
        return new ListaIterador();
    
    }
}
