package com.techlab.menu;

import com.techlab.services.ProductoService;
import com.techlab.services.PedidoService;

import java.util.Scanner;

public class MenuPrincipal {

    private ProductoService productoService;
    private PedidoService pedidoService;

    public MenuPrincipal(ProductoService productoService, PedidoService pedidoService) {
        this.productoService = productoService;
        this.pedidoService = pedidoService;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar/Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> productoService.agregarProducto(scanner);
                case 2 -> productoService.listarProductos();
                case 3 -> productoService.buscarYActualizarProducto(scanner);
                case 4 -> productoService.eliminarProducto(scanner);
                case 5 -> pedidoService.crearPedido(scanner);
                case 6 -> pedidoService.listarPedidos();
                case 7 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}