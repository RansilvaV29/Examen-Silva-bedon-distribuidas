package examen.models;

import org.springframework.stereotype.Component;

@Component("evaluadorRiesgoBajo") // Spring bean
public class EvaluadorRiesgoBajo extends EvaluadorRiesgo {

    @Override
    public boolean aplica(Cliente cliente, int puntajeFinal) {
        return puntajeFinal >= 80;
    }

    @Override
    public ResultadoEvaluacion determinarCondiciones(Cliente cliente, int puntajeFinal, ResultadoEvaluacion resultadoBase) {
        resultadoBase.setNivelRiesgo("BAJO");
        resultadoBase.setAprobado(true);
        resultadoBase.setPuntajeFinal(puntajeFinal);
        resultadoBase.setMensaje("Cliente apto para préstamo con condiciones preferenciales.");
        resultadoBase.setTasaInteres(6.5); // Example value
        resultadoBase.setPlazoAprobado(Math.min(cliente.getPlazoEnMeses(), 24)); // Example, can be more complex
        return resultadoBase;
    }
}
