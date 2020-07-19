package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class PreguntasVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaPreguntaVerdaderoFalsoYSeEligeLaCorrecta(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El cielo es azul?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);

        int puntos = unaPregunta.responder(respuestaCorrecta);

        assertEquals(1,puntos);

    }

    @Test
    public void test02CreoUnaPreguntaVerdaderoFalsoYSeEligeLaIncorrecta(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);

        int puntos = unaPregunta.responder(respuestaIncorrecta);

        assertEquals(0,puntos);

    }


    @Test
    public void test03SiCreoUnaPreguntaVerdaderoFalsoYLeIntentoAgregarMasDeDosRespuestasLanzaExcepcion(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El sistema solar tiene 12 planetas?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaCorrecta otraRespuestaCorrecta = new RespuestaCorrecta("Otro falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(otraRespuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta unaPregunta = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);}
                );
    }



}
