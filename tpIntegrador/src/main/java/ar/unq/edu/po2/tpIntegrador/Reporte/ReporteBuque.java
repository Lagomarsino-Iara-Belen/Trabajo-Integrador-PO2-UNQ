package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public class ReporteBuque implements Reporte {

	@Override
	public String generarReportePara(Buque buque, List<Orden> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitar(Buque buque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitar(OrdenDeExportacion orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitar(OrdenDeImportacion orden) {
		// TODO Auto-generated method stub
		return null;
	}
}
