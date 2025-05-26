package examen.models;

import org.springframework.stereotype.Component;

@Component("evaluadorRiesgoMedio") // Spring bean
public class EvaluadorRiesgoMedio extends EvaluadorRiesgo {

    @Override
    public boolean aplica(Cliente cliente, int puntajeFinal) {
        return puntajeFinal >= 60 && puntajeFinal <= 79;
    }

    @Override
    public ResultadoEvaluacion determinarCondiciones(Cliente cliente, int puntajeFinal, ResultadoEvaluacion resultadoBase) {
        resultadoBase.setNivelRiesgo("MEDIO");
        resultadoBase.setAprobado(true);
        resultadoBase.setPuntajeFinal(puntajeFinal);
        resultadoBase.setMensaje("Cliente apto para préstamo con condiciones ajustadas.");
        resultadoBase.setTasaInteres(10.0); 
        resultadoBase.setPlazoAprobado(Math.min(cliente.getPlazoEnMeses(), 36));
        return resultadoBase;
    }
}