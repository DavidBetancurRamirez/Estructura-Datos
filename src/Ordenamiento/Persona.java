package Ordenamiento;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona o) {
		/*
		 * compareTo:
		 * 		-1 si es menos
		 * 		0 si son iguales
		 * 		>0 si es mayor 
		 */
		int i = nombre.compareToIgnoreCase(o.getNombre());
		return (i!=0)? i : edad-o.getEdad();
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
}
