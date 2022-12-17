package ucn.cl.taller3.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		
		Sistema sistema = new SistemaImpl();
		
		leerRobots(sistema);
		leerPiezas(sistema);
		leerArmas(sistema);
		leerCombates(sistema);
		menu(sistema);

	}

	private static void leerRobots(Sistema sistema) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Robots.txt"));
		while(arch.hasNextLine()) {
			String linea = arch.nextLine();
			String[] datos = linea.split(", ");
			String nombreRobot = datos[0];
			String arma = datos[1];
			String piernas = datos[2];
			String brazos = datos[3];
			String torax = datos[4];
			String cabeza = datos[5];
			String tipo = datos[6];
			
			if(tipo.equals("H")) {
				String piloto = datos[7];
				String equipo = datos[8];
				sistema.ingresarRobotH(nombreRobot, arma, piernas, brazos, torax, cabeza, piloto, equipo);
			} else if(tipo.equals("A")) {
				int escudo = Integer.parseInt(datos[7]);
				String clase = datos[8];
				sistema.ingresarRobotA(nombreRobot, arma, piernas, brazos, torax, cabeza, escudo, clase);
			}
		}
		arch.close();
	}
	
	private static void leerPiezas(Sistema sistema) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("piezas.txt"));
		while(arch.hasNextLine()) {
			String linea = arch.nextLine();
			String[] datos = linea.split(", ");
			String nombre = datos[0];
			int vidaBase = 2000;
			String rareza = datos[1];
			String tipo = datos[2];
			
			if(tipo.equals("P")) {
				int velocidad = Integer.parseInt(datos[3]);
				sistema.ingresarPiernas(nombre, vidaBase, rareza, velocidad);
			}
			else if(tipo.equals("B")) {
				int ataque = Integer.parseInt(datos[3]);
				sistema.ingresarBrazos(nombre, vidaBase, rareza, ataque);
			
			}
			else if(tipo.equals("T")) {
				int vida = Integer.parseInt(datos[3]);
				sistema.ingresarTorax(nombre, vidaBase, rareza, vida);
			
			}
			else if(tipo.equals("C")) {
				int velocidad = Integer.parseInt(datos[3]);
				int vida = Integer.parseInt(datos[4]);
				sistema.ingresarCabeza(nombre, vidaBase, rareza, velocidad, vida);
			}
		}
		arch.close();
	}
	
	private static void leerArmas(Sistema sistema) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("armas.txt"));
		while(arch.hasNextLine()) {
			String linea = arch.nextLine();
			String[] datos = linea.split(", ");
			String nombre = datos[0];
			int daño = Integer.parseInt(datos[1]);
			int velocidadATK = Integer.parseInt(datos[2]);
			sistema.ingresarArma(nombre, daño, velocidadATK);
		}
		arch.close();
	}
	
	private static void leerCombates(Sistema sistema) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("combates.txt"));
		while(arch.hasNextLine()) {
			String linea = arch.nextLine();
			String[] datos = linea.split(", ");
			String nombreRobotH1 = datos[0];
			String nombreRobotH2 = datos[1];
			String nombreRobotH3 = datos[2];
			String nombreRobotA1 = datos[3];
			String nombreRobotA2 = datos[4];
			String nombreRobotA3 = datos[5];
			String bandoGanador = datos[6];
			sistema.ingresarCombate(nombreRobotH1, nombreRobotH2, nombreRobotH3,
					nombreRobotA1, nombreRobotA2, nombreRobotA3, bandoGanador);
		}
		arch.close();
	}

	private static void menu(Sistema sistema) throws IOException {
		System.out.println("==============================");
		System.out.println(" ==Bienvenido al simulador==");
		System.out.println("==============================");
		
		Scanner read = new Scanner(System.in);
		boolean sigueDentro = true;
		while(sigueDentro) {
			System.out.println();
			System.out.println("[1] Iniciar simulación");
			System.out.println("[2] Añadir pieza");
			System.out.println("[3] Ensamblar robot");
			System.out.println("[4] Cambiar piezas de un robot");
			System.out.println("[5] Cambiar arma de un robot");
			System.out.println("[6] Mostrar estadísticas de los robots");
			System.out.println("[7] Mostrar robots con piloto");
			System.out.println("[8] Mostrar robots de un equipo");
			System.out.println("[9] Ver estadísticas de las victorias ganadas por la humanidad");
			System.out.println("[10] Cerrar sesión");
			System.out.print("Opcion: ");
			
			int opcion = Integer.parseInt(read.nextLine());
			System.out.println();
			switch(opcion) {
			case 1:
				sistema.iniciarSimulacion();
				break;
			case 2:
				sistema.añadirPiezas(read);
				break;
			case 3:
				sistema.ensamblarRobot(read);
				break;
			case 4:
				sistema.cambiarPiezasRobot(read);
				break;
			case 5:
				sistema.cambiarArmas(read);
				break;
			case 6:
				sistema.obtenerEstadisticasRobots();
				break;
			case 7:
				sistema.obtenerRobotsPilotados();
				break;
			case 8:
				sistema.obtenerRobotsDeUnEquipo(read);
				break;
			case 9:
				sistema.obtenerEstadisticasVictoriasDeHumanidad();
				break;
			case 10:
				System.out.println("Cierre de sesión exitoso.");
				sigueDentro = false;
				sistema.sobrescribirDatos();
				break;
			default:
				System.out.println("Ingrese una opción válida.");
			}
		}
	}
}
