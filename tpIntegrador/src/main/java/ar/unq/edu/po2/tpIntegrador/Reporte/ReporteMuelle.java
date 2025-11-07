package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public class ReporteMuelle implements Reporte{

	@Override
	public String generarReportePara(Buque buque, List<Orden> ordenes) {
		return buque.aceptarReporte(this) + "Cantidad de containers operados: " + ordenes.size();
	}

	@Override
	public String visitar(Buque buque) {
		String reporte = "Nombre del buque: " + buque.getNombre() + "\n" +
                		 "Fecha de arribo: " + buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "\n" +
                		 "Fecha de partida: " + buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "\n";
		return reporte;
	}
	
	@Override
	public String visitar(OrdenDeImportacion orden) {
		return "";
	}
	
	@Override
	public String visitar(OrdenDeExportacion orden) {
		return "";
	}

}
