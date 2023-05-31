package Estructuras;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Expresiones {
	public static void main(String[] args) {
		System.out.println(parentesis("Hola (saludar)"));
		System.out.println("A * B + C * D");
		System.out.println(infixToPostfix("A * B + C * D"));
		System.out.println("( A + B ) * C - ( D - E ) * ( F + G )");
        System.out.println(infixToPostfix("( A + B ) * C - ( D - E ) * ( F + G )"));
        try {
        	System.out.println(parentesisExcepcion("(a+b))((c*4)))(x"));			
		} catch (ExcepcionParentesis e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static boolean parentesis(String s) {
		Stack<Character> parentesis = new Stack<Character>();
		char c;
		int i = 0;
		boolean salir = false;
		
		while (i < s.length() && !salir) {
			c = s.charAt(i);
			if (c=='(') 
				parentesis.push(c);
			else if (c==')')
				if (parentesis.size()==0)
					salir = true;
				else
					parentesis.pop();
			i++;
		}
		
		return parentesis.isEmpty();
	}
	
	public static boolean parentesisExcepcion(String s) throws ExcepcionParentesis {
		Stack<Integer> parentesis = new Stack<Integer>();
		Queue<Integer> errores = new LinkedList<Integer>();
		char c;
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c=='(') 
				parentesis.push(i);
			else if (c==')')
				if (parentesis.isEmpty())
					errores.add(i);
				else
					parentesis.pop();
		}
		
		if (!parentesis.isEmpty()) {
			for (int i = 0; i < parentesis.size(); i++) {
				errores.add(parentesis.pop());				
			}
			String posiciones = "[";
			while(!errores.isEmpty())
				posiciones += errores.poll()+",";
			posiciones += "]";
			throw new ExcepcionParentesis(posiciones);
		}
		
		return true;
	}
	
	public static String infixToPostfix(String operacion) {
		Map<String, Integer> prec = new HashMap<>();
        prec.put("*", 3);
        prec.put("/", 3);
        prec.put("+", 2);
        prec.put("-", 2);
        prec.put("(", 1);
        
        Stack<String> operadoresStack = new Stack<>();
        StringBuilder postfixList = new StringBuilder();
        String[] tokenList = operacion.split(" ");

        for (String token : tokenList) {
            if (token.matches("[A-Z0-9]+")) {
                postfixList.append(token).append(" ");
            } else if (token.equals("(")) {
            	operadoresStack.push(token);
            } else if (token.equals(")")) {
                String topToken = operadoresStack.pop();
                while (!topToken.equals("(")) {
                    postfixList.append(topToken).append(" ");
                    topToken = operadoresStack.pop();
                }
            } else {
                while (!operadoresStack.isEmpty() && 
                        prec.get(operadoresStack.peek()) >= prec.get(token)) {
                    postfixList.append(operadoresStack.pop()).append(" ");
                }
                operadoresStack.push(token);
            }
        }

        while (!operadoresStack.isEmpty()) {
            postfixList.append(operadoresStack.pop()).append(" ");
        }

        return postfixList.toString().trim();
    }
}

class ExcepcionParentesis extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionParentesis(String posiciones) {
		super("ExcepcionParentesis: Error en las posiciones: "+posiciones);
	}
}