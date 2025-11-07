package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public class ReporteMuelle implements Reporte{
	private String nombreBuque;
	private String fechaArribo;
	private String fechaPartida;
	private int cantOperados;
	

	@Override
	public String generarReportePara(Buque buque, List<Orden> list) {
		list.stream().forEach(ord -> ord.aceptarReporte(this));
		buque.aceptarReporte(this);
		
		String reporte = "Nombre del buque: " + this.nombreBuque + "\n" +
				  "Fecha de arribo: " + this.fechaArribo + "\n" +
				  "Fecha de partida: " + this.fechaPartida + "\n" +
				  "Cantidad de containers operados: " + this.cantOperados;
		return reporte;
	}

	@Override
	public void visitar(Buque buque) {
		nombreBuque = buque.getNombre();
		fechaArribo = buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString();
		fechaPartida = fechaArribo;
	}
	
	@Override
	public void visitar(OrdenDeImportacion orden) {
		cantOperados += 1;
	}
	
	@Override
	public void visitar(OrdenDeExportacion orden) {
		cantOperados += 1;
	}

}
