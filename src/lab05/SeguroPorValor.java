package lab05;

public class SeguroPorValor extends Seguro{
	
	private int valorDoSeguro;
	private int custo;
	private boolean asseguradoPorValor;
	
	public SeguroPorValor(int valor, int valorDoSeguro) {
		super(valor);
		this.valorDoSeguro = valorDoSeguro;
		this.asseguradoPorValor = true;
	}
	

	public boolean getAsseguradoPorValor() {
		return asseguradoPorValor;
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
	
	@Override
	public int getSeguro() {
		return 0;
	}
	
	@Override
	public String toString() {

		return " - "  + "ASSEGURADO(VALOR) - R$" + valorDoSeguro;
	}
}