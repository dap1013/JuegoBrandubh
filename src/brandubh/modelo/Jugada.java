package brandubh.modelo;

import brandubh.util.Sentido;

/**
 * The  Jugada.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public record Jugada(Celda origen, Celda destino) {

	
	public Sentido consultarSentido() {
		
	}
	
	public boolean esMovimientoHorizontalOVertical() {
		
		return false;
	}
}
