package brandubh.control;


import brandubh.modelo.Celda;
import brandubh.modelo.Jugada;
import brandubh.modelo.Pieza;
import brandubh.modelo.Tablero;
import brandubh.util.Color;
import brandubh.util.Coordenada;
import brandubh.util.Sentido;
import brandubh.util.TipoCelda;
import brandubh.util.TipoPieza;
import brandubh.util.Traductor;


public class Arbitro {
	
	/** Tablero donde se juega. */
	private Tablero tablero;
	
	/** El contador de jugadas. */
	private int contadorJugadas;
	
	/** El turno. */
	private Color turno;
	
	/**
	 * Instancia un nuevo arbitro.
	 *
	 * @param tablero 
	 */
	public Arbitro (Tablero tablero) {
		this.tablero = tablero;
		contadorJugadas = 0;
	}
	
	/**
	 * Cambiar turno.
	 */
	public void cambiarTurno() {
		if(turno == Color.NEGRO) {
			turno = Color.BLANCO;
		}else {
			turno = Color.NEGRO;
		}
	}
	
	/**
	 * Colocar piezas.
	 *
	 * @param el tipo de las piezas
	 * @param coordenadas donde poner las piezas
	 * @param El turno después de colocar las piezas
	 */
	public void colocarPiezas(TipoPieza[] tipo, int[][] coordenadas, Color turnoActual) {
		this.turno = turnoActual;
		for(int i = 0; i < tipo.length; i++) {
			tablero.colocar(new Pieza(tipo[i]), new Coordenada(coordenadas[i][0] , coordenadas[i][1] ));
		}
	}
	
	/**
	 * Coloca las piezas en la configuracion inicial.
	 */
	public void colocarPiezasConfiguracionInicial() {
		colocarPiezas(new TipoPieza[] {
				TipoPieza.ATACANTE, TipoPieza.ATACANTE, TipoPieza.DEFENSOR, TipoPieza.REY, TipoPieza.DEFENSOR,
				TipoPieza.ATACANTE, TipoPieza.ATACANTE, TipoPieza.ATACANTE, TipoPieza.ATACANTE, TipoPieza.DEFENSOR, 
				TipoPieza.DEFENSOR, TipoPieza.ATACANTE, TipoPieza.ATACANTE}, 
				new int[][] {
						{0,3}, {1,3}, {2,3}, {3,3}, {4,3}, {5,3}, {6,3}, {3,0}, {3,1}, {3,2}, 
						{3,2}, {3,5}, {3,6}, 
				} , Color.NEGRO);
	}
	
	/**
	 * Consultar numero jugada.
	 *
	 * @return Número de jugada
	 */
	public int consultarNumeroJugada() {
		return contadorJugadas;
	}
	
	/**
	 * Consultar tablero.
	 *
	 * @return El tablero
	 */
	public Tablero consultarTablero() {
		return tablero.clonar();
	}
	
	/**
	 * Consultar turno.
	 *
	 * @return El color
	 */
	public Color consultarTurno() {
		return turno;
	}
	
	/**
	 * Es movimiento legal.
	 *
	 * @param jugada a jugar
	 * @return true, si es legal
	 */
	public boolean esMovimientoLegal(Jugada jugada) {
		if(jugada.esMovimientoHorizontalOVertical()) {
			if(tablero.consultarCelda(jugada.destino().coordenada) == null ) {//comprobar si la celda de destino está vacía
				// comprobar que las coordenadas están dentro de los límites del tablero
				if(jugada.origen().coordenada.columna() >= 0 && jugada.origen().coordenada.columna() < Tablero.columnas &&
						jugada.origen().coordenada.fila() >= 0 && jugada.origen().coordenada.fila() < Tablero.filas &&
						jugada.destino().coordenada.columna() >= 0 && jugada.destino().coordenada.columna() < Tablero.columnas &&
						jugada.destino().coordenada.fila() >= 0 && jugada.destino().coordenada.fila() < Tablero.filas) { 
					if(!hayPiezasEntreCeldas(jugada.origen(), jugada.destino())) { //comprobar si hay piezas entre la celda de destino y la de origen
						TipoCelda tipoCelda = tablero.consultarCelda(jugada.destino().coordenada).consultarTipoCelda();
						if(tipoCelda == TipoCelda.PROVINCIA || tipoCelda == TipoCelda.TRONO) {
							if(tablero.consultarCelda(jugada.origen().coordenada).pieza.tipoPieza == TipoPieza.REY) {
								return true;
							}else {
								return false;
							}
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean hayPiezasEntreCeldas(Celda origen, Celda destino) {
		switch((new Jugada(origen, destino)).consultarSentido()) {
		case HORIZONTAL_O:
			for(int i = destino.coordenada.columna(); i < origen.coordenada.columna(); i++) {
				if(!tablero.consultarCelda(new Coordenada(origen.coordenada.fila(), i)).estaVacia()) {
					return true;
				}
			}
		case HORIZONTAL_E:
			for(int i = origen.coordenada.columna(); i < destino.coordenada.columna(); i++) {
				if(!tablero.consultarCelda(new Coordenada(origen.coordenada.fila(), i)).estaVacia()) {
					return true;
				}
			}
		case VERTICAL_N:
			for(int i = destino.coordenada.fila(); i < origen.coordenada.fila(); i++) {
				if(!tablero.consultarCelda(new Coordenada(origen.coordenada.columna(), i)).estaVacia()) {
					return true;
				}
			}
		case VERTICAL_S:
			for(int i = origen.coordenada.fila(); i < destino.coordenada.fila(); i++) {
				if(!tablero.consultarCelda(new Coordenada(origen.coordenada.columna(), i)).estaVacia()) {
					return true;
				}
			}
		default:
			return false;
		}
		
		
	}
	
	/**
	 * Ha ganado atacante.
	 *
	 * @return true, si han ganado los atacantes
	 */
	public boolean haGanadoAtacante() {
		
		return false;
	}
	
	/**
	 * Ha ganado rey.
	 *
	 * @return true, si ha ganado el rey
	 */
	public boolean haGanadoRey() {
		Celda[] celda00 = tablero.consultarCeldasContiguas(new Coordenada(0,0));
		if(hayReyEnCeldas(celda00)) return true;
		Celda[] celda06 = tablero.consultarCeldasContiguas(new Coordenada(0,6));
		if(hayReyEnCeldas(celda06)) return true;
		Celda[] celda60 = tablero.consultarCeldasContiguas(new Coordenada(6,0));
		if(hayReyEnCeldas(celda60)) return true;
		Celda[] celda66 = tablero.consultarCeldasContiguas(new Coordenada(6,6));
		if(hayReyEnCeldas(celda66)) return true;
		return false;
	}
	
	private boolean hayReyEnCeldas(Celda[] celdas) {
		for(int i = 0; i < celdas.length; i++) {
			if(celdas[i].pieza.tipoPieza == TipoPieza.REY) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Mover.
	 *
	 * @param jugada a jugar
	 */
	public void mover(Jugada jugada) {
		//colocar la pieza en el destino
		tablero.colocar(tablero.consultarCelda(jugada.origen().coordenada).pieza, jugada.destino().coordenada);
		//eliminar la pieza del origen
		tablero.eliminarPieza(jugada.origen().coordenada);
		String ultimoMovimiento = Traductor.consultarTextoEnNotacionAlgebraica(jugada.origen().coordenada) + 
				Traductor.consultarTextoEnNotacionAlgebraica(jugada.destino().coordenada);
	}
	
	/**
	 * Realizar capturas tras mover.
	 */
	public void realizarCapturasTrasMover() {
		
	}
}
