package Estructuras;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CodMensaje {

	public static void main(String[] args) {
		String s = "S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE, VENTERGU";
		
		System.out.println(CodMensaje.codificar(s));
	}

	public static Queue<Character> stringQueue(String s) {
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++)
			q.add(s.charAt(i));
		return q;
	}
	
	public static String printStack(Stack<Character> s) {
		@SuppressWarnings("unchecked")
		Stack<Character> stemp = (Stack<Character>)s.clone();
		String result = "";
		while(!stemp.isEmpty())
			result += stemp.pop();
		return result;
	}
	
	public static String codificar(String mensaje) {
		Queue<Character> q = stringQueue(mensaje);
		Stack<Character> s = invNoVocales(q);
		return printStack(s);
	}
	
	public static Stack<Character> invNoVocales(Queue<Character> q) {
		String vocales = "aeiou";
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> pila = new Stack<Character>();
		
		while (!q.isEmpty()) {
			while (!q.isEmpty() && !vocales.contains(String.valueOf(q.peek()).toLowerCase()))
				pila.push(q.poll());
			// Copiar lo que esta en la pila de resultado
			while(!pila.isEmpty())
				stack.push(pila.pop());
			if (!q.isEmpty())
				stack.push(q.poll());
		}
		
		return stack;
	}
}
