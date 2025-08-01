package com.techlab.services;

import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();
    private static int contadorId = 1;

    public void agregarProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // consumir salto

        Producto producto = new Producto(contadorId++, nombre, precio, stock);
        productos.add(producto);
        System.out.println("Producto agregado.");
    }

    public void listarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void buscarYActualizarProducto(Scanner scanner) {
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto producto = buscarPorId(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto encontrado: " + producto);
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("Nuevo stock: ");
        int nuevoStock = scanner.nextInt();
        scanner.nextLine();

        if (nuevoStock >= 0) {
            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);
            System.out.println("Producto actualizado.");
        } else {
            System.out.println("Stock no puede ser negativo.");
        }
    }

    public void eliminarProducto(Scanner scanner) {
        System.out.print("ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto producto = buscarPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public Producto buscarPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}