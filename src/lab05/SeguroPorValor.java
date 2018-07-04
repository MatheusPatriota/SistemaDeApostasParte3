package lab05;

public class SeguroPorValor extends Seguro{
	
	private int valorDoSeguro;
	private int custo;
	
	/**
	 * classe filha responsavel por armazenar aposta assegurado por uma valor.
	 * 
	 * @param apostador - Nome do apostador.
	 * @param valor - Valor a ser apostado.
	 * @param previsao - Previsao se o cenario ira acontecer ou nao.
	 * @param valorDoSeguro - Valor a ser restituido ao apostador caso ele perca a aposta.
	 */
	public SeguroPorValor(String apostador, int valor, String previsao, int valorDoSeguro) {
		super(apostador, valorDoSeguro, previsao);
		this.valorDoSeguro = valorDoSeguro;
	}
	
	public int getCusto() {
		return custo;
	}
	
	public int getValorDoResgate() {
		return valorDoSeguro;
	}
	
	public void setValorDoResgate(int valorDoResgate) {
		this.valorDoSeguro = valorDoResgate;
	}
	
	/**
	 * toString resposavel por exibir os valores de um seguro por valor.
	 * 
	 * @return - retorna uma String que representa os valores da aposta assegurada por valor.
	 */
	@Override
	public String toString() {

		return super.toString() + " - "  + "ASSEGURADO(VALOR) - R$" + valorDoSeguro;
	}
}