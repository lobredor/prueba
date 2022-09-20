package prueba.tecnica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prueba.tecnica.entity.Estudiante;
import prueba.tecnica.fachada.IEstudianteFachada;


@RestController
@RequestMapping("/escuela")
public class EstudianteController {
	
	@Autowired
	private IEstudianteFachada estudianteFachada;
	
	@PostMapping("/estudiante")
	public ResponseEntity<Estudiante> postCrearEstudiante(@RequestBody Estudiante est){
		try {
			Estudiante e = new Estudiante();
			e = estudianteFachada.crearEstudiante(est);
			return ResponseEntity.ok(e);
		} catch (Exception e) {
			Logger logger = Logger.getLogger(EstudianteController.class.getName());
			logger.log(Level.SEVERE,e.getMessage());
		}
		return null;
	}
	
	@GetMapping("/estudiantes")
	public List<Estudiante> obtenerEstudiantes(){
		List<Estudiante> list = new ArrayList<Estudiante>();
		try {
			return estudianteFachada.obtenerEstudiantes();
		} catch (Exception e) {
			Logger logger = Logger.getLogger(EstudianteController.class.getName());
			logger.log(Level.SEVERE,e.getMessage());
		}
		return list;
		
	}

}
