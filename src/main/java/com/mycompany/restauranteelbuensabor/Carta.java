package com.mycompany.restauranteelbuensabor;

public class Carta {
    private static final Producto[] productos = {
        new Producto("Bandeja Paisa", 32000),
        new Producto("Sancocho de Gallina", 28000),
        new Producto("Arepa con Huevo", 8000),
        new Producto("Jugo Natural", 7000),
        new Producto("Gaseosa", 4500),
        new Producto("Cerveza Poker", 6000),
        new Producto("Agua Panela", 3500),
        new Producto("Arroz con Pollo", 25000)
    };

    public static Producto getProducto(int indice) {
        if (indice >= 1 && indice <= productos.length) {
            return productos[indice - 1];
        }
        return null;
    }

    public static int getCantidad() {
        return productos.length;
    }

    public static void mostrar() {
        System.out.println(Constantes.SEPARADOR);
        System.out.println("    " + Constantes.NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(Constantes.SEPARADOR);
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%d. %-22s $%,.0f%n", i + 1, productos[i].getNombre(), productos[i].getPrecio());
        }
        System.out.println(Constantes.SEPARADOR);
    }
}