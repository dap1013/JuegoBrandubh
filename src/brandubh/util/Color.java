package brandubh.util;

/**
 * Enum que representa el color de las piezas del juego.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public enum Color {
	
	/** Color blanco. */
	BLANCO('B'), 
	/** Color negro. */
	NEGRO('N');
	
	/** guarda la letra del color. */
	private char letra;
	
	/**
	 * Instancia un nuevo color.
	 *
	 * @param letra del color
	 */
	private Color(char letra) {
		this.letra = letra;
	}
	
	/**
	 * Consulta el color contrario al suyo.
	 *
	 * @return color contrario
	 */
	public Color consultarContrario() {
		if(letra == 'B') {
			return Color.NEGRO;
		}
		return Color.BLANCO;
	}
	
	/**
	 * Devuelve el caracter correspondiente a ese color.
	 *
	 * @return caracter correspondiente a ese color
	 */
	public char toChar() {
		return letra;
	}
}
