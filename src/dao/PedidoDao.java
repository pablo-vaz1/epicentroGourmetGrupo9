package dao;

import org.hibernate.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Festival;
import datos.Item;
import datos.Pedido;

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
			Query query = session.createQuery("from Pedido");
			lista = (List<Pedido>) query.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Pedido> traerPorFechaYTipoUnidad(LocalDate fechaDesde, LocalDate fechaHasta, String tipoUnidad,
			Festival festival) throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			String hql = "select p from Pedido p join p.unidadVenta u where p.fecha between :fechaDesde and :fechaHasta and type(u) = "
					+ tipoUnidad + " and p.festival = :festival order by p.fecha asc";
			lista = session.createQuery(hql, Pedido.class).setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta).setParameter("festival", festival).getResultList();
			for (Pedido p : lista) {
				Hibernate.initialize(p.getItems());
				for (Item i : p.getItems()) {
					Hibernate.initialize(i.getPlato());
				}
			}
		} finally {
			session.close();
		}
		return lista;
	}
}
