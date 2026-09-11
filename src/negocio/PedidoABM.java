package negocio;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import dao.PedidoDao;
import datos.Festival;
import datos.Pedido;

public class PedidoABM {
	PedidoDao dao = new PedidoDao();

	public List<Pedido> traerPorFechaYTipoUnidad(LocalDate fechaDesde, LocalDate fechaHasta, String tipoUnidad,
			Festival festival) throws HibernateException {
		return dao.traerPorFechaYTipoUnidad(fechaDesde, fechaHasta, tipoUnidad, festival);
	}
}
