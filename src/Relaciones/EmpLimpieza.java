package Relaciones;

public class EmpLimpieza extends Trabajador {
	private float norma;
	private float cump;
	
	public EmpLimpieza(String nombre, float sb, float dt, float norma, float cump) {
		super(nombre, sb, dt);
		this.norma = norma;
		this.cump = cump;
	}
	
	public float salario() {
		return (float) (super.salario()+super.salario()*0.1*cump/norma);
	}
}
