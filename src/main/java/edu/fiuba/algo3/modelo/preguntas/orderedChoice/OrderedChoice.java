package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.EvaluadorOrden;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import java.util.ArrayList;

public class OrderedChoice implements Pregunta {

    private String enunciado;
    private ArrayList<OpcionSimple> respuestasOrdenadasCorrectamente;
    private PuntajeClasico puntaje;

    public OrderedChoice(String enunciado, ArrayList<OpcionSimple> respuestasOrdenadas) {
        this.enunciado = enunciado;
        respuestasOrdenadasCorrectamente = respuestasOrdenadas;
        puntaje = new PuntajeClasico();
    }




    @Override
    public Resultado responder(RespuestaComparable respuestasUsuario) {
        Resultado unResultado = puntaje.obtenerResultado(1);
        EvaluadorOrden evaluador = new EvaluadorOrden(respuestasOrdenadasCorrectamente);
        respuestasUsuario.evaluarConParametro(unResultado,evaluador);
        return unResultado;
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasUsuario) {
        return null;
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

}