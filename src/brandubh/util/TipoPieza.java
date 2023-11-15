package brandubh.util;

/**
 * Enum que guarda el tipo de la pieza.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public enum TipoPieza {
	
	/** El defensor. */
	DEFENSOR('D', Color.BLANCO), 
	/** El atacante. */
	ATACANTE('A', Color.NEGRO), 
	/** El rey. */
	REY('R', Color.BLANCO);
		
	/** Caracter que guarda la letra de la pieza. */
	private char caracter;
	
	/** Color de la pieza. */
	private Color color;
	
	/**
	 * Instancia un nuevo tipo pieza.
	 *
	 * @param caracter de la pieza
	 * @param color de la pieza
	 */
	private TipoPieza(char caracter, Color color) {
		this.caracter = caracter;
		this.color = color;
	}

	/**
	 * Consultar color.
	 *
	 * @return el color de la pieza
	 */
	public Color consultarColor() {
		return color;
	}
	
	/**
	 * To char.
	 *
	 * @return el caracter de la pieza
	 */
	public char toChar() {
		return caracter;
	}
}
