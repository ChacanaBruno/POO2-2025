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

			String value = getValue(card);

			String suit = getSuit(card);

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

		List<String> valuesOfCards = valuesOf(cards);

		return (countCardsWith(value, valuesOfCards) == 4);

	}

	private List<String> valuesOf(List<Carta> cards) {

		List<String> values = new ArrayList<>();

		for (Carta card : cards) {
			values.add(getValue(card));
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
			suit.add(getSuit(card));
		}
		return suit;
	}

	private boolean isTrio(String value, List<Carta> cards) {

		List<String> valuesOfCards = valuesOf(cards);

		return (countCardsWith(value, valuesOfCards) == 3);

	}

	private String getValue(Carta card) {
		//return card.substring(0, card.length() - 1); // Extrae todo menos el palo, "10D" = "10"
		return card.getValue();
	}

	private String getSuit(Carta card) {
		//return card.substring(card.length() - 1); // Extrae el palo, por ejemplo "10D" -> "D"
		return card.getSuit();
	}

	/*
	 * private int countCardsWithSuit(String suit, List<String> cards) { int count =
	 * 0; for (String card : cards) { if (getSuit(card).equals(suit)) { count++; } }
	 * return count; }
	 */

	/*
	 * private int countCardsWithValue(String value, List<String> cards) { int count
	 * = 0; for (String card : cards) { if (getValue(card).equals(value)) { count++;
	 * } } return count; }
	 */

}
