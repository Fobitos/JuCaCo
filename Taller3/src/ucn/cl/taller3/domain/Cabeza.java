package ucn.cl.taller3.domain;

public class Cabeza extends Pieza {
	
	private int velocidad, vida;

	public Cabeza(String nombre, int vidaBase, String rareza, int velocidad, int vida) {
		super(nombre, vidaBase, rareza);
		this.velocidad = velocidad;
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
