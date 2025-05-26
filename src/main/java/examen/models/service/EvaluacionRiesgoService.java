package examen.models.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.dto.ConsultaDto;
import examen.dto.RespuestaDto;
import examen.models.Cliente;
import examen.models.EvaluadorRiesgo;
import examen.models.EvaluadorRiesgoAlto;
import examen.models.EvaluadorRiesgoBajo;
import examen.models.EvaluadorRiesgoMedio;
import examen.models.HistorialEvaluacion;
import examen.models.PersonaJuridica;
import examen.models.PersonaNatural;
import examen.models.ResultadoEvaluacion;
import examen.models.repository.HistorialEvaluacionRepository;


@Service
public class EvaluacionRiesgoService {

    @Autowired
    private EvaluadorRiesgoBajo evaluadorRiesgoBajo;
    @Autowired
    private EvaluadorRiesgoMedio evaluadorRiesgoMedio;
    @Autowired
    private EvaluadorRiesgoAlto evaluadorRiesgoAlto;
    @Autowired
    private HistorialEvaluacionRepository historialRepository;

    public RespuestaDto evaluarRiesgo(ConsultaDto request) {
        Cliente cliente;
        if ("NATURAL".equalsIgnoreCase(request.getTipoCliente())) {
            cliente = new PersonaNatural(
                request.getNombre(),
                request.getPuntajeCrediticio(),
                request.getDeudasActuales(),
                request.getMontoSolicitado(),
                request.getPlazoEnMeses(),
                request.getEdad() != null ? request.getEdad() : 0,
                request.getIngresoMensual() != null ? request.getIngresoMensual() : 0.0
            );
        } else if ("JURIDICA".equalsIgnoreCase(request.getTipoCliente())) {
            cliente = new PersonaJuridica(
                request.getNombre(),
                request.getPuntajeCrediticio(),
                request.getDeudasActuales(),
                request.getMontoSolicitado(),
                request.getPlazoEnMeses(),
                request.getAntiguedadAnios() != null ? request.getAntiguedadAnios() : 0,
                request.getIngresoAnual() != null ? request.getIngresoAnual() : 0.0,
                request.getEmpleados() != null ? request.getEmpleados() : 0
            );
        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido: " + request.getTipoCliente());
        }

        if (!cliente.esAptoParaCredito()) {
            ResultadoEvaluacion resultado = new ResultadoEvaluacion();
            resultado.setNivelRiesgo("NO_APTO");
            resultado.setAprobado(false);
            resultado.setPuntajeFinal(0);
            resultado.setMensaje("Cliente no cumple con los requisitos básicos para crédito.");
            resultado.setTasaInteres(0.0);
            resultado.setPlazoAprobado(0);
            return toResponseDTO(resultado);
        }

        // Calcular score final
        EvaluadorRiesgo evaluador = getEvaluador(cliente);
        int puntajeFinal = evaluador.calcularPuntajeConPenalidades(cliente);

        // Determinar condicines
        ResultadoEvaluacion resultado = new ResultadoEvaluacion();
        resultado = evaluador.determinarCondiciones(cliente, puntajeFinal, resultado);

        // guardar historial 
        HistorialEvaluacion historial = new HistorialEvaluacion();
        historial.setClienteNombre(cliente.getNombre());
        historial.setTipoCliente(request.getTipoCliente());
        historial.setMontoSolicitado(cliente.getMontoSolicitado());
        historial.setPlazoEnMeses(cliente.getPlazoEnMeses());
        historial.setNivelRiesgo(resultado.getNivelRiesgo());
        historial.setAprobado(resultado.isAprobado());
        historial.setPuntajeFinal(resultado.getPuntajeFinal());
        historial.setFechaConsulta(LocalDateTime.now());
        historial.setTasaInteresAplicada(resultado.getTasaInteres());
        historial.setPlazoAprobadoFinal(resultado.getPlazoAprobado());
        historialRepository.save(historial);

        return toResponseDTO(resultado);
    }

    private EvaluadorRiesgo getEvaluador(Cliente cliente) {
        int puntajeFinal = evaluadorRiesgoBajo.calcularPuntajeConPenalidades(cliente);
        if (evaluadorRiesgoBajo.aplica(cliente, puntajeFinal)) {
            return evaluadorRiesgoBajo;
        } else if (evaluadorRiesgoMedio.aplica(cliente, puntajeFinal)) {
            return evaluadorRiesgoMedio;
        } else {
            return evaluadorRiesgoAlto;
        }
    }

    private RespuestaDto toResponseDTO(ResultadoEvaluacion resultado) {
        RespuestaDto response = new RespuestaDto();
        response.setNivelRiesgo(resultado.getNivelRiesgo());
        response.setAprobado(resultado.isAprobado());
        response.setPuntajeFinal(resultado.getPuntajeFinal());
        response.setMensaje(resultado.getMensaje());
        response.setTasaInteres(resultado.getTasaInteres());
        response.setPlazoAprobado(resultado.getPlazoAprobado());
        return response;
    }
}
