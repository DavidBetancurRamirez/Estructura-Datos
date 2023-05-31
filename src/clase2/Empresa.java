package clase2;

import java.util.Arrays;
import java.util.Random;

public class Empresa {
	private Trabajador[] trabajadores;
	private Proyecto[] proyectos;
	
	public Proyecto[] getProyectos() {
		return proyectos;
	}


	public Empresa() {
		trabajadores = new Trabajador[0];
		proyectos = new Proyecto[0];
	}
	

	public void addProyecto(String nombre) {
		proyectos = Arrays.copyOf(proyectos, proyectos.length+1);
		proyectos[proyectos.length-1] = new Proyecto(nombre); 
	}
	
	public void addTrabajador(String nombre, double salarioBasico) {
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length+1);
		trabajadores[trabajadores.length-1] = new Trabajador(nombre, salarioBasico); 
	}
	
	public void addTrabajador(String nombre) {
		Proyecto proyecto = new Proyecto(nombre);
		Random numAleatorio = new Random();

		for (int j = 0; j < 12; j++) {
			proyecto.setHoraMes(j, numAleatorio.nextInt(160-20+1)+20);
		}
		
		proyectos = Arrays.copyOf(proyectos, proyectos.length+1);
		proyectos[proyectos.length-1] = proyecto; 
	}
	
	public int buscar(String nombre) {
		int i = -1;
		while (++i<trabajadores.length && trabajadores[i].getNombre().compareTo(nombre) != 0);
		return (i<trabajadores.length)? i:-1;
	}
	
	public void asignarDias(String nombre, int dias) {
		int index = buscar(nombre);
		
		if (index != -1) {
			trabajadores[index].setDiasTrabajados(dias);
		}
	}
	
	public double salarioMasBajo() {
		double salarioMasBajo = Double.POSITIVE_INFINITY;
		for (int i = 0; i < trabajadores.length; i++) {
			double salario = trabajadores[i].calcularSalario();
			
			if (salario<salarioMasBajo) salarioMasBajo = salario;
		}
		
		return salarioMasBajo;
	}
	
	public int trabajadorSalarioMasBajo() {
		double salarioMasBajo = Double.POSITIVE_INFINITY;
		int index = -1;
		
		for (int i = 0; i < trabajadores.length; i++) {
			double salario = trabajadores[i].calcularSalario();
			
			if (salario<salarioMasBajo && salario!=0) {
				salarioMasBajo = salario;
				index = i;
			}
		}
		
		return index;
	}
	
	public void eliminarTrabajador(String nombre) {
		int index = buscar(nombre);
		
		if (index!=-1) {
			System.arraycopy(trabajadores, index+1, trabajadores, index, trabajadores.length-index-1);
			trabajadores = Arrays.copyOf(trabajadores, trabajadores.length-1);
		}
	}
	
	public double[] horasXProyecto() {
		double[] horasP = new double[proyectos.length];
		
		for (int i = 0; i < horasP.length; i++) {
			horasP[i] = proyectos[i].totalHoras();
		}
		
		return horasP;
	}
	
	public double[][] horasXMes() {
		double[][] horasM = new double[proyectos.length][12];
		
		for (int i = 0; i < horasM.length; i++) {
			for (int j = 0; j < horasM[0].length; j++) {
				horasM[i][j] = proyectos[i].getHorasMes(j);
			}
		}
		
		return horasM;
	}
	
	public double totalHoras() {
		double totalHoras = 0;
		
		for (int i = 0; i < proyectos.length; i++) {
			totalHoras += proyectos[i].totalHoras();
		}
		
		return totalHoras;
	}
}
