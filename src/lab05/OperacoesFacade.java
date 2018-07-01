package lab05;

import easyaccept.EasyAccept;

public class OperacoesFacade {
	
	public static void main(String[] args) {
		
		args = new String[] {"lab05.OperacoesFacade","acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
		"acceptance_test/us3_test.txt",	"acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt",
		"acceptance_test/us7_test.txt"};
		
		EasyAccept.main(args);
	}
	
	OperacoesController operacao;
	
	public OperacoesFacade() {
		
		this.operacao = new OperacoesController();
	}
	
	public void inicializa(int caixa, double taxa) {
		
		operacao.inicializarSistema(caixa, taxa);
	}
	
	public int cadastrarCenario(String descricao) {
		
		return operacao.cadastrarCenario(descricao);
	}
	
	public String exibirCenarioOrdenado(int numeracaoCenario) {
		
		return operacao.exibirCenarioOrdenado(numeracaoCenario);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		
		return operacao.cadastrarCenario(descricao, bonus);
	}
	
	public String exibirCenario(int numeracaoCenario) {
		
		return operacao.exibirCenario(numeracaoCenario);
	}
	
	public String listarCenarios() {
		
		return operacao.listarCenarios();
	}
	
	public String alterarOrdem(String ordem) {
		
		return operacao.alterarOrdem(ordem);
	}
	
	public void cadastrarAposta(int numeracaoCenario, String apostador, int valor, String previsao) {
		
		operacao.cadastrarApostas(numeracaoCenario, apostador, valor, previsao);
	}
	
	public void cadastrarApostaSeguraTaxa(int numeracaoCenario, String apostador, int valor, String previsao, double taxa, int custo) {
		
		operacao.cadastrarApostaSeguraTaxa(numeracaoCenario, apostador, valor, previsao, taxa, custo);
	}
	
	public void cadastrarApostaSeguraValor(int numeracaoCenario, String apostador, int valor, String previsao, int valorDoResgate, int custo) {
		
		operacao.cadastrarApostaSeguraValor(numeracaoCenario, apostador, valor, previsao, valorDoResgate, custo);
	}
	
	public int alterarSeguroValor(int numeracaoCenario, int apostaAssegurada, int valorDoResgate) {
		
		operacao.alterarSeguroValor(numeracaoCenario, apostaAssegurada, valorDoResgate);
		return 0;
	}
	
	public void alterarSeguroTaxa(int numeracaoCenario, int apostaAssegurada, double taxa ) {
		
		operacao.alterarSeguroTaxa(numeracaoCenario, apostaAssegurada, taxa);
	}
	
	public int valorTotalDeApostas(int numeracaoCenario) {
		
		return operacao.valorTotalDeApostas(numeracaoCenario);
	}
	
	public int totalDeApostas(int numeracaoCenario) {
		
		return operacao.totalDeApostas(numeracaoCenario);
	}
	
	public String exibeApostas(int numeracaoCenario) {
		
		return operacao.exibeApostas(numeracaoCenario);
	}
	
	public void fecharAposta(int numeracaoCenario, boolean ocorreu) {
		
		operacao.fecharAposta(numeracaoCenario, ocorreu);
	}
	
	public int getCaixaCenario(int numeracaoCenario) {
		
		return operacao.getCaixaCenario(numeracaoCenario);
	}
	
	public int getTotalRateioCenario(int numeracaoCenario) {
		
		return operacao.getTotalRateioCenario(numeracaoCenario);
	}
	
	public int getCaixa() {
		
		return operacao.getCaixa();
	}
	
	
}
