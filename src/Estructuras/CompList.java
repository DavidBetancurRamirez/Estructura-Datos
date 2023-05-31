package Estructuras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompList {

	public static void main(String[] args) {
		int N=10000000;
		Integer p2=10;
		
		
		// Lista
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			aList.add(i);
		}
		aList.add(p2);
		long inicio = System.currentTimeMillis();
		aList.remove(0);
		long fin = System.currentTimeMillis();
		long time=fin-inicio;
		System.out.println("ArrayList: "+time);
		

		// Lista
		LinkedList<Integer> lList = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			lList.add(i);
		}
		lList.add(p2);
		inicio = System.currentTimeMillis();
		lList.remove(0);
		fin = System.currentTimeMillis();
		time=fin-inicio;
		System.out.println("LinkedList: "+time);
		
		
		// Cola
		Queue<Integer> lQueue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			lQueue.add(i);
		}
		lQueue.add(p2);
		inicio = System.currentTimeMillis();
		lQueue.poll();
		fin = System.currentTimeMillis();
		time=fin-inicio;
		System.out.println("Queue: "+time);
		
		
		// Pila
		Stack<Integer> lStack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			lStack.push(i);
		}
		lStack.push(p2);
		inicio = System.currentTimeMillis();
		lStack.pop();
		fin = System.currentTimeMillis();
		time=fin-inicio;
		System.out.println("Stack: "+time);
	}

}
