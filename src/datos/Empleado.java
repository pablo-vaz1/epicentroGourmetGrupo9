package datos;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Empleado {
private long idEmpleado;
private int dni;
private String nombre;
private String apellido;
private LocalDate fechaNacimiento;
private LocalDate fechaIngreso;
private float sueldo;
private boolean esEncargado;
private long puestoDondeTrabaja;
     public Empleado() {
     }
	 public Empleado( int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldo, boolean esEncargado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldo = sueldo;
		this.esEncargado = esEncargado;
	 }
	 public long getIdEmpleado() {
		 return idEmpleado;
	 }
	 protected void setIdEmpleado(long idEmpleado) {
		 this.idEmpleado = idEmpleado;
	 }
	 public int getDni() {
		 return dni;
	 }
	 public void setDni(int dni) {
		 this.dni = dni;
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
	 public LocalDate getFechaNacimiento() {
		 return fechaNacimiento;
	 }
	 public void setFechaNacimiento(LocalDate fechaNacimiento) {
		 this.fechaNacimiento = fechaNacimiento;
	 }
	 public LocalDate getFechaIngreso() {
		 return fechaIngreso;
	 }
	 public void setFechaIngreso(LocalDate fechaIngreso) {
		 this.fechaIngreso = fechaIngreso;
	 }
	 public float getSueldo() {
		 return sueldo;
	 }
	 public void setSueldo(float sueldo) {
		 this.sueldo = sueldo;
	 }
	 public boolean isEsEncargado() {
		 return esEncargado;
	 }
	 public void setEsEncargado(boolean esEncargado) {
		 this.esEncargado = esEncargado;
	 }
	 public long getPuestoDondeTrabaja() {
		 return puestoDondeTrabaja;
	 }
	 public void setPuestoDondeTrabaja(long puestoDondeTrabaja) {
		 this.puestoDondeTrabaja = puestoDondeTrabaja;
	 }
	 
	 
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Empleado empleado = (Empleado) o;
	        return idEmpleado == empleado.idEmpleado; // O compara por dni si idEmpleado es 0 antes de guardar
	    }

	  @Override
	    public int hashCode() {
	        return Objects.hash(idEmpleado);
	    }
	 
	 @Override
	 public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldo=" + sueldo
				+ ", esEncargado=" + esEncargado + ", puestoDondeTrabaja=" + puestoDondeTrabaja + "]";
	 }
	 
     


}
