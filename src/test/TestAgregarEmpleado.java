package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import negocio.EmpleadoABM;

public class TestAgregarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Inserción de Cocinero
        Cocinero cocinero = new Cocinero(111, "Gabriel", "Fernandez", LocalDate.of(2001, 3, 5),
        		LocalDate.of(2023, 4, 7), 500000.f, true, "Sushiman", 200000.f);
        
        EmpleadoABM eabm = new  EmpleadoABM();
        
        eabm.agregarCocinero(cocinero.getDni(),cocinero.getNombre(), cocinero.getApellido(), cocinero.getFechaNacimiento(),
        		cocinero.getFechaIngreso(), cocinero.getSueldo(), cocinero.isEsEncargado(),
        		cocinero.getEspecialidad(), cocinero.getPlusSalarial());
		
		
		//Insercion de Cajero
        Cajero cajero = new Cajero( 222, "Eduardo", "Gonzales", LocalDate.of(2002, 5, 7),
        		LocalDate.of(2022, 4, 7), 500000.f, true, "Tarde"); 
        
        eabm.agregarCajero(cajero.getDni(), cajero.getNombre(), cajero.getApellido(), cajero.getFechaNacimiento(),
        		cajero.getFechaIngreso(), cajero.getSueldo(), cajero.isEsEncargado(), cajero.getTurno());

	}

}
