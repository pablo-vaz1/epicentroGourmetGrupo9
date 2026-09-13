package negocio;

import java.util.List;
import java.util.Set;

import dao.UnidadVentaDao;
import datos.CamionComida;
import datos.Empleado;
import datos.PuestoDesmontable;
import datos.UnidadVenta;


public class UnidadVentaABM {
	UnidadVentaDao dao = UnidadVentaDao.getInstance();
	public UnidadVenta traer(long idUnidadVenta) {
	return dao.traer(idUnidadVenta);
	}
	
	public int agregarPuestoDesmontable( String nombre, Double superficie, Set<Empleado> empleados,int cantidadCarpas, int tiempoInstalacion){
	
	
	PuestoDesmontable uv = new PuestoDesmontable(nombre, superficie, empleados,cantidadCarpas,tiempoInstalacion);
	return dao.agregar(uv);
	}
	
	public void modificar(PuestoDesmontable uv){
	
	dao.actualizar(uv);
	}
	
	public void modificarUnidadVenta(UnidadVenta uv){
		
	  dao.actualizar(uv);
	}
	
	public void modificarPuestoDesmontable(long idUnidadVenta, String nombreNuevo, Double superficieNuevo, Set<Empleado> empleadosNuevo,int cantidadCarpasNuevo,int tiempoInstalacionNuevo)throws Exception{
	    UnidadVenta UnidadVentaParaModificar=dao.traer(idUnidadVenta);
		if(UnidadVentaParaModificar == null) {
			throw new Exception("esta unidad de venta no existe");
		}
		
		
		if(UnidadVentaParaModificar instanceof PuestoDesmontable) {
			throw new Exception("Esta unidad de venta no es un puesto desmontable");
		}
			PuestoDesmontable pd = (PuestoDesmontable)UnidadVentaParaModificar;
			pd.setNombre(nombreNuevo);
		    pd.setSuperficie(superficieNuevo);
		    pd.setEmpleados(empleadosNuevo);
			pd.setCantidadCarpas(cantidadCarpasNuevo);
			pd.setTiempoInstalacion(tiempoInstalacionNuevo);
			dao.actualizar(pd);
		
		
		
	}
	
	public int agregarCamionComida( String nombre, Double superficie, Set<Empleado> empleados,String dominio, boolean usaElectrisidad ){
		
		
		CamionComida uv = new CamionComida(nombre, superficie, empleados,dominio,usaElectrisidad);
		return dao.agregar(uv);
		}
		public void modificar(CamionComida uv){
		
		dao.actualizar(uv);
		}
		public void modificarCamionComida(long idUnidadVenta, String nombreNuevo, Double superficieNuevo, Set<Empleado> empleadosNuevo,String dominioNuevo,boolean usaElectrisidadNuevo)throws Exception{
		    UnidadVenta UnidadVentaParaModificar=dao.traer(idUnidadVenta);
			if(UnidadVentaParaModificar == null) {
				throw new Exception("esta unidad de venta no existe");
			}
			
			
			if(!(UnidadVentaParaModificar instanceof CamionComida)) {
				throw new Exception("Esta unidad de venta no es un camion de comidas");
			}
				CamionComida cc = (CamionComida)UnidadVentaParaModificar;
				cc.setNombre(nombreNuevo);
			    cc.setSuperficie(superficieNuevo);
			    cc.setEmpleados(empleadosNuevo);
				cc.setDominio(dominioNuevo);
				cc.setUsaElectrisidad(usaElectrisidadNuevo);
				dao.actualizar(cc);
			
			
			
		}
	public void eliminar(long idUnidadVenta) throws Exception {
	
		
	UnidadVenta uv = dao.traer(idUnidadVenta);
	
	if(uv==null) {
		throw new Exception("la unidad de venta no existe");
	}
	dao.eliminar(uv);
	}
	public List<UnidadVenta> traer() {
	return dao.traer();
	}
}
