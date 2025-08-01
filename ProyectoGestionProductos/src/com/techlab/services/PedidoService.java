package com.techlab.services;

import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private ProductoService productoService;
    private static int contadorPedidos = 1;

    public PedidoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void crearPedido(Scanner scanner) {
        List<LineaPedido> lineas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            productoService.listarProductos();
            System.out.print("ID del producto: ");
            int id = scanner.nextInt();
            Producto producto = productoService.buscarPorId(id);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (cantidad > producto.getStock()) {
                System.out.println("Stock insuficiente.");
                continue;
            }

            lineas.add(new LineaPedido(producto, cantidad));
            producto.setStock(producto.getStock() - cantidad);

            System.out.print("¿Agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        Pedido pedido = new Pedido(contadorPedidos++, lineas);
        pedidos.add(pedido);
        System.out.println("Pedido creado con total: $" + pedido.calcularTotal());
    }

    public void listarPedidos() {
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}