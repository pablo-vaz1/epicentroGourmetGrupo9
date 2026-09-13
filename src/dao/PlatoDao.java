package dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import datos.Plato;
public class PlatoDao {
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
	public int agregar(Plato objeto) {
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
	public void actualizar(Plato objeto) {
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

	public void eliminar(Plato objeto) {
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
	public Plato traer(int idPlato) {
		Plato objeto = null;
	try {
	iniciaOperacion();
	objeto = (Plato) session.get(Plato.class, idPlato);
	} finally {
	session.close();
	}
	return objeto;
	}
	
	
	public List<Plato> traer() {
	List<Plato> lista = new ArrayList<Plato>();
	try {
	iniciaOperacion();
	Query  query = session.createQuery("from Festival f");
	lista =(List<Plato>) query.list();
	} finally {
	session.close();
	}
	return lista;
	}
}
