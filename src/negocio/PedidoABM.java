package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import dao.PedidoDao;
import datos.Item;
import datos.Pedido;
import datos.UnidadVenta;
import datos.Plato;
public class PedidoABM {
	PedidoDao dao = new PedidoDao();
	public Pedido traer(long idPedido) {
	return dao.traer(idPedido);
	}
	
	public int agregar(LocalDate fecha, UnidadVenta unidadVenta, Set<Item> items){
	Pedido p = new Pedido(fecha, unidadVenta, items);
	return dao.agregar(p);
	}
	public void modificar(Pedido p){
	
	dao.actualizar(p);
	}
	public void modificar(long idPedido , LocalDate fechaN, UnidadVenta unidadVentaN, Set<Item> itemsN)throws Exception{
	    Pedido PedidoParaModificar=dao.traer(idPedido);
		if(PedidoParaModificar == null) {
			throw new Exception("el pedido no existe");
		}
		PedidoParaModificar.setFecha(fechaN);
		PedidoParaModificar.setUnidadVenta(unidadVentaN);
		PedidoParaModificar.setItems(itemsN);
		
		dao.actualizar(PedidoParaModificar);
	}
	public void eliminar(long idPedido) throws Exception {
	
		
	Pedido p = dao.traer(idPedido);
	
	if(p==null) {
		throw new Exception("el pedido no existe");
	}
	dao.eliminar(p);
	}
	public List<Pedido> traer() {
	return dao.traer();
	}
	
	
	
	
	
	public long tomarPedido(UnidadVenta unidadVenta, Map<Plato, Integer> platosYCantidades) throws Exception {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    long idGenerado = 0;

	    try {
	        tx = session.beginTransaction();
	        Set<Item> itemsPedido = new HashSet<>();
	        

	        for (Map.Entry<Plato, Integer> entrada : platosYCantidades.entrySet()) {
	            Plato plato = entrada.getKey();
	            int cantidad = entrada.getValue();

	            // idItem se genera automático, el constructor solo pide (cantidad, plato)
	            Item nuevoItem = new Item(cantidad, plato);
	            session.persist(nuevoItem);
	            itemsPedido.add(nuevoItem);
	        }
	        Pedido nuevoPedido = new Pedido(LocalDate.now(),unidadVenta,itemsPedido);
	        session.persist(nuevoPedido);
	        String sql = "UPDATE item SET idPedido = :idPedido WHERE idPedido IS NULL";
	        session.createNativeQuery(sql)
	               .setParameter("idPedido", nuevoPedido.getIdPedido())
	               .executeUpdate();
	        
	        tx.commit();
	        
	        // Acá ya tenés el ID real asignado automáticamente por tu BD
	        idGenerado = nuevoPedido.getIdPedido(); 

	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        throw new Exception("Error al tomar el pedido: " + e.getMessage(), e);
	    } finally {
	        session.close();
	    }
	    return idGenerado;
	}
	public double cierreCaja(long idUnidadVenta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Double totalVendido = 0.0;
		try {
			String hql = "SELECT SUM(i.cantidad * pl.precio)"
					   + "FROM Pedido p "
					   + "JOIN p.items i "
					   + "JOIN i.plato pl "
					   + "JOIN p.unidadVenta uv "
					   + "WHERE uv.idUnidadVenta = :idUnidadVenta";
			totalVendido = session.createQuery(hql, Double.class)
					              .setParameter("idUnidadVenta", idUnidadVenta)
					              .uniqueResult();
			if(totalVendido == null) {
				totalVendido=-1.0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalVendido;
	}
}
