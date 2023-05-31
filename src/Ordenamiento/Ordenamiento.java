
package Ordenamiento;

import java.util.Arrays;

public class Ordenamiento {
	
	@SuppressWarnings("rawtypes")
	public static void printLista(Comparable[] a) {
		if (a!=null)
			for (Comparable p : a)
				System.out.println(p+" ");
			
		System.out.println();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean ordenado(Comparable[] a) {
		int i = 0;
		while (i<a.length-1 && a[i].compareTo(a[++i])<0);
		return !(i<a.length-1);
	}
	@SuppressWarnings({ "rawtypes" })
	public static Comparable[] add(Comparable[] l, Comparable o) {		
		l = Arrays.copyOf(l, l.length+1);
		l[l.length-1] = o;
		
		return l;
	}

	public static void main(String[] args) {
		/*
		int[] aint = {6,9,5,3,4};
		bubbleSort(aint);
		printLista(aint);*/
		/*
		Persona p1 = new Persona("Marcela",24);
		Persona p2 = new Persona("Oscar",21);
		Persona p3 = new Persona("Marcela",20);
		Persona p4 = new Persona("Andrés",26);
		Persona p5 = new Persona("Oscar",30);
		Persona p6 = new Persona("Nadia",21);
		Persona[] listaP = {p1,p2,p3,p4,p5,p6};
		printLista(listaP);
		System.out.println();
		Persona[] listaTempP;
		System.out.println("bubleSort");
		listaTempP = Arrays.copyOf(listaP, listaP.length);
		bubleSort(listaTempP);
		printLista(listaTempP);
		System.out.println("selectionSort");
		listaTempP = Arrays.copyOf(listaP, listaP.length);
		selectionSort(listaTempP);
		printLista(listaTempP);
		System.out.println("insertSort");
		listaTempP = Arrays.copyOf(listaP, listaP.length);
		insertSort(listaTempP);
		printLista(listaTempP);
		*/
		/*
		int N = 50000;
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for (int i = 0; i < N; i++) {
			lista[i]=r.nextInt(2*N);
			//lista[i]=N-i;
			//lista[i]=i;
		}*/
		Integer[] listaTemp;
		long timeInicio, timeFin;
		
		Integer[] lista = {6,3,5,2,8,4,7,9,0};
		//Integer[] lista = {0,1,2,3,4,5,6,7,8,9};
		/*
		Integer[] lista1 = {3,7,5,8};
		Integer[] lista2 = {2,10,9,6,12};
		*/
		// merchSort(lista1, lista2);
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		try {
			mergeSort(lista,0,lista.length-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		timeFin=System.currentTimeMillis();
		System.out.println("MerchSort: "+(timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		quickSort(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("QuickSort: "+(timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		quickSortOrdenado(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("QuickSort Ordenado: "+(timeFin-timeInicio));

		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		//quickSortPA(listaTemp);		// MUY POCO EFICIENTE
		timeFin=System.currentTimeMillis();
		System.out.println("QuickSort pivote aleatorio: "+(timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		bubleSort(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("BubbleSort: "+(timeFin-timeInicio));

		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		bubleSortOrdenado(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("BubleSort Ordenado: "+(timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		selectionSort(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("SelectionSort: "+(timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		insertSort(listaTemp);
		timeFin=System.currentTimeMillis();
		System.out.println("InsertSort: "+(timeFin-timeInicio));
	}
	
	// Metodos de ordenamiento
	@SuppressWarnings({ "rawtypes" })
	public static Comparable[] mergeSort(Comparable[] lista, int inicio, int fin) throws Exception {
		if (inicio==fin)
			return new Comparable[]{lista[inicio]};
		else {
			Comparable[] list1=mergeSort(lista, inicio, (inicio+fin)/2);
			Comparable[] list2=mergeSort(lista, 1+(inicio+fin)/2, fin);
			return merge(list1,list2);
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable[] merge(Comparable[] lista1, Comparable[] lista2) throws Exception {
		if (lista1==null || lista2==null)
			throw new Exception("Una lista es vacia");
		
		Comparable[] result = new Comparable[lista1.length+lista2.length];
		int i=0,j=0;
		
		while(i<lista1.length && j<lista2.length)
				result[i+j]=(lista1[i].compareTo(lista2[j])<=0)? lista1[i++] : lista2[j++];
		
		for (int k = i; k < lista1.length; k++)
			result[k+j]=lista1[k];
		
		for (int k = j; k < lista2.length; k++)
			result[k+j]=lista2[k];
		return result;		
	}
	/*
	@SuppressWarnings({ "rawtypes" })
	public static Comparable[] merchSort(Comparable[] a, Comparable[] b) {
		if (a==null || b==null) return null;
		quickSortOrdenado(a);
		quickSortOrdenado(b);
		Comparable[] c = new Comparable[0];
		return merchSort(a,b,0,0,c);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable[] merchSort(Comparable[] a, Comparable[] b, int i, int j, Comparable[] c) {
		if (i==a.length) {
			int d = c.length;
			int e = a.length+b.length;
			c = Arrays.copyOf(c, e);
			System.arraycopy(b, j, c, d, e-d);
			return c;
		} else if (j == b.length) {
			int d = c.length;
			int e = a.length+b.length;
			c = Arrays.copyOf(c, e);
			System.arraycopy(a, i, c, d, e-d);			
			return c;
		}
		
		// Negativo cuando a[i] es menor
		if (a[i].compareTo(b[j])<=0) c = add(c,a[i++]);
		else c = add(c,b[j++]);
		
		return merchSort(a,b,i,j,c);
	}
	*/
	
	
	@SuppressWarnings({ "rawtypes" })
	public static void quickSort(Comparable[] a){
		// -Xss256m
		 quickSort(a, 0, a.length-1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void quickSort(Comparable[] a, int inicio, int fin){
		if (fin <= inicio)
			return;
		Comparable pivote = a[fin];
		int i = inicio-1;
		int j = fin;
		Comparable temp;
		while (i<j) {
			//busca un elemento mayor que pivote, si no para en el pivote (el último)
			while( a[++i].compareTo(pivote)<0 );
			//se busca un elemento menor que el pivote, si no lo hay, para en el primero
			while( j > inicio && pivote.compareTo(a[--j])<0 );
			if( i < j ){	
				//se intercambian los elementos
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		/*
		 * se sale del ciclo cuando la i>=j, si se cruzan los índices en i hay un elemento mayor que el pivote, 
		 * la posición correcta del pivote es i deben intercambiarse
		 */
		temp=a[i];
		a[i]=a[fin]; // el pivote está en fin
		a[fin]=temp;
		int partition=i;
		quickSort( a, inicio, partition-1 );
		quickSort( a, partition+1, fin );
	}

	
	@SuppressWarnings({ "rawtypes" })
	public static void quickSortOrdenado(Comparable[] a){
		quickSortOrdenado(a, 0, a.length-1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void quickSortOrdenado(Comparable[] a, int inicio, int fin){
		if (fin <= inicio)
			return;
		Comparable pivote = a[fin];
		int i = inicio-1;
		int j = fin;
		Comparable temp;
		while (i<j) {
			while( a[++i].compareTo(pivote)<0);
			while( j > inicio && pivote.compareTo(a[--j])<0 );
			if( i < j ){	
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[i];
		a[i]=a[fin];
		a[fin]=temp;
		if (!ordenado(a)) {
			int partition=i;
			quickSortOrdenado( a, inicio, partition-1 );
			quickSortOrdenado( a, partition+1, fin );
		}
	}

	
	@SuppressWarnings({ "rawtypes" })
	// FALTA TERMINAR
	public static void quickSortPA(Comparable[] a){
		quickSortPA(a, 0, a.length-1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void quickSortPA(Comparable[] a, int inicio, int fin){
		if (fin <= inicio)
			return;
		Comparable pivote = a[fin];
		int i = inicio-1;
		int j = fin+1;
		Comparable temp;
		while (i<j) {
			//busca un elemento mayor que pivote, si no para en el pivote (el último)
			while( a[++i].compareTo(pivote)<0 );
			//se busca un elemento menor que el pivote, si no lo hay, para en el primero
			while( j > inicio && pivote.compareTo(a[--j])<0 );
			if( i < j ){	
				//se intercambian los elementos
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		/*
		 * se sale del ciclo cuando la i>=j, si se cruzan los índices en i hay un elemento mayor que el pivote, 
		 * la posición correcta del pivote es i deben intercambiarse
		 */
		temp=a[i];
		a[i]=a[fin]; // el pivote está en fin
		a[fin]=temp;
		int partition=i;
		quickSort( a, inicio, partition-1 );
		quickSort( a, partition+1, fin );
	}
	
	/*
	@SuppressWarnings({ "rawtypes" })
	public static void quickSortPA(Comparable[] a) {
		quickSortPA(a,0,a.length-1);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void quickSortPA(Comparable[] a, int inicio, int fin) {
		if (fin <= inicio)
			return;
		Random rand = new Random();
		int pivote = (int) a[rand.nextInt(fin)];
		int i = inicio;
		int j = fin;
		Comparable temp;
		while (i<=j) {
			while( a[i].compareTo(pivote)<0 ) i++;
			while( a[j].compareTo(pivote)>0 ) j--;
			if( i <= j ) {
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
	            j--;
			}
		}
		quickSortPA( a, inicio, i-1 );
		quickSortPA( a, i, fin );
	}
	*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void bubleSort(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if (a[j+1].compareTo(a[j])<0) {
					Comparable temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void bubleSortOrdenado(Comparable[] a) {
		int i=-1;
		boolean bandera = true;
		
		while (bandera && ++i < a.length-1) {
			bandera = false;
			for (int j = 0; j < a.length-1-i; j++) {
				if (a[j+1].compareTo(a[j])<0) {
					Comparable temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					bandera = true;
				}
			}
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void selectionSort(Comparable[] a) {		// MEJOR CUANDO ESTA DESORDENADO
		for (int i = 0; i < a.length-1; i++) {
			int im =i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j].compareTo(a[im])<0) {
					im = j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im]=temp;
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertSort(Comparable[] a) {		// MEJOR CUANDO YA ESTA ORDENADO
		for (int i = 1; i < a.length; i++) {
			Comparable temp = a[i];		// El que quiero insertar
			int j=i;
			while(j>0 && temp.compareTo(a[j-1])<0) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}
}
