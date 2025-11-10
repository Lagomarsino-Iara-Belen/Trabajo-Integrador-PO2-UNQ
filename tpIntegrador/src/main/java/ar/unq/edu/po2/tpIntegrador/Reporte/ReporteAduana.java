package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;
import java.util.stream.Collectors;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public class ReporteAduana implements Reporte {

	@Override
	public String generarReportePara(Buque buque, List<Orden> ordenes) {
		return buque.aceptarReporte(this);
	}

	@Override
	public String visitar(Buque buque) {
		String reporte = "<html> \n <head> \n <title> Reporte de Aduana </title> \n </head> \n <body> \n"
					   + "<p> Nombre del buque: "+ buque.getNombre() + "</p> \n"
					   + "<p> fecha de arribo: "+ buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "</p> \n"
					   + "<p> fecha de partida: "+ buque.getViaje().fechaDeParada(buque.getViaje().getParadaActual()).toString() + "</p> \n"
					   + "<p> los containers en el buque son: </p> \n"
					   +  "<ul> \n" + this.listaContainer(buque) +"</ul> \n </body> \n </html>";
		
		return reporte;
	}
	
	private String listaContainer(Buque buque) {
		String lista = ""; //de esta forma inicializo el string (neutro).
		for(Container cont : buque.getContainers()) {
			lista += "<li> ID: " + cont.getId() + " tiene los productos: " 
								+ cont.getContenido().getTipoProducto().stream().collect(Collectors.joining(", "))
								+ "</li> \n";
		}
		return lista;
	}

	@Override
	public String visitar(OrdenDeExportacion orden) {
		return "";
	}

	@Override
	public String visitar(OrdenDeImportacion orden) {
		return "";
	}
}
