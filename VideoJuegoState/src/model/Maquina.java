package model;

public class Maquina {
	
	private EstadoMaquina estado;
	
	public Maquina(EstadoMaquina estado) {
		this.estado = estado;
	}
	
	public void inicar() {
		estado.inicar(this);
	}

	public void setEstado(EstadoMaquina estado) {
		this.estado = estado;
		
	} 
	
}
