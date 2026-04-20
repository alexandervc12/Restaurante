package com.mycompany.restauranteelbuensabor;

public class Factura {
    private final Pedido pedido;
    private final int numero;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() >= Constantes.MIN_ITEMS_PARA_DESCUENTO) {
            return calcularSubtotal() * Constantes.TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        return calcularSubtotal() - calcularDescuento();
    }

    public double calcularIVA() {
        return calcularSubtotalConDescuento() * Constantes.TASA_IVA;
    }

    public double calcularPropina() {
        double base = calcularSubtotalConDescuento();
        if (base > Constantes.UMBRAL_PROPINA) {
            return base * Constantes.TASA_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotalConDescuento() + calcularIVA() + calcularPropina();
    }

    public int getNumero() { return numero; }
    public Pedido getPedido() { return pedido; }
}