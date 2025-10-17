package model;

public class Nomina {

	// Atributos
	private String dni;
	private double salario;

	// Constructor:
	public Nomina(String dni, double salario) {
		this.dni = dni;
		this.salario = salario;
	}

	//Getters y Setters:
	public String getDni() {
		return dni;
	}

	public void setDni() {
		this.dni = dni;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}