package ucn.cl.taller3.domain;

public class H extends Robot {
	
	private String piloto, equipo;

	public H(String nombreRobot, String arma, String piernas, String brazos, String torax, String cabeza, String piloto, String equipo) {
		super(nombreRobot, arma, piernas, brazos, torax, cabeza);
		this.piloto = piloto;
		this.equipo = equipo;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}