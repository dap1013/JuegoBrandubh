package brandubh.control;


import brandubh.modelo.Celda;
import brandubh.modelo.Jugada;
import brandubh.modelo.Pieza;
import brandubh.modelo.Tablero;
import brandubh.util.Color;
import brandubh.util.Coordenada;
import brandubh.util.Sentido;
import brandubh.util.TipoPieza;
import brandubh.util.Traductor;


public class Arbitro {
	
	private Tablero tablero;
	private int contadorJugadas;
	private Color turno;
	
	public Arbitro (Tablero tablero) {
		this.tablero = tablero;
		contadorJugadas = 0;
	}
	
	public void cambiarTurno() {
		if(turno == Color.NEGRO) {
			turno = Color.BLANCO;
		}else {
			turno = Color.NEGRO;
		}
	}
	
	public void colocarPiezas(TipoPieza[] tipo, int[][] coordenadas, Color turnoActual) {
		this.turno = turnoActual;
		for(int i = 0; i < tipo.length; i++) {
			tablero.colocar(new Pieza(tipo[i]), new Coordenada(coordenadas[i][0] , coordenadas[i][1] ));
		}
	}
	
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
	
	public int consultarNumeroJugada() {
		return contadorJugadas;
	}
	
	public Tablero consultarTablero() {
		return tablero.clonar();
	}
	
	public Color consultarTurno() {
		return turno;
	}
	
	public boolean esMovimientoLegal(Jugada jugada) {
		if(jugada.esMovimientoHorizontalOVertical()) {
			if(tablero.consultarCelda(jugada.destino().coordenada) == null) {//comprobar si la celda de destino está vacía
				// comprobar que las coordenadas están dentro de los límites del tablero
				if(jugada.origen().coordenada.columna() >= 0 && jugada.origen().coordenada.columna() < Tablero.columnas &&
						jugada.origen().coordenada.fila() >= 0 && jugada.origen().coordenada.fila() < Tablero.filas &&
						jugada.destino().coordenada.columna() >= 0 && jugada.destino().coordenada.columna() < Tablero.columnas &&
						jugada.destino().coordenada.fila() >= 0 && jugada.destino().coordenada.fila() < Tablero.filas) { 
					if(!hayPiezasEntreCeldas(jugada.origen(), jugada.destino())) { //comprobar si hay piezas entre la celda de destino y la de origen
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
	
	public boolean haGanadoAtacante() {
		
	}
	
	public boolean haGanadoRey() {
		
	}
	
	public void mover(Jugada jugada) {
		//colocar la pieza en el destino
		tablero.colocar(tablero.consultarCelda(jugada.origen().coordenada).pieza, jugada.destino().coordenada);
		//eliminar la pieza del origen
		tablero.eliminarPieza(jugada.origen().coordenada);
		String ultimoMovimiento = Traductor.consultarTextoEnNotacionAlgebraica(jugada.origen().coordenada) + 
				Traductor.consultarTextoEnNotacionAlgebraica(jugada.destino().coordenada);
	}
	
	public void realizarCapturasTrasMover() {
		
	}
}
