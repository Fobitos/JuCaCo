package ucn.cl.taller3.domain;

public class Combate {
	
	private String nombreRobotH1, nombreRobotH2, nombreRobotH3,
	nombreRobotA1, nombreRobotA2, nombreRobotA3, bandoGanador;

	public Combate(String nombreRobotH1, String nombreRobotH2, String nombreRobotH3, String nombreRobotA1,
			String nombreRobotA2, String nombreRobotA3, String bandoGanador) {
		this.nombreRobotH1 = nombreRobotH1;
		this.nombreRobotH2 = nombreRobotH2;
		this.nombreRobotH3 = nombreRobotH3;
		this.nombreRobotA1 = nombreRobotA1;
		this.nombreRobotA2 = nombreRobotA2;
		this.nombreRobotA3 = nombreRobotA3;
		this.bandoGanador = bandoGanador;
	}

	public String getNombreRobotH1() {
		return nombreRobotH1;
	}

	public void setNombreRobotH1(String nombreRobotH1) {
		this.nombreRobotH1 = nombreRobotH1;
	}

	public String getNombreRobotH2() {
		return nombreRobotH2;
	}

	public void setNombreRobotH2(String nombreRobotH2) {
		this.nombreRobotH2 = nombreRobotH2;
	}

	public String getNombreRobotH3() {
		return nombreRobotH3;
	}

	public void setNombreRobotH3(String nombreRobotH3) {
		this.nombreRobotH3 = nombreRobotH3;
	}

	public String getNombreRobotA1() {
		return nombreRobotA1;
	}

	public void setNombreRobotA1(String nombreRobotA1) {
		this.nombreRobotA1 = nombreRobotA1;
	}

	public String getNombreRobotA2() {
		return nombreRobotA2;
	}

	public void setNombreRobotA2(String nombreRobotA2) {
		this.nombreRobotA2 = nombreRobotA2;
	}

	public String getNombreRobotA3() {
		return nombreRobotA3;
	}

	public void setNombreRobotA3(String nombreRobotA3) {
		this.nombreRobotA3 = nombreRobotA3;
	}

	public String getBandoGanador() {
		return bandoGanador;
	}

	public void setBandoGanador(String bandoGanador) {
		this.bandoGanador = bandoGanador;
	}
}
