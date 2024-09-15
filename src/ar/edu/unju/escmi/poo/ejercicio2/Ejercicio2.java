package ar.edu.unju.escmi.poo.ejercicio2;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio2 {
    private static TreeSet<GatoSimple> gatos = new TreeSet<>((g1, g2) -> g1.getNombre().compareTo(g2.getNombre()));
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear gato simple");
            System.out.println("2 – Dar de comer a un gato simple");
            System.out.println("3 – Eliminar un gato simple");
            System.out.println("4 – Mostrar todos los gatos");
            System.out.println("5 – Crear gato contrincante para pelear con un gato simple");
            System.out.println("6 – Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    crearGatoSimple(scanner);
                    break;
                case 2:
                    darDeComer(scanner);
                    break;
                case 3:
                    eliminarGato(scanner);
                    break;
                case 4:
                    mostrarGatos();
                    break;
                case 5:
                    crearGatoContrincante(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        
        scanner.close();
    }

    private static void crearGatoSimple(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el color del gato: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese la raza del gato: ");
        String raza = scanner.nextLine();
        System.out.print("Ingrese el sexo del gato (macho/hembra): ");
        String sexo = scanner.nextLine();
        System.out.print("Ingrese el peso del gato: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese la edad del gto: ");
        int edad = scanner.nextInt();
        
        GatoSimple gato = new GatoSimple(color, peso, raza, edad, nombre, sexo);
        gatos.add(gato);
        System.out.println("Gato creado exitosamente.");
    }

    private static void darDeComer(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.nextLine();
        GatoSimple gato = buscarGato(nombre);
        if (gato != null) {
            System.out.print("Ingrese la comida: ");
            String comida = scanner.nextLine();
            gato.comer(comida);
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    private static void eliminarGato(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato a eliminar: ");
        String nombre = scanner.nextLine();
        GatoSimple gato = buscarGato(nombre);
        if (gato != null) {
            gatos.remove(gato);
            System.out.println("Gato eliminado.");
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    private static void mostrarGatos() {
        if (gatos.isEmpty()) {
            System.out.println("No hay gatos registrados.");
        } else {
            for (GatoSimple gato : gatos) {
                System.out.println("Nombre: " + gato.getNombre());
                gato.maullar();
                gato.ronronear();
            }
        }
    }

    private static void crearGatoContrincante(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato contrincante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el color del gato: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese la raza del gato: ");
        String raza = scanner.nextLine();
        System.out.print("Ingrese el sexo del gato (macho/hembra): ");
        String sexo = scanner.nextLine();
        System.out.print("Ingrese el peso del gato: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese la edad del gato: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        GatoSimple gatoContrincante = new GatoSimple(color, peso, raza, edad, nombre, sexo);
        gatos.add(gatoContrincante);
        
        System.out.print("Ingrese el nombre del gato con el que peleará: ");
        String nombreGato = scanner.nextLine();
        GatoSimple gatoSimple = buscarGato(nombreGato);
        if (gatoSimple != null) {
            gatoSimple.pelear(gatoContrincante);
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    private static GatoSimple buscarGato(String nombre) {
        for (GatoSimple gato : gatos) {
            if (gato.getNombre().equalsIgnoreCase(nombre)) {
                return gato;
            }
        }
        return null;
    }
}