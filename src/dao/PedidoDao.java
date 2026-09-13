package dao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Pedido;
import datos.UnidadVenta;

public class PedidoDao {
	private static Session session;
	private Transaction tx;
	private void iniciaOperacion() throws HibernateException {
	session = HibernateUtil.getSessionFactory().openSession();
	tx = session.beginTransaction();
	}
	private void manejaExcepcion(HibernateException he) throws HibernateException {
	tx.rollback();
	throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	public int agregar(Pedido objeto) {
	int id = 0;
	try {
	iniciaOperacion();
	id = Integer.parseInt(session.save(objeto).toString());
	tx.commit();
	} catch (HibernateException he) {
	manejaExcepcion(he);
	} finally {
	session.close();
	}
	return id;
	}
	public void actualizar(Pedido objeto) {
	try {
	iniciaOperacion();
	session.update(objeto);
	tx.commit();
	} catch (HibernateException he) {
	manejaExcepcion(he);
	} finally {
	session.close();
	}
	}

	public void eliminar(Pedido objeto) {
	try {
	iniciaOperacion();
	session.delete(objeto);
	tx.commit();
	} catch (HibernateException he) {
	manejaExcepcion(he);
	} finally {
	session.close();
	}
	}
	public Pedido traer(long idPedido) {
		Pedido objeto = null;
	try {
	iniciaOperacion();
	objeto = (Pedido) session.get(Pedido.class, idPedido);
	} finally {
	session.close();
	}
	return objeto;
	}
	
	
	public List<Pedido> traer() {
	List<Pedido> lista = new ArrayList<Pedido>();
	try {
	iniciaOperacion();
	Query  query = session.createQuery("from Pedido");
	lista =(List<Pedido>) query.list();
	} finally { 
	session.close();
	}
	return lista;
	}
	
	 public double calcularGananciasPorUnidadYFechas(UnidadVenta unidadVenta, LocalDate fechaDesde, LocalDate fechaHasta) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Double totalGanancias = 0.0;
	        
	        try {
	            
	            String hql = "SELECT SUM(i.cantidad * (pl.precio - pl.costoProduccion)) " +
	                         "FROM Pedido p " +
	                         "JOIN p.items i " +
	                         "JOIN i.plato pl " +
	                         "WHERE p.unidadVenta = :unidadVenta " +
	                         "AND p.fecha BETWEEN :fechaDesde AND :fechaHasta";
	            
	            var query = session.createQuery(hql, Double.class)
	            .setParameter("unidadVenta", unidadVenta)
	            .setParameter("fechaDesde", fechaDesde)
	            .setParameter("fechaHasta", fechaHasta);
	            
	            totalGanancias = query.uniqueResult();
	            
	            if (totalGanancias == null) {
	                totalGanancias = 0.0;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        
	        return totalGanancias;
	    }
	}



