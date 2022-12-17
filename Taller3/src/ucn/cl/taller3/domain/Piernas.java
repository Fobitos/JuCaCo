package ucn.cl.taller3.domain;

public class Piernas extends Pieza {
	
	private int velocidad;
	
	public Piernas(String nombre, int vidaBase, String rareza, int velocidad) {
		super(nombre, vidaBase, rareza);
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
}
