package brandubh.modelo;

import brandubh.util.Sentido;

/**
 * Describe una jugada.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public record Jugada(Celda origen, Celda destino) {

	
	/**
	 * Consultar sentido.
	 *
	 * @return Sentido de la jugada
	 */
	public Sentido consultarSentido() {
		if(esMovimientoHorizontalOVertical()) {
			if(origen.coordenada.fila() == destino.coordenada.fila()) { //movimiento horizontal
				if(origen.coordenada.columna() > destino.coordenada.columna()) {
					return Sentido.HORIZONTAL_O;
				}else {
					return Sentido.HORIZONTAL_E;
				}
			}else if(origen.coordenada.columna() == destino.coordenada.columna()) { //movimiento vertical
				if(origen.coordenada.fila() > destino.coordenada.fila()) {
					return Sentido.VERTICAL_N;
				}else {
					return Sentido.VERTICAL_S;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Es movimiento horizontal O vertical.
	 *
	 * @return true, si es movimiento horizontal o vertical
	 */
	public boolean esMovimientoHorizontalOVertical() {
		
		if(origen.coordenada.fila() == destino.coordenada.fila() ||
				origen.coordenada.columna() == destino.coordenada.columna()) {
			return true;
		}
		
		return false;
	}
}
