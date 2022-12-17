package ucn.cl.taller3.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ucn.cl.taller3.domain.A;
import ucn.cl.taller3.domain.Arma;
import ucn.cl.taller3.domain.Brazos;
import ucn.cl.taller3.domain.Cabeza;
import ucn.cl.taller3.domain.Combate;
import ucn.cl.taller3.domain.H;
import ucn.cl.taller3.domain.Piernas;
import ucn.cl.taller3.domain.Pieza;
import ucn.cl.taller3.domain.Robot;
import ucn.cl.taller3.domain.Torax;

public class SistemaImpl implements Sistema {
	
	private ArrayList<Combate> listaCombates;
	private ArrayList<Robot> listaRobots;
	private ArrayList<Pieza> listaPiezas;
	private ArrayList<Arma> listaArmas;
	
	public SistemaImpl() {
		listaCombates = new ArrayList<Combate>();
		listaRobots = new ArrayList<Robot>();
		listaPiezas = new ArrayList<Pieza>();
		listaArmas = new ArrayList<Arma>();
	}

	@Override
	public void ingresarRobotH(String nombreRobot, String arma, String piernas, String brazos, String torax,
			String cabeza, String piloto, String equipo) {
		Robot h = new H(nombreRobot, arma, piernas, brazos, torax, cabeza, piloto, equipo);
		listaRobots.add(h);
	}

	@Override
	public void ingresarRobotA(String nombreRobot, String arma, String piernas, String brazos, String torax,
			String cabeza, int escudo, String clase) {
		Robot a = new A(nombreRobot, arma, piernas, brazos, torax, cabeza, escudo, clase);
		listaRobots.add(a);
	}

	@Override
	public void ingresarPiernas(String nombre, int vidaBase, String rareza, int velocidad) {
		Pieza p = new Piernas(nombre, vidaBase, rareza, velocidad);
		listaPiezas.add(p);
	}

	@Override
	public void ingresarBrazos(String nombre, int vidaBase, String rareza, int ataque) {
		Pieza b = new Brazos(nombre, vidaBase, rareza, ataque);
		listaPiezas.add(b);
	}

	@Override
	public void ingresarTorax(String nombre, int vidaBase, String rareza, int vida) {
		Pieza t = new Torax(nombre, vidaBase, rareza, vida);
		listaPiezas.add(t);
		
	}

	@Override
	public void ingresarCabeza(String nombre, int vidaBase, String rareza, int velocidad, int vida) {
		Pieza c = new Cabeza(nombre, vidaBase, rareza, velocidad, vida);
		listaPiezas.add(c);
	}

	@Override
	public void ingresarArma(String nombre, int daño, int velocidadATK) {
		Arma a = new Arma(nombre, daño, velocidadATK);
		listaArmas.add(a);
	}

	@Override
	public void ingresarCombate(String nombreRobotH1, String nombreRobotH2, String nombreRobotH3, String nombreRobotA1,
			String nombreRobotA2, String nombreRobotA3, String bandoGanador) {
		Combate c = new Combate(nombreRobotH1, nombreRobotH2, nombreRobotH3,
					nombreRobotA1, nombreRobotA2, nombreRobotA3, bandoGanador);
		listaCombates.add(c);
	}
	
	@Override
	public void iniciarSimulacion() {
		System.out.println("No me dio el tiempo :<");
		
	}
	
