package Arboles;

import java.util.ArrayList;

class ExceptionNodo extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionNodo(String s) {
		super(s);
	}
}

public class ABB<E extends Comparable<E>> extends ArbolB<E>{
	// Arbol Binario de Busqueda
	public ABB(NodoB<E> raiz) {
		super(raiz);
	}
	
	public NodoB<E> busqueda(E llave) throws ExceptionNodo {
		return busqueda(llave,raiz);
	}
	public NodoB<E> busqueda(E llave, NodoB<E> nodo) throws ExceptionNodo {
		if (nodo==null)
			throw new ExceptionNodo("El nodo no existe");
		if (llave.compareTo(nodo.getLlave())<0)
			return busqueda(llave, nodo.getHijoIzq());
		if (llave.compareTo(nodo.getLlave())>0)
			return busqueda(llave, nodo.getHijoDer());
		return nodo;
	}
	
	public void insertarNodo(E llave) throws ExceptionNodo {
		raiz=insertarNodo(new NodoB<E>(llave),raiz);
	}	
	public void insertarNodo(NodoB<E> n) throws ExceptionNodo {
		if (n==null)
			throw new ExceptionNodo("El nodo es nulo");
		raiz=insertarNodo(n, raiz);
	}
	public NodoB<E> insertarNodo(NodoB<E> n, NodoB<E> r) throws ExceptionNodo {
		if (r==null)
			r=n;
		else {
			if (n.getLlave().compareTo(r.getLlave())<0)
				r.setHijoIzq(insertarNodo(n, r.getHijoIzq()));
			else if (n.getLlave().compareTo(r.getLlave())>0)
				r.setHijoDer(insertarNodo(n, r.getHijoDer()));
			else
				throw new ExceptionNodo("El nodo esta repetido");
		}
		return r;
	}
	
	public void deleteNodo(E llave) throws ExceptionNodo {
		if (llave==null)
			throw new ExceptionNodo("La llave es nula");
	    raiz = deleteNodo(this.raiz, llave);
	}
	public NodoB<E> deleteNodo(NodoB<E> nodo, E llave) throws ExceptionNodo {
	    if (nodo == null) {
	        throw new ExceptionNodo("No se encontro la llave "+llave);
	    }
	    if (llave.compareTo(nodo.getLlave())<0) {
	        nodo.setHijoIzq(deleteNodo(nodo.getHijoIzq(), llave));
	    } else {
	    	if (llave.compareTo(nodo.getLlave())>0) {
		        nodo.setHijoDer(deleteNodo(nodo.getHijoDer(), llave));
		    } else {
		    	if (nodo.getHijoIzq()!=null && nodo.getHijoDer()!=null) {
		    		// Caso 3
		    		NodoB<E> antecesor = nodo.getHijoIzq();
		    		nodo.setLlave(antecesor.getLlave());
		    		nodo.setHijoIzq(deleteNodo(nodo.getHijoIzq(), antecesor.llave));
		    	} else {
		    		if (nodo.getHijoDer()!=null)
		    			nodo = nodo.getHijoDer();
		    		else
		    			nodo = nodo.getHijoIzq();
		    	}
		    }
	    }
	    return nodo;
	}
	
	public NodoB<E> buscarAntecesor(NodoB<E> n) throws ExceptionNodo {
		return (n.getHijoIzq()==null) ? null : buscarMax(n.getHijoIzq());
	}
	
	public NodoB<E> buscarMax(NodoB<E> n) throws ExceptionNodo {
		return (n.getHijoDer()==null) ? n : buscarMax(n.getHijoDer());
	}
	
	
	public ABB<E> preOrdenArbol(ArrayList<E> arreglo) throws ExceptionNodo {
		if (arreglo==null || arreglo.size()==0)
			throw new ExceptionNodo("No se puede hacer un arbol con estos parametros");
		return new ABB<E>(preOrdenArbol(arreglo, new NodoB<E>(arreglo.get(0)), 1));
	}
	public NodoB<E> preOrdenArbol(ArrayList<E> arreglo, NodoB<E> nodo, int i) throws ExceptionNodo {
		if (arreglo.size()==i)
			return nodo;
		insertarNodo(new NodoB<E>(arreglo.get(i)), nodo);
		return preOrdenArbol(arreglo,nodo,i+1);
	}
}