package clase2;

public class Cuerpo {
	private double espacio, tiempo;

	public double getEspacio() {
		return espacio;
	}
	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}

	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public double velocidad() {
		return espacio / tiempo;
	}
}
