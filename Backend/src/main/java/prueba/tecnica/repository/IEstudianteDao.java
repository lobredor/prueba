package prueba.tecnica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prueba.tecnica.entity.Estudiante;

@Repository
public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {

	
}