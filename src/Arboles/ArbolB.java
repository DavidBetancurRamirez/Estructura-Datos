package Arboles;

import java.util.ArrayList;

public class ArbolB<E extends Comparable <E>> {
	protected NodoB<E> raiz;

	public ArbolB(NodoB<E> raiz) {
		this.raiz = raiz;
	}

	public NodoB<E> getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}
	
	public static void main(String[] args) {
		/*
		NodoB<Integer> n1 = new NodoB<Integer>(10);
		NodoB<Integer> n2 = new NodoB<Integer>(7);
		NodoB<Integer> n3 = new NodoB<Integer>(15);
		NodoB<Integer> n4 = new NodoB<Integer>(5);
		NodoB<Integer> n5 = new NodoB<Integer>(9);
		NodoB<Integer> n6 = new NodoB<Integer>(12);
		n3.setHijoIzq(n6);
		n2.setHijoIzq(n4);
		n2.setHijoDer(n5);
		n1.setHijoIzq(n2);
		n1.setHijoDer(n3);
		ArbolB<Integer> a = new ArbolB<Integer>(n1);
		System.out.println("Preorden:");
		a.preorden();
		ArrayList<Integer> pre = (ArrayList<Integer>) a.preordenArr();
		System.out.println(pre.toString());
		System.out.println("Inorden:");
		a.inorden();
		System.out.println("Postorden:");
		a.postorden();
		System.out.println("Altura: "+n3.altura());
		System.out.println("Hojas: "+n4.hojas());
		*/
		
		NodoB<Integer> n1 = new NodoB<>(1);
		NodoB<Integer> n2 = new NodoB<>(2);
		NodoB<Integer> n3 = new NodoB<>(3);
		NodoB<Integer> n4 = new NodoB<>(4);
		NodoB<Integer> n5 = new NodoB<>(5);
		NodoB<Integer> n6 = new NodoB<>(6);
		NodoB<Integer> n7 = new NodoB<>(7);
		NodoB<Integer> n8 = new NodoB<>(8);
		NodoB<Integer> n9 = new NodoB<>(9);
		NodoB<Integer> n10 = new NodoB<>(10);
		NodoB<Integer> n15 = new NodoB<>(15);
		NodoB<Integer> n16 = new NodoB<>(16);
		
		ABB<Integer> a = new ABB<>(n5);
		
		try {
			a.insertarNodo(n2);
			a.insertarNodo(n3);
			a.insertarNodo(n1);
			a.insertarNodo(n9);
			a.insertarNodo(n7);
			a.insertarNodo(n8);
			a.insertarNodo(n6);
			a.insertarNodo(n4);
			a.insertarNodo(n10);
			a.insertarNodo(n15);
			a.insertarNodo(n16);
			a.inordenArr();
			
//			a.deleteNodo(4);
//			a.deleteNodo(15);
			a.deleteNodo(9);
//			a.deleteNodo(3);
//			a.deleteNodo(10);
//			a.deleteNodo();
			
			ArrayList<Integer> preorden = a.preordenArr();
			ABB<Integer> b = a.preOrdenArbol(preorden);
			System.out.println(b);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void preorden() {
		preorden(this.raiz);
		System.out.println();
	}
	public void preorden(NodoB<E> nodo) {
		if (nodo!=null) {
			System.out.print(nodo.getLlave() +"\t");
			preorden(nodo.getHijoIzq());
			preorden(nodo.getHijoDer());
		}
	}
	public ArrayList<E> preordenArr() {
		ArrayList<E> arr = new ArrayList<E>();
		System.out.println(preordenArr(this.raiz, arr));
		return arr;
	}
	public ArrayList<E> preordenArr(NodoB<E> nodo, ArrayList<E> arr) {
		if (nodo!=null) {
			arr.add(nodo.getLlave());
			preordenArr(nodo.getHijoIzq(),arr);
			preordenArr(nodo.getHijoDer(),arr);
		}
		return arr;
	}
	
	public void inorden() {
		inorden(this.raiz);
		System.out.println();		
	}
	public void inorden(NodoB<E> nodo) {
		if (nodo!=null) {
			inorden(nodo.getHijoIzq());
			System.out.print(nodo.getLlave() +"\t");
			inorden(nodo.getHijoDer());
		}
	}
	public ArrayList<E> inordenArr() {
		ArrayList<E> arr = new ArrayList<E>();
		return inordenArr(this.raiz, arr);	
	}
	public ArrayList<E> inordenArr(NodoB<E> nodo, ArrayList<E> arr) {
		if (nodo!=null) {
			inordenArr(nodo.getHijoIzq(), arr);
			arr.add(nodo.getLlave());
			inordenArr(nodo.getHijoDer(), arr);
		}
		return arr;
	}
	
	public void postorden() {
		postorden(this.raiz);
		System.out.println();		
	}
	public void postorden(NodoB<E> nodo) {
		if (nodo!=null) {
			postorden(nodo.getHijoIzq());
			postorden(nodo.getHijoDer());
			System.out.print(nodo.getLlave() +"\t");
		}
	}
	public ArrayList<E> postordenArr() {
		ArrayList<E> arr = new ArrayList<E>();
		return postordenArr(this.raiz, arr);		
	}
	public ArrayList<E> postordenArr(NodoB<E> nodo, ArrayList<E> arr) {
		if (nodo!=null) {
			postordenArr(nodo.getHijoIzq(), arr);
			postordenArr(nodo.getHijoDer(), arr);
			arr.add(nodo.getLlave());
		}
		return arr;
	}
}
