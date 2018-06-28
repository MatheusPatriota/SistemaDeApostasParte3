package lab05;

import static org.junit.Assert.*;

import org.junit.Test;


@SuppressWarnings("unused")
public class OperacoesControllerTest {

	private OperacoesController operacao = new OperacoesController();
	private Aposta aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void testIncializarSistemaComCaixaNegativo() {
		
		operacao.inicializarSistema(-10, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIncializarSistemaComTaxaMenorOuIgualZero() {
		
		operacao.inicializarSistema(10000, 0);
	}
	
	@Test
	public void testIncializarSistemaComValoresValidos() {
		
		operacao.inicializarSistema(10000, 0.01);
		assertEquals(10000, operacao.getCaixa());
		assertEquals(0.01, operacao.getTaxa(),0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCenarioVazio() {
		
		operacao.cadastrarCenario("");
	}
	
	
	@Test(expected=NullPointerException.class)
	public void testCadastraCenarioNulo() {
		
		operacao.cadastrarCenario(null);
	}
	
	@Test
	public void testCadastraCenarioValido() {
		
		Cenario cenario = new Cenario("RED será campeã mundial");
		assertEquals(1, operacao.cadastrarCenario("RED será campeã mundial"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComNomeDoApostadorNulo() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, null, 20, "VAI ACONTECER");
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComPrevisaoNula() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComNomeDoApostadorVazio() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, "", 20, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComPrevisaoVazia() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComValorDaApostaNegativo() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, "Matheus Patriota", -20, "VAI ACONTECER");
		
	}
	
	@Test
	public void testCadastraApostaValida() {
		
		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "VAI ACONTECER");
	
	}
	
	@Test
	public void testExibirCenarioValido() {

		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		assertEquals("1 - RED Não vai ser rebaixada pro circuitão - Nao finalizado", operacao.exibirCenario(1));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testExibirCenarioInvalido() {

		operacao.cadastrarCenario("RED Não vai ser rebaixada pro circuitão");
		operacao.exibirCenario(2);
	}
	
	@Test
	public void testListarCenarios() {

		operacao.cadastrarCenario("RED vai ganhar o CBLOL");
		assertEquals("1 - RED vai ganhar o CBLOL - Nao finalizado" + System.lineSeparator(), operacao.listarCenarios());
	}
	
	@Test
	public void testValorTotalDeApostas() {
		
		operacao.cadastrarCenario("RED vai ganhar o CBLOL");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "VAI ACONTECER");
		assertEquals(20, operacao.valorTotalDeApostas(1));

	}
	
	@Test
	public void testTotalDeApostas() {
		
		operacao.cadastrarCenario("RED vai ganhar o CBLOL");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "VAI ACONTECER");
		assertEquals(1, operacao.totalDeApostas(1));

	}
	
	@Test
	public void testExibeApostas() {
		
		operacao.cadastrarCenario("RED vai ganhar o CBLOL");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "VAI ACONTECER");
		assertEquals("- Matheus Patriota - R$20 - VAI ACONTECER" + System.lineSeparator(), operacao.exibeApostas(1));

	}
	
	@Test
	public void testFecharApostas() {
		
		operacao.cadastrarCenario("RED vai ganhar o CBLOL");
		operacao.cadastrarApostas(1, "Matheus Patriota", 20, "VAI ACONTECER");
		operacao.fecharAposta(1, true);

	}
	
}
