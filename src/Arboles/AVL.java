package Arboles;

import java.util.ArrayList;

public class AVL<E extends Comparable<E>> extends ABB<E> {
	public AVL(NodoB<E> raiz) {
		super(raiz);
	}
	
	public static void main(String[] args) {
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
		NodoB<Integer> n12 = new NodoB<>(12);
		NodoB<Integer> n13 = new NodoB<>(13);
		
		AVL<Integer> a = new AVL<Integer>(n8);
		AVL<Integer> b = new AVL<Integer>(n10);
		
		try {			
			a.insertarNodo(n3);
			a.insertarNodo(n1);

			a.insertarNodo(n12);
			a.insertarNodo(n9);

			a.insertarNodo(n6);
			a.insertarNodo(n5);
			
			a.preorden();
			
			a.deleteNodo(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		a.preorden();
		a.inorden();
		a.postorden();
		try {			
			b.insertarNodo(n2);
			b.insertarNodo(n7);
			b.insertarNodo(n4);
			b.insertarNodo(n13);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("AVL1:");
		a.inorden();
		System.out.println("AVL2:");
		b.inorden();
		System.out.println(a.ordenados(a,b));
	}
	
	@Override
	public void insertarNodo(NodoB<E> n) throws ExceptionNodo {
		super.insertarNodo(n);
		balancear(n);
	}
	
	private void balancear(NodoB<E> n) {
		NodoB<E> desb = desbalance(n);
		if (desb!=null) {
			NodoB<E> p = desb.getPadre();
			if (desb.FE()>0) {
				if (desb.getHijoDer().FE()>=0)
					desb = balanceSimpleIzq(desb);
				else
					desb = balanceDobleIzq(desb);
			} else {
				if (desb.FE()<0) {
					if (desb.getHijoIzq().FE()<=0)
						desb = balanceSimpleDer(desb);
					else
						desb = balanceDobleDer(desb);
				}
			}
			if (p==null)
				raiz = desb;
			else
				if (desb.getLlave().compareTo(p.getLlave())>0)
					p.setHijoDer(desb);
				else
					p.setHijoIzq(desb);
		}
	}

	private NodoB<E> desbalance(NodoB<E> n) {
		NodoB<E> nodo = n;
		while (nodo!=null && Math.abs(nodo.FE())<=1) {
			nodo = nodo.getPadre();
		}
		return nodo;
	}

	private NodoB<E> balanceDobleDer(NodoB<E> n) {
		n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq()));
		return balanceSimpleDer(n);
	}

	private NodoB<E> balanceSimpleDer(NodoB<E> n) {
		NodoB<E> izq = n.getHijoIzq();
		izq.setPadre(n.getPadre());
		n.setHijoIzq(izq.getHijoDer());
		izq.setHijoDer(n);
		return izq;
	}

	private NodoB<E> balanceDobleIzq(NodoB<E> n) {
		n.setHijoDer(balanceSimpleDer(n.getHijoDer()));
		return balanceSimpleIzq(n);
	}

	private NodoB<E> balanceSimpleIzq(NodoB<E> n) {
		NodoB<E> der = n.getHijoDer();
		der.setPadre(n.getPadre());
		n.setHijoDer(der.getHijoIzq());
		der.setHijoIzq(n);
		return der;
	}
	
	@Override
	public void deleteNodo(E llave) throws ExceptionNodo {
		NodoB<E> n = super.busqueda(llave);
		NodoB<E> padre;
		if (n.getHijoDer()!=null && n.getHijoIzq()!=null)
			padre=buscarAntecesor(n).getPadre();
		else
			padre=n.getPadre();
		super.deleteNodo(llave);
		if (padre==null)
			balancear(raiz);
		else
			while (padre!=null) {
				balancear(padre);
				padre=padre.getPadre();
			}
	}
	
	public ArrayList<E> ordenados(AVL<E> a1, AVL<E> a2) {
		ArrayList<E> arr = new ArrayList<E>();
		return ordenados(arr, a1.inordenArr(), 0, a2.inordenArr(), 0);
	}
	public ArrayList<E> ordenados(ArrayList<E> arr, ArrayList<E> a1, int i , ArrayList<E> a2, int j) {
		if (a1.size()==i) {
			while (j<a2.size()) {
				arr.add(a2.get(j++));
			}
			return arr;
		} else if (a2.size()==j) {
			while (i<a1.size()) {
				arr.add(a1.get(i++));
			}	
			return arr;
		}
		if (a1.get(i).compareTo(a2.get(j))<=0) {
			arr.add(a1.get(i++));
		} else {
			arr.add(a2.get(j++));	
		}
		return ordenados(arr, a1, i, a2, j);
	}
}
