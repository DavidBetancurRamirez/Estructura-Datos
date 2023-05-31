package Ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Juan Perez", "100854326", 23);
		Estudiante e2 = new Estudiante("Ana Reyes", "100854328", 20);
		Estudiante e3 = new Estudiante("Jose Lopez", "100854325", 17);
		Estudiante[] lista = {e1,e2,e3};
		EjFicheroEstudiante listaEst1 = new EjFicheroEstudiante(lista);
		
		for (Estudiante e : listaEst1.getListaEstudiantes()) {
			System.out.println(e);
		}
		
		String fichero = "C:\\Users\\David\\Documents\\DAVID\\Universidad\\Semestre 3\\Estructura de datos\\Ficheros\\estudiantes.txt";
		
		try {
			listaEst1.writeEstudiantes(fichero);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos incompletos IOException");
		} catch (Exception e) {
			System.out.println("Datos incompletos");
		}
		
		EjFicheroEstudiante listaEst = new EjFicheroEstudiante();
		Estudiante[] estudiantes = null;
		
		try {
			estudiantes = listaEst.readEstudiantes(fichero);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos incompletos IOException");
		} catch (Exception e) {
			System.out.println("Datos incompletos");
		}
		
		System.out.println("___Lectura___");
		for (Estudiante est : listaEst.getListaEstudiantes()) {
			System.out.println(est);
		}
		
		String addres= "C:\\Users\\David\\Documents\\DAVID\\Universidad\\Semestre 3\\Estructura de datos\\Ficheros\\Estudiantes";
		EjFicheroEstudiante listaEst2 = new EjFicheroEstudiante();
		try {
			listaEst1.escribirEstudiantesObjeto(addres);
			listaEst2.leerTodosEstudiantesObjeto(addres);
			System.out.println();
			for (Estudiante e : listaEst2.getListaEstudiantes()) {
				System.out.println(e);
			}
		} catch (IOException e) {
			System.out.println("Problemas con fichero");
		} catch (ClassNotFoundException e) {
			System.out.println("No se puede convertir el objeto");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
