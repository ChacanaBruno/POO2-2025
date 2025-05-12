package model;

public class Inicio extends Estado {


	@Override
	public void inicar(Maquina maquina) {
	     System.out.println("Ingrese una ficha para comenzar.");
		
	}

	@Override
	public void ingresarFicha(Maquina maquina) {
		 System.out.println("Ficha insertada: modo 1 jugador listo.");
		 
	     maquina.setEstado(new Solitario());
		
	}

	@Override
	public void finalizar(Maquina m) {
		
		System.out.println("No hay juego en curso.");
		
	}
	
}
