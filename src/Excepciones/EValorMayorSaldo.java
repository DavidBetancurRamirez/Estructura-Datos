package Excepciones;

public class EValorMayorSaldo extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EValorMayorSaldo() {
		super("El valor solicitado excede al saldo");
	}
}
