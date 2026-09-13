package test;

import java.time.LocalDate;

import dao.UnidadVentaDao;
import datos.UnidadVenta;
import negocio.PedidoABM;

public class TestGanancias {

	public static void main(String[] args) {
		 PedidoABM pedidoABM = new PedidoABM();
	        
	        System.out.println("TEST DE GANANCIAS POR UNIDAD DE VENTA");

	        try {
	            // traemos la Unidad de Venta por id
	
	            long idUnidad = 1; 
	            
	          
	            UnidadVenta unidadVenta = UnidadVentaDao.getInstance().traer(idUnidad); 
	           
	            if (unidadVenta == null) {
	                System.out.println("no se encontro la unidad de venta con ID: " + idUnidad);
	                return;
	            }
	            
	    
	            System.out.println(" Unidad de Venta  " + unidadVenta.getNombre());

	           
	            LocalDate fechaDesde = LocalDate.of(2026, 1, 1);
	            LocalDate fechaHasta = LocalDate.of(2026, 12, 31);

	            
	            double gananciasTotales = pedidoABM.calcularGananciasUnidadVenta(unidadVenta, fechaDesde, fechaHasta);

	            System.out.printf(" \nlas ganancias del periodo fueron: $%.2f\n", gananciasTotales);
	            

	        } catch (Exception e) {
	            System.err.println("\nfallo en el testeo");
	            e.printStackTrace();
	        }
		

	}

}
