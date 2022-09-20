package prueba.tecnica.fachadaImpl;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.entity.Estudiante;
import prueba.tecnica.fachada.IEstudianteFachada;
import prueba.tecnica.repository.IEstudianteDao;


@Service
public class EstudianteFachadaImpl implements IEstudianteFachada {
	
	@Autowired
	private IEstudianteDao estudianteDao;

	public Estudiante crearEstudiante(Estudiante estudiante) throws Exception {
		estudianteDao.save(estudiante);
		return estudiante;
	}

	public List<Estudiante> obtenerEstudiantes() throws Exception {
		return (List<Estudiante>) estudianteDao.findAll();
	}
	
}
