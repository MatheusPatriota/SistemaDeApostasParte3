package lab05;

import static org.junit.Assert.*;

import org.junit.Test;


@SuppressWarnings("unused")
public class CenarioTest {

	private Cenario cenario;
	private Aposta aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void testDescricaoVazia() {
		
		cenario = new Cenario("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComNomeDoApostadorVazio() {
		
		aposta = new Aposta("", 20, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComPrevisaoVazia() {
		
		aposta = new Aposta("Matheus Patriota", 20, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaComValorDaApostaNegativo() {
		
		aposta = new Aposta("Matheus Patriota", -20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testDescricaoNula() {
		
		cenario = new Cenario(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComNomeDoApostadorNulo() {
		
		aposta = new Aposta(null, 20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarApostaComPrevisaoNula() {
		
		aposta = new Aposta("Matheus Patriota", 20, null);
	}
	
	@Test
	public void testToString() {
		
		cenario = new Cenario("RED Não vai ser rebaixada pro circuitão");
		assertEquals("RED Não vai ser rebaixada pro circuitão - Nao finalizado", cenario.toString());
	}
	
	

}
