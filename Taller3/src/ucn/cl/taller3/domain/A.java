package ucn.cl.taller3.domain;

public class A extends Robot {
	
	private int escudo;
	private String clase;

	public A(String nombreRobot, String arma, String piernas, String brazos, String torax, String cabeza, int escudo, String clase) {
		super(nombreRobot, arma, piernas, brazos, torax, cabeza);
		this.escudo = escudo;
		this.clase = clase;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
}
