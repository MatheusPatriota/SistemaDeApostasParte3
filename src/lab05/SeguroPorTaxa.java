package lab05;

public class SeguroPorTaxa extends Seguro {
	
	private double taxa;
	private int custo;
	
	/**
	 * classe filha responsavel por armazenar aposta assegurado por uma taxa.
	 * 
	 * @param apostador - Nome do apostador.
	 * @param valor - Valor a ser apostado.
	 * @param previsao - Previsao se o cenario ira acontecer ou nao.
	 * @param taxa - taxa a ser restituido ao apostador caso ele perca a aposta.
	 */
	public SeguroPorTaxa(String apostador, int valor, String previsao, double taxa){
             
		super(apostador, valor, previsao);
        this.taxa = taxa;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
	public int getCusto() {
		return custo;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	/**
	 * toString resposavel por exibir os valores de um seguro por taxa.
	 * 
	 * @return - retorna uma String que representa os valores da aposta assegurada por taxa.
	 */
	@Override
	public String toString() {
		
		return super.toString() + " - " + "ASSEGURADA(TAXA) - " + (int)(taxa) + "%";
	}
}
