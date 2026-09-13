package test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.HibernateUtil;
import datos.CamionComida;
import datos.Empleado;
import datos.Cajero;
import datos.Plato;
import negocio.EmpleadoABM;
import negocio.PedidoABM;

public class TestPedido {

	public static void main(String[] args) { 
        CamionComida camion = null;
        Plato hamburguesa = null;
        Plato papas = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Crear Cajero
            Cajero cajero = new Cajero();
            cajero.setNombre("toto");
            session.persist(cajero);
            EmpleadoABM empleadoAbm= new EmpleadoABM();
            empleadoAbm.agregarCajero(28000000, "pablo", "vazquez",LocalDate.of(1981,4,4),LocalDate.of(2015,6,6),80000f, false, 1, "noche");

            // Guardar al cajero en el conjunto de empleados del camión
            Set<Empleado> listaEmpleados = new HashSet<>();
            listaEmpleados.add(cajero);

            // Crear la Unidad de Venta concreta
            camion = new CamionComida();
            camion.setNombre("Food Truck Plaza Norte");
            camion.setSuperficie(11.5);
            camion.setEmpleados(listaEmpleados);
            session.persist(camion);

            // Crear el menú disponible
            hamburguesa = new Plato("Hamburguesa simple", 5000f, 1400f);
            papas = new Plato("Papas", 25000f, 900f);
            session.persist(hamburguesa);
            session.persist(papas);

            tx.commit();
            System.out.println("datos en ls base\n");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("falló la carga de datos");
            e.printStackTrace();
            return; 
        } finally {
            session.close();
        }

        
        
        try {
           
            PedidoABM pedidoABM = new PedidoABM();

            Map<Plato, Integer> carritoCompras = new HashMap<>();
            carritoCompras.put(hamburguesa, 1); 
            carritoCompras.put(papas, 3);      

            
            long idPedidoGenerado = pedidoABM.tomarPedido(camion, carritoCompras);
            
            
            System.out.println(" Número de Pedido: " + idPedidoGenerado);
            System.out.println(" Fecha: " + LocalDate.now());
            System.out.println(" Unidad de venta: " + camion.getNombre());

        } catch (Exception e) {
            System.err.println("no se pudo tomar el pedido");
            e.printStackTrace();
        }
        
    	PedidoABM pedidoabm = new PedidoABM();
		double totalVentaCaja= pedidoabm.cierreCaja(1L);
		System.out.println("las ventas de esta caja fueron $"+ totalVentaCaja);
    }

}
