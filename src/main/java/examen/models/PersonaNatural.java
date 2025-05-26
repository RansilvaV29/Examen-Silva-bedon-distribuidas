package examen.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class PersonaNatural extends Cliente {
    private int edad;
    private double ingresoMensual;

    public PersonaNatural(String nombre, int puntajeCrediticio, List<Deuda> deudasActuales,
                          double montoSolicitado, int plazoEnMeses, int edad, double ingresoMensual) {
        super(nombre, puntajeCrediticio, deudasActuales, montoSolicitado, plazoEnMeses);
        this.edad = edad;
        this.ingresoMensual = ingresoMensual;
    }

    @Override
    public double getIngresoReferencial() {
        return this.ingresoMensual;
    }

    @Override
    public boolean esAptoParaCredito() {
        return edad >= 18;
    }

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(double ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}
    
    
}