package prueba.tecnica.fachada;

import java.util.List;

import prueba.tecnica.entity.Estudiante;

public interface IEstudianteFachada {
	
	public Estudiante crearEstudiante(Estudiante estudiante) throws Exception;	
	
	public List<Estudiante> obtenerEstudiantes() throws Exception;
}
