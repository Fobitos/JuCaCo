package ucn.cl.taller3.domain;

public class Arma {
	
	private String nombre;
	private int daño, velocidadATK;
	
	public Arma(String nombre, int daño, int velocidadATK) {
		this.nombre = nombre;
		this.daño = daño;
		this.velocidadATK = velocidadATK;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getVelocidadATK() {
		return velocidadATK;
	}

	public void setVelocidadATK(int velocidadATK) {
		this.velocidadATK = velocidadATK;
	}
}
