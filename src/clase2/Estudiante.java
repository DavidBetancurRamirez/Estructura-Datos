package clase2;

public class Estudiante {
	private double notas[];
	public static int cantidadEstudiantes;
	
	
	public double[] getNotas() {
		return notas;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	
	public Estudiante(double notas[]) {
		this.notas = notas; 
		cantidadEstudiantes++;
	}

	
	public double promedio() {
		double promedio = 0;
		
		if (notas.length >= 3) {
			for (int i = notas.length-1; i >= 0; i--) {
				promedio += notas[i];
			}
		} else {
			System.out.println("No hay suficientes notas para realizar el promedio");
		}
		
		return promedio/notas.length;
	}
	
	public char calificacion() {
		int promedio = (int) promedio();
		
		switch (promedio) {
			case 5: case 4:
				return 'B';
			case 3:
				return 'R';
			case 2: case 1: case 0:
				return 'M';
	
			default:
				System.out.println("El promedio no esta entre las opciones");
				break;
		}
		
		return 'X';
	}
}
