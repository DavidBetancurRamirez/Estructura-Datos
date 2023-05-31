package Estructuras;


public class Enlazada<E extends Comparable<E>> {
	
	public static void main(String[] args) {
		Enlazada<Integer> lista = new Enlazada<Integer>();
		lista.addFirst(5);
		lista.addFirst(1);
		lista.addFirst(2);
		lista.addFirst(3);
		lista.addFirst(4);
		
		System.out.println("Lista");
		lista.printList();
		System.out.println("");
		System.out.println(lista.getIndex(3));
		System.out.println(lista.getNodo(2));
		try {
			System.out.println("Insertando nodo");
			lista.insertNodo(8, 2);
			lista.printList();
			System.out.println("");
			System.out.println("Eliminando nodo");
			lista.deleteNodo(2);
			lista.printList();
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Clase
	private NodoL<E> head;

	public Enlazada(NodoL<E> head) {
		super();
		this.head = head;
	}
	public Enlazada() {
		super();
		this.head = null;
	}
	
	public int length() {
		int l = 0;
		NodoL<E> temp = head;
		while(temp!=null) {
			temp = temp.getNext();
			l++;
		}
		return l;
	}
	
	public void addFirst(E x) {
		NodoL<E> newNodo = null;
		if (head!=null) {
			newNodo = new NodoL<E>(head.getInfo());
			newNodo.setNext(head.getNext());
		} else {
			head = new NodoL<E>(x);			
		}
		head.setInfo(x);
		head.setNext(newNodo);
	}
	
	public void printList() {
		NodoL<E> actual = head;
		while (actual!=null) {
			System.out.println(actual.getInfo()+" ");
			actual=actual.getNext();
		}
	}
	
	public void insertNodo(E x, int pos) throws Exception {
		NodoL<E> nodo = getNodo(pos-1);
		
		if (nodo==null)
			throw new Exception("La posicion no es valida");
		
		NodoL<E> newNodo = new NodoL<E>(x);
		newNodo.setNext(nodo.getNext());
		nodo.setNext(newNodo);
	}
	
	public void deleteNodo(int pos) throws Exception {
		NodoL<E> nodoEliminar = getNodo(pos);

		if (nodoEliminar==null)
			throw new Exception("La posicion no es valida");
		
		NodoL<E> nodoAnterior = getNodo(pos-1);
		
		nodoAnterior.setNext(nodoEliminar.getNext());
	}
	
	public int getIndex(E x) {
		NodoL<E> actual = head;
		int i = 0;
		while (actual!=null && ((Comparable<E>) actual.getInfo()).compareTo(x)!=0) {
			actual=actual.getNext();
			i++;
		}
		return (actual!=null) ? i : -1;
	}
	
	public NodoL<E> getNodo(int i) {
		NodoL<E> actual = head;
		int contador = -1;
		while (actual!=null && ++contador<i) {
			actual = actual.getNext();
		}
		return (actual!=null) ? actual : null;
	}

	public NodoL<E> getHead() {
		return head;
	}
	public void setHead(NodoL<E> head) {
		this.head = head;
	}
}

class NodoL<E> {
	private E info;
	private NodoL<E> next;
	
	public NodoL(E info) {
		super();
		this.info = info;
		this.next = null;
	}
	
	public E getInfo() {
		return info;
	}
	public void setInfo(E info) {
		this.info = info;
	}
	public NodoL<E> getNext() {
		return next;
	}
	public void setNext(NodoL<E> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return info.toString();
	}
}
