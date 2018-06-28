package lab05;


public class CenarioBonus extends Cenario {
	
	private int bonus;
	/**
	 * Construtor de Cenario bonus responsavel por iniciar a classe e seus atributos.
	 * 
	 * @param descricao - Descricao de um cenario possivel.
	 * @param bonus - bonus para incentivar apostas em determinado cenario.
	 */
	public CenarioBonus(String descricao, int bonus) {
		
		super(descricao);
		if (bonus <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		
		this.bonus = bonus;
		rateioCenario += bonus;
	}
	
	/**
	 * toString responsavel por padronizar a exibicao de CenarioBonus
	 * 
	 * @return - retorna uma string que representa CenarioBonus
	 */
	@Override
	public String toString() {
		
		return super.toString() + " - R$ " + bonus/100 + ",00";
	}
	
}
