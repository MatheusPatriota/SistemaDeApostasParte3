package lab05;

public class SeguroPorTaxa extends Seguro {
	
	private double taxa;
	private int custo;
	
	public SeguroPorTaxa(int valor,double taxa){
             
		super(valor);
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
	
	@Override
	public int getSeguro() {
		return 1;
	}
	
	@Override
	public String toString() {
		
		return " - " + "ASSEGURADA(TAXA) - " + (int)(taxa) + "%";
	}
}
