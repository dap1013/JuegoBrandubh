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
		
	}
	
	public String aTexto() {
		
        String estadoTablero = "Estado del tablero actual: \n";
        for (int i = 0; i< filas; i++ ) {
        	estadoTablero += String.valueOf(( filas - i));
        	for (int j = 0; j< columnas; j++) {
        		if (matriz[i][j].estaVacia()) {
        			estadoTablero += " -";	
        		} else {
        			if(matriz[i][j].pieza.tipoPieza == TipoPieza.ATACANTE) {
        				estadoTablero += " A";
        			}else if(matriz[i][j].pieza.tipoPieza == TipoPieza.DEFENSOR) {
        				estadoTablero += " D";
        			}else {
        				estadoTablero += " R";
        			}
        		}
        	}
        }
        estadoTablero += "  a b c d e f g";
		return estadoTablero;
	}
	
	public Tablero clonar() {
		
		Tablero TableroClonado = new Tablero();
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				TableroClonado.matriz[i][j] = this.matriz[i][j].clonar();
			}
		}
		return TableroClonado;
		
	}
	
		
	public void colocar(Pieza pieza, Coordenada coordenada) {
	
		matriz[coordenada.fila()][coordenada.columna()].colocar(pieza);
	}
	
	public Celda consultarCelda(Coordenada coordenada) {
		return matriz[coordenada.fila()][coordenada.columna()];
	}
		
	public Celda[] consultarCeldas() {
		return consultarCeldas();
	}
	
	public Celda[] consultarCeldasContiguas(Coordenada coordenada) {
		Celda[] celdasContiguas = new Celda[4];
		Celda[] celdasContiguasHorizontal = consultarCeldasContiguasEnHorizontal(coordenada);
		Celda[] celdasContiguasVertical = consultarCeldasContiguasEnVertical(coordenada);
		System.arraycopy(celdasContiguasHorizontal, 0, celdasContiguas, 0, 2);
		System.arraycopy(celdasContiguasVertical, 0, celdasContiguasVertical, 2, 2);
		return celdasContiguas;
	}
	
	public Celda[] consultarCeldasContiguasEnHorizontal(Coordenada coordenada) {
		Celda[] celdasContiguas = new Celda[2];
		
		celdasContiguas[0] = matriz[coordenada.fila()][coordenada.columna() + 1].clonar();
		celdasContiguas[1] = matriz[coordenada.fila()][coordenada.columna() - 1].clonar();
		
		return celdasContiguas;
	}
	
	public Celda[] consultarCeldasContiguasEnVertical(Coordenada coordenada) {
		Celda[] celdasContiguas = new Celda[2];
		
		celdasContiguas[0] = matriz[coordenada.fila() + 1][coordenada.columna()].clonar();
		celdasContiguas[1] = matriz[coordenada.fila() - 1][coordenada.columna()].clonar();
		
		return celdasContiguas;
	}
	
	public int consultarNumeroColumnas() {
		return columnas;
	}
	
	public int consultarNumeroFilas() {
		return filas;
	}
	
	public int consultarNumeroPiezas(TipoPieza tipoPieza) {
		int numPiezas = 0;
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				if(!matriz[i][j].estaVacia()) {
					if(matriz[i][j].pieza.tipoPieza == tipoPieza) {
						numPiezas++;
					}
				}
			}
		}
		return numPiezas;
	}
	
	public void eliminarPieza(Coordenada coordenada) {
		matriz[coordenada.fila()][coordenada.columna()].eliminarPieza();
	}
	public Celda obtenerCelda(Coordenada coordenada) {
		return matriz[coordenada.fila()][coordenada.columna()];
	}
	
	//Falta por implementar toString(), hashCode() y equals(), generarlos cuando se termine la clase
	
	
}