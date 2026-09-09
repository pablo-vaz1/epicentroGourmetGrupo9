package datos;

import java.time.LocalDate;

public class Cajero extends Empleado{
	private String turno;

	public Cajero() {
		super();
	}

	public Cajero( int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldo, boolean esEncargado, String turno) {
		super( dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldo, esEncargado);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return super.toString() + "Cajero [turno=" + turno + "]";
	}
	

}
