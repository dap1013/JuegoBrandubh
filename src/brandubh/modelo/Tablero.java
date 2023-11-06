package brandubh.modelo;

import brandubh.util.Coordenada;
import brandubh.util.TipoCelda;
import brandubh.util.TipoPieza;

/**
 * Clase del tipo Tablero.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */

public class Tablero {
	
	public static final int filas = 7;
	public static final int columnas = 7;

	private Celda[][] matriz;
	
	public Tablero() {
		matriz = new Celda[filas][columnas];
		inicializarTablero();
	}
	
	
	private void inicializarTablero() {
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				if((i == 0 && j == 0) || (i == 0 && j==6) || (i == 6 && j == 0) || i == 6 && j == 6) {
					matriz[i][j] = new Celda(new Coordenada(i, j), TipoCelda.PROVINCIA);
				}else if(i == 3 && j == 3) {
					matriz[i][j] = new Celda(new Coordenada(i, j), TipoCelda.TRONO);
				}else {
					matriz[i][j] = new Celda(new Coordenada(i, j));
				}
			}
		}
		colocarPiezasInicio();
		
	}
	private void colocarPiezasInicio() {
		matriz[0][3].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[1][3].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[2][3].colocar(new Pieza(TipoPieza.DEFENSOR));
		matriz[3][3].colocar(new Pieza(TipoPieza.REY));
		matriz[4][3].colocar(new Pieza(TipoPieza.DEFENSOR));
		matriz[5][3].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[6][3].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[3][0].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[3][1].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[3][2].colocar(new Pieza(TipoPieza.DEFENSOR));
		matriz[3][4].colocar(new Pieza(TipoPieza.DEFENSOR));
		matriz[3][5].colocar(new Pieza(TipoPieza.ATACANTE));
		matriz[3][6].colocar(new Pieza(TipoPieza.ATACANTE));
		
	}
	
	public String aTexto() {
		
	}
	
	public Tablero clonar() {
		
	}
	
	public void colocar(Pieza pieza, Coordenada coordenada) {
		
	}
	
	public Celda consultarCelda(Coordenada coordenada) {
		
	}
	
	public Celda[] consultarCeldas() {
		
	}
	
	public Celda[] consultarCeldasContiguas(Coordenada coordenada) {
		
	}
	
	public Celda[] consultarCeldasContiguasEnHorizontal(Coordenada coordenada) {
		
	}
	
	public Celda[] consultarCeldasContiguasEnVertical(Coordenada coordenada) {
		
	}
	
	public int consultarNumeroColumnas() {
		
	}
	
	public int consultarNumeroFilas() {
		
	}
	
	public int consultarNumeroPiezas(TipoPieza tipoPieza) {
		
	}
	
	public void eliminarPieza(Coordenada coordenada) {
		
	}
	public Celda obtenerCelda(Coordenada coordenada) {
		
	}
	
	//Falta por implementar toString(), hashCode() y equals(), generarlos cuando se termine la clase
	
	
}