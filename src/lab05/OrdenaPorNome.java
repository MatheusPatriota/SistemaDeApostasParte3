package lab05;

import java.util.Comparator;

public class OrdenaPorNome implements Comparator<Cenario> {

	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		
		if (arg0.getDescricao() == arg1.getDescricao()) {
			
			return arg0.getNumeracaoCenario() - arg1.getNumeracaoCenario();
		}
		
		return arg0.getDescricao().compareTo(arg1.getDescricao());
	}

}
