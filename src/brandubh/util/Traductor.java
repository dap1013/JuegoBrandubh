package brandubh.util;

import brandubh.modelo.Tablero;

/**
 * Clase para traducir las coordenadas.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public class Traductor {
		
	/**
	 * Consultar coordenada para notacion algebraica.
	 *
	 * @param texto the texto
	 * @return La coordenada en tipo coordenada
	 */
	public static Coordenada consultarCoordenadaParaNotacionAlgebraica(String texto) {
		if(esTextoCorrectoParaCoordenada(texto)) {
			Coordenada coordenada = new Coordenada(Tablero.filas - Integer.parseInt(String.valueOf(texto.toLowerCase().charAt(1))), ((int) texto.toLowerCase().charAt(0) - 97));
			return coordenada;
		}
		return null;
	}
	
	/**
	 * Consultar texto en notacion algebraica.
	 *
	 * @param coordenada a consultar
	 * @return coordenada en tipo texto
	 */
	public static String consultarTextoEnNotacionAlgebraica(Coordenada coordenada) {
		if(coordenada.fila() >= 0 && coordenada.fila() < Tablero.filas && coordenada.columna() >= 0 && coordenada.columna() < Tablero.columnas) {
			return String.valueOf((char)(coordenada.columna() + 97)) + String.valueOf((Tablero.filas - coordenada.fila()));
		}
		return null;
	}
	
	/**
	 * Comprueba si el texto pasado corresponde a una coordenada válida.
	 *
	 * @param texto a comprobar
	 * @return true, si el texto es correxto
	 */
	public static boolean esTextoCorrectoParaCoordenada(String texto) {
		if(!texto.isEmpty() || !texto.isBlank() || texto != null) {
			if(texto.length() == 2) {
				try {
					char letra = texto.charAt(0);
					int numero = Integer.parseInt(String.valueOf(texto.charAt(1)));
					if(numero > 0 && numero <= Tablero.filas && ((int)letra) >= 97 && ((int) letra) <= (97 + Tablero.columnas)) {
						return true;
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					return false;
				}
				
			}
		}
		return false;
	}
}
