package examen.models;

public abstract class EvaluadorRiesgo {
    public static final int puntajeBase = 100;

    public abstract boolean aplica(Cliente cliente, int puntajeFinal);

    public abstract ResultadoEvaluacion determinarCondiciones(Cliente cliente, int puntajeFinal, ResultadoEvaluacion resultadoBase);

    public int calcularPuntajeConPenalidades(Cliente cliente) {
        int puntaje = puntajeBase;
        if (cliente.getPuntajeCrediticio() < 650) {
            puntaje -= 30;
        }
        
        if (cliente instanceof PersonaNatural natural) {
            if (natural.getIngresoMensual() > 0 && (cliente.getMontoTotalDeudas() / natural.getIngresoMensual()) > 0.40) {
                puntaje -= 15;
            }
            if (natural.getIngresoMensual() > 0 && (cliente.getMontoSolicitado() / natural.getIngresoMensual()) > 0.50) {
                puntaje -= 10;
            }

        } else if (cliente instanceof PersonaJuridica juridica) {

            if (juridica.getAntiguedadAnios() < 3) { 
            }

            if (juridica.getIngresoAnual() > 0 && (cliente.getMontoTotalDeudas() / juridica.getIngresoAnual()) > 0.35) {
                puntaje -= 20;
            }
            
            if (juridica.getIngresoAnual() > 0 && (cliente.getMontoSolicitado() / juridica.getIngresoAnual()) > 0.30) {
                puntaje -= 15;
            }
        }
        return Math.max(0, puntaje); 
    }
}
