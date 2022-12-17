package ucn.cl.taller3.domain;

public class Pieza {
	
	private String nombre;
	private int vidaBase;
	private String rareza;
	
	public Pieza(String nombre, int vidaBase, String rareza) {
		this.nombre = nombre;
		this.vidaBase = vidaBase;
		this.rareza = rareza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public void setVidaBase(int vidaBase) {
		this.vidaBase = vidaBase;
	}

	public String getRareza() {
		return rareza;
	}

	public void setRareza(String rareza) {
		this.rareza = rareza;
	}
}
