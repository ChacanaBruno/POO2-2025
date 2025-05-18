package model;

public class Carta {
	
	private String value;
	private String suit;
	
	public Carta(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public String getSuit() {
		
		return suit;
	}

	public boolean isEqualsValue(Carta card) {
		return getValue().equals(card.getValue());
	}
	
 
    public boolean isGreaterThan(Carta other) {
        return rankOfValue(this.value) > rankOfValue(other.getValue());
    }

   
    private int rankOfValue(String value) {
        switch (value) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: throw new IllegalArgumentException("Valor de carta inválido: " + value);
        }
    }
	
	public String getCard() { return getValue() + getSuit(); }
}
