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
public class PersonaJuridica extends Cliente {
    private int antiguedadAnios;
    private double ingresoAnual;
    private int empleados;

    public PersonaJuridica(String nombre, int puntajeCrediticio, List<Deuda> deudasActuales,
                           double montoSolicitado, int plazoEnMeses, int antiguedadAnios,
                           double ingresoAnual, int empleados) {
        super(nombre, puntajeCrediticio, deudasActuales, montoSolicitado, plazoEnMeses);
        this.antiguedadAnios = antiguedadAnios;
        this.ingresoAnual = ingresoAnual;
        this.empleados = empleados;
    }

    @Override
    public double getIngresoReferencial() {
        return this.ingresoAnual;
    }

    @Override
    public boolean esAptoParaCredito() {
        return antiguedadAnios >= 1;
    }

	public int getAntiguedadAnios() {
		return antiguedadAnios;
	}

	public void setAntiguedadAnios(int antiguedadAnios) {
		this.antiguedadAnios = antiguedadAnios;
	}

	public double getIngresoAnual() {
		return ingresoAnual;
	}

	public void setIngresoAnual(double ingresoAnual) {
		this.ingresoAnual = ingresoAnual;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
    
    
}