	@Override
	public void añadirPiezas(Scanner read) {
		int vidaBase = 2000;
		String rareza = "";
		
		System.out.print("Ingrese el nombre de la pieza: ");
		String nombre = read.nextLine();
		System.out.println();
		
		boolean aunNoEscoge = true;
		while(aunNoEscoge) {
			System.out.println("Escoja la rareza");
			System.out.println("[1] PC");
			System.out.println("[2] PE");
			System.out.println("[3] PP");
			System.out.print("Opcion: ");
			
			int opcion = Integer.parseInt(read.nextLine());
			System.out.println();
			switch(opcion) {
			case 1:
				rareza = "PC";
				aunNoEscoge = false;
				break;
			case 2:
				rareza = "PE";
				aunNoEscoge = false;
				break;
			case 3:
				rareza = "PP";
				aunNoEscoge = false;
				break;
			default:
				System.out.println("  - Escoja una opción válida.");
				System.out.println();
			}
		}
		
		aunNoEscoge = true;
		while(aunNoEscoge) {
			System.out.println("Escoja el tipo");
			System.out.println("[1] Piernas");
			System.out.println("[2] Brazos");
			System.out.println("[3] Torax");
			System.out.println("[4] Cabeza");
			System.out.print("Opcion: ");
			
			int opcion  = Integer.parseInt(read.nextLine());
			System.out.println();
			switch(opcion) {
			case 1:
				System.out.print("Ingrese velocidad: ");
				int velocidad = Integer.parseInt(read.nextLine());
				
				Pieza p = new Piernas(nombre, vidaBase, rareza, velocidad);
				listaPiezas.add(p);
				
				aunNoEscoge = false;
				break;
			case 2:
				System.out.print("Ingrese ataque: ");
				int ataque = Integer.parseInt(read.nextLine());
				
				Pieza b = new Brazos(nombre, vidaBase, rareza, ataque);
				listaPiezas.add(b);
				
				aunNoEscoge = false;
				break;
			case 3:
				System.out.print("Ingrese vida: ");
				int vida = Integer.parseInt(read.nextLine());
				
				Pieza t = new Torax(nombre, vidaBase, rareza, vida);
				listaPiezas.add(t);
				
				aunNoEscoge = false;
				break;
			case 4:
				System.out.print("Ingrese velocidad: ");
				velocidad = Integer.parseInt(read.nextLine());
				
				System.out.println();
				System.out.print("Ingrese vida: ");
				vida = Integer.parseInt(read.nextLine());
				
				Pieza c = new Cabeza(nombre, vidaBase, rareza, velocidad, vida);
				listaPiezas.add(c);
				
				aunNoEscoge = false;
				break;
			default:
				System.out.println("  - Escoja una opción válida.");
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("  - Pieza añadida exitosamente.");
		
	}
	
	@Override
	public void ensamblarRobot(Scanner read) {
		System.out.print("Ingrese el nombre del nuevo robot: ");
		String nombreRobot = read.nextLine();
		System.out.println();
		
		System.out.println("Escoja un arma para el nuevo robot:");
		for(int i = 0; i < listaArmas.size(); i++) {
			System.out.println("   [" + i + "] " + listaArmas.get(i).getNombre());
		}
		System.out.print("Opcion: ");
		int opcionArma = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionArma < 0 || opcionArma > listaArmas.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionArma = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		String nombreArma = listaArmas.get(opcionArma).getNombre();
		
		System.out.println("Escoja unas Piernas para el nuevo robot:");
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i) instanceof Piernas) {
				System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
			}
		}
		System.out.print("Opcion: ");
		int opcionPiernas = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionPiernas < 0 || opcionPiernas > listaPiezas.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionPiernas = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		String nombrePiernas = listaPiezas.get(opcionPiernas).getNombre();
		
