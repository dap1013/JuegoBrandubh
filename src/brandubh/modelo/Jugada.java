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
		if(esMovimientoHorizontalOVertical()) {
			if(origen.coordenada.fila() == destino.coordenada.fila()) {
				
			}else if(origen.coordenada.columna() == destino.coordenada.columna()) {
				
			}
		}
		
		return null;
	}
	
	public boolean esMovimientoHorizontalOVertical() {
		
		if(origen.coordenada.fila() == destino.coordenada.fila() ||
				origen.coordenada.columna() == destino.coordenada.columna()) {
			return true;
		}
		
		return false;
	}
}
