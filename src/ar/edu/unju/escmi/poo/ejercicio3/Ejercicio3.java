package ar.edu.unju.escmi.poo.ejercicio3;

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        HashSet<Empleado> empleados = new HashSet<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearEmpleado(scanner, empleados);
                    break;
                case 2:
                    aumentarSalarioEmpleado(scanner, empleados);
                    break;
                case 3:
                    mostrarSumaTotalSalarios(empleados);
                    break;
                case 4:
                    mostrarTodosEmpleados(empleados);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n-- MENÚ --");
        System.out.println("1- Crear empleado");
        System.out.println("2- Aumentar Salario");
        System.out.println("3- Mostrar la suma total de todos los salarios");
        System.out.println("4- Mostrar todos los empleados");
        System.out.println("5- Salir");
        System.out.print("Elija una opción: ");
    }

    public static void crearEmpleado(Scanner scanner, HashSet<Empleado> empleados) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el legajo del empleado: ");
        int legajo = scanner.nextInt();

        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();

        Empleado nuevoEmpleado = new Empleado(nombre, legajo, salario);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado creado con éxito.");
    }

    public static void aumentarSalarioEmpleado(Scanner scanner, HashSet<Empleado> empleados) {
        System.out.print("Ingrese el número de legajo del empleado que recibirá el aumento: ");
        int legajo = scanner.nextInt();

        Empleado empleadoEncontrado = null;
        for (Empleado empleado : empleados) {
            if (empleado.getLegajo() == legajo) {
                empleadoEncontrado = empleado;
                break;
            }
        }

        if (empleadoEncontrado != null) {
            empleadoEncontrado.aumentarSalario();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void mostrarSumaTotalSalarios(HashSet<Empleado> empleados) {
        double sumaTotal = 0;
        for (Empleado empleado : empleados) {
            sumaTotal += empleado.getSalario();
        }
        System.out.printf("La suma total de todos los salarios es: $"+ sumaTotal);
    }

    public static void mostrarTodosEmpleados(HashSet<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para mostrar.");
        } else {
            for (Empleado empleado : empleados) {
            	System.out.println("\n-----------------");
                empleado.mostrarDatos();
                System.out.println("\n-----------------");
            }
        }
}
}
