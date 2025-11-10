package ar.unq.edu.po2.tpIntegrador.Terminal;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class CriteriosCombinados implements CriterioDeRuta {
	
	private CriterioDeRuta criterioIzq;
	private CriterioDeRuta criterioDer;
	private OperadorLogico operador;
	
	public CriteriosCombinados(CriterioDeRuta criterio1, CriterioDeRuta criterio2, OperadorLogico operador) {
		criterioIzq = criterio1;
		criterioDer = criterio2;
		this.operador = operador;
	}

	@Override
	public boolean seCumplenQue(Viaje viaje, Terminal terminal) {
		
		return operador.combinarCriterios(criterioIzq.seCumplenQue(viaje, terminal), 
				     					  criterioDer.seCumplenQue(viaje, terminal));
	}

}
