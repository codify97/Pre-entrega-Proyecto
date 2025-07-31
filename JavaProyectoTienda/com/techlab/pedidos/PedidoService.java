package com.techlab.pedidos;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido crearPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;
    }

    public void agregarProductoAPedido(Pedido pedido, Producto producto, int cantidad) throws StockInsuficienteException {
        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
        }
        producto.setStock(producto.getStock() - cantidad);
        pedido.agregarLinea(new LineaPedido(producto, cantidad));
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}
