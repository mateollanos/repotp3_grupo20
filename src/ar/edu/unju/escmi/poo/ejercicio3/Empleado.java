package ar.edu.unju.escmi.poo.ejercicio3;

public class Empleado {
	private String nombre;
    private int legajo;
    private double salario;
    
    private static final double SALARIO_MINIMO = 300000.00;
    private static final double AUMENTO_MERITOS = 10000.00;

    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.printf("Salario: $"+ salario);
    }

    public void aumentarSalario() {
        this.salario += AUMENTO_MERITOS;
        System.out.println("Salario aumentado. Nuevo salario: " + this.salario);
    }

    public int getLegajo() {
        return legajo;
    }

    public double getSalario() {
        return salario;
    }
}
