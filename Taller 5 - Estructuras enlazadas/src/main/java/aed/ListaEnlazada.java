package aed;

import aed.ABB.HandleABB;

public class ListaEnlazada<T>  {
    private Nodo primero;
    private Nodo ultimo;

    private int longitudLista;

    private class Nodo {
        public HandleABB valor;
        public Nodo siguiente;
        public Nodo anterior;
        public Nodo(HandleABB v) { 
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


    public void agregarAdelante(HandleABB elem) {
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

    public void agregarAtras(HandleABB elem) {
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

    public HandleABB obtener(int i) {
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

    public HandleABB eliminar(int i) {
        Nodo nodoAEliminar = obtenerNodo(i);
        Nodo anteriorAEliminar = nodoAEliminar.anterior;
        Nodo siguienteAEliminar = nodoAEliminar.siguiente;
        desconectarNodo(anteriorAEliminar, siguienteAEliminar);
        //Eliminar handle del arbol!! 
        nodoAEliminar.valor.eliminar();
        longitudLista--;
        return nodoAEliminar.valor;
    }

    public void modificarPosicion(int indice, HandleABB elem) {
        Nodo nodoAModificar = obtenerNodo(indice);
        nodoAModificar.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        int i = 0;
        while (i < lista.longitud()) {
            agregarAtras(lista.obtener(i));
            i++;
        }
    }
    
    @Override
    public String toString() {
        if (primero == null && ultimo == null) return "[]";
        String listaAImprimir = new String("[");
        int i = 0;
        while(i < longitudLista - 1){
            listaAImprimir += obtener(i).valor() + ", ";
            i++;
        }

        listaAImprimir += ultimo.valor.valor() + "]";
        return listaAImprimir;
    }

    public class ListaIterador{
    	// Completar atributos privados
        int posc = 0;
        public boolean haySiguiente() {
            return posc >=0 && posc < longitudLista;
        }
        
        public boolean hayAnterior() {
            return posc > 0 && posc <= longitudLista;
        }

        public HandleABB siguiente() {
            HandleABB valorADevolver = obtener(posc);
            posc++;
            return valorADevolver;
        }
        

        public HandleABB anterior() {
            posc--;
            HandleABB valorADevolver = obtener(posc);
            return valorADevolver;        }
    }
    public ListaIterador iterador() {
        return new ListaIterador();
    
    }
}
