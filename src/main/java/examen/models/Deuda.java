package examen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deuda {
    private double monto;
    private int plazoMeses;
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getPlazoMeses() {
		return plazoMeses;
	}
	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}
    
    
}
