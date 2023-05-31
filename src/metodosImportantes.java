

public class metodosImportantes {
	/*
	public Usuario addUsuario(String nombre, String CC, String telefono) {
		Usuario usuario = new Usuario(nombre, CC, telefono);
		
		usuarios = Arrays.copyOf(usuarios, usuarios.length+1);
		usuarios[usuarios.length-1] = usuario;
		
		return usuario;
	}
	*/
	
	/*
	public void eliminar(int indexParaBorrar) {
		System.arraycopy(trabajadores, index+1, trabajadores, index, trabajadores.length-index-1);
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length-1);
	}
	*/
	
	/*
	public int buscarLibroCodigo(String codigo) {
		int i = -1;
		while (++i<libros.length && libros[i].getCodigo().toLowerCase().compareTo(codigo.toLowerCase()) != 0);

		return (i<libros.length)? i : -1;
	}
	*/
	
	/*
	public void writeEstudiantes(String fichero) throws IOException {
		File f = new File(fichero);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);
		for (Estudiante est : listaEstudiantes) {
			b.write(est.getNombre());b.newLine();
			b.write(est.getCc());b.newLine();
			b.write(Integer.toString(est.getEdad()));b.newLine();
		}		
		b.close();
		fr.close();
	}
	*/
	
	/*
	public Estudiante[] readEstudiantes(String fichero) throws IOException {
		File f = new File(fichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		Estudiante[] listaEstudiantes = new Estudiante[0];
		
		while((linea=b.readLine()) != null) {
			String nombre = linea;
			String cedula = b.readLine();
			int edad = Integer.parseInt(b.readLine());
			Estudiante e = new Estudiante(nombre, cedula, edad);
			listaEstudiantes = Arrays.copyOf(listaEstudiantes, listaEstudiantes.length+1);
			listaEstudiantes[listaEstudiantes.length-1] = e;			
		}
		
		b.close();
		fr.close();
		this.listaEstudiantes = listaEstudiantes;
		
		return listaEstudiantes;
	}
	*/
}
