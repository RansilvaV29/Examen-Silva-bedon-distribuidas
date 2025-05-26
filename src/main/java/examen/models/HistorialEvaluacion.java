package examen.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_evaluaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNombre;
    private String tipoCliente;
    private Double montoSolicitado;
    private Integer plazoEnMeses; 	
    private String nivelRiesgo; 
    private Boolean aprobado;
    private Integer puntajeFinal;
    private LocalDateTime fechaConsulta;

    private Double tasaInteresAplicada;
    private Integer plazoAprobadoFinal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}
	public Integer getPlazoEnMeses() {
		return plazoEnMeses;
	}
	public void setPlazoEnMeses(Integer plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}
	public String getNivelRiesgo() {
		return nivelRiesgo;
	}
	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}
	public Boolean getAprobado() {
		return aprobado;
	}
	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}
	public Integer getPuntajeFinal() {
		return puntajeFinal;
	}
	public void setPuntajeFinal(Integer puntajeFinal) {
		this.puntajeFinal = puntajeFinal;
	}
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public Double getTasaInteresAplicada() {
		return tasaInteresAplicada;
	}
	public void setTasaInteresAplicada(Double tasaInteresAplicada) {
		this.tasaInteresAplicada = tasaInteresAplicada;
	}
	public Integer getPlazoAprobadoFinal() {
		return plazoAprobadoFinal;
	}
	public void setPlazoAprobadoFinal(Integer plazoAprobadoFinal) {
		this.plazoAprobadoFinal = plazoAprobadoFinal;
	}
    
    
}
