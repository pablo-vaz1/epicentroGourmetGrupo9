package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.EmpleadoDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;

public class EmpleadoABM {
	EmpleadoDao dao = EmpleadoDao.getInstance();
	public Empleado traer(long idEmpleado) {
	return dao.traer(idEmpleado);
	}
	
	public int agregarCajero(int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldo, boolean esEncargado,String turno){
	
	
	Cajero c = new Cajero(dni,nombre, apellido, fechaNacimiento,fechaIngreso,sueldo,esEncargado,turno);
	return dao.agregar(c);
	}
	public void modificar(Cajero c){
	
	dao.actualizar(c);
	}
	public void modificarCajero(long idEmpleado,int dniN, String nombreN, String apellidoN, LocalDate fechaNacimientoN,
			LocalDate fechaIngresoN, float sueldoN, boolean esEncargadoN,String turnoN)throws Exception{
	    Empleado empleadoParaModificar=dao.traer(idEmpleado);
		if(empleadoParaModificar == null) {
			throw new Exception("este empleado no existe");
		}
		
		
		if(!(empleadoParaModificar instanceof Cajero)) {
			throw new Exception("Este empleado no es cajero");
		}
			Cajero c = (Cajero)empleadoParaModificar;
			c.setDni(dniN);
		    c.setNombre(nombreN);
		    c.setApellido(apellidoN);
		    c.setFechaNacimiento(fechaNacimientoN);
		    c.setFechaIngreso(fechaIngresoN);
		    c.setSueldo(sueldoN);
		    c.setEsEncargado(esEncargadoN);
		    c.setTurno(turnoN);
		    
			dao.actualizar(c);
		
		
		
	}
	
	public int agregarCocinero(int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldo, boolean esEncargado, String especialidad,
			float plusSalarial){
	
	
	Cocinero c = new Cocinero(dni,nombre, apellido, fechaNacimiento,fechaIngreso,sueldo,esEncargado, especialidad,
			 plusSalarial);
	return dao.agregar(c);
	}
	public void modificar(Cocinero c){
	
	dao.actualizar(c);
	}
	public void modificarCocinero(long idEmpleado,int dniN, String nombreN, String apellidoN, LocalDate fechaNacimientoN,
			LocalDate fechaIngresoN, float sueldoN, boolean esEncargadoN,String especialidadN,
			float plusSalarialN)throws Exception{
	    Empleado EmpleadoParaModificar=dao.traer(idEmpleado);
		if(EmpleadoParaModificar == null) {
			throw new Exception("este empleado no existe");
		}
		
		
		if(!(EmpleadoParaModificar instanceof Cocinero)) {
			throw new Exception("Este empleado no es cocinero");
		}
			Cocinero c = (Cocinero)EmpleadoParaModificar;
			c.setDni(dniN);
		    c.setNombre(nombreN);
		    c.setApellido(apellidoN);
		    c.setFechaNacimiento(fechaNacimientoN);
		    c.setFechaIngreso(fechaIngresoN);
		    c.setSueldo(sueldoN);
		    c.setEsEncargado(esEncargadoN);
		    c.setEspecialidad(especialidadN);
		    c.setPlusSalarial(plusSalarialN);
		    
			dao.actualizar(c);
		
		
		
	}		
		
		
	public void eliminar(long idEmpleado) throws Exception {
	
		
	Empleado e = dao.traer(idEmpleado);
	
	if(e==null) {
		throw new Exception("este empleado no existe");
	}
	dao.eliminar(e);
	}
	public List<Empleado> traer() {
	return dao.traer();
	}
	
	public void asignarUnidadVenta(long idEmpleado, long idUnidadVenta) {
		
		dao.asignarUnidadVenta(idEmpleado, idUnidadVenta);
		
	}

}
