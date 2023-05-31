package Estructuras;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExample {
	
	public static <E> void printList(ArrayList<E> list) {
		for (E e: list)
			System.out.print(e+"\t");
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Pedro");
		lista.add("Olga");
		lista.add("Miguel");
		lista.add("Antonio");
		lista.add("Olga");
		lista.add("Olga");
		lista.add("Andres");
		lista.add("Olga");
		printList(lista);
		ArrayList<String> listaTemp = (ArrayList<String>)lista.clone();
		for (int i = 0; i < listaTemp.size(); i++)
			if (listaTemp.get(i).compareTo("Olga")==0)
				listaTemp.remove(i);
		printList(listaTemp);

		listaTemp=(ArrayList<String>)lista.clone();
		ListIterator<String> it = listaTemp.listIterator();
		String e;
		while(it.hasNext()) {
			e=it.next();
			if (e.compareTo("Olga")==0)
				it.remove();
		}
		printList(listaTemp);
	}
}
