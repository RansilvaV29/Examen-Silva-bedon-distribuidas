package examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import examen.dto.ConsultaDto;
import examen.dto.RespuestaDto;
import examen.models.service.EvaluacionRiesgoService;

@RestController
@RequestMapping("/evaluar-riesgo")
public class EvaluacionRiesgoController {

    @Autowired
    private EvaluacionRiesgoService evaluacionRiesgoService;

    @PostMapping
    public ResponseEntity<RespuestaDto> evaluarRiesgo(@RequestBody ConsultaDto request) {
        RespuestaDto response = evaluacionRiesgoService.evaluarRiesgo(request);
        return ResponseEntity.ok(response);
    }
}