package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {
	private PokerStatus pokerSUT;
	
	private Carta c1;
	private Carta c2;
	private Carta c3;
	private Carta c4;
	private Carta c5;
	

	@BeforeEach
	public void setUp() {
		pokerSUT = new PokerStatus();
	}
	
	@Test
	void WhenPokerStatusChecksPokerReturnsAPoquer() {
		//setUp
		c1 = new Carta("2", "D");
		c2 = new Carta("2", "P");
		c3 = new Carta("2", "C");
		c4 = new Carta("2", "Q");
		c5 = new Carta("1", "D");
		//exercise
		String poker = pokerSUT.verificar(c1,c2,c3,c4,c5);
		
		//verifiy
		assertTrue("Poquer".equals(poker));
	}
	

	@Test
	void WhenPokerStatusChecksPokerWithQueens() {
		//setUp
		c1 = new Carta("Q", "D");
		c2 = new Carta("Q", "P");
		c3 = new Carta("Q", "C");
		c4 = new Carta("Q", "Q");
		c5 = new Carta("3", "D");
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
		
		//verifiy
		assertTrue("Poquer".equals(poker));
	}
	
	@Test
	void WhenPokerStatusChecksPokerReturnsANada() {
		
		c1 = new Carta("1",  "P");
		c2 = new Carta("2",  "C");
		c3 = new Carta("3",  "P");
		c4 = new Carta("Q",  "D");
		c5 = new Carta("10", "D");
		
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
		
		//verifiy
		assertEquals(poker, "Nada");
	}
		
		@Test
		void WhenPokerStatusChecksColorReturnsAColor() {
			
			c1 = new Carta("1",  "P");
			c2 = new Carta("2",  "P");
			c3 = new Carta("3",  "P");
			c4 = new Carta("4",  "P");
			c5 = new Carta("10", "P");
			
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
			
		//verifiy
		assertEquals(poker, "Color");
	}
	
		
		@Test
		void WhenPokerStatusChecksTrioReturnsATrio() {
		
		c1 = new Carta("2",  "P");
		c2 = new Carta("2",  "D");
		c3 = new Carta("3",  "C");
		c4 = new Carta("2",  "P");
		c5 = new Carta("10", "P");
		
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
			
		//verifiy
		assertEquals(poker, "Trio");
	}
	
		
		@Test
		void WhenPokerStatusChecksTrioAndFailReturnsANada() {
		
		c1 = new Carta("1",  "P");
		c2 = new Carta("2",  "D");
		c3 = new Carta("3",  "C");
		c4 = new Carta("2",  "P");
		c5 = new Carta("10", "P");
			
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
			
		//verifiy
		assertEquals(poker, "Nada");
	}
		
	
		@Test
		void WhenPokerStatusChecksHandAndFailReturnsANada() {
		
		c1 = new Carta("1",  "D");
		c2 = new Carta("2",  "D");
		c3 = new Carta("3",  "C");
		c4 = new Carta("2",  "P");
		c5 = new Carta("10", "P");
			
		//exercise
		String poker = pokerSUT.verificar(c1, c2,c3, c4, c5);
			
		//verifiy
		assertEquals(poker, "Nada");
	}
		
		
}
