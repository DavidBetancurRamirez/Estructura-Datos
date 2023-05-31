package Finales;

import java.util.*;

public class Permutaciones {
    int[][] permutMatriz;
    int count;
    
    public void calcularCombinacion(int[] lista) {
        int cantidadPermutaciones = factorial(lista.length);
        this.permutMatriz = new int[factorial(lista.length)][lista.length];
        boolean[] used = new boolean[lista.length];
        calcularCombinacion(lista, used, new int[lista.length], 0);
    }
    private void calcularCombinacion(int[] lista, boolean[] used, int[] currentCombination, int index) {
        if (index == lista.length) {
            permutMatriz[count++] = Arrays.copyOf(currentCombination, lista.length);
            return;
        }

        for (int i = 0; i < lista.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentCombination[index] = lista[i];
                calcularCombinacion(lista, used, currentCombination, index + 1);
                used[i] = false;
            }
        }
    }
    
    public static int factorial (int n) {
		if (n==1 || n==0)				
			return 1;
		else
			return n*factorial(n-1);
	}

      /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        String[] lineSplit=line.split(",");
        int[] l= new int[lineSplit.length];
        for (int i=0;i<lineSplit.length;i++)
            l[i]=Integer.parseInt(lineSplit[i]);    
        Permutaciones p=new Permutaciones();
        p.calcularCombinacion(l);
        for (int i=0;i<p.permutMatriz.length;i++){
			for (int j=0;j<p.permutMatriz[i].length;j++) {
				if (j!=0)
					System.out.print(",");
				System.out.print(p.permutMatriz[i][j]);
			}				
			System.out.println();
		}        

    }

}
