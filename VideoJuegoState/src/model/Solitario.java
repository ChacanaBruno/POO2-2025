package model;

public class Solitario extends Estado {

	@Override
	public void inicar(Maquina maquina) {
		System.out.println("Comienza juego para 1 jugador.");
		reiniciar(maquina); // restablece las fichas
		
	}

	@Override
	public void ingresarFicha(Maquina maquina) {
		
		 System.out.println("Ficha adicional: modo 2 jugadores listo.");
		 maquina.setEstado(new Dobles());
		
	}

}
