package Grafos;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class ExceptionVertice extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionVertice() {
		super("Error en Vertice");
	}
	
	public ExceptionVertice(String s) {
		super(s);
	}
}

public class Grafo<E extends Comparable<E>> {
	private LinkedList<Vertice<E>> vertices;

	public Grafo(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
	public Grafo() {
		this.vertices = new LinkedList<Vertice<E>>();
	}
	
	public static void main(String[] args) {
		Vertice<Integer> v1 = new Vertice<Integer>(1);
		Vertice<Integer> v2 = new Vertice<Integer>(2);
		Vertice<Integer> v3 = new Vertice<Integer>(3);
		Vertice<Integer> v4 = new Vertice<Integer>(4);
		Vertice<Integer> v5 = new Vertice<Integer>(5);
		Vertice<Integer> v6 = new Vertice<Integer>(6);
		Vertice<Integer> v7 = new Vertice<Integer>(7);
		Arista<Integer> a12 = new Arista<Integer>(v2, 3);
		Arista<Integer> a13 = new Arista<Integer>(v3, 10);
		Arista<Integer> a14 = new Arista<Integer>(v4, 7);
		Arista<Integer> a24 = new Arista<Integer>(v4, 2);
		Arista<Integer> a25 = new Arista<Integer>(v5, 8);
		Arista<Integer> a36 = new Arista<Integer>(v6, 5);
		Arista<Integer> a47 = new Arista<Integer>(v7, 3);
		Arista<Integer> a57 = new Arista<Integer>(v7, 1);
		Arista<Integer> a67 = new Arista<Integer>(v7, 1);
		v1.getAdyacentes().add(a12);v1.getAdyacentes().add(a13);v1.getAdyacentes().add(a14);
		v2.getAdyacentes().add(a24);v2.getAdyacentes().add(a25);
		v3.getAdyacentes().add(a36);
		v4.getAdyacentes().add(a47);
		v5.getAdyacentes().add(a57);
		v6.getAdyacentes().add(a67);
		Grafo<Integer> grafo = new Grafo<Integer>();
		grafo.getVertices().add(v1);
		grafo.getVertices().add(v2);
		grafo.getVertices().add(v3);
		grafo.getVertices().add(v4);
		grafo.getVertices().add(v5);
		grafo.getVertices().add(v6);
		grafo.getVertices().add(v7);
		
		Stack<Vertice<Integer>> s;
		
		try {
			s = grafo.menorCaminoSinPeso(v1, v7);
			grafo.imprimirCamino(s);
			s = grafo.dijkstra(1,7);
			grafo.imprimirCamino(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void imprimirCamino(Stack<Vertice<E>> s) {
		while (!s.isEmpty()) {
			Vertice<E> v = s.pop();
			System.out.print(v.getInfo()+"\t");
		}
		System.out.println();
	}
	
	public Stack<Vertice<E>> dijkstra(E infoInicio, E infoDestino) throws ExceptionVertice {
		Vertice<E> inicio = vertices.get(indexVertice(infoInicio));
		Vertice<E> destino = vertices.get(indexVertice(infoDestino));
		
		inicializarVertices();
		Queue<Vertice<E>> vSinVisitar = new PriorityQueue<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while (!vSinVisitar.isEmpty()) {
			// Buscar vertice
			Vertice<E> actual = vSinVisitar.poll();
			// Recorrer adyacentes y poner en cola sin visitar
			ListIterator<Arista<E>> iterator = actual.getAdyacentes().listIterator();
			while (iterator.hasNext()) {
				Arista<E> a = iterator.next();
				Vertice<E> v = a.getDestino();
				double distancia = actual.getDistance()+a.getPeso();
				if (v.getAnterior()==null || distancia<v.getDistance()) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+a.getPeso());
					if (!vSinVisitar.contains(v))
						vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio, destino);
	}
	
	public int indexVertice(E info) throws ExceptionVertice {
		int i = 0;
		while (i<vertices.size() && vertices.get(i).getInfo().compareTo(info)!=0)i++;
		if (i<vertices.size()) return i;
		else throw new ExceptionVertice();
	}
	
	public Stack<Vertice<E>> menorCaminoSinPeso(Vertice<E> inicio, Vertice<E> destino) throws ExceptionVertice {
		inicializarVertices();	// Inicializar los anteriores y distancias antes de recorrer
		// Recorrer a lo ancho todas las aristar con que tiene coneccion
		Queue<Vertice<E>> vSinVisitar = new LinkedList<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while (!vSinVisitar.isEmpty()) {
			// Buscar vertice
			Vertice<E> actual = vSinVisitar.poll();
			// Recorrer adyacentes y poner en cola sin visitar
			ListIterator<Arista<E>> iterator = actual.getAdyacentes().listIterator();
			while (iterator.hasNext()) {
				Arista<E> a = iterator.next();
				Vertice<E> v = a.getDestino();
				if (v.getAnterior()==null) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+1);
					vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio, destino);
	}
	
	public Stack<Vertice<E>> camino(Vertice<E> inicio, Vertice<E> destino) throws ExceptionVertice {
		Stack<Vertice<E>> camino = new Stack<Vertice<E>>();
		Vertice<E> v = destino;
		while (v!=null) {
			camino.push(v);
			v = v.getAnterior();
		}
		if (camino.peek().getInfo().compareTo(inicio.getInfo())!=0)
			throw new ExceptionVertice("No se encontro camino");
		return camino;
	}
	
	public void inicializarVertices() {
		ListIterator<Vertice<E>> list = vertices.listIterator();
		while (list.hasNext()) {
			Vertice<E> v = list.next();
			v.setAnterior(null);
			v.setDistance(Double.POSITIVE_INFINITY);
		}
	}

	public LinkedList<Vertice<E>> getVertices() {
		return vertices;
	}
	public void setVertices(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
}
