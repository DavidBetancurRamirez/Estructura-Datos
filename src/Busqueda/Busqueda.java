package Busqueda;

public class Busqueda {

	public static void main(String[] args) {
		int[] arr = {5,6,3,9,8,2};
		System.out.println(busquedaOCercano(arr,4));
		Integer[] lista = {1,2,3,5,6,7,8,10,42,68,92,96,100,150,170};
		System.out.println(busquedaBinRecursiva(lista,7));
	}
	
	
	// Busqueda binaria
	@SuppressWarnings({ "rawtypes" })
	public static int busquedaBinRecursiva(Comparable[] a, Comparable valor) {
		if (a==null) return -1;
		return busquedaBinRecursiva(a,valor,0,a.length-1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int busquedaBinRecursiva(Comparable[] a, Comparable valor, int inicio, int fin){
		int medio;
		if (inicio >= fin)
			return a[inicio].compareTo(valor)==0 ? inicio : -1;
		else {
			medio=(inicio+fin)/2;
			if (a[medio].compareTo(valor)==0)
				return medio;
			else{
				if (a[medio].compareTo(valor)>0)
					return busquedaBinRecursiva(a,valor, inicio,medio-1);
				else
					return busquedaBinRecursiva(a, valor,medio+1,fin);
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int busquedaBinIterativa(Comparable[] a, Comparable valor){
		int inicio=0;
		int fin=a.length-1;
		int medio;
		while (inicio<=fin){
			medio=(inicio+fin)/2; 				// posición media
			if (a[medio].compareTo(valor)==0) 	// búsqueda satisfactoria
				return medio;
			else { 								// actualización de los límites
				if (a[medio].compareTo(valor)>0)
					fin=medio-1;
				else
					inicio=medio+1;
			}
		}
		return -1;		// no se encontró el elemento
	}
	
	
	// Busqueda secuencial o lineal
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int busqueda(Comparable[] ps, Comparable p3){
		int i=0;
		while ( i<ps.length && ps[i].compareTo(p3)!=0) i++ ;
		return (i==ps.length) ? -1: i;
	}
	
	public static int busquedaOCercano(int[] a, int n){
		int i=0;
		int[] cercano = {0,Integer.MAX_VALUE}; // [posicion,valor]
		while ( i<a.length && a[i]!=n ) {
			if (Math.abs(n-a[i])<cercano[1]) {
				cercano[0] = i;
				cercano[1] = Math.abs(n-a[i]);
			}
			i++;
		}
		return (i==a.length) ? cercano[0] : i;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int mayor(Comparable [] a){
		int indm=0;
		for (int i=1; i<a.length; i++){
			if (a[indm].compareTo(a[i])<0) {
				indm=i;
			}
		}
		return indm;
	}
}
