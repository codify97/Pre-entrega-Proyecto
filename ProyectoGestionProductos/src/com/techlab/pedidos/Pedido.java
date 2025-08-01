package com.techlab.pedidos;

import java.util.List;

public class Pedido {
    private int id;
    private List<LineaPedido> lineas;

    public Pedido(int id, List<LineaPedido> lineas) {
        this.id = id;
        this.lineas = lineas;
    }

    public double calcularTotal() {
        return lineas.stream().mapToDouble(LineaPedido::calcularSubtotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        for (LineaPedido lp : lineas) {
            sb.append(lp).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}