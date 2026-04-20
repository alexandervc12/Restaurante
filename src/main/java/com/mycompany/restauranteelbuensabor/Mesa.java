package com.mycompany.restauranteelbuensabor;

public class Mesa {
    private int numero;
    private Pedido pedidoActual;
    private boolean activa;
    private static int contadorFacturas = 1;

    public Mesa() {
        this.pedidoActual = new Pedido();
        this.activa = false;
    }

    public void activar(int numeroMesa) {
        this.numero = numeroMesa;
        this.activa = true;
    }

    public void desactivar() {
        this.activa = false;
    }

    public void reiniciar() {
        pedidoActual.limpiar();
        activa = false;
        numero = 0;
    }

    public Pedido getPedido() {
        return pedidoActual;
    }

    public boolean isActiva() {
        return activa;
    }

    public int getNumero() {
        return numero;
    }

    public static int getNuevoNumeroFactura() {
        return contadorFacturas++;
    }
}