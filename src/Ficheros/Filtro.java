package Ficheros;

import java.io.File;
import java.io.FilenameFilter;

public class Filtro implements FilenameFilter {
	private String extension;

	public Filtro(String extension) {
		super();
		this.extension = extension;
	}

	@Override
	public boolean accept(File ruta, String file) {
		return file.endsWith(extension);
	}
}
