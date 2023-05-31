package Relaciones;

public class TestTrabajador {
	
	public static void main(String[] args) {
		Trabajador t = new Trabajador("Juan Gonzalo", 400, 23);
		System.out.println("El salario es: "+t.salario());
	
		Trabajador l = new EmpLimpieza("Maria Linares", 250, 19, 50, 40);
		System.out.println("El salario es: "+l.salario());
	}
	
}
