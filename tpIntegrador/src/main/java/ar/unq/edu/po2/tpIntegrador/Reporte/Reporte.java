package ar.unq.edu.po2.tpIntegrador.Reporte;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;

public interface Reporte {

	public String generarReportePara(Buque buque, List<Orden> list);

	public void visitar(Buque buque);

	public void visitar(OrdenDeExportacion orden);

	public void visitar(OrdenDeImportacion orden);
}
