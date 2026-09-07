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

	public static void main(String[] args) {  // Usamos variables para guardar los objetos maestros creados
        CamionComida camion = null;
        Plato hamburguesa = null;
        Plato papas = null;

        System.out.println("=== ETAPA 1: Preparación y Carga de Datos Maestros ===");
        
        // 1. Abrimos sesión para inyectar los datos iniciales necesarios en la BD
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Crear y persistir un Cajero
            Cajero cajero = new Cajero();
            cajero.setNombre("toto");
            session.persist(cajero);
            EmpleadoABM empleadoAbm= new EmpleadoABM();
            empleadoAbm.agregarCajero(28000000, "pablo", "vazquez",LocalDate.of(1981,4,4),LocalDate.of(2015,6,6),80000f, false, 1, "noche");

            // Guardar al cajero en el conjunto de empleados del camión
            Set<Empleado> listaEmpleados = new HashSet<>();
            listaEmpleados.add(cajero);

            // Crear y persistir la Unidad de Venta concreta
            camion = new CamionComida();
            camion.setNombre("Food Truck Plaza Norte");
            camion.setSuperficie(11.5);
            camion.setEmpleados(listaEmpleados);
            session.persist(camion);

            // Crear y persistir el menú disponible (Platos)
            hamburguesa = new Plato("Hamburguesa simple", 5000f, 1400f);
            papas = new Plato("Papas", 25000f, 900f);
            session.persist(hamburguesa);
            session.persist(papas);

            tx.commit();
            System.out.println("[OK] Datos maestros creados con éxito con IDs automáticos.\n");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[ERROR] Falló la carga inicial de datos maestros:");
            e.printStackTrace();
            return; // Interrumpimos si no pudimos crear la base del test
        } finally {
            session.close();
        }

        System.out.println("=== ETAPA 2: Ejecución de la Función Tomar Pedido ===");
        
        try {
            // 2. Instanciamos el componente de negocio ABM que acabás de programar
            PedidoABM pedidoABM = new PedidoABM();

            // 3. Simulamos el carrito de compras del cliente usando un mapa (Plato -> Cantidad)
            Map<Plato, Integer> carritoCompras = new HashMap<>();
            carritoCompras.put(hamburguesa, 1); // El cliente pide 2 hamburguesas
            carritoCompras.put(papas, 3);       // El cliente pide 1 porción de papas

            // 4. Invocamos la función de negocio pasándole la unidad de venta y el carrito
            System.out.println("Enviando orden a PedidoABM...");
            long idPedidoGenerado = pedidoABM.tomarPedido(camion, carritoCompras);
            
            System.out.println("\n[ÉXITO TOTAL]");
            System.out.println("-> Número de Pedido asignado automáticamente por BD: " + idPedidoGenerado);
            System.out.println("-> Fecha del registro: " + LocalDate.now());
            System.out.println("-> Despachado en: " + camion.getNombre());

        } catch (Exception e) {
            System.err.println("[ERROR] Error crítico al ejecutar la función tomarPedido:");
            e.printStackTrace();
        }
        
    	PedidoABM pedidoabm = new PedidoABM();
		double totalVentaCaja= pedidoabm.cierreCaja(1L);
		System.out.println("las ventas de esta caja fueron $"+ totalVentaCaja);
    }

}
