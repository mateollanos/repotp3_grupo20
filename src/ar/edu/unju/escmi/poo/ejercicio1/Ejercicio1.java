package ar.edu.unju.escmi.poo.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear objeto con Constructor por defecto.");
            System.out.println("2 – Crear objeto con Constructor parametrizado.");
            System.out.println("3 – Crear objeto con Constructor (dni, nombre, fecha de nacimiento).");
            System.out.println("4 – Mostrar personas.");
            System.out.println("5 - Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    Persona persona1 = new Persona();
                    System.out.print("Ingrese DNI: ");
                    persona1.setDni(scanner.nextLine());
                    System.out.print("Ingrese nombre: ");
                    persona1.setNombre(scanner.nextLine());
                    System.out.print("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
                    persona1.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));
                    System.out.print("Ingrese domicilio: ");
                    persona1.setDomicilio(scanner.nextLine());
                    System.out.print("Ingrese provincia: ");
                    persona1.setProvincia(scanner.nextLine());
                    personas.add(persona1);
                    System.out.println("Persona creada con éxito.\n");
                    break;

                case 2:
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
                    LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Ingrese provincia: ");
                    String provincia = scanner.nextLine();
                    Persona persona2 = new Persona(dni, nombre, fechaNacimiento, domicilio, provincia);
                    personas.add(persona2);
                    System.out.println("Persona creada con éxito.\n");
                    break;

                case 3:
                    System.out.print("Ingrese DNI: ");
                    String dni3 = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre3 = scanner.nextLine();
                    System.out.print("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
                    LocalDate fechaNacimiento3 = LocalDate.parse(scanner.nextLine());
                    Persona persona3 = new Persona(dni3, nombre3, fechaNacimiento3);
                    personas.add(persona3);
                    System.out.println("Persona creada con éxito.\n");
                    break;

                case 4:
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas para mostrar.\n");
                    } else {
                        for (Persona persona : personas) {
                            persona.mostrarDatos();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.\n");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }
}
