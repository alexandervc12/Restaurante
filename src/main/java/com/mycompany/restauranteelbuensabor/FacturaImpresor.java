package com.mycompany.restauranteelbuensabor;

public class FacturaImpresor {

    public void imprimirFacturaCompleta(Factura factura) {
        System.out.println(Constantes.SEPARADOR);
        System.out.println("    " + Constantes.NOMBRE_RESTAURANTE);
        System.out.println("    " + Constantes.DIRECCION);
        System.out.println("    NIT: " + Constantes.NIT);
        System.out.println(Constantes.SEPARADOR);
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println(Constantes.LINEA);

        for (ItemPedido item : factura.getPedido().getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal());
        }

        System.out.println(Constantes.LINEA);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotal());

        if (factura.calcularDescuento() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Descuento (5%):", factura.calcularDescuento());
        }

        System.out.printf("%-27s $%,.0f%n", "Subtotal con descuento:", factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());

        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }

        System.out.println(Constantes.LINEA);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(Constantes.SEPARADOR);
        System.out.println("Gracias por su visita!");
        System.out.println(Constantes.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println(Constantes.SEPARADOR);
    }

    public void imprimirFacturaResumen(Factura factura) {
        System.out.println(Constantes.SEPARADOR);
        System.out.println("    " + Constantes.NOMBRE_RESTAURANTE);
        System.out.println("    " + Constantes.DIRECCION);
        System.out.println("    NIT: " + Constantes.NIT);
        System.out.println(Constantes.SEPARADOR);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println(Constantes.LINEA);
        System.out.printf("%-27s $%,.0f%n", "Subtotal con descuento:", factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }
        System.out.println(Constantes.LINEA);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(Constantes.SEPARADOR);
    }
}