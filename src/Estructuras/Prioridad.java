package Estructuras;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prioridad {

	public static void main(String[] args) {
		Comp compararNombre = new Comp();
		CompEdad compararEdad = new CompEdad();
		Comp2 comparar = new Comp2("edad");
		PriorityQueue<Persona> pq = new PriorityQueue<Persona>(compararEdad);
		pq.add(new Persona("Juan",20));
		pq.add(new Persona("Juan",16));
		pq.add(new Persona("Abel",20));
		pq.add(new Persona("Ana",20));
		pq.add(new Persona("Abel",15));
		
		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}

}

class Comp implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
	
}

class CompEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getEdad()-o2.getEdad();
	}
	
}

class Comp2 implements Comparator<Persona> {
	private String tipo;

	public Comp2(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compare(Persona o1, Persona o2) {
		if (tipo.compareTo("nombre")==0)
			return o1.getNombre().compareTo(o2.getNombre());
		else
			return o1.getEdad()-o2.getEdad();
	}
	
}
