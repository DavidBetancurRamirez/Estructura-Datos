package clase2;

public class Calculadora {
	
	public static int mcd(int a, int b) {
		while (a!=b) {
			if (a>b) a-=b;
			else b-=a;
		}
		
		return a;
	}
	
	public static int factorial(int n){
		int f=1;
		
		for (int i=2; i<=n; i++) f*=i;
		
		return f;
	}
}
