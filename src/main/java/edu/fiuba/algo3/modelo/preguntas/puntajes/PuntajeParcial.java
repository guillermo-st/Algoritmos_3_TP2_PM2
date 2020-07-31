package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;

public class PuntajeParcial implements PuntajeChoice {

    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales) {
        return new ResultadoParcial();
    }
}
