package datos;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	private String especialidad;
	private float plusSalarial;
	public Cocinero() {
		super();
	}
	public Cocinero(int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldo, boolean esEncargado, String especialidad,
			float plusSalarial) {
		super( dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldo, esEncargado);
		this.especialidad = especialidad;
		this.plusSalarial = plusSalarial;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public float getPlusSalarial() {
		return plusSalarial;
	}
	public void setPlusSalarial(float plusSalarial) {
		this.plusSalarial = plusSalarial;
	}
	@Override
	public String toString() {
		return super.toString() + "Cocinero [especialidad=" + especialidad + ", plusSalarial=" + plusSalarial + "]";
	}
	

}
