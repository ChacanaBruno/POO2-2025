package model;

public interface EstadoMaquina {
	public void inicar(Maquina maquina);
	
	public void ingresarFicha(Maquina maquina);
	
	public void finalizar(Maquina maquina);
	
	public void reiniciar(Maquina maquina);
}
