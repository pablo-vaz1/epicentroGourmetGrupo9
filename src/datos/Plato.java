package datos;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precio;
	private float costoProduccion;
	public Plato() {
	
	}
	public Plato(String nombre, float precio, float costoProduccion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costoProduccion = costoProduccion;
	}
	public int getIdPlato() {
		return idPlato;
	}
	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costoProduccion="
				+ costoProduccion + "]";
	}
	
	
	

}
