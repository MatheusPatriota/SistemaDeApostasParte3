package lab05;

import java.util.Comparator;

public class OrdenaPorCadastro implements Comparator<Cenario>{

	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		
		return arg0.getNumeracaoCenario() - arg1.getNumeracaoCenario();
	}

}
