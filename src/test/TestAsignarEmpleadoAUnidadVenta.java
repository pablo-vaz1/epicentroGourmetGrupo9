package test;

import datos.Empleado;
import datos.UnidadVenta;
import negocio.EmpleadoABM;
import negocio.UnidadVentaABM;

public class TestAsignarEmpleadoAUnidadVenta {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		UnidadVentaABM uniabm = new UnidadVentaABM();
		
		// 1. Traer la unidad de venta
		UnidadVenta uv = uniabm.traer(1L); 
	    if (uv == null) throw new Exception("Unidad de venta inexistente");
	    
	    // 2. Traer el empleado
	    EmpleadoABM empabm = new EmpleadoABM();
        Empleado emp = empabm.traer(1L);
        if (emp == null) {
            throw new Exception("El empleado especificado no existe.");
        }

        // 3. Agregar el empleado al Set de la Unidad de Venta
        uv.getEmpleados().add(emp);

        // 4. Guardar los cambios en la BD con Hibernate
        uniabm.modificarUnidadVenta(uv);
        
        // 5. Asignar el empleado a la Unidad de Venta
        empabm.asignarUnidadVenta(emp.getIdEmpleado(), uv.getIdUnidadVenta());
        
        Empleado emp2 = empabm.traer(2L);
        if (emp2 == null) {
            throw new Exception("El empleado especificado no existe.");
        }   
        
        uv.getEmpleados().add(emp2);
        
        empabm.asignarUnidadVenta(emp2.getIdEmpleado(), uv.getIdUnidadVenta());
        
        Empleado emp3 = empabm.traer(3L);
        if (emp3 == null) {
            throw new Exception("El empleado especificado no existe.");
        }   
        
        uv.getEmpleados().add(emp3);
        
        empabm.asignarUnidadVenta(emp3.getIdEmpleado(), uv.getIdUnidadVenta());
        
        Empleado emp4 = empabm.traer(4L);
        if (emp4 == null) {
            throw new Exception("El empleado especificado no existe.");
        }   
        
        uv.getEmpleados().add(emp4);
        
        empabm.asignarUnidadVenta(emp4.getIdEmpleado(), uv.getIdUnidadVenta());

	}

}
