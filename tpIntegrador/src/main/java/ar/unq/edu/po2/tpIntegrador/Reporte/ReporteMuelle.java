package ar.unq.edu.po2.tpIntegrador.Reporte;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;

public class ReporteMuelle implements Reporte{

	@Override
	public String generarReportePara(Buque buque) {
		return buque.aceptarReporte(this);
	}

	@Override
	public String visitar(Buque buque) {
		String reporte = "Nombre del buque: " + buque.getNombre() + "\n" +
						  "Fecha de arribo: " + buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "\n" +
						  "Fecha de partida: " + buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "\n" +
						  "Cantidad de containers operados: " + buque.getContainersOperados().size();
		return reporte;
	}

}
