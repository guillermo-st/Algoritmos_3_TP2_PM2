package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

public class TurnoSegundoJugador extends Turno {

    private Respuesta respuestaDelJugador1;

    public TurnoSegundoJugador(Respuesta unaRespuesta, Jugador jugador2) {
        respuestaDelJugador1 = unaRespuesta;
        jugadorDelTurno = jugador2;
    }

    @Override
    public Turno procesarTurno(Respuesta respuestaDelJugador2, Jugador jugador1, Jugador jugador2) {
        AlgoHoot.getInstance().jugar(respuestaDelJugador1, respuestaDelJugador2);
        return new TurnoPrimerJugador(jugador1);
    }

    @Override
    public boolean terminoElJuego() {
        return false;
    }

}
