/**
* Laboratorio de Programacao 2 - Lab 5
*
* @author Matheus da Silva Coimbra Patriota - 117210391
*/

package lab05;

import java.util.ArrayList;
import java.util.Collections;




public class OperacoesController implements Comparable<OperacoesController>{

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;
	private int numeracaoCenarioCadastrado;


	/**
	 * Construtor da classe Operacoes responsavel por inicializar sua classe e seus atributos.
	 */
	public OperacoesController() {
		
		this.cenarios = new ArrayList<>();
		this.caixa = 0;
		this.taxa = 0;
		this.numeracaoCenarioCadastrado = 0;
		
	}
	
	/**
	 * metodo responsavel por inicializar o sistema de apostas
	 * recebendo como parametro caixa e taxa.
	 * 
	 * @param caixa - Total em centavos do caixa do sistema.
	 * @param taxa - taxa de retirada das apostas perdedoras
	 */
	public void inicializarSistema(int caixa, double taxa) {
		
		if (caixa < 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		
		if (taxa  <= 0) {
			
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	/**
	 * metodo responsavel por cadastras um cenario, recebendo como
	 * parametro uma descricao.
	 * 
	 * @param descricao - Descricao de um cenario qualquer que pode ocorrer ou nao.
	 * @return - retorna a numeracao do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		numeracaoCenarioCadastrado ++;
		cenario.setNumeracaoCenario(numeracaoCenarioCadastrado);
		return numeracaoCenarioCadastrado;
		
	}
	
	/**
	 * Cadastra um cenario com bonus.
	 * 
	 * @param descricao - Descricao de um cenario possivel.
	 * @param bonus - Bonus para incentivar as apostas em determinado cenario.
	 * @return - retorna a numeracao do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		
		Cenario cenario = new CenarioBonus(descricao, bonus);
		cenarios.add(cenario);
		numeracaoCenarioCadastrado ++;
		cenario.setNumeracaoCenario(numeracaoCenarioCadastrado);
		this.caixa -= bonus;
		return numeracaoCenarioCadastrado;
	
	}
	
	/**
	 * metodo responsavel por exibir o Cenario especifico a partir da numeracao do cenario.
	 *  
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna uma String que representa o cenario escolhido.
	 */
	public String exibirCenario(int numeracaoCenario) {
		
		if (numeracaoCenario < 0) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		Collections.sort(cenarios, new OrdenaPorCadastro());
		return  cenarios.get(numeracaoCenario-1).toString();
	}
	
	/**
	 * metodo responsavel por listar todos os cenarios cadastrados.
	 * 
	 * @return - Retorna uma String com todos os cenarios cadastrados.
	 */
	public String listarCenarios() {
		
		String listaDeCenarios = "";
		for (int i = 0; i < cenarios.size(); i++) {
			
			listaDeCenarios += cenarios.get(i).toString() + System.lineSeparator();
		}
		
		return listaDeCenarios;
	}
	
	/**
	 * metodo responsavel por alterar a ordem do cenario de acordo com os parametros
	 * cadastro, nome e apostas.
	 * 
	 * @param ordem - String que representa qual a prioridade de ordenacao dos cenarios.
	 * @return - retorna uma String com todos os cenarios ordenados da maneira desejada.
	 */
	public String alterarOrdem(String ordem) {
		
		String resultadoDaAlteracao = "";
		ordem = ordem.toLowerCase();
		
		if (ordem.equals(" ")) {
			
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		
		else if (ordem.equals("cadastro")) {
			
			Collections.sort(cenarios, new OrdenaPorCadastro());
			for (int i = 0; i < cenarios.size(); i++) {
				
				resultadoDaAlteracao += cenarios.get(i).toString() + System.lineSeparator();
			}
		}
		
		else if (ordem.equals("nome")) {
			
			Collections.sort(cenarios, new OrdenaPorNome());
			for (int i = 0; i < cenarios.size(); i++) {
				
				resultadoDaAlteracao += cenarios.get(i).toString() + System.lineSeparator();
			}
		}
		
		else if(ordem.equals("apostas")) {
			
			Collections.sort(cenarios, new OrdenaPorApostas());
			for (int i = 0; i < cenarios.size(); i++) {
				
				resultadoDaAlteracao += cenarios.get(i).toString() + System.lineSeparator();
			}
		}
		
		else {
			
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
		
		return resultadoDaAlteracao;
	}
	
	/**
	 * metodo responsavel por exibir o cenario ordenado a partir de sua posicao.
	 * 
	 * @param numeracaoCenario - posicao do cenario a ser exibido.
	 * @return - retorna uma String que representa o cenario ordenado.
	 */
	public String exibirCenarioOrdenado(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		
		if (numeracaoCenario > cenarios.size()) {
			
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		
		return cenarios.get(numeracaoCenario-1).toString();
	}
	/**
	 * metodo responsavel por cadastrar uma nova aposta em um cenario especifico, passando como parametro
	 * a numeracaoCenario, apostador e previsao.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario que deve-se cadastrar a aposta.
	 * @param apostador - String com o nome do apostador.
	 * @param valor - O valor a ser apostado.
	 * @param previsao - Prever se o evento vai acontecer ou nao.
	 */
	public void cadastrarApostas(int numeracaoCenario, String apostador, int valor, String previsao) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracaoCenario-1).cadastrarApostas(apostador, valor, previsao);
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
		
	}
	
	/**
	 * metodo responsavel por cadastrar aposta assegurado por uma taxa.
	 * 
	 * @param numeracaoCenario - posicao do cenario onde ira ser cadastrado a apostas.
	 * @param apostador - Nome do apostador.
	 * @param valor - Valor a ser apostado.
	 * @param previsao - Previsao se o cenario ira acontecer ou nao.
	 * @param taxa - Taxa que incide em cima do valor apostado a ser restituida ao apostador.
	 * @param custo - custo para fazer uma aposta assegurada.
	 */
	public void cadastrarApostaSeguraTaxa(int numeracaoCenario, String apostador, int valor, String previsao, double taxa, int custo) {
		
        if (numeracaoCenario <= 0) {
        
            throw  new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
        }
        
        if (numeracaoCenario > cenarios.size()) {
        
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
        }
        
        if (apostador == null) {
           
        	throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
        }
        
        if (apostador.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
        }
        
		if (valor <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		
		if (apostador.equals("  ")) {
			
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		
		if (previsao.equals("  ")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("") || previsao == null) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
                
        if (apostador.equals("   ")) {
        
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
        }
                
		cenarios.get(numeracaoCenario-1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa, custo);
		caixa += custo;
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
	}
	
	
	/**
	 * metodo responsavel por cadastrar aposta assegurado por uma valor.
	 * 
	 * @param numeracaoCenario - posicao do cenario onde ira ser cadastrado a apostas.
	 * @param apostador - Nome do apostador.
	 * @param valor - Valor a ser apostado.
	 * @param previsao - Previsao se o cenario ira acontecer ou nao.
	 * @param valor - Valor a ser restituido ao apostador caso ele perca a aposta.
	 * @param custo - custo para fazer uma aposta assegurada.
	 */
	public void cadastrarApostaSeguraValor(int numeracaoCenario, String apostador, int valor, String previsao, int valorDoResgate, int custo) {

        if (numeracaoCenario <= 0) {
        
            throw  new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
        }
        
        if (numeracaoCenario > cenarios.size()) {
        
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
        }
        
        if (apostador == null) {
        	
            throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
        }
        
        if (apostador.equals("")) {
        	
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
        }
        
		if (valor <= 0) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		
		if (apostador.equals("  ")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		
		if (previsao.equals("  ")) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("") || previsao == null) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
                
        if (apostador.equals("   ")) {
        
            throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
        }
        
		cenarios.get(numeracaoCenario-1).cadastrarApostaSeguraValor(apostador, valor, previsao, valorDoResgate, custo);
		caixa += custo;
		cenarios.get(numeracaoCenario-1).setTotalDeApostas();
		cenarios.get(numeracaoCenario-1).setValorTotalApostas(valor);
	}
	
	/**
	 * metodo responsavel por alterar o valor da aposta assegurada.
	 * 
	 * @param numeracaoCenario - numero onde o cenario se encontra
	 * @param apostaAssegurada - numero onde a aposta assegurada se encontra.
	 * @param valorDoSeguro - valor que o substituira o valor atual do seguro.
	 */
	public void alterarSeguroValor(int numeracaoCenario, int apostaAssegurada, int valorDoSeguro) {
		
		cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(apostaAssegurada-1).alterarParaValor(valorDoSeguro);
		
	}
	/**
	 * metodo responsavel por alterar a taxa da aposta assegurada.
	 * 
	 * @param numeracaoCenario - numero onde o cenario se encontra
	 * @param apostaAssegurada - numero onde a aposta assegurada se encontra.
	 * @param taxa - Nova taxa que substituira a antiga.
	 */
	public void alterarSeguroTaxa(int numeracaoCenario, int apostaAssegurada, double taxa ) {
		
		cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(apostaAssegurada-1).alterarParaTaxa(taxa);
          
	}
	
	/**
	 * metodo responsavel por retornar o total do valor de apostas de um cenario especifico.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna um numero inteiro que representa o valor total de apostas no cenario. 
	 */
	public int valorTotalDeApostas(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		return cenarios.get(numeracaoCenario-1).getValorTotalApostas();
	}
	
	/**
	 * metodo responsavel por retornar o numero total de apostas no cenario especifico recebendo como parametro
	 * a numeracaoCenario.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna a quantidade em inteiro de apostas no cenario.
	 */
	public int totalDeApostas(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		return cenarios.get(numeracaoCenario-1).getTotalDeApostas();
	}
	
	/**
	 * metodo responsavel por exibir todas as apostas feitas em um cenario recebendo como parametro
	 * a numeracaoCenario.
	 * 
	 * @param numeracaoCenario - Numeracao inteira do cenario.
	 * @return - Retorna uma String com todas as apostas feitas no cenario.
	 */
	public String exibeApostas(int numeracaoCenario) {
		
		String exibindoApostas = "";
		for (int i = 0; i < cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
			exibindoApostas += "- " + cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i) + System.lineSeparator();
		}
		
		
		return exibindoApostas;
		
	}
	
	/**
	 * metodo responsavel por fechar uma aposta recebendo como parametro a
	 * numeracaoCenario e um boolean determinando se ocorreu ou nao.
	 * 
	 * @param numeracaoCenario - Numeracao em inteiro do cenario.
	 * @param ocorreu - valor booleano representando se o Cenario ocorreu ou nao.
	 */
	public void fecharAposta(int numeracaoCenario, boolean ocorreu) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		if (!cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
		
		if (ocorreu  == true) {
			
			for (int i = 0; i <cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
				
				if (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getPrevisao().equals("N VAI ACONTECER")) {
					
					cenarios.get(numeracaoCenario-1).setCaixaCenario(cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor());
				}
			}
			
			caixa += (cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa);
			cenarios.get(numeracaoCenario-1).setRateioCenario((int) (cenarios.get(numeracaoCenario-1).getCaixaCenario() - cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa));
			cenarios.get(numeracaoCenario-1).setStatus("Finalizado (ocorreu)");
		}
		
		else {
			
			for (int i = 0; i <cenarios.get(numeracaoCenario-1).getArrayDeApostas().size(); i++) {
				
				if (cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getPrevisao().equals("VAI ACONTECER")) {
					
					cenarios.get(numeracaoCenario-1).setCaixaCenario(cenarios.get(numeracaoCenario-1).getArrayDeApostas().get(i).getValor());
				}
				
			}
			
			caixa += (cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa);
			cenarios.get(numeracaoCenario-1).setRateioCenario((int) (cenarios.get(numeracaoCenario-1).getCaixaCenario() - cenarios.get(numeracaoCenario-1).getCaixaCenario() * taxa));
			cenarios.get(numeracaoCenario-1).setStatus("Finalizado (n ocorreu)");
		}
	
		
	}
	
	public int getCaixaCenario(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		if (cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		
		return cenarios.get(numeracaoCenario-1).getCaixaCenario()/100;
	}
	
	public int getTotalRateioCenario(int numeracaoCenario) {
		
		if (numeracaoCenario <= 0) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		
		if (cenarios.size() < numeracaoCenario-1) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		if (cenarios.get(numeracaoCenario-1).getStatus().equals("Nao finalizado")) {
			
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		
		return cenarios.get(numeracaoCenario-1).getRateioCenario();
	}
	
	public int getCaixa() {
		
		return this.caixa;
	}
	
	public double getTaxa() {
		return taxa;
	}

	@Override
	public int compareTo(OperacoesController o) {
		return this.numeracaoCenarioCadastrado - o.numeracaoCenarioCadastrado;
	}

	
	
}
