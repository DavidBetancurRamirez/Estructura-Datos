import java.util.Arrays;

public class arreglos {
	public static void main(String[] args) {
		// System.arraycopy()
		int [] c = {1,2,3,4};
		int [] d= {0,0,0,0,0,0};
		
		System.arraycopy(c, 0, d, 0, c.length); // Copiar elementos
		
		/* ELILMINAR en posicion index
		System.arraycopy(trabajadores, index+1, trabajadores, index, trabajadores.length-index-1);
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length-1);
		*/
		
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		
			// array.copyOf()
		int[] y = new int[1];
		y[0] = 4;
		
		// AGREGAR elemento al arreglo
		y= Arrays.copyOf(y, y.length+1);	// Incrementar el arreglo en un valor
		y[y.length-1]=5;					// adicionar el 5 al final de arreglo
		
		
			// Array.fill()
		int[] a = new int[10];
		Arrays.fill(a, 5);		// Llena el arreglo a con valor 5 en las 10 posiciones
		Arrays.fill(a,3,6,8); 	// Llena el arreglo desde la posicion con indice 3 hasta la posicion 5 con el valor 8
		
		
			// Array.sort()
		int[] b = {4,6,1,3,2};
		Arrays.sort(b);		// Ordena de forma ascendente
	}
}
