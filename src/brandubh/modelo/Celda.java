package brandubh.modelo;

import java.util.Objects;

import brandubh.util.Color;
import brandubh.util.Coordenada;
import brandubh.util.TipoCelda;

/**
 * Clase del tipo Celda.
 * 
 * @author Diego Arbeloa
 * @author Victor Vidal
 * @version 1.0
 * @since 1.0
 */
public class Celda {
	
	/** La coordenada. */
	public Coordenada coordenada;
	
	/** El tipo de la celda. */
	private TipoCelda tipoCelda;
	
	/** La pieza. */
	public Pieza pieza;
	
	/**
	 * Instancia una nueva celda.
	 *
	 * @param coordenada de la celda
	 */
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.tipoCelda = TipoCelda.NORMAL;
	}
	
	/**
	 * Instancia una nueva celda.
	 *
	 * @param coordenada de la celda
	 * @param tipoCelda tipo de la celda
	 */
	public Celda(Coordenada coordenada, TipoCelda tipoCelda) {
		this.coordenada = coordenada; 
		this.tipoCelda = tipoCelda;
	}
	
	/**
	 * Crea un clon en profundidad de la celda.
	 *
	 * @return clon de la celda
	 */
	public Celda clonar() {		
		Celda nueva = new Celda(new Coordenada(coordenada.fila(), coordenada.columna()), consultarTipoCelda());
		if(pieza != null) {
			Pieza nuevaPieza = new Pieza(this.pieza.consultarTipoPieza());
			nueva.pieza = nuevaPieza;
		}
		
		return nueva;
	}
	
	/**
	 * Colocar una pieza en la celda.
	 *
	 * @param pieza en la celda
	 */
	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}
	
	/**
	 * Consultar color de pieza.
	 *
	 * @return El color de la pieza
	 */
	public Color consultarColorDePieza() {
		if(!estaVacia()) {
			return pieza.color;
		}
		return null;
	}
	
	/**
	 * Consultar coordenada.
	 *
	 * @return La coordenada de la celda
	 */
	public Coordenada consultarCoordenada() {
		return coordenada;
	}
	
	/**
	 * Consultar pieza.
	 *
	 * @return La pieza en la celda, null = no hay pieza
	 */
	public Pieza consultarPieza() {
		if(!estaVacia()) {
			return new Pieza(pieza.tipoPieza);
		}
		return null;
	}
	
	/**
	 * Consultar tipo celda.
	 *
	 * @return El tipo de la celda
	 */
	public TipoCelda consultarTipoCelda() {
		return tipoCelda;
	}
	
	/**
	 * Elimina la asignación de la pieza.
	 */
	public void eliminarPieza() {
		this.pieza = null;
	}
	
	/**
	 * Comprueba si la celda tiene una pieza o no.
	 *
	 * @return resultado de comprobar si hay pieza, false = hay pieza
	 */
	public boolean estaVacia() {
		return pieza!=null?false:true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza, tipoCelda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza)
				&& tipoCelda == other.tipoCelda;
	}

	@Override
	public String toString() {
		return "Celda [coordenada=" + coordenada + ", tipoCelda=" + tipoCelda + ", pieza=" + pieza + "]";
	}
	
}
