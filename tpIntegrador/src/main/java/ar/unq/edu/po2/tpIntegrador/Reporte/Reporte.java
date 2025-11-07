package ar.unq.edu.po2.tpIntegrador.Reporte;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;

public interface Reporte {

	public String generarReportePara(Buque buque);

	public String visitar(Buque buque);
}
