package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Festival {
	private long idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFin;
	private Set<Plato> platos = new HashSet<Plato>();

	public Festival() {
	}

	public Festival(String nombre, String temporada, LocalDate fechaDeInicio, LocalDate fechaDeFin, Set<Plato> platos) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
		this.platos = platos;
	}

	public long getIdFestival() {
		return idFestival;
	}

	protected void setIdFestival(long idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(LocalDate fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos.clear();
		if (platos != null) {
			this.platos.addAll(platos);
		}
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaDeInicio=" + fechaDeInicio + ", fechaDeFin=" + fechaDeFin + "]";
	}

}
