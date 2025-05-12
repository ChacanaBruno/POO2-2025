package model;

public class Dobles extends Estado {

	@Override
	public void inicar(Maquina maquina) {
		
        System.out.println("Comienza juego para 2 jugadores.");
        
        reiniciar(maquina);
		
	}

	@Override
	public void ingresarFicha(Maquina maquina) {
		System.out.println("Máximo 2 fichas. Ya está listo para 2 jugadores.");
		
	}

}
