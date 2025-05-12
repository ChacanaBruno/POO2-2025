package model;

public abstract class Estado implements EstadoMaquina {
	
	public Estado() {
		
	}
	
	
	public void reiniciar(Maquina maquina) {
		// restablece las fichas
		 maquina.setEstado(new Inicio());
	}
	
	public void finalizar(Maquina maquina) { 
	
		System.out.println("Juego finalizado.");
		
		reiniciar(maquina);
	}
	
}
