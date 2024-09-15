package ar.edu.unju.escmi.poo.ejercicio4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
    	
        HashMap<String, Cliente> clientesMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n--- Menú ---");
            System.out.println("1 - Alta cliente");
            System.out.println("2 - Mostrar todos los clientes");
            System.out.println("3 - Ingrese clave para eliminar cliente");
            System.out.println("4 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Alta cliente
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la categoría del cliente (letra): ");
                    char categoria = scanner.nextLine().charAt(0);

                    // Crear el objeto Cliente
                    Cliente cliente = new Cliente(dni, nombre, categoria);

                    // Generar la clave
                    String clave = dni + categoria;

                    // Guardar cliente
                    clientesMap.put(clave, cliente);

                    System.out.println("Cliente agregado con éxito.");
                    break;

                case 2:
                    // Mostrar clientes
                    if (clientesMap.isEmpty()) {
                        System.out.println("No hay clientes en el sistema.");
                    } else {
                        Iterator<Map.Entry<String, Cliente>> iterator = clientesMap.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String, Cliente> entry = iterator.next();
                            System.out.println("Clave: " + entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    // Eliminar cliente por clave
                    System.out.print("Ingrese la clave del cliente a eliminar: ");
                    String claveEliminar = scanner.nextLine();

                    if (clientesMap.containsKey(claveEliminar)) {
                        clientesMap.remove(claveEliminar);
                        System.out.println("Cliente eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró un cliente con esa clave.");
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}