package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mesa mesa = new Mesa();
        FacturaImpresor impresor = new FacturaImpresor();
        boolean ejecutando = true;

        System.out.println(Constantes.SEPARADOR);
        System.out.println("    " + Constantes.NOMBRE_RESTAURANTE);
        System.out.println("    " + Constantes.DIRECCION);
        System.out.println("    NIT: " + Constantes.NIT);
        System.out.println(Constantes.SEPARADOR);

        while (ejecutando) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println(Constantes.SEPARADOR);
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Carta.mostrar();
                    break;

                case 2:
                    System.out.println("--- AGREGAR PRODUCTO ---");
                    System.out.print("Numero de producto (1-" + Carta.getCantidad() + "): ");
                    int numProducto = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();

                    if (numProducto >= 1 && numProducto <= Carta.getCantidad() && cantidad > 0) {
                        if (!mesa.isActiva()) {
                            System.out.print("Ingrese numero de mesa: ");
                            mesa.activar(scanner.nextInt());
                        }
                        Producto producto = Carta.getProducto(numProducto);
                        mesa.getPedido().agregarItem(producto, cantidad);
                        System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
                    } else {
                        System.out.println("Producto o cantidad invalida");
                    }
                    break;

                case 3:
                    if (mesa.getPedido().tieneProductos()) {
                        System.out.println("--- PEDIDO ACTUAL ---");
                        for (ItemPedido item : mesa.getPedido().getItems()) {
                            System.out.printf("%-20s x%-6d $%,.0f%n",
                                item.getProducto().getNombre(),
                                item.getCantidad(),
                                item.calcularSubtotal());
                        }
                        System.out.println(Constantes.LINEA);
                        System.out.printf("%-27s $%,.0f%n", "Subtotal:", mesa.getPedido().calcularSubtotal());
                    } else {
                        System.out.println("No hay productos en el pedido actual.");
                    }
                    break;

                case 4:
                    if (mesa.getPedido().tieneProductos()) {
                        int numFactura = Mesa.getNuevoNumeroFactura();
                        Factura factura = new Factura(mesa.getPedido(), numFactura);
                        impresor.imprimirFacturaCompleta(factura);
                        mesa.desactivar();
                    } else {
                        System.out.println("No se puede generar factura. Pedido vacio.");
                    }
                    break;

                case 5:
                    mesa.reiniciar();
                    System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                    break;

                case 0:
                    ejecutando = false;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println();
        }
        scanner.close();
    }
}