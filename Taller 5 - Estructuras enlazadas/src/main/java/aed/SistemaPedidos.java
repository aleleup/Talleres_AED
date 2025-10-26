package aed;

public class SistemaPedidos {
    /* COMPLETAR atributos privados: ¿cómo se representan los pedidos? */
    ABB<Pedido> arbolDePedidos;
    ListaEnlazada<ABB<Pedido>.HandleABB> colaDePedidos;

    public SistemaPedidos() {
        this.arbolDePedidos = new ABB<Pedido>();
        this.colaDePedidos = new ListaEnlazada<ABB<Pedido>.HandleABB>();
    }

    public void agregarPedido(Pedido pedido){
        // ABB<Pedido>.HandleABB handle = arbolDePedidos.insertar(pedido);
        colaDePedidos.agregarAtras(arbolDePedidos.insertar(pedido));
    }

    public Pedido proximoPedido(){
        ABB<Pedido>.HandleABB handlePedido = colaDePedidos.eliminar(0);
        return handlePedido.valor();
    }

    public Pedido pedidoMenorId(){
        return arbolDePedidos.minimo();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        return colaDePedidos.toString();
    }

    public String obtenerPedidosOrdenadosPorId(){
        return arbolDePedidos.toString();
    }
}