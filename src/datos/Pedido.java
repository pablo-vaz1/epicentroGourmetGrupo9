package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
	private long idPedido;
	private LocalDate fecha;
	private UnidadVenta unidadVenta;
	private Festival festival;
	private Set<Item> items = new HashSet<Item>();

	public Pedido() {
	}

	public Pedido(long idPedido, LocalDate fecha, UnidadVenta unidadVenta, Festival festival, Set<Item> items) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.unidadVenta = unidadVenta;
		this.festival = festival;
		this.items = items;
	}

	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items.clear();
		if (items != null) {
			this.items.addAll(items);
		}
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", unidadVenta=" + unidadVenta + ", festival="
				+ festival + "]";
	}

}
