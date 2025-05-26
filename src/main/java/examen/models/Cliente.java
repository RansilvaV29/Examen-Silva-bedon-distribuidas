package examen.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public abstract class Cliente {
    private String nombre;
    private int puntajeCrediticio;
    private List<Deuda> deudasActuales;
    private double montoSolicitado;
    private int plazoEnMeses; // Loan term requested by client

    public Cliente(String nombre, int puntajeCrediticio, List<Deuda> deudasActuales, double montoSolicitado, int plazoEnMeses) {
        this.nombre = nombre;
        this.puntajeCrediticio = puntajeCrediticio;
        this.deudasActuales = deudasActuales;
        this.montoSolicitado = montoSolicitado;
        this.plazoEnMeses = plazoEnMeses;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntajeCrediticio() {
		return puntajeCrediticio;
	}

	public void setPuntajeCrediticio(int puntajeCrediticio) {
		this.puntajeCrediticio = puntajeCrediticio;
	}

	public List<Deuda> getDeudasActuales() {
		return deudasActuales;
	}

	public void setDeudasActuales(List<Deuda> deudasActuales) {
		this.deudasActuales = deudasActuales;
	}

	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public int getPlazoEnMeses() {
		return plazoEnMeses;
	}

	public void setPlazoEnMeses(int plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}

    public abstract double getIngresoReferencial();
    public abstract boolean esAptoParaCredito();

    public double getMontoTotalDeudas() {
        if (deudasActuales == null) {
            return 0.0;
        }
        return deudasActuales.stream().mapToDouble(Deuda::getMonto).sum();
    }

	
    
    
}
