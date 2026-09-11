package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.Item;
import datos.Pedido;
import datos.Plato;
import negocio.EmpleadoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestPedidosPorFechaYTipo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// Inserción de Cocinero
		/*Cocinero cocinero = new Cocinero(111, "Gabriel", "Fernandez", LocalDate.of(2001, 3, 5),
				LocalDate.of(2023, 4, 7), 500000.f, true, 2, "Sushiman", 200000.f);

		EmpleadoABM eabm = new  EmpleadoABM();

		eabm.agregarCocinero(cocinero.getDni(),cocinero.getNombre(), cocinero.getApellido(), cocinero.getFechaNacimiento(),
				cocinero.getFechaIngreso(), cocinero.getSueldo(), cocinero.isEsEncargado(), cocinero.getPuestoDondeTrabaja(),
				cocinero.getEspecialidad(), cocinero.getPlusSalarial());


		//Insercion de Cajero
		Cajero cajero = new Cajero( 222, "Eduardo", "Gonzales", LocalDate.of(2002, 5, 7),
				LocalDate.of(2022, 4, 7), 500000.f, true, 1, "Tarde");

		eabm.agregarCajero(cajero.getDni(), cajero.getNombre(), cajero.getApellido(), cajero.getFechaNacimiento(),
				cajero.getFechaIngreso(), cajero.getSueldo(), cajero.isEsEncargado(), cajero.getPuestoDondeTrabaja(),
				cajero.getTurno());*/

		//Insercion de Plato
		Plato plato = new Plato("Asado", 50000.f, 20000.f);

		PlatoABM pabm = new PlatoABM();

		pabm.agregar(plato.getNombre(), plato.getPrecio(), plato.getCostoProduccion());



		PedidoABM abm = new PedidoABM();
		FestivalABM festivalAbm = new FestivalABM();

		LocalDate fechaDesde = LocalDate.of(2026, 1, 1);
		LocalDate fechaHasta = LocalDate.of(2026, 12, 31);
		String tipoUnidad = "CamionComida";
		Festival festival = festivalAbm.traer(1);

		List<Pedido> lista = abm.traerPorFechaYTipoUnidad(fechaDesde, fechaHasta, tipoUnidad, festival);

		System.out.println("Pedidos entre " + fechaDesde + " y " + fechaHasta + " de tipo " + tipoUnidad
				+ " del festival " + festival.getNombre() + ":");
		for (Pedido p : lista) {
			System.out.println("Pedido " + p.getIdPedido() + " - fecha: " + p.getFecha());
			for (Item i : p.getItems()) {
				System.out.println("   Item: " + i.getCantidad() + " x " + i.getPlato().getNombre());
			}
		}

	}
}