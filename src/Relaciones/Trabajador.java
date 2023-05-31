package Relaciones;

public class Trabajador {
	protected String nombre;
	protected float sb;		// Salario basico
	protected float dt;		// Dias trabajados
	
	public Trabajador(String nombre, float sb, float dt) {
		this.nombre = nombre;
		this.sb = sb;
		this.dt = dt;
	}
	
	public float salario() {
		return sb*dt/24;
	}
}
