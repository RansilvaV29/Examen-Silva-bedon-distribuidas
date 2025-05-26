package examen.dto;

import java.util.List;

import examen.models.Deuda;

public class ConsultaDto {
	private String tipoCliente; // "NATURAL" o "JURIDICA"
    private String nombre;
    private int puntajeCrediticio;
    private List<Deuda> deudasActuales;
    private double montoSolicitado;
    private int plazoEnMeses;
    // PersonaNatural
    private Integer edad;
    private Double ingresoMensual;
    // PersonaJuridica
    private Integer antiguedadAnios;
    private Double ingresoAnual;
    private Integer empleados;
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getIngresoMensual() {
		return ingresoMensual;
	}
	public void setIngresoMensual(Double ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}
	public Integer getAntiguedadAnios() {
		return antiguedadAnios;
	}
	public void setAntiguedadAnios(Integer antiguedadAnios) {
		this.antiguedadAnios = antiguedadAnios;
	}
	public Double getIngresoAnual() {
		return ingresoAnual;
	}
	public void setIngresoAnual(Double ingresoAnual) {
		this.ingresoAnual = ingresoAnual;
	}
	public Integer getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}
    
    
}