		System.out.println("Escoja unos Brazos para el nuevo robot:");
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i) instanceof Brazos) {
				System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
			}
		}
		System.out.print("Opcion: ");
		int opcionBrazos = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionBrazos < 0 || opcionBrazos > listaPiezas.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionBrazos = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		String nombreBrazos = listaPiezas.get(opcionBrazos).getNombre();
		
		System.out.println("Escoja un Torax para el nuevo robot:");
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i) instanceof Torax) {
				System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
			}
		}
		System.out.print("Opcion: ");
		int opcionTorax = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionTorax < 0 || opcionTorax > listaPiezas.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionTorax = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		String nombreTorax = listaPiezas.get(opcionTorax).getNombre();
		
		System.out.println("Escoja una Cabeza para el nuevo robot:");
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i) instanceof Cabeza) {
				System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
			}
		}
		System.out.print("Opcion: ");
		int opcionCabeza = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionCabeza < 0 || opcionCabeza > listaPiezas.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionCabeza = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		String nombreCabeza = listaPiezas.get(opcionCabeza).getNombre();
		
		System.out.println("¿A qué bando pertenece el robot?");
		System.out.println("[1] Humanidad");
		System.out.println("[2] Alienígenas");
		System.out.print("Opcion: ");
		int opcionBando = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionBando < 1 || opcionBando > 2) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionBando = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		
		if(opcionBando == 1) {
			System.out.print("Ingrese el nombre del piloto (ingresar -nulo- si no tiene): ");
			String piloto = read.nextLine();
			System.out.println();
			
			System.out.print("Ingrese el nombre del equipo al que pertenece: ");
			String equipo = read.nextLine();
			System.out.println();
			
			Robot h = new H(nombreRobot, nombreArma, nombrePiernas, nombreBrazos, nombreTorax, nombreCabeza, piloto, equipo);
			listaRobots.add(h);
			System.out.println("  - Robot ingresado exitosamente.");
		}
		else if(opcionBando == 2) {
			System.out.print("Ingrese la cantidad de escudo del robot: ");
			int escudo = Integer.parseInt(read.nextLine());
			System.out.println();
			
			System.out.print("Ingrese la clase del robot (SS+ | S+ | S | A | B): ");
			String clase = read.nextLine();
			System.out.println();
			
			Robot a = new A(nombreRobot, nombreArma, nombrePiernas, nombreBrazos, nombreTorax, nombreCabeza, escudo, clase);
			listaRobots.add(a);
			System.out.println("  - Robot ingresado exitosamente.");
		}
	}
	
	@Override
	public void cambiarPiezasRobot(Scanner read) {
		System.out.println("Escoja un robot para cambiar sus piezas:");
		for(int i = 0; i < listaRobots.size(); i++) {
			System.out.println("   [" + i + "] " + listaRobots.get(i).getNombreRobot());
		}
		System.out.print("Opcion: ");
		int opcionRobot = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionRobot < 0 || opcionRobot > listaRobots.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionRobot = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		
		System.out.println("¿Qué pieza desea cambiar?");
		System.out.println("[1] Piernas");
		System.out.println("[2] Brazos");
		System.out.println("[3] Torax");
		System.out.println("[4] Cabeza");
		System.out.print("Opcion: ");
		int opcionPieza = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionPieza <= 0 || opcionPieza > 4) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionPieza = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		
		if(opcionPieza == 1) {
			System.out.println("[Las Piernas actuales del robot son " + listaRobots.get(opcionRobot).getPiernas() + "]");
			System.out.println();
			
			Pieza piernasActuales = null;
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(listaPiezas.get(i).getNombre().equals(listaRobots.get(opcionRobot).getPiernas()) && listaPiezas.get(i) instanceof Piernas) {
					piernasActuales = listaPiezas.get(i);
					break;
				}
			}
			
			System.out.println("Escoja las nuevas piernas del robot:");
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(!listaPiezas.get(i).getNombre().equals(piernasActuales.getNombre()) && listaPiezas.get(i) instanceof Piernas) {
					System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
				}
			}
			System.out.print("Opcion: ");
			int opcionNuevaPieza = Integer.parseInt(read.nextLine());
			System.out.println();
			
			listaRobots.get(opcionRobot).setPiernas(listaPiezas.get(opcionNuevaPieza).getNombre());
			System.out.println("  - Piernas modificadas exitosamente.");
		}
		else if(opcionPieza == 2) {
			System.out.println("[Los Brazos actuales del robot son " + listaRobots.get(opcionRobot).getBrazos() + "]");
			System.out.println();
			
			Pieza brazosActuales = null;
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(listaPiezas.get(i).getNombre().equals(listaRobots.get(opcionRobot).getBrazos()) && listaPiezas.get(i) instanceof Brazos) {
					brazosActuales = listaPiezas.get(i);
					break;
				}
			}
			
			System.out.println("Escoja los nuevos brazos del robot:");
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(!listaPiezas.get(i).getNombre().equals(brazosActuales.getNombre()) && listaPiezas.get(i) instanceof Brazos) {
					System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
				}
			}
			System.out.print("Opcion: ");
			int opcionNuevaPieza = Integer.parseInt(read.nextLine());
			System.out.println();
			
			listaRobots.get(opcionRobot).setBrazos(listaPiezas.get(opcionNuevaPieza).getNombre());
			System.out.println("  - Brazos modificadas exitosamente.");
		}
		else if(opcionPieza == 3) {
			System.out.println("[El Torax actual del robot es " + listaRobots.get(opcionRobot).getTorax() + "]");
			System.out.println();
			
			Pieza toraxActual = null;
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(listaPiezas.get(i).getNombre().equals(listaRobots.get(opcionRobot).getTorax()) && listaPiezas.get(i) instanceof Torax) {
					toraxActual = listaPiezas.get(i);
					break;
				}
			}
			
			System.out.println("Escoja el nuevo torax del robot:");
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(!listaPiezas.get(i).getNombre().equals(toraxActual.getNombre()) && listaPiezas.get(i) instanceof Torax) {
					System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
				}
			}
			System.out.print("Opcion: ");
			int opcionNuevaPieza = Integer.parseInt(read.nextLine());
			System.out.println();
			
			listaRobots.get(opcionRobot).setTorax(listaPiezas.get(opcionNuevaPieza).getNombre());
			System.out.println("  - Torax modificado exitosamente.");
		}
		else if(opcionPieza == 4) {
			System.out.println("[La Cabeza actual del robot es " + listaRobots.get(opcionRobot).getCabeza() + "]");
			System.out.println();
			
			Pieza cabezaActual = null;
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(listaPiezas.get(i).getNombre().equals(listaRobots.get(opcionRobot).getCabeza()) && listaPiezas.get(i) instanceof Cabeza) {
					cabezaActual = listaPiezas.get(i);
					break;
				}
			}
			
			System.out.println("Escoja la nueva cabeza del robot:");
			for(int i = 0; i < listaPiezas.size(); i++) {
				if(!listaPiezas.get(i).getNombre().equals(cabezaActual.getNombre()) && listaPiezas.get(i) instanceof Cabeza) {
					System.out.println("   [" + i + "] " + listaPiezas.get(i).getNombre());
				}
			}
			System.out.print("Opcion: ");
			int opcionNuevaPieza = Integer.parseInt(read.nextLine());
			System.out.println();
			
			listaRobots.get(opcionRobot).setCabeza(listaPiezas.get(opcionNuevaPieza).getNombre());
			System.out.println("  - Cabeza modificada exitosamente.");
		}
	}
	
	@Override
	public void cambiarArmas(Scanner read) {
		System.out.println("Escoja un robot para cambiar su arma:");
		for(int i = 0; i < listaRobots.size(); i++) {
			System.out.println("   [" + i + "] " + listaRobots.get(i).getNombreRobot());
		}
		System.out.print("Opcion: ");
		int opcionRobot = Integer.parseInt(read.nextLine());
		System.out.println();
		
		while(opcionRobot < 0 || opcionRobot > listaRobots.size() - 1) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionRobot = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		
		System.out.println("[El arma actual del robot es " + listaRobots.get(opcionRobot).getArma() + "]");
		System.out.println();
		
		Arma armaActual = null;
		for(int i = 0; i < listaArmas.size(); i++) {
			if(listaArmas.get(i).getNombre().equals(listaRobots.get(opcionRobot).getArma())) {
				armaActual = listaArmas.get(i);
				break;
			}
		}
		
		System.out.println("Escoja la nueva arma del robot:");
		for(int i = 0; i < listaArmas.size(); i++) {
			if(!listaArmas.get(i).getNombre().equals(armaActual.getNombre())) {
				System.out.println("   [" + i + "] " + listaArmas.get(i).getNombre());
			}
		}
		System.out.print("Opcion: ");
		int opcionArma = Integer.parseInt(read.nextLine());
		System.out.println();

		while(opcionArma < 0 || opcionArma > listaArmas.size() - 1 || opcionArma == listaArmas.indexOf(armaActual)) {
			System.out.println("  - Escoja una opción válida.");
			System.out.println();
			System.out.print("Opcion: ");
			opcionArma = Integer.parseInt(read.nextLine());
			System.out.println();
		}
		
		listaRobots.get(opcionRobot).setArma(listaArmas.get(opcionArma).getNombre());
		System.out.println("  - Arma cambiada exitosamente.");
	}
	
	@Override
	public void obtenerEstadisticasRobots() {
		if(listaRobots.size() == 0) {
			System.out.println("  - No hay robots ingresados para ver sus estadísticas.");
		} else {
			for(int i = 0; i < listaRobots.size(); i++) {
				System.out.println("  " + (i + 1) + ". " + listaRobots.get(i).getNombreRobot());
				Robot robot = listaRobots.get(i);
				
				int vida = calcularHP(robot);
				int ataque = calcularATK(robot);
				int velocidad = calcularSPE(robot);
				
				System.out.println("     - HP: " + vida);
				System.out.println("     - ATK: " + ataque);
				System.out.println("     - SPE: " + velocidad);
				System.out.println();
			}
		}
	}
	
	public int calcularHP(Robot robot) {
		int vida = 8000;
		
		String nombrePiernas = robot.getPiernas();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombrePiernas)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					vida += 3000;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					vida += 2000;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PC")) {
					vida += 1000;
					break;
				}
			}
		}
		
		String nombreBrazos = robot.getBrazos();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreBrazos)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					vida += 3000;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					vida += 2000;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PC")) {
					vida += 1000;
					break;
				}
			}
		}
		
		String nombreTorax = robot.getTorax();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreTorax)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					vida += 3000 + ((Torax) listaPiezas.get(i)).getVida();
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					vida += 2000 + ((Torax) listaPiezas.get(i)).getVida();
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PC")) {
					vida += 1000 + ((Torax) listaPiezas.get(i)).getVida();
					break;
				}
			}
		}
		
		String nombreCabeza = robot.getCabeza();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreCabeza)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					vida += 3000 + ((Cabeza) listaPiezas.get(i)).getVida();
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					vida += 2000 + ((Cabeza) listaPiezas.get(i)).getVida();
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PC")) {
					vida += 1000 + ((Cabeza) listaPiezas.get(i)).getVida();
					break;
				}
			}
		}
		
		if(robot instanceof A) {
			vida += ((A) robot).getEscudo();
			
			if(((A) robot).getClase().equals("SS+")) {
				vida += 5000;
			}
			else if(((A) robot).getClase().equals("S+")) {
				vida += 3000;
			}
			else if(((A) robot).getClase().equals("S")) {
				vida += 2000;
			}
			else if(((A) robot).getClase().equals("A")) {
				vida += 1000;
			}
			else if(((A) robot).getClase().equals("B")) {
				vida += 500;
			}
		}
		
		return vida;
	}
	
	public int calcularATK(Robot robot) {
		int ataque = 0;
		
		String nombreArma = robot.getArma();
		for(int i = 0; i < listaArmas.size(); i++) {
			if(listaArmas.get(i).getNombre().equals(nombreArma)) {
				ataque += listaArmas.get(i).getDaño();
				break;
			}
		}
		
		String nombrePiernas = robot.getPiernas();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombrePiernas)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					ataque += 200;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					ataque += 100;
					break;
				}
			}
		}
		
		String nombreBrazos = robot.getBrazos();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreBrazos)) {
				ataque += ((Brazos) listaPiezas.get(i)).getAtaque();
				
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					ataque += 200;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					ataque += 100;
					break;
				}
			}
		}
		
		String nombreTorax = robot.getTorax();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreTorax)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					ataque += 200;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					ataque += 100;
					break;
				}
			}
		}
		
		String nombreCabeza = robot.getCabeza();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreCabeza)) {
				if(listaPiezas.get(i).getRareza().equals("PP")) {
					ataque += 200;
					break;
				}
				else if(listaPiezas.get(i).getRareza().equals("PE")) {
					ataque += 100;
					break;
				}
			}
		}
		
		if(robot instanceof A) {
			if(((A) robot).getClase().equals("SS+")) {
				ataque += 500;
			}
			else if(((A) robot).getClase().equals("S+")) {
				ataque += 400;
			}
			else if(((A) robot).getClase().equals("S")) {
				ataque += 300;
			}
			else if(((A) robot).getClase().equals("A")) {
				ataque += 200;
			}
			else if(((A) robot).getClase().equals("B")) {
				ataque += 100;
			}
		}
		
		return ataque;
	}
	
	public int calcularSPE(Robot robot) {
		int velocidad = 0;
		
		String nombreArma = robot.getArma();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaArmas.get(i).getNombre().equals(nombreArma)) {
				velocidad += listaArmas.get(i).getVelocidadATK();
				break;
			}
		}
		
		String nombrePiernas = robot.getPiernas();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombrePiernas)) {
				velocidad += ((Piernas) listaPiezas.get(i)).getVelocidad();
				break;
			}
		}
		
		String nombreCabeza = robot.getCabeza();
		for(int i = 0; i < listaPiezas.size(); i++) {
			if(listaPiezas.get(i).getNombre().equals(nombreCabeza)) {
				velocidad += ((Cabeza) listaPiezas.get(i)).getVelocidad();
				break;
			}
		}
		
		return velocidad;
	}
	
	@Override
	public void obtenerRobotsPilotados() {
		System.out.println("Lista de robots pilotados:");
		
		int cont = 0;
		for(int i = 0; i < listaRobots.size(); i++) {
			Robot robot = listaRobots.get(i);
			
			if((robot instanceof H) && !((H) robot).getPiloto().equals("nulo")) {
				System.out.println("  - " + robot.getNombreRobot());
				cont++;
			}
		}
		if(cont == 0) {
			System.out.println("  - No hay robots pilotados.");
		}
	}
	
	@Override
	public void obtenerRobotsDeUnEquipo(Scanner read) {
		System.out.print("Ingrese el nombre del equipo: ");
		String equipoIngresado = read.nextLine();
		
		int cont = 0;
		for(int i = 0; i < listaRobots.size(); i++) {
			Robot robot = listaRobots.get(i);
			
			if((robot instanceof H) && ((H) robot).getEquipo().equals(equipoIngresado)) {
				System.out.println("  - " + robot.getNombreRobot());
				cont++;
			}
		}
		if(cont == 0) {
			System.out.println("  - No se encontraron robots ingresados bajo ese equipo.");
		}
	}
	
	@Override
	public void obtenerEstadisticasVictoriasDeHumanidad() {
		int contTotal = 0;
		int contVictoriasH = 0;
		
		for(int i = 0; i < listaCombates.size(); i++) {
			if(listaCombates.get(i).getBandoGanador().equals("H")) {
				contVictoriasH++;
			}
			contTotal++;
		}
		
		if(contVictoriasH == 0) {
			System.out.println("  - La humanidad no ha ganado ningún combate.");
		} else {
			double porc = (contVictoriasH/contTotal) * 100;
			System.out.println("  - El porcentaje de victorias de la humanidad es de: " + porc + "%");
		}
	}
	
	@Override
	public void sobrescribirDatos() throws IOException {
		FileWriter save0 = new FileWriter(new File("Robots.txt"));
		for(int i = 0; i < listaRobots.size(); i++) {
			Robot robot = listaRobots.get(i);

			if(robot instanceof H) {
				save0.write(robot.getNombreRobot() + ", " + robot.getArma() + ", " + robot.getPiernas() + ", "
						+ robot.getBrazos() + ", " + robot.getTorax() + ", " + robot.getCabeza() + ", H, "
						+ ((H) robot).getPiloto() + ", " + ((H) robot).getEquipo());
				save0.write("\r\n");
			}
			else if(robot instanceof A) {
				save0.write(robot.getNombreRobot() + ", " + robot.getArma() + ", " + robot.getPiernas() + ", "
						+ robot.getBrazos() + ", " + robot.getTorax() + ", " + robot.getCabeza() + ", A, "
						+ ((A) robot).getEscudo() + ", " + ((A) robot).getClase());
				save0.write("\r\n");
			}
		}
		save0.close();
		
		FileWriter save1 = new FileWriter(new File("piezas.txt"));
		for(int i = 0; i < listaPiezas.size(); i++) {
			Pieza pieza = listaPiezas.get(i);
			
			if(pieza instanceof Piernas) {
				save1.write(pieza.getNombre() + ", " + pieza.getRareza() + ", P, " + ((Piernas) pieza).getVelocidad());
				save1.write("\r\n");
			}
			else if(pieza instanceof Brazos) {
				save1.write(pieza.getNombre() + ", " + pieza.getRareza() + ", B, " + ((Brazos) pieza).getAtaque());
				save1.write("\r\n");
			}
			else if(pieza instanceof Torax) {
				save1.write(pieza.getNombre() + ", " + pieza.getRareza() + ", T, " + ((Torax) pieza).getVida());
				save1.write("\r\n");
			}
			else if(pieza instanceof Cabeza) {
				save1.write(pieza.getNombre() + ", " + pieza.getRareza() + ", C, " + ((Cabeza) pieza).getVelocidad() + ", " + ((Cabeza) pieza).getVida());
				save1.write("\r\n");
			}
		}
		save1.close();
		
		FileWriter save2 = new FileWriter(new File("armas.txt"));
		for(int i = 0; i < listaArmas.size(); i++) {
			Arma arma = listaArmas.get(i);
			
			save2.write(arma.getNombre() + ", " + arma.getDaño() + ", " + arma.getVelocidadATK());
			save2.write("\r\n");
		}
		save2.close();
		
		FileWriter save3 = new FileWriter(new File("combates.txt"));
		for(int i = 0; i < listaCombates.size(); i++) {
			Combate combate = listaCombates.get(i);
			
			save3.write(combate.getNombreRobotH1() + ", " + combate.getNombreRobotH2() + ", " + combate.getNombreRobotH3() + ", "
					+ combate.getNombreRobotA1() + ", " + combate.getNombreRobotA2() + ", " + combate.getNombreRobotA3() + ", "
					+ combate.getBandoGanador());
			save3.write("\r\n");
		}
		save3.close();
	}
}
