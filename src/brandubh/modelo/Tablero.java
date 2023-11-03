package brandubh.modelo;

import brandubh.util.Coordenada;
import brandubh.util.TipoCelda;

/**
 * Clase del tipo Tablero.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */

public class Tablero {

	/** La pieza. */
	public Pieza pieza;

	private Celda[][] matriz;
	
	/** */
	public Tablero(int filas, int columnas) {
	matriz = new Celda[7][7];
	for(int i = 0; i<matriz.length; i++) {
		for(int j = 0; j<matriz[i].length; j++ ) {
		Coordenada coordenada = new Coordenada (i, j);
		Celda celda = new Celda(coordenada,TipoCelda.NORMAL);
		matriz [i][j] = celda;
		}
	/*Usar el de Celda de la línea 44*/
	matriz = new Celda[0][0];
	}
	
	}
}