package ucn.cl.taller3.domain;

public class Arma {
	
	private String nombre;
	private int da�o, velocidadATK;
	
	public Arma(String nombre, int da�o, int velocidadATK) {
		this.nombre = nombre;
		this.da�o = da�o;
		this.velocidadATK = velocidadATK;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public int getVelocidadATK() {
		return velocidadATK;
	}

	public void setVelocidadATK(int velocidadATK) {
		this.velocidadATK = velocidadATK;
	}
}
