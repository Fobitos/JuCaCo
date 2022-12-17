package ucn.cl.taller3.logic;

import java.io.IOException;
import java.util.Scanner;

public interface Sistema {

	void ingresarRobotH(String nombreRobot, String arma, String piernas, String brazos, String torax, String cabeza,
			String piloto, String equipo);

	void ingresarRobotA(String nombreRobot, String arma, String piernas, String brazos, String torax, String cabeza,
			int escudo, String clase);

	void ingresarPiernas(String nombre, int vidaBase, String rareza, int velocidad);

	void ingresarBrazos(String nombre, int vidaBase, String rareza, int ataque);

	void ingresarTorax(String nombre, int vidaBase, String rareza, int vida);

	void ingresarCabeza(String nombre, int vidaBase, String rareza, int velocidad, int vida);

	void ingresarArma(String nombre, int daño, int velocidadATK);

	void ingresarCombate(String nombreRobotH1, String nombreRobotH2, String nombreRobotH3, String nombreRobotA1,
			String nombreRobotA2, String nombreRobotA3, String bandoGanador);

	void iniciarSimulacion();
	
	void añadirPiezas(Scanner read);
	
	void ensamblarRobot(Scanner read);
	
	void cambiarPiezasRobot(Scanner read);
	
	void cambiarArmas(Scanner read);
	
	void obtenerEstadisticasRobots();
	
	void obtenerRobotsPilotados();
	
	void obtenerRobotsDeUnEquipo(Scanner read);
	
	void obtenerEstadisticasVictoriasDeHumanidad();
	
	void sobrescribirDatos() throws IOException;

}
