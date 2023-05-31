package Arboles;

public class NodoB<E extends Comparable<E>> {
	protected E llave;
	protected NodoB<E> hijoIzq;
	protected NodoB<E> hijoDer;
	protected NodoB<E> padre;
	
	public NodoB(E llave) {
		this.llave = llave;
		padre = null;
		hijoIzq = null;
		hijoDer = null;
	}

	public NodoB(E llave, NodoB<E> hijoIzq, NodoB<E> hijoDer, NodoB<E> padre) {
		super();
		this.llave = llave;
		this.hijoIzq = hijoIzq;
		this.hijoDer = hijoDer;
		this.padre = padre;
	}
	
	public int altura() {
		int a = altura(this);
		return (this.getPadre()==null) ? a : a-1;
	}
	public int altura(NodoB<E> nodo) {
		if (nodo==null)
			return 0;
		int izq = altura(nodo.getHijoIzq());
		int der = altura(nodo.getHijoDer());
		return Math.max(izq, der)+1;
	}
	
	public int hojas() {
		int h = hojas(this);
		return (this.getHijoIzq()==null && this.getHijoDer()==null) ? 0 : h;
	}
	public int hojas(NodoB<E> nodo) {
		if (nodo.getHijoIzq()==null && nodo.getHijoDer()==null) {
			return 1;
		}
		int izq = (nodo.getHijoIzq()==null) ? 0 : hojas(nodo.getHijoIzq());
		int der = (nodo.getHijoDer()==null) ? 0 : hojas(nodo.getHijoDer());
		return izq+der;
	}

	public E getLlave() {
		return llave;
	}
	public void setLlave(E llave) {
		this.llave = llave;
	}

	public NodoB<E> getHijoIzq() {
		return hijoIzq;
	}
	public void setHijoIzq(NodoB<E> hijoIzq) {
		if (hijoIzq!=null)
			hijoIzq.setPadre(this);
		this.hijoIzq = hijoIzq;
	}

	public NodoB<E> getHijoDer() {
		return hijoDer;
	}
	public void setHijoDer(NodoB<E> hijoDer) {
		if (hijoDer!=null)
			hijoDer.setPadre(this);
		this.hijoDer = hijoDer;
	}

	public NodoB<E> getPadre() {
		return padre;
	}
	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}

	public int FE() {
		return altura(this.getHijoDer())-altura(this.getHijoIzq());
	}
}
