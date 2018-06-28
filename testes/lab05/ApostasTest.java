package lab05;

import static org.junit.Assert.*;

import org.junit.Test;


public class ApostasTest {


	private Aposta aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostadorVazio() {
		
		aposta = new Aposta("", 20, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrevisaoVazia() {
		
		aposta = new Aposta("Matheus Patriota", 20, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorDaApostaNegativo() {
		
		aposta = new Aposta("Matheus Patriota", -20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testNomeDoApostadorNulo() {
		
		aposta = new Aposta(null, 20, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testPrevisaoNula() {
		
		aposta = new Aposta("Matheus Patriota", 20, null);
	}
	
	@Test
	public void testToString() {
		
		aposta = new Aposta("Matheus Patriota", 20, "VAI ACONTECER");
		assertEquals("Matheus Patriota - R$20 - VAI ACONTECER", aposta.toString());
	}
	
	

}
