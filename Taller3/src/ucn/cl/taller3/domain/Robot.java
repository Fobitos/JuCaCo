package ucn.cl.taller3.domain;

public class Robot {
	
	private String nombreRobot, arma, piernas,
	brazos, torax, cabeza;

	public Robot(String nombreRobot, String arma, String piernas, String brazos, String torax, String cabeza) {
		this.nombreRobot = nombreRobot;
		this.arma = arma;
		this.piernas = piernas;
		this.brazos = brazos;
		this.torax = torax;
		this.cabeza = cabeza;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getPiernas() {
		return piernas;
	}

	public void setPiernas(String piernas) {
		this.piernas = piernas;
	}

	public String getBrazos() {
		return brazos;
	}

	public void setBrazos(String brazos) {
		this.brazos = brazos;
	}

	public String getTorax() {
		return torax;
	}

	public void setTorax(String torax) {
		this.torax = torax;
	}

	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
}
