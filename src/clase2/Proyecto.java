package clase2;

public class Proyecto {
	private String nombre;
	private double[] horasMes = new double[12];
	
	
	public Proyecto(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double[] getHorasMeses() {
		return horasMes;
	}
	public void setHorasMeses(double[] horasMes) {
		this.horasMes = horasMes;
	}
	
	public void setHoraMes(int mes, double horas) {
		if (mes>=0 && mes<=12) {
			horasMes[mes] = horas;
		}
	}

	public double getHorasMes(String mes) {
		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int i = -1;
		while (++i<12 && meses[i].compareTo(mes) != 0);
		return (i<12)? horasMes[i] : -1;
	}
	
	public double getHorasMes(int numMes) {
		return (numMes>=0 && numMes<=12)? horasMes[numMes]: -1;
	}
	
	public double totalHoras() {
		double horas = 0;

		for (int i = 0; i < 12; i++) {
			horas += horasMes[i];
		}
		
		return horas;
	}
}
