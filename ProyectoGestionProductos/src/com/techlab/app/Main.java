package com.techlab.app;

import com.techlab.menu.MenuPrincipal;
import com.techlab.services.ProductoService;
import com.techlab.services.PedidoService;

public class Main {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService(productoService);
        MenuPrincipal menu = new MenuPrincipal(productoService, pedidoService);
        menu.iniciar();
    }
}