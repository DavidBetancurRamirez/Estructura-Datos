package Recursividad;

import java.util.Arrays;

public class Recursividad {
	
	public static void main(String[] args) {
//		System.out.println(factorial(4));
//		System.out.println(sumaPrimerosNR(4));
//		long[] n = {1,3,5,6,10};
//		System.out.println(sumaArrayAtrasAdelante(n));
//		System.out.println(sumaArrayAdelanteAtras(n));
//		System.out.println(numMax(n));
//		System.out.println(subsecuenciaSumaMaxima(n));
//		String[] pasos = hanoi(5);
//		for (String paso : pasos) {
//			System.out.println(paso);
//		}
//		int[][] matriz = {{1,1},{1,1},{1,2}};
//		System.out.println(sumaMatriz(matriz));
//		int[] arreglo = {4,6,5,3,2,6,8};
//		System.out.println(cantidadPares(arreglo));
		int[] serie = fibbonacci(15);
		for (int i : serie) {
			System.out.println(i);
		}
	}
	
	// Solucion recursiva
	public static long factorial (long n) {
		if (n==1 || n==0)				// Condicion de parada
			return 1;
		else
			return n*factorial(n-1);	// Llamada recursiva
	}
	
	public static String[] hanoi(int n) {
		String[] pasos = new String[0];
		return hanoi(n,1,3,2,pasos);
	}
	public static String[] hanoi(int n, int inicial, int fin, int central, String[] pasos) {
		if (n == 1) {
			pasos = Arrays.copyOf(pasos, pasos.length+1);
			pasos[pasos.length-1] = "Mover D"+n+" de "+inicial+" a "+fin;
			return pasos;
		} else {
			pasos = hanoi(n-1, inicial, central, fin, pasos);
			pasos = Arrays.copyOf(pasos, pasos.length+1);
			pasos[pasos.length-1] = "Mover D"+n+" de "+inicial+" a "+fin;
			return hanoi(n-1, central, fin, inicial, pasos);
		}
	}
	/* Hanoi mostrando el paso a paso
	public static void hanoi(int n) {
		hanoi(n,1,3,2);
	}
	public static void hanoi(int n, int inicial, int fin, int central) {
		if (n == 1) {
			System.out.println("Mover D"+n+" de "+inicial+" a "+fin);
		} else {
			hanoi(n-1, inicial, central, fin);
			System.out.println("Mover D"+n+" de "+inicial+" a "+fin);
			hanoi(n-1, central, fin, inicial);
		}
	}*/
	
	public static long sumaPrimerosNR(long n) {
		if (n==1 || n==0)				// Condicion de parada
			return 1;
		else
			return n+sumaPrimerosNR(n-1);	// Llamada recursiva
	}
	
	public static long sumaArrayAtrasAdelante(long[] n) {
		// Aqui se hacen verificaciones
		return sumaArrayAtrasAdelante(n,0);
	}
	public static long sumaArrayAtrasAdelante(long[] n, int i) {
		if (i==n.length-1)				// Condicion de parada
			return n[i];
		else
			return n[i]+sumaArrayAtrasAdelante(n,i+1);	// Llamada recursiva
	}
	
	
	public static long sumaArrayAdelanteAtras(long[] n) {
		// Aqui se hacen verificaciones
		return sumaArrayAdelanteAtras(n,n.length-1);
	}
	public static long sumaArrayAdelanteAtras(long[] n, int i) {
		if (i==0)
			return n[0];
		else
			return n[i]+sumaArrayAdelanteAtras(n,i-1);
	}
	
	public static long numMax(long[] arr) {
		return numMax(arr,arr.length-1,-1);
	}
	public static long numMax(long[] arr, int i, long max) {
		if (i==0)
			return max;
		else
			return (arr[i]>max) ? numMax(arr,i-1,arr[i]) : numMax(arr,i-1,max);
	}
	
	public static int max(int[] lista) {
		if (lista.length>0)
			return maxR(lista, 0, lista.length-1);
		else
			System.out.println("Lista vacia");
			return -1;
	}
	public static int maxR(int[] lista, int inf, int sup) {
		if (inf>=sup)
			return lista[inf];
		int medio = (sup-inf)/2;
		int maxI = maxR(lista,inf, inf+medio);
		int maxD = maxR(lista, inf+medio+1, sup);
		return Math.max(maxI, maxD);
	}
	
	public static int sumaMatriz(int[][] m) {
		return sumaMatriz(m,0,0);
	}
	public static int sumaMatriz(int[][] m, int fila, int columna) {
		if (fila == m.length) {
			return 0;
		}
		if (m[fila].length == columna) {
			return sumaMatriz(m,fila+1,0);
		}
		return m[fila][columna] + sumaMatriz(m,fila,columna+1);
	}
	
	public static int cantidadPares(int[] n) {
		return cantidadPares(n,0);
	}
	public static int cantidadPares(int[] n, int i) {
		if (i==n.length)
			return 0;
		return (n[i]%2==0) ? 1 + cantidadPares(n,i+1) : cantidadPares(n,i+1);
	}
	
	public static int[] fibbonacci(int n) {
		// n indica la cantidad de numeros de la sucesion que se devolveran
		int[] serie = {1,1};
		return (n<=2) ? serie : fibbonacci(n,serie);
	}
	public static int[] fibbonacci(int n, int[] serie) {
		if (serie.length==n)
			return serie;
		serie = Arrays.copyOf(serie, serie.length+1);
		serie[serie.length-1] = serie[serie.length-2]+serie[serie.length-1];
		return fibbonacci(n,serie);
	}
	
	
	
	// Solucion comun
	public static long subsecuenciaSumaMaxima(long[] a) {
		int secIni, secFin, aux1, aux2;
		long sumaActual = 0;
		long sumaMax = 0;
		
		for (int i = 1; i < a.length; i++) {
			aux1 = i-1;
			aux2 = i;
			sumaActual = a[aux1]+a[aux2];
			
			if (sumaActual>sumaMax) {
				sumaMax = sumaActual;
			}
		}
		
		return sumaMax;
	}	
	
	/* Solucion recursiva
	public static long factorial (long n) {
		if (n==1 || n==0)				// Condicion de parada
			return 1;
		else
			return n*factorial(n-1);	// Llamada recursiva
	}*/
	
	/* Solucion comun
	public static long factorial (long n) {
		long f=1;
		for (int i = 0; i <= n; i++)
			f*=i;
		return f;
	}
	*/
}
