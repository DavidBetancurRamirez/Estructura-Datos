package clase2;

public class Trabajador {
	private String nombre;
	private double salarioBasico, diasTrabajados;
	public static final int cantidadDias = 24;
	

	public String getNombre() {
		return nombre;
	}
	
	public double getSalarioBasico() {
		return salarioBasico;
	}
	public void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}
	
	public double getDiasTrabajados() {
		return diasTrabajados;
	}
	public void setDiasTrabajados(double diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	
	public Trabajador(String nombre, double salarioBasico) {
		this.nombre = nombre;
		this.salarioBasico = salarioBasico;
	}
	
	public double calcularSalario() {
		return salarioBasico * diasTrabajados / cantidadDias;
	}
}
