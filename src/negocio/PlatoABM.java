package negocio;

import java.util.List;
import dao.PlatoDao;
import datos.Plato;

public class PlatoABM {
	
		PlatoDao dao = new PlatoDao();
		public Plato traer(int idPlato) {
		return dao.traer(idPlato);
		}
		
		public int agregar(String nombre, float precio, float costoProduccion){
		Plato p = new Plato(nombre, precio, costoProduccion);
		return dao.agregar(p);
		}
		public void modificar(Plato p){
		
		dao.actualizar(p);
		}
		public void modificar(int idPlato , String nombreN, float precioN, float costoProduccionN)throws Exception{
		    Plato PlatoParaModificar=dao.traer(idPlato);
			if(PlatoParaModificar == null) {
				throw new Exception("el plato no existe");
			}
			PlatoParaModificar.setNombre(nombreN);
			PlatoParaModificar.setPrecio(precioN);
			PlatoParaModificar.setCostoProduccion(costoProduccionN);
			
			dao.actualizar(PlatoParaModificar);
		}
		public void eliminar(int idPlato) throws Exception {
		
			
		Plato p = dao.traer(idPlato);
		
		if(p==null) {
			throw new Exception("el plato no existe");
		}
		dao.eliminar(p);
		}
		public List<Plato> traer() {
		return dao.traer();
		}
}
