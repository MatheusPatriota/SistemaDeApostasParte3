package lab05;

public abstract class Seguro {
	

	private String apostador;
	private int valor;
	private String previsao;
	
	/**
	 * Classe pai seguro responsavel por compartilhar codigo semelhante entre suas classes 
	 * filhas.
	 * 
	 * @param apostador - Nome do apostador.
	 * @param valor - valor da aposta.
	 * @param previsao - previsao da aposta.
	 */
	public Seguro(String apostador, int valor, String previsao) {
		this.valor = valor;
		this.apostador = apostador;
		this.previsao = previsao;
	}
	
	/**
	 * Exibicao padrao para uma aposta sem seguro
	 * 
	 * @return - retorna uma String que representa a exibicao padrao de uma aposta sem seguro.
	 */
	@Override
	public String toString() {
		return apostador + " - R$" + valor + " - " + previsao;
	}

	
	
}