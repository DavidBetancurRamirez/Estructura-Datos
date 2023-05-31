package clase2;

public class Triangulo {
	private double lado1, lado2, lado3;

	public double getLado1() {
		return lado1;
	}
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public double getLado3() {
		return lado3;
	}
	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	public Triangulo(double lado1, double lado2, double lado3) {
		restriccion(lado1, lado2, lado3);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	
	public void restriccion(double a, double b, double c) {
		if ((a<b+c) && (b<a+c) && (c<a+b)) {
			System.out.println("El triangulo se creo exitosamente");
		} else {
			System.out.println("No es posible crear un triangulo con estas longitudes");
		}
	}
	
	public double area() {
		double s = perimetro()/2;
		double area = Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));	
		
		return area;
	}
	
	public double perimetro() {
		return lado1 + lado2 + lado3;
	}
	
	public char clasificacion() {
		return (lado1==lado2 && lado1==lado3) ? 'q' : (lado1==lado2 || lado1==lado3 || lado2==lado3) ? 'i' : 'e';
	}
}
