package lab05;

public class SistemaDeApostas {
	
	public static void main(String[] args) {
		
		
		OperacoesFacade operacao = new OperacoesFacade();
		operacao.inicializa(100000, 0.01);
		/**
		 *  Operacoes realacionadas a Cenario
		 */
		
		operacao.cadastrarCenario("RED vai ganhar o mundial ",1000);
		operacao.cadastrarCenario("RED vai ganhar o mundial ");
		operacao.cadastrarCenario("As provas vao ser corrigidas ate sexta"); 
		operacao.cadastrarCenario("As provas nao vao ser corrigidas ate sexta");
		System.out.println(operacao.exibirCenario(1));
		System.out.println();
		System.out.println(operacao.listarCenarios());
		
		/**
		 * Operacoes relacionadas a Aposta
		 */
		
		System.out.println(operacao.getCaixa());
		operacao.cadastrarAposta(1, "Matheus Patriota", 101, "N VAI ACONTECER");
		operacao.cadastrarAposta(1, "Homer simpson", 201, "VAI ACONTECER");
		operacao.cadastrarAposta(1, "Marge simpson", 301, "N VAI ACONTECER");
		operacao.cadastrarAposta(1, "Matheus Patriota", 401, "VAI ACONTECER");
		operacao.cadastrarApostaSeguraValor(1, "Matheus Patriota", 501, "VAI ACONTECER",200,50);
		operacao.cadastrarApostaSeguraTaxa(1, "Homilson", 501, "VAI ACONTECER", 0.02, 40);
		System.out.println(operacao.getCaixa());
		operacao.alterarSeguroValor(1, 5, 100);
		operacao.alterarSeguroTaxa(1, 6, 0.02);
		System.out.println(operacao.getCaixa());    
		operacao.fecharAposta(1, false);
		System.out.println(operacao.getCaixaCenario(1));
		System.out.println(operacao.getTotalRateioCenario(1));
		System.out.println(operacao.getCaixa());

	
		
	}

}
