package examen.models;

import org.springframework.stereotype.Component;

@Component("evaluadorRiesgoAlto") // Spring bean
public class EvaluadorRiesgoAlto extends EvaluadorRiesgo {

    @Override
    public boolean aplica(Cliente cliente, int puntajeFinal) {
        return puntajeFinal < 60;
    }

    @Override
    public ResultadoEvaluacion determinarCondiciones(Cliente cliente, int puntajeFinal, ResultadoEvaluacion resultadoBase) {
        resultadoBase.setNivelRiesgo("ALTO");
        resultadoBase.setAprobado(false);
        resultadoBase.setPuntajeFinal(puntajeFinal);
        resultadoBase.setMensaje("Cliente no apto para préstamo.");
        resultadoBase.setTasaInteres(0.0);
        resultadoBase.setPlazoAprobado(0);
        return resultadoBase;
    }
}
