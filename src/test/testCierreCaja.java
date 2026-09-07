package test;

import negocio.PedidoABM;

public class testCierreCaja {

	public static void main(String[] args) {
		PedidoABM pedidoabm = new PedidoABM();
		double totalVentaCaja= pedidoabm.cierreCaja(2L);
		System.out.println("las ventas de esta caja fueron $"+ totalVentaCaja);
		

	}

}
