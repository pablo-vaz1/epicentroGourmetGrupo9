package test;

import datos.Cocinero;
import datos.Empleado;
import datos.UnidadVenta;
import negocio.EmpleadoABM;
import negocio.UnidadVentaABM;

public class TestSueldosTotalesPorUnidad {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		UnidadVentaABM uniabm = new UnidadVentaABM();
		
		UnidadVenta uv = uniabm.traer(1L);

	    double totalSueldos = 0;
	    for (Empleado emp : uv.getEmpleados()) {
	        totalSueldos += emp.getSueldo();
	        
	        // Uso explícito de la relación de Herencia
	        if (emp instanceof Cocinero) {
	            Cocinero c = (Cocinero) emp;
	            totalSueldos += c.getPlusSalarial();
	        }
	    }

	    System.out.printf("Total en unidad de venta: $%.2f%n", totalSueldos);
	}

}
