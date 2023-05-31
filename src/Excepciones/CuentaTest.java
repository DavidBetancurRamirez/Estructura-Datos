package Excepciones;

public class CuentaTest {

	public static void main(String[] args) {
		Cuenta c = new Cuenta(200);
		try {
			c.depositar(200);
			System.out.println("El saldo es: "+c.getSaldo());
			c.extraer(300);
			System.out.println("El saldo es: "+c.getSaldo());
			c.extraer(500);
		} catch (EValorNegativo e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (EValorMayorSaldo e) {
			System.out.println(e.getMessage());
		}
	}

}
