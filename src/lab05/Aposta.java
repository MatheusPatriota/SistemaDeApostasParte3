/**
* Laboratorio de Programacao 2 - Lab 5
*
* @author Matheus da Silva Coimbra Patriota - 117210391
*/

package lab05;


public abstract class Aposta {
	
	protected String apostador;
	protected int valor;
	protected String previsao;
	
	/**
	 * Construtor de Apostas responsavel por inicializar sua classe e atributos.
	 * 
	 * @param apostador - Nome de quem está apostando
	 * @param valor - Valor da aposta
	 * @param previsao - Prever se o cenario vai acontecer ou não
	 */
	public Aposta(String apostador, int valor, String previsao) {
				
		this.valor = valor;
		this.apostador = apostador;
		this.previsao = previsao;
		
	}
	
	public String getPrevisao() {
		return previsao;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getSeguro() {
		return 0;
	}
	
	public void alterarParaValor(int valorDoSeguro) {

	}
	
	public void alterarParaTaxa(double taxa) {
	    	
	}
	
	/**
	 * toString para padronizar a exibicao da classe Apostas, usando apostador, valor e previsao.
	 * 
	 * @return - retorna uma string que representa as Apostas
	 */
	@Override
	public String toString() {
		
		return apostador + " - R$" + valor + " - " + previsao;
	}
}
