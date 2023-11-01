package brandubh.modelo;

import java.util.Objects;

import brandubh.util.Color;
import brandubh.util.TipoPieza;

/**
 * Clase que representa una pieza.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public class Pieza {
	
	/** Color de la pieza. */
	public Color color;
	
	/** Tipo de la pieza. */
	public TipoPieza tipoPieza;
	
	/**
	 * Instancia una nueva pieza.
	 *
	 * @param tipoPieza el tipo de la pieza
	 */
	public Pieza(TipoPieza tipoPieza) {
		this.color = tipoPieza.consultarColor();
		this.tipoPieza = tipoPieza;
	}
	
	/**
	 * Clona en profundida la pieza.
	 *
	 * @return la pieza clonada
	 */
	public Pieza clonar() {
		Pieza nueva = new Pieza(this.tipoPieza);
		return nueva;
	}
	
	/**
	 * Consultar color.
	 *
	 * @return el color
	 */
	public Color consultarColor() {
		return color;
	}
	
	/**
	 * Consultar tipo pieza.
	 *
	 * @return el tipo de la pieza
	 */
	public TipoPieza consultarTipoPieza() {
		return tipoPieza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, tipoPieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		return color == other.color && tipoPieza == other.tipoPieza;
	}

	@Override
	public String toString() {
		return "Pieza [color=" + color + ", tipoPieza=" + tipoPieza + "]";
	}
	
	
}
