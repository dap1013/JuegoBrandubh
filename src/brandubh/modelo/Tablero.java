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

/*Se crea el método tablero*/
public Tablero aTexto() {
	return null;}
	

/** La coordenada. */
public Coordenada coordenada;

/** La pieza. */
public Pieza pieza;


/**
 * Instancia una nueva celda.
 *
 * @param coordenada de la celda
 */
public Tablero(Coordenada coordenada) {
	this.coordenada = coordenada;}

/**
 * Instancia una nueva celda.
 *
 * @param coordenada de la celda
 * @param tipoCelda tipo de la celda
 */
public  Celda consultarCelda (Coordenada coordenada) {
	this.coordenada = coordenada;
	 
}
/*Crea un clon en profundidad del tablero actual
 * 
 * 
 * @return del tablero
 */

public Tablero clonar() {}


}