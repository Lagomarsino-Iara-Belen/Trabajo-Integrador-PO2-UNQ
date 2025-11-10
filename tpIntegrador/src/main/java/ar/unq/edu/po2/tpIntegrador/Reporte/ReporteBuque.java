package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;
import java.util.stream.Collectors;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public class ReporteBuque implements Reporte {

	@Override
	public String generarReportePara(Buque buque, List<Orden> list) {
		
		String importaciones = list.stream().filter(ord -> ord instanceof OrdenDeImportacion)
				 							.map(ord -> ord.aceptarReporte(this))
				 							.collect(Collectors.joining());
		
		String exportaciones = list.stream().filter(ord -> ord instanceof OrdenDeExportacion)
				 							.map(ord -> ord.aceptarReporte(this))
				 							.collect(Collectors.joining());
		
		return "<report> \n <import> \n" + importaciones + "</import> \n" +
						   "<export> \n" + exportaciones + "</import> \n </report>";
	}

	@Override
	public String visitar(Buque buque) {
		return "";
	}

	@Override
	public String visitar(OrdenDeExportacion orden) {
		return "<item>"+ orden.getContainer().getId() + "</item> \n";
	}

	@Override
	public String visitar(OrdenDeImportacion orden) {
		return "<item>"+ orden.getContainer().getId() + "</item> \n";
	}
}
