package model;

public class CuentaCorriente extends CuentaBancaria { 
    private int descubierto; 
 
    public CuentaCorriente(String titular, int descubierto){ 
        super(titular); 
        this.descubierto=descubierto; 
    } 
    public int getDescubierto(){ 
        return this.descubierto; 
    } 
	@Override
	protected boolean puedeExtraerMonto(int monto) {
		return this.getSaldo()+this.getDescubierto()>=monto;
	}

} 
