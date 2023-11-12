package brandubh.control;

import brandubh.modelo.Jugada;
import brandubh.modelo.Pieza;
import brandubh.modelo.Tablero;
import brandubh.util.Color;
import brandubh.util.Coordenada;
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
		
	}
	
	public void colocarPiezasConfiguracionInicial() {
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(0,3));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(1,3));
		tablero.colocar(new Pieza(TipoPieza.DEFENSOR), new Coordenada(2,3));
		tablero.colocar(new Pieza(TipoPieza.REY), new Coordenada(3,3));
		tablero.colocar(new Pieza(TipoPieza.DEFENSOR), new Coordenada(4,3));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(5,3));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(6,3));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(3,0));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(3,1));
		tablero.colocar(new Pieza(TipoPieza.DEFENSOR), new Coordenada(3,2));
		tablero.colocar(new Pieza(TipoPieza.DEFENSOR), new Coordenada(3,4));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(3,5));
		tablero.colocar(new Pieza(TipoPieza.ATACANTE), new Coordenada(3,6));
		turno = Color.NEGRO;
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
		
	}
	
	public boolean haGanadoAtacante() {
		
	}
	
	public boolean haGanadoRey() {
		
	}
	
	public void mover(Jugada jugada) {
		
	}
	
	public void realizarCapturasTrasMover() {
		
	}
}
