package datos;

import java.util.HashSet;
import java.util.Set;

public abstract class UnidadVenta {
	private long idUnidadVenta;
	private String nombre;
	private Double superficie;
	private Set<Empleado> empleados = new HashSet();
	
	
	public UnidadVenta() {
	}


	public UnidadVenta( String nombre, Double superficie, Set<Empleado> empleados) {
		super();
		this.nombre = nombre;
		this.superficie = superficie;
		this.empleados = empleados;
	}

	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}


	protected void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}


	public Set<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados.clear();
		if(empleados != null) {
			this.empleados.addAll(empleados);
	     }

	}


	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombre=" + nombre + ", superficie=" + superficie
				+ "]";
	}
	
	

}
