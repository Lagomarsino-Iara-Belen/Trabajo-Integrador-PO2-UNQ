package ar.unq.edu.po2.tpIntegrador.Terminal;

public class Or implements OperadorLogico {

	@Override
	public boolean combinarCriterios(boolean bool1, boolean bool2) {
		return bool1 || bool2;
	}

}
