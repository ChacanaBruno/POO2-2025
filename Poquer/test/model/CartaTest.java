package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	private Carta card;
	private Carta card2;
	private Carta card3;
	private Carta card4;
	
	private Carta cardMock;
	
	@BeforeEach
	void setup() {
		card = new Carta("2", "D");
		
		card2 = new Carta("5", "P");
		
		card3 = new Carta("3", "C");
		
		card4 = new Carta("2", "C");
		
		
	}
	
	@Test
	void whenCreateACartaGetValueAndSitue() {
		
		card = new Carta("7", "D");
		
		assertEquals(card.getValue(), "7");
		assertEquals(card.getSuit(), "D");
	}

	@Test
	void whenACardHasTheSameSuitAsAnotherReturnsTrue() {
		
		boolean result = card.isEqualsValue(card4);
		
		assertEquals(result, true);
		
	}
	
	
	@Test
	void whenACardNotHasTheSameSuitAsAnotherReturnsFalse() {
		
		boolean result = card.isEqualsValue(card2);
		
		assertFalse(result);
		
	}
	
	@Test
	void whenCardIsGreaterThanAnother() {
		
		boolean result = card2.isGreaterThan(card);
		
		assertTrue(result);
	}
}
