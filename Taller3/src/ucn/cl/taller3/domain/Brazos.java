package ucn.cl.taller3.domain;

public class Brazos extends Pieza {
	
	private int ataque;

	public Brazos(String nombre, int vidaBase, String rareza, int ataque) {
		super(nombre, vidaBase, rareza);
		this.ataque = ataque;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
}
