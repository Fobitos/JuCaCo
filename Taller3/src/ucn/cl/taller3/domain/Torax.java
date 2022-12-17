package ucn.cl.taller3.domain;

public class Torax extends Pieza {
	
	private int vida;
	
	public Torax(String nombre, int vidaBase, String rareza, int vida) {
		super(nombre, vidaBase, rareza);
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
