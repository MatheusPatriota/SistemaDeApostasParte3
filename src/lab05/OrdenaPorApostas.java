package lab05;

import java.util.Comparator;

public class OrdenaPorApostas implements Comparator<Cenario> {

	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		
		if (arg0.getTotalDeApostas() == arg1.getTotalDeApostas()) {
			
			return arg0.getNumeracaoCenario() - arg1.getNumeracaoCenario();
		}
		return arg1.getTotalDeApostas() - arg0.getTotalDeApostas();
	}

}
