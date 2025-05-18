package model;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {

	public PokerStatus() {
	}

	public String verificar(Carta card1, Carta card2, Carta card3, Carta card4, Carta card5) {
		// miro el primer string, identifico su palo
		// comparo su palo si se repite 3 veces en el resto de strings
		// si se repiten retorno true pues hay poquer
		// sino, realizo lo mismo con los demas,
		// si el length del string es de 3, entonces es un 10 y una letra, en el index
		// numero 2, obtengo el palo
		// de lo contrario, es una carta en la cual su palo se encuntra en el index 1
		// (contamos desde el 0)

		List<Carta> cards = List.of(card1, card2, card3, card4, card5);

		for (Carta card : cards) {

			String value = card.getValue();

			String suit = card.getSuit();

			if (isPoquer(value, cards)) {
				return "Poquer";
			} else {
				if (isColor(suit, cards)) {
					return "Color";
				} else {
					if (isTrio(value, cards)) {
						return "Trio";
					}
				}
			}
		}
		return "Nada";
	}

	private boolean isPoquer(String value, List<Carta> cards) {

		return (countCardsWith(value, valuesOfCards(cards)) == 4);

	}

	private List<String> valuesOfCards(List<Carta> cards) {

		List<String> values = new ArrayList<>();

		for (Carta card : cards) {
			values.add(card.getValue());
		}
		return values;
	}

	private int countCardsWith(String element, List<String> elements) {
		int count = 0;
		for (String e : elements) {
			if (e.equals(element)) {
				count++;
			}
		}
		return count;
	}

	private boolean isColor(String suit, List<Carta> cards) {

		List<String> suitOfCards = suitOf(cards);

		return (countCardsWith(suit, suitOfCards) == 5);
	}

	private List<String> suitOf(List<Carta> cards) {

		List<String> suit = new ArrayList<>();

		for (Carta card : cards) {
			suit.add(card.getSuit());
		}
		return suit;
	}

	private boolean isTrio(String value, List<Carta> cards) {

		return (countCardsWith(value, valuesOfCards(cards)) == 3);

	}

	public String verificarManoDeCartasGanadora(HandOfCards firstHandCard, HandOfCards secondHandCard) {

		String jugada1 = this.jugadaDe(firstHandCard);
		String jugada2 = this.jugadaDe(secondHandCard);

		int valorJugada1 = valorJugada(jugada1);
		int valorJugada2 = valorJugada(jugada2);

		if (valorJugada1 > valorJugada2) {
			return "Gana la primera mano: " + jugada1;
		} else if (valorJugada2 > valorJugada1) {
			return "Gana la segunda mano: " + jugada2;
		} else {
			// Misma jugada, desempatar por valor máximo
			int valorMax1 = valorMaximoJugada(firstHandCard, jugada1);
			int valorMax2 = valorMaximoJugada(secondHandCard, jugada2);

			if (valorMax1 > valorMax2) {
				return "Gana la primera mano por desempate: " + jugada1;
			} else if (valorMax2 > valorMax1) {
				return "Gana la segunda mano por desempate: " + jugada2;
			} else {
				return "Empate";
			}
		}
	}

	public String jugadaDe(HandOfCards handCard) {

		return verificar(handCard.cardInPosition(0), handCard.cardInPosition(1), handCard.cardInPosition(2),
				handCard.cardInPosition(3), handCard.cardInPosition(4));
	}
	
	
	private int valorJugada(String jugada) {
		switch (jugada) {
		case "Poquer":
			return 3;
		case "Color":
			return 2;
		case "Trio":
			return 1;
		default:
			return 0; // Nada o mano no válida
		}
	}

	private int valorCarta(String valorCarta) {
		switch (valorCarta) {
		case "A":
			return 14;
		case "K":
			return 13;
		case "Q":
			return 12;
		case "J":
			return 11;
		case "10":
			return 10;
		case "9":
			return 9;
		case "8":
			return 8;
		case "7":
			return 7;
		case "6":
			return 6;
		case "5":
			return 5;
		case "4":
			return 4;
		case "3":
			return 3;
		case "2":
			return 2;
		default:
			return 0;
		}
	}

	private int valorMaximoJugada(HandOfCards hand, String jugada) {

		List<String> valores = hand.valuesOfCards();

		if (jugada.equals("Poquer") || jugada.equals("Trio")) {
			return valorDeCartaRepetida(valores, jugada);
		} else if (jugada.equals("Color")) {
			return valorDeCartaMasAlta(valores);
		}

		return 0;
	}

	private int valorDeCartaRepetida(List<String> valores, String jugada) {

		for (String val : valores) {

			int count = ocurrenciasDelValorEnLosValores(val, valores);

			if ((jugada.equals("Poquer") && count == 4) || (jugada.equals("Trio") && count == 3)) {
				return valorCarta(val);
			}
		}
		return 0;
	}

	private int ocurrenciasDelValorEnLosValores(String valor, List<String> valores) {
		int count = 0;
		for (String v : valores) {
			if (v.equals(valor))
				count++;
		}
		return count;
	}

	private int valorDeCartaMasAlta(List<String> valores) {
		int max = 0;
		for (String val : valores) {
			int valorNumerico = valorCarta(val);
			if (valorNumerico > max) {
				max = valorNumerico;
			}
		}
		return max;
	}
}
