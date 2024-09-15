package ar.edu.unju.escmi.poo.ejercicio5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
           
            System.out.println("\n--- Menú ---");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Incrementar precio de productos");
            System.out.println("4 - Ordenar productos por código");
            System.out.println("5 - Filtrar productos por código superior");
            System.out.println("6 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Alta de producto
                    System.out.print("Ingrese el código del producto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();

                    // Crear producto
                    Producto producto = new Producto(codigo, descripcion, precio);
                    productos.add(producto);

                    System.out.println("Producto agregado con éxito.");
                    break;

                case 2:
                    // Mostrar productps
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos en el sistema.");
                    } else {
                        productos.stream().forEach(System.out::println);
                    }
                    break;

                case 3:
                    // Incrementar precio
                    productos = (ArrayList<Producto>) productos.stream()
                            .map(p -> {
                                p.setPrecio(p.getPrecio() + 300.00);
                                return p;
                            })
                            .collect(Collectors.toList());
                    System.out.println("El precio de todos los productos ha sido incrementado en $300.");
                    break;

                case 4:
                    // Ordenar productos
                    productos.sort(Comparator.comparingInt(Producto::getCodigo));
                    System.out.println("Productos ordenados por código:");
                    productos.stream().forEach(System.out::println);
                    break;

                case 5:
                    // Filtrar productos
                    System.out.print("Ingrese un código para filtrar productos con código superior: ");
                    int codigoFiltro = scanner.nextInt();
                    System.out.println("Productos con código superior a " + codigoFiltro + ":");
                    productos.stream()
                            .filter(p -> p.getCodigo() > codigoFiltro)
                            .forEach(System.out::println);
                    break;

                case 6:
                    // Salir del programa
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }
}