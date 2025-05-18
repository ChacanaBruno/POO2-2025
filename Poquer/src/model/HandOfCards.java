package model;

import java.util.ArrayList;
import java.util.List;

public class HandOfCards {
	
	private List<Carta> cartas;
	public HandOfCards(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Carta cardInPosition(int position) {
	
		/*la position no debe ser mayor a 4 ni menor a 0*/
		
		return cartas.get(position);
	}
	

	
	public List<String> valuesOfCards() {
		List<String> values = new ArrayList<>();
		for(Carta c : cartas) {
			values.add(c.getValue());
		}
		
		return values;
	}
}
