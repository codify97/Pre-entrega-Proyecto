package com.techlab.pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private static int contador = 1;
    private List<LineaPedido> lineas;

    public Pedido() {
        this.id = contador++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    public double calcularTotal() {
        return lineas.stream().mapToDouble(LineaPedido::calcularSubtotal).sum();
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido #" + id + ": ");
        for (LineaPedido lp : lineas) {
            sb.append("  ").append(lp.toString()).append("\n");
        }
        sb.append("Total: $").append(calcularTotal());
        return sb.toString();
    }
}
