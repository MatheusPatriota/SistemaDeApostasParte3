package lab05;

public class ApostaAssegurada extends Aposta {
    private Seguro tipoSeguro;
    
    public ApostaAssegurada(String apostador, int valor, String previsao, double taxa, int custo) {
    	super(apostador, valor, previsao);
        tipoSeguro = new SeguroPorTaxa(valor, taxa);
    }
    
    public ApostaAssegurada(String apostador, int valor, String previsao, int valorDoResgate, int custo ) {
    	super(apostador, valor, previsao);
        tipoSeguro = new SeguroPorValor(valor, valorDoResgate);
    }
    
    @Override
    public void alterarParaTaxa(double taxa) {
    	tipoSeguro = new SeguroPorTaxa(valor,taxa);
    }
    
    @Override
    public void alterarParaValor(int valorDoSeguro) {
    	tipoSeguro = new SeguroPorValor(valor, valorDoSeguro);
    }
    
    
    public String toString() {
    	return super.toString() + tipoSeguro.toString();
    }
    
    public int getSeguro() {
    	return tipoSeguro.getSeguro();
    }
    
}