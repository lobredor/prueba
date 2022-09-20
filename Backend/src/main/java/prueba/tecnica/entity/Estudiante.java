package prueba.tecnica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESTUDIANTES")
public class Estudiante {
	
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="IDENTIFICACION", length = 30)
	private String identificacion;
	
	@Column(name="NOMBRE", length = 30)
	private String nombre;
	
	@Column(name="APELLIDO", length = 30)
	private String apellido;

	@Column(name="EDAD")
	private int edad;
	
	@Column(name="CARRERA")
	private String carrera;
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(String identificacion, String nombre, String apellido, int edad, String carrera) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.carrera = carrera;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}
