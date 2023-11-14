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
		
        String estadoTablero = "Estado del tablero actual: \n";
        for (int i = 0; i<matriz.length; i++ ) {
        	for (int j = 0; j<matriz[i].length; j++) {
        		Celda celda = matriz [i][j];
        		if (celda.estaVacia()) {
        			estadoTablero = estadoTablero + '_';	
        		} else {
        			estadoTablero = estadoTablero + '\n';        		}
        	}
        }
		return estadoTablero;
	}
	
	public Tablero Clonar() {
		
		Tablero TableroClonado = new Tablero();
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				TableroClonado.matriz[i][j] = this.matriz[i][j].clonar();
			}
		}
		return TableroClonado;
		
	}
	
	//Poner las public coordenada,celda,tipopieza...
		
	public void colocar(Pieza pieza, Coordenada coordenada) {
	
		//Se verifica si las coordenadas estan dentro del tablero
		if(coordenada.equals(coordenada)  && pieza != null) {
			matriz[filas][columnas].colocar(pieza);
		}
		
	}
	
	public Celda consultarCelda(Coordenada coordenada) {
		if(coordenada.equals(coordenada))	{
		return matriz[filas][columnas].clonar();
		}else{
			return null;
		}
	}
		
	public Celda[] consultarCeldas() {
		return consultarCeldas();
	}
	
	public Celda[] consultarCeldasContiguas(Coordenada coordenada) {
		
	}
	
	public Celda[] consultarCeldasContiguasEnHorizontal(Coordenada coordenada) {
		
	}
	
	public Celda[] consultarCeldasContiguasEnVertical(Coordenada coordenada) {
		
	}
	
	public int consultarNumeroColumnas() {
		return matriz[0].length;
	}
	
	public int consultarNumeroFilas() {
		return matriz.length;
	}
	
	public int consultarNumeroPiezas(TipoPieza tipoPieza) {
		
	}
	
	public void eliminarPieza(Coordenada coordenada) {
		
	}
	public Celda obtenerCelda(Coordenada coordenada) {
		
	}
	
	//Falta por implementar toString(), hashCode() y equals(), generarlos cuando se termine la clase
	
	
}