package clase2;

public class principal {

	public static void main(String[] args) {
		Cuerpo c = new Cuerpo();
		c.setEspacio(100);
		c.setTiempo(15);
		double v = c.velocidad();
		System.out.println("Velocidad: "+v);
		
		Rectangulo r = new Rectangulo(10, 15);
		System.out.println("Area rectangulo: "+r.area());
		System.out.println("Perimetro rectangulo: "+r.perimetro());
		
		Triangulo t = new Triangulo(5,3,3);
		System.out.println("El area del triangulo es: "+t.area());
		System.out.println("El perimetro del triangulo es: "+t.perimetro());
		System.out.println("El triangulo es: "+t.clasificacion());
		
		double[] notas;
		Estudiante e1 = new Estudiante(notas=new double[]{4,3,5});
		Estudiante e2 = new Estudiante(notas=new double[]{5,1,3});
		Estudiante e3 = new Estudiante(notas=new double[]{2,5,4});
		
		Trabajador trabajador = new Trabajador("trabajador", 200);
		
		System.out.println("Cantidad de estudiantes: "+Estudiante.cantidadEstudiantes);
		
		Empresa globant = new Empresa();
		globant.addTrabajador("david", 800);
		globant.addTrabajador("frankenstein", 600);
		globant.addTrabajador("ana", 500);
		globant.addTrabajador("laura", 400);
		
		System.out.println("�frankenstein es empleado?: "+globant.buscar("laura"));
		
		System.out.println(e1.promedio());
		e1.calificacion();
		
		globant.asignarDias("david", 34);
		globant.asignarDias("frankenstein", 10);
		globant.asignarDias("ana", 15);
		globant.asignarDias("laura", 20);
		
		System.out.println("Salario mas bajo: "+globant.salarioMasBajo());
		System.out.println("Trabajador con salario mas bajo: "+globant.trabajadorSalarioMasBajo());
		
		globant.eliminarTrabajador("david");
		
		for (int i = 0; i < 20; i++) {
			globant.addProyecto("proyect"+(i+1));
		}
		
		
		System.out.println("\nHoras por proyecto:");
		System.out.print("[");
		for (int i = 0; i < globant.horasXProyecto().length; i++) {
			System.out.print(globant.horasXProyecto()[i]+", ");
		}
		System.out.println("]");
		
		
		System.out.println("\nHoras por mes:");
		String[] meses = {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"};
		
		System.out.print("\t\t");
		for (int j = 0; j < meses.length; j++) {
			System.out.print(meses[j]+"\t");
		}
		System.out.println("");
		
		for (int i = 0; i < globant.horasXMes().length; i++) {
			System.out.print(globant.getProyectos()[i].getNombre()+"\t");
			
			for (int j = 0; j < globant.horasXMes()[0].length; j++) {
				System.out.print(globant.horasXMes()[i][j]+"\t");
			}
			System.out.println("");
		}
		
		System.out.println("\nEl total de horas entre todos los proyectos es: "+globant.totalHoras());
	}

}
