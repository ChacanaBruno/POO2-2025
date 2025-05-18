package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {
	private PokerStatus pokerSUT;

	private Carta c1;
	private Carta c2;
	private Carta c3;
	private Carta c4;
	private Carta c5;

	private Carta c1Mock;
	private Carta c2Mock;
	private Carta c3Mock;
	private Carta c4Mock;
	private Carta c5Mock;

	
	private Carta cAMock;
	private Carta cBMock;
	private Carta cCMock;
	private Carta cDMock;
	private Carta cEMock;
	
	private HandOfCards handPoquer;
	private HandOfCards handTrio;
	
	@BeforeEach
	public void setUp() {
		pokerSUT = new PokerStatus();

		c1Mock = mock(Carta.class);
		c2Mock = mock(Carta.class);
		c3Mock = mock(Carta.class);
		c4Mock = mock(Carta.class);
		c5Mock = mock(Carta.class);
		
		
		cAMock = mock(Carta.class);
		cBMock = mock(Carta.class);
		cCMock = mock(Carta.class);
		cDMock = mock(Carta.class);
		cEMock = mock(Carta.class);
		
		handPoquer = mock(HandOfCards.class);
		handTrio   = mock(HandOfCards.class);
		
	}
	// method auxiliar

	private void mockCarta(Carta mock, String valor, String palo) {
		when(mock.getValue()).thenReturn(valor);
		when(mock.getSuit()).thenReturn(palo);
	}
	/*
	 * 1. Implementar los test del ejercicio anterior (verificar con 5 Cartas)
	 * utilizando mockito.
	 */

	@Test
	void

			WhenPokerStatusChecksPokerMockReturnsAPoquer() {

		when(c1Mock.getValue()).thenReturn("2");
		when(c2Mock.getValue()).thenReturn("2");
		when(c3Mock.getValue()).thenReturn("2");
		when(c4Mock.getValue()).thenReturn("2");
		when(c5Mock.getValue()).thenReturn("4");

		String poker = pokerSUT.verificar(c1Mock, c2Mock, c3Mock, c4Mock, c5Mock);

		assertTrue("Poquer".equals(poker));
	}

	@Test
	void WhenPokerStatusChecksPokerReturnsAPoquer() {
		// setUp
		c1 = new Carta("2", "D");
		c2 = new Carta("2", "P");
		c3 = new Carta("2", "C");
		c4 = new Carta("2", "Q");
		c5 = new Carta("1", "D");
		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertTrue("Poquer".equals(poker));
	}

	@Test
	void WhenPokerStatusChecksPokerWithQueens() {
		// setUp
		c1 = new Carta("Q", "D");
		c2 = new Carta("Q", "P");
		c3 = new Carta("Q", "C");
		c4 = new Carta("Q", "Q");
		c5 = new Carta("3", "D");
		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertTrue("Poquer".equals(poker));
	}

	@Test
	void WhenPokerStatusChecksPokerMockReturnsANada() {

		mockCarta(c1Mock, "1", "P");
		mockCarta(c2Mock, "2", "D");
		mockCarta(c3Mock, "3", "C");
		mockCarta(c4Mock, "2", "D");
		mockCarta(c5Mock, "4", "Q");

		String resultado = pokerSUT.verificar(c1Mock, c2Mock, c3Mock, c4Mock, c5Mock);

		assertEquals("Nada", resultado);
	}

	@Test
	void WhenPokerStatusChecksPokerReturnsANada() {

		c1 = new Carta("1", "P");
		c2 = new Carta("2", "C");
		c3 = new Carta("3", "P");
		c4 = new Carta("Q", "D");
		c5 = new Carta("10", "D");

		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertEquals(poker, "Nada");
	}

	@Test
	void WhenPokerStatusChecksColorReturnsAColor() {

		c1 = new Carta("1", "P");
		c2 = new Carta("2", "P");
		c3 = new Carta("3", "P");
		c4 = new Carta("4", "P");
		c5 = new Carta("10", "P");

		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertEquals(poker, "Color");
	}

	@Test
	void WhenPokerStatusChecksTrioReturnsATrio() {

		c1 = new Carta("2", "P");
		c2 = new Carta("2", "D");
		c3 = new Carta("3", "C");
		c4 = new Carta("2", "P");
		c5 = new Carta("10", "P");

		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertEquals(poker, "Trio");
	}

	@Test
	void WhenPokerStatusChecksTrioAndFailReturnsANada() {

		c1 = new Carta("1", "P");
		c2 = new Carta("2", "D");
		c3 = new Carta("3", "C");
		c4 = new Carta("2", "P");
		c5 = new Carta("10", "P");

		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertEquals(poker, "Nada");
	}

	@Test
	void WhenPokerStatusChecksHandAndFailReturnsANada() {

		c1 = new Carta("1", "D");
		c2 = new Carta("2", "D");
		c3 = new Carta("3", "C");
		c4 = new Carta("2", "P");
		c5 = new Carta("10", "P");

		// exercise
		String poker = pokerSUT.verificar(c1, c2, c3, c4, c5);

		// verifiy
		assertEquals(poker, "Nada");
	}
	
	/*
	@Test
	void handPokerWinsAHandColor() {
		
		List<Carta> cartas1 = new ArrayList<>();
		
		cartas1.add(c1Mock);
		cartas1.add(c2Mock);
		cartas1.add(c3Mock);
		cartas1.add(c4Mock);
		cartas1.add(c5Mock);
		
		
		List<Carta> cartas2 = new ArrayList<>();
		
		cartas2.add(cAMock);
		cartas2.add(cBMock);
		cartas2.add(cCMock);
		cartas2.add(cDMock);
		cartas2.add(cEMock);
		
		
		
		mockCarta(c1Mock, "2", "P");
		mockCarta(c2Mock, "2", "D");
		mockCarta(c3Mock, "2", "C");
		mockCarta(c4Mock, "2", "D");
		mockCarta(c5Mock, "4", "Q");
		
		
		mockCarta(cAMock, "1", "P");
		mockCarta(cBMock, "2", "D");
		mockCarta(cCMock, "3", "C");
		mockCarta(cDMock, "2", "D");
		mockCarta(cEMock, "4", "Q");
		
		HandOfCards handCard1 = new HandOfCards(cartas1);
		
		HandOfCards handCard2 = new HandOfCards(cartas2);
		
		String handOfCardsWinner = pokerSUT.verificarManoDeCartasGanadora(handCard1, handCard2);
		
		assertEquals(handOfCardsWinner, "Poquer");
	}
	*/

	
	@Test
	void handPokerWinsAHandColorPrueba() {
		
		mockCarta(c1Mock, "2", "P");
		mockCarta(c2Mock, "2", "D");
		mockCarta(c3Mock, "2", "C");
		mockCarta(c4Mock, "2", "D");
		mockCarta(c5Mock, "4", "Q");
		
		
		mockCarta(cAMock, "2", "P");
		mockCarta(cBMock, "3", "D");
		mockCarta(cCMock, "3", "C");
		mockCarta(cDMock, "3", "Q");
		mockCarta(cEMock, "4", "D");
		
		
		when(handPoquer.cardInPosition(0)).thenReturn(c1Mock);
		when(handPoquer.cardInPosition(1)).thenReturn(c2Mock);
		when(handPoquer.cardInPosition(2)).thenReturn(c3Mock);
		when(handPoquer.cardInPosition(3)).thenReturn(c4Mock);
		when(handPoquer.cardInPosition(4)).thenReturn(c5Mock);
		
		
		when(handTrio.cardInPosition(0)).thenReturn(cAMock);
		when(handTrio.cardInPosition(1)).thenReturn(cBMock);
		when(handTrio.cardInPosition(2)).thenReturn(cCMock);
		when(handTrio.cardInPosition(3)).thenReturn(cDMock);
		when(handTrio.cardInPosition(4)).thenReturn(cEMock);
		
		List<Carta> cartas1 = mock(ArrayList.class);
		
		List<Carta> cartas2 = mock(ArrayList.class);
		
		String handOfCardsWinner = pokerSUT.verificarManoDeCartasGanadora(handPoquer, handTrio);
		
		assertEquals(handOfCardsWinner,"Poquer");
	}
	
	
	
	/*
	@Test
	void returnsWinningHandGivenTwoHands() {
		
		List<Carta> cartas1 = new ArrayList<>();
		
		List<Carta> cartas2 = new ArrayList<>();
		
		HandOfCards handCard1 = new HandOfCards(cartas1);
		
		HandOfCards handCard2 = new HandOfCards(cartas2);
		
		String poker = pokerSUT.verificarManoDeCartasGanadora(handCard1, handCard2);
	}*/
}
