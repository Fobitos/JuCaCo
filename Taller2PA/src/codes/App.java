import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
* Main class where all the main code is implemented.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class App {

	/**
	 * The main method. Scanner and six lists are built.
   	 * It calls seven other methods, the first six read the txt files and the other one starts the login system.
	 *
	 * @param args The command line arguments.   
         * @throws FileNotFoundException If the file is not found. 
         * @throws IOException If input/output values are misinterpreted or fail.
         **/
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner read = new Scanner(System.in);
		
		RobotsList robots = new RobotsList(1000);
		CountryList countries = new CountryList(1000);
		PieceList pieces = new PieceList(1000);
		WeaponsList weapons = new WeaponsList(1000);
		MaterialsList materials = new MaterialsList(1000);
		PersonList people = new PersonList(1000);
		ModelList models = new ModelList(1000);
		
		readRobots(robots);
		readCountries(countries);
		readPieces(pieces);
		readWeapons(weapons);
		readMaterials(materials);
		readPeople(people);
		
		login(read, robots, countries, pieces, weapons, materials, people, models);
		
	}
	
	/**
	 * The user enters a name and an ID.
	 * If the name equals to "empanada", and the ID equals to "porotosconriendas",
	 * the login system opens the secret menu.
	 * If name and ID belong to the admin team, the normal menu opens.
	 * If name and ID exist, but don't belong to the admin team, it asks you to enter
	 * a proper user, same if name and ID don't exist.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 * @throws IOException If input/output values are misinterpreted or fail.
	 */
	public static void login(Scanner read, RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) throws IOException {
		System.out.println("==== Bienvenido al programa BOCCHI ====");
		System.out.println();
		
		boolean checker = true;
		
		while(checker) {
			System.out.print("Ingrese su nombre: ");
			String name = read.nextLine();
			
			System.out.print("Ingrese su identificación: ");
			String ID = read.nextLine();
			
			if(name.equals("empanada") && ID.equals("porotosconriendas")) {
				secretMenu(read, robots, countries, pieces, weapons, materials, people, models);
				checker = false;
			}
			else {
				boolean existsName = people.existName(name);
				boolean existsID = people.existID(ID);
				Person person = people.getPerson(ID);
				
				if(existsName == true && existsID == true) {
					if(person != null && person.getTeam().equals("ADMINISTRACION")) {
						menu(read, robots, countries, pieces, weapons, materials, people, models);
						checker = false;
					}
					else {
						System.out.println();
						System.out.println("Usuario no perteneciente al equipo de admins.");
						System.out.println();
					}
				}
				else {
					System.out.println();
					System.out.println("Nombre/ID no encontrado.");
					System.out.println();
				}
			}
		}	
	}
	
	/**
	 * Admin's menu. It has 17 different methods, including the "log-off" system.
	 * It shows all the program options to the user on screen and executes
	 * the chosen option inserted.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 * @throws IOException If input/output values are misinterpreted or fail.
	 */
	public static void menu(Scanner read, RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) throws IOException {
		System.out.println();
		System.out.println("==== Ingreso exitoso ====");
		
		boolean checker = true;
		
		while(checker) {
			System.out.println();
			System.out.println("============================");
			System.out.println("[1] Ingresar pieza o arma");			    // LISTO
			System.out.println("[2] Ensamblar robot");						// LISTO
			System.out.println("[3] Crear equipo");							// 
			System.out.println("[4] Buscar piezas por tipo");         		// LISTO
			System.out.println("[5] Buscar material");     				    // LISTO
			System.out.println("[6] Crear modelo");							// LISTO
			System.out.println("[7] Revisar piezas de un robot");	        // LISTO
			System.out.println("[8] Mostrar todo el personal");         	// LISTO
			System.out.println("[9] Mostrar grupos");	                    // LISTO
			System.out.println("[10] Mostrar todos los robots");            // LISTO
			System.out.println("[11] Revisar munición");                    // LISTO
			System.out.println("[12] Mostrar todos los países");			// LISTO
			System.out.println("[13] Añadir stock de piezas");              // LISTO
			System.out.println("[14] Añadir stock de algún material");		// LISTO
			System.out.println("[15] Mostrar todas las piezas y armas");	// LISTO
			System.out.println("[16] Cambiar piezas");                      // LISTO
			System.out.println("[17] Cerrar sesión");						// LISTO
			System.out.println("============================");
			
			System.out.println();
			System.out.print("Ingrese una opción: ");
			
			int option = Integer.parseInt(read.nextLine());
			switch(option) {
			case 1:
				addPieceOrWeapon(read, pieces, weapons);
				break;
			case 2:
				assembleRobot(read, pieces, weapons, robots, countries, materials, people);
				break;
			case 3:
				createTeam(read, pieces, weapons, robots, countries, materials, people);
				break;
			case 4:
				searchByType(read, pieces, countries);
				break;
			case 5:
				findMaterial(read, materials, countries);
				break;
			case 6:
				createModel(robots, people, pieces, models);
				break;
			case 7:
				checkPieces(read, robots, pieces);
				break;
			case 8:
				showPeople(people);
				break;
			case 9:
				showGroups(people);
				break;
			case 10:
				showRobots(robots);
				break;
			case 11:
				checkAmmo(read, robots, weapons);
				break;
			case 12:
				showCountries(countries);
				break;
			case 13:
				addPiecesStock(read, countries, pieces, materials);
				break;
			case 14:
				addMaterialStock(read, materials);
				break;
			case 15:
				showPiecesAndWeapons(pieces, weapons);
				break;
			case 16:
				changePieces(read, robots, pieces, weapons);
				break;
			case 17:
				fileWriting(robots, countries, pieces, weapons, materials, people, models);
				checker = false;
				System.out.println();
				System.out.println("Log off..");
				break;
			default:
				System.out.println();
				System.out.println("Opción no disponible.");
				break;
			}
		}
	}

	/**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
   	 * 
	 * @param robots The robot list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readRobots(RobotsList robots) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("robots.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(", ");
			String robotName = parts[0];
			String armName = parts[1];
			String legName = parts[2];
			String chestName = parts[3];
			String headName = parts[4];
			String extraQuality = parts[5];
			String weaponName = parts[6];
			String team = parts[7];
			String pilotCode = parts[8];
			
			Robot r = new Robot(robotName, armName, legName, chestName, headName, extraQuality, weaponName, team, pilotCode);
			robots.add(r);
		}
		arch.close();
	}

        /**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
	 * 
	 * @param countries The country list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readCountries(CountryList countries) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Países.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(", ");
			String countryName = parts[0];
			String type = parts[1];
			String typeCode = parts[2];
			int cant = Integer.parseInt(parts[3]);
			String material = parts[4];
			
			Country c = new Country(countryName, type, typeCode, cant, material);
			countries.add(c);
		}
		arch.close();
	}

    /**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
	 * 
	 * @param pieces The piece list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readPieces(PieceList pieces) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Piezas.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(", ");
			String name = parts[0];
			String code = parts[1];
			String type = parts[2];
			String originCountry = parts[3];
			int cantMaterial = Integer.parseInt(parts[4]);
			
			Piece p = new Piece(name, code, type, originCountry, cantMaterial);
			pieces.add(p);
		}
		arch.close();
	}
	
    /**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
	 * 
	 * @param weapons The weapon list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readWeapons(WeaponsList weapons) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Armas.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(", ");
			String name = parts[0];
			String code = parts[1];
			int ammo = Integer.parseInt(parts[2]);
			String originCountry = parts[3];
			int cantMaterial = Integer.parseInt(parts[4]);
			
			Weapon w = new Weapon(name, code, ammo, originCountry, cantMaterial);
			weapons.add(w);
		}
		arch.close();
	}
	
    /**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
	 * 
	 * @param materials The material list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readMaterials(MaterialsList materials) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Materiales.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(",");
			String name = parts[0];
			int stock = Integer.parseInt(parts[1]);
			String originCountry = parts[2];
			
			Material m = new Material(name, stock, originCountry);
			materials.add(m);
		}
		arch.close();
	}

    /**
	 * One list is inserted.
	 * This method open a txt file, which can be empty or filled with information.
	 * It also builds and add the objects in the respective list.
	 * 
	 * @param people The person list built in the main method.
	 * @throws FileNotFoundException If the files are not found.
	 */
	public static void readPeople(PersonList people) throws FileNotFoundException {
		Scanner arch = new Scanner(new File("Personas.txt"));
		while(arch.hasNextLine()) {
			String line = arch.nextLine();
			String[] parts = line.split(", ");
			String name = parts[0];
			String ID = parts[1];
			String specialty = parts[2].toLowerCase();
			String team = parts[3];
			
			Person p = new Person(name, ID, specialty, team);
			people.add(p);
		}
		arch.close();
	}
	
	/**
	 * This method asks if you want to add a part or a weapon.
	 * Depending on the decision made, a different method is opened.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 */
	public static void addPieceOrWeapon(Scanner read, PieceList pieces, WeaponsList weapons) {
		System.out.println();
		System.out.print("¿Desea ingresar una pieza (1) o un arma (2)?: ");
		
		int option = Integer.parseInt(read.nextLine());
		switch(option) {
		case 1:
			addPiece(read, pieces);
			break;
		case 2:
			addWeapon(read, weapons);
			break;
		default:
			System.out.println();
			System.out.println("Ingrese una opción válida.");
			break;
		}
	}
	
	/**
	 * It asks to enter all the characteristics of a piece.
	 * If the piece list has a free space, the new piece is added.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param pieces The piece list built in the main method.
	 */
	public static void addPiece(Scanner read, PieceList pieces) {
		System.out.println();
		System.out.print("Nombre: ");
		String name = read.nextLine();
		
		System.out.print("Código:");
		String code = read.nextLine();
		
		System.out.print("Tipo: ");
		String type = read.nextLine();
		
		System.out.print("País de origen: ");
		String originCountry = read.nextLine();
		
		System.out.print("Cantidad de material necesario: ");
		int cantMaterial = Integer.parseInt(read.nextLine());
		
		Piece p = new Piece(name, code, type, originCountry, cantMaterial);
		boolean added = pieces.add(p);
		
		if(added) {
			System.out.println();
			System.out.println("La pieza fue agregada exitosamente.");
		} else {
			System.out.println();
			System.out.println("La pieza no pudo ser agregada (lista llena).");
		}
	}
	
	/**
	 * It asks to enter all the characteristics of a weapon.
	 * If the weapon list has a free space, the new weapon is added.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param weapons The weapon list built in the main method.
	 */
	public static void addWeapon(Scanner read, WeaponsList weapons) {
		System.out.println();
		System.out.print("Nombre: ");
		String name = read.nextLine();
		
		System.out.print("Código: ");
		String code = read.nextLine();
		
		System.out.print("Cantidad de munición: ");
		int ammo = Integer.parseInt(read.nextLine());
		
		System.out.print("País de origen: ");
		String originCountry = read.nextLine();
		
		System.out.print("Cantidad de material necesario: ");
		int cantMaterial = Integer.parseInt(read.nextLine());
		
		Weapon w = new Weapon(name, code, ammo, originCountry, cantMaterial);
		boolean added = weapons.add(w);
		
		if(added) {
			System.out.println();
			System.out.println("El arma fue agregada exitosamente.");
		} else {
			System.out.println();
			System.out.println("El arma no pudo ser agregada (lista llena).");
		}
	}
	
	/**
	 * It asks to enter the new robot name.
	 * Then show all the available pieces and weapons, and asks the user to choose
	 * one for each part (extra piece is optional).
	 * It also shows all teams and ask you for a pilot code, if it exists, the robot is
	 * added, if it doesn't exist, the method is closed.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 */
	public static void assembleRobot(Scanner read, PieceList pieces, WeaponsList weapons, RobotsList robots, CountryList countries, MaterialsList materials, PersonList people)  {
		System.out.println();
	    System.out.println("Nombre del Robot: ");
	    String robotName = read.nextLine();
	    System.out.println();
	    
	    System.out.println("Lista Brazos:");
	    for(int i = 0 ; i < pieces.getCant(); i++) {
	      Piece a = pieces.getPieceType(i, "brazos");
	      if(a != null) {
	        System.out.println("[" + i + "] " + a.getName());
	      }
	    }
	    System.out.print("Ingrese el n° de los brazos que desea agregar: ");
	    int iArms = Integer.parseInt(read.nextLine());
	    Piece arms = pieces.getPiece(iArms);
	    String armsName = "";
	    if(countries.checkTotalIt(arms.getCode())) {
	    	armsName = pieces.getPiece(iArms).getName();
	    	System.out.println();	    	
	    }else {
	    	System.out.println("No hay piezas suficientes");
	    	return;
	    }

	    System.out.println("Lista Piernas:");
	    for(int i = 0 ; i < pieces.getCant(); i++) {
	      Piece a = pieces.getPieceType(i, "piernas");
	      if(a != null) {
	        System.out.println("[" + i + "] " + a.getName());
	      }
	    }
	    System.out.print("Ingrese el n° de las piernas que desea agregar: ");
	    int iLegs = Integer.parseInt(read.nextLine());
	    Piece legs = pieces.getPiece(iLegs);
	    String legsName = "";
	    if(countries.checkTotalIt(legs.getCode())) {
	    	legsName = pieces.getPiece(iLegs).getName();
	    	System.out.println();	    	
	    }else {
	    	System.out.println("No hay piezas suficientes");
	    	return;
	    }
	    System.out.println("Lista Tórax:");
	    for(int i = 0 ; i < pieces.getCant(); i++) {
	      Piece a = pieces.getPieceType(i, "tórax");
	      if(a != null) {
	        System.out.println("[" + i + "] " + a.getName());
	      }
	    }
	    System.out.print("Ingrese el n° del tórax que desea agregar: ");
	    int iChest = Integer.parseInt(read.nextLine());
	    Piece chest = pieces.getPiece(iChest);
	    String chestName = "";
	    if(countries.checkTotalIt(chest.getCode())) {
	    	chestName = pieces.getPiece(iChest).getName();
	    	System.out.println();	    	
	    } else {
	    	System.out.println("No hay piezas suficientes");
	    	return;
	    }
	    
	    System.out.println("Lista Cabeza:");
	    for(int i = 0 ; i < pieces.getCant(); i++) {
	      Piece a = pieces.getPieceType(i, "cabeza");
	      if(a != null) {
	        System.out.println("[" + i + "] " + a.getName());
	      }
	    }
	    System.out.print("Ingrese el n° de la cabeza que desea agregar: ");
	    int iHead = Integer.parseInt(read.nextLine());
	    Piece head = pieces.getPiece(iHead);
	    String headName = "";
	    if(countries.checkTotalIt(head.getCode())) {
	    	headName = pieces.getPiece(iHead).getName();
	    	System.out.println();	    	
	    }else {
	    	System.out.println("No hay piezas suficientes");
	    	return;
	    }
	    
	    System.out.print("Deseas agregar una pieza extra(y/n): ");
	    String yesOrNot = read.nextLine();
	    Piece extra = null;
	    String extraName = "";
	    if(yesOrNot.equals("y")) {
	    	System.out.println("Lista Extra:");
		    for(int i = 0 ; i < pieces.getCant(); i++) {
		      Piece a = pieces.getPieceType(i, "extra");
		      if(a != null) {
		        System.out.println("[" + i + "] " + a.getName());
		      }
		    }
		    System.out.print("Ingrese el n° de la cualidad extra que desea agregar: ");
		    int iExtra = Integer.parseInt(read.nextLine());
		    extra = pieces.getPiece(iExtra);
		    if(countries.checkTotalIt(extra.getCode())) {
		    	extraName = pieces.getPiece(iExtra).getName();
		    	System.out.println();	    	
		    }else {
		    	System.out.println("No hay piezas suficientes");
		    	return;
		    }
	    }
	    else {
	      System.out.println("Pieza extra no añadida.");
	      System.out.println();
	    }
	    
	    System.out.println("Lista Armas:");
	    for(int i = 0 ; i < weapons.getCant(); i++) {
	      System.out.println("[" + i + "] " + weapons.getWeapon(i).getName());
	    }
	    System.out.print("Ingrese el n° del arma que desea agregar: ");
	    int iWeapon = Integer.parseInt(read.nextLine());
	    Weapon weapon = weapons.getWeapon(iWeapon);
	    String weaponName = "";
	    if(countries.checkTotalIt(weapon.getCode())) {
	    	weaponName = weapons.getWeapon(iWeapon).getName();
	    	System.out.println();	    	
	    }else {
	    	System.out.println("No hay piezas suficientes");
	    	return;
	    }
	    
	    System.out.println("Lista equipos:");
	    for(int i = 0 ; i < people.getCant(); i++) {
	      if(people.showTeams(i)!=null) System.out.println("[" + i + "] " + people.showTeams(i).getTeam());
	    }
	    System.out.print("selecciona el equipo: ");
	    int iteam = Integer.parseInt(read.nextLine());
	    Person teamObj=people.getPersonWithI(iteam);
	    String team = teamObj.getTeam();	    
	    System.out.println();
	    
		System.out.println("[Team "+team+"] " + "Pilot: "+teamObj.toString());
	    System.out.print("Codigo del Piloto: ");
	    
	    String pilotCode = read.nextLine();
	    
	    if(!pilotCode.equals(teamObj.getID())) {
	    	System.out.println("No existe un piloto con ese id en el equipo "+team);
	    	return;
	    }
	  
	    Robot a = new Robot(robotName,armsName,legsName,chestName,headName,extraName,weaponName,team, pilotCode);
	    countries.subtractTotal(weapon.getCode());
	    countries.subtractTotal(arms.getCode());
	    countries.subtractTotal(legs.getCode());
	    countries.subtractTotal(chest.getCode());
	    countries.subtractTotal(head.getCode());
	    
	    if(extra!=null) {
	    	countries.subtractTotal(extra.getCode());
	    }
	    
	    boolean added = robots.add(a);
	    System.out.println();
	    
	    if(!added) {
	    	System.out.println("El robot no ha podido ser añadido. Intente nuevamente.");
	    } else {
	    	System.out.println("Robot añadido exitosamente.");
	    	showRobotImage();
	    	System.out.println(a.toString());
	    }
	}
	
	/**
	 * The team's name is entered and a list is created, it saves the ID of the members that are added to the team.
	 * It shows two options on the screen to choose from the list of people or add a person and add it to the list members
	 * and another option showing the candidates already chosen.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
 	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 */
	private static void createTeam(Scanner read, PieceList pieces, WeaponsList weapons, RobotsList robots,CountryList countries, MaterialsList materials, PersonList people) {
		  System.out.println("Ingrese el nombre del equipo: ");
		  String teamName = read.nextLine();
		  for(int i = 0 ; i < people.getCant(); i++) {
		      if(people.showTeams(i)!=null && people.showTeams(i).getTeam().equals(teamName)){
		    	  System.out.println("Este equipo ya existe en la base de datos...");
		    	  return;
		      }
		  }
		  String[] members = new String[6];
		  for(int i = 0 ; i<6;i++) {
			  System.out.println("Menu creacion de Equipo // personal N° "+ (i+1));
			  System.out.println("[1] Agregar persona");
			  System.out.println("[2] Escoger escoger a alguien del personal");
			  System.out.println("[3] Mostrar Los integrantes");
			  int selection = Integer.parseInt(read.nextLine());
			  
			  
			  switch (selection) {
			case 1: 
				boolean created = addPerson(i,members,people, read,teamName);
				if(created!=true) i--;
				break;
			case 2: 
				choosePersonal(i,members,people,read,teamName);
				break;
			case 3: 
				showList(i,members,people,read,teamName);
				i--;
				break;
			  }
			  System.out.println();
		  }
		  for(int x=0; x<6;x++) {
			  people.getPerson(members[x]).setTeam(teamName);
		  }
		  System.out.println("#### equipo creado ###");
		  //showTeamImage();                                                  por si agregamos una imagen de un equipo--------------------------
		}
	
		/**
		 * Shows the list of members added to the team.
		 * 
		 * @param i The list space to which the next worker should be entered.
		 * @param members The member list built in the createTeam method.
		 * @param people The people list list built in the main method
		 * @param read The scanner built in the main method. Saves values entered by the user.
		 * @param teamName The name of the created team.
		 */
		private static void showList(int i, String[] members, PersonList people, Scanner read, String teamName){
			System.out.println("############ Equipo "+ teamName+ " ############" );
			for(int x = 0; x<i;x++) {
				System.out.println(people.getPerson(members[x]).getName());
			}
			System.out.println("#########################################" );
		}
		
		/**
		 * Shows the information of all the staff members, except those of the staff with the administrator degree.
		 * You must enter the position number of the member you want to add to the team.
		 * If the entered member already belongs to the team, another number must be entered.
		 * 
		 * @param i The list space to which the next worker should be entered.
		 * @param members The member list built in the createTeam method.
		 * @param people The people list list built in the main method
		 * @param read The scanner built in the main method. Saves the values entered by the user.
		 * @param teamName The name of the created team.
		 */
		private static void choosePersonal(int i, String[] members, PersonList people, Scanner read, String teamName) {
			for(int x = 0; x<people.getCant();x++) {
				System.out.println();
				if(people.getPersonWithI(x).getSpecialty().equals("admin")) {
					System.out.println("------------[#]------------");
					System.out.println("No es posible acceder al registro de este individuo");
				}else{
					System.out.println("------------["+x+"]------------");
					System.out.println(people.getPersonWithI(x).toString());
					for(int z = 0; z<i ;z++) {
						if(members[z].equals(people.getPersonWithI(x).getID())) {
							System.out.println("########## Ya en el equipo ##########");
						}
					}
				}
			}
			int iPersonal;
			while(true) {
				System.out.println();
				System.out.println("ingrese la posicion del Individuo: ");
				iPersonal = Integer.parseInt(read.nextLine());
				boolean exist = false;
				for(int z = 0; z<i ;z++) {
					if(people.getPersonWithI(iPersonal).getID().equals(members[z])) {
						System.out.println("Ya existe en el equipo");
						exist = true;
					}
				}
				if(exist!= true) {
					break;
				}
			}
			members[i] = people.getPersonWithI(iPersonal).getID();
			
			
			
		}
		
		/**
		 * The data belonging to a person is entered.
		 * If there is no other person with the same ID, it is added to the list of people.
		 * 
		 * @param i The list space to which the next worker should be entered.
		 * @param members The member list built in the createTeam method.
		 * @param people The people list list built in the main method
		 * @param read The scanner built in the main method. Saves values entered by the user.
		 * @param teamName The name of the created team.
		 * @return True if the person was added. False if not.
		 */
		private static boolean addPerson(int i, String[] members, PersonList people, Scanner read, String teamName) {
			System.out.println("------------------------------#");
			System.out.println("Ingrese el nombre: ");
			String name= read.nextLine();
			String iD= "";
			while(true) {
				System.out.println();
				System.out.println("------------------------------#");
				System.out.println("Ingrese el ID: ");
				iD= read.nextLine();
				if(people.existID(iD)) {
					System.out.println("Ya existe una persona con esa ID en la base de datos.");
				}else {
					break;
				}
			}
			System.out.println();
			System.out.println("------------------------------#");
			System.out.println("[1] Piloto");
			System.out.println("[2] Ensamblador");
			System.out.println("Escoja que espcialidad es: ");
			int choose= Integer.parseInt(read.nextLine());
			String speciality = "";
			if(choose == 1) {
				speciality = "piloto";
			}else {
				speciality = "ensamblador";
			}
			
			Person a = new Person(name, iD,speciality,teamName);
			System.out.println("############# crear persona #############");
			System.out.println(a.toString());
			System.out.println("#########################################");
			System.out.println("(1) si // (2) No");
			int choose2= Integer.parseInt(read.nextLine());
			if(choose2 == 2) {
				i--;
				return false;
			}
			
			people.add(a);
			members[i]= iD;
			return true;
		}
	
	/**
	 * It asks for a piece type, and depending on the type, it opens a method with
	 * different parameters.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param pieces The piece list built in the main method.
	 * @param countries The country list built in the main method.
	 */
	public static void searchByType(Scanner read, PieceList pieces, CountryList countries) {
		System.out.println();
		System.out.println("¿Qué pieza desea buscar?");
		System.out.println();
		System.out.println("[1] Cabeza");
		System.out.println("[2] Tórax");
		System.out.println("[3] Brazos");
		System.out.println("[4] Piernas");
		System.out.println("[5] Extra");
		System.out.println();
		System.out.print("Opción: ");
		
		int option = Integer.parseInt(read.nextLine());
		switch(option) {
		case 1:
			findPiece(pieces, countries, "cabeza");
			break;
		case 2:
			findPiece(pieces, countries, "tórax");
			break;
		case 3:
			findPiece(pieces, countries, "brazos");
			break;
		case 4:
			findPiece(pieces, countries, "piernas");
			break;
		case 5:
			findPiece(pieces, countries, "extra");
			break;
		default:
			System.out.println();
			System.out.println("Ingrese una opción válida.");
			break;
		}
	}
	
	/**
	 * Depending on the piece type, it shows all the countries with the type entered.
	 * If no country has a piece of the entered type, a message is displayed on screen.
	 * 
	 * @param pieces The piece list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param type The piece type entered in "searchByType" method.
	 */
	public static void findPiece(PieceList pieces, CountryList countries, String type) {
		int cantCountries = 0;
		
		for(int j = 0; j < countries.getCant(); j++) {
			int cantP = 0;
			
			for(int i = 0; i < pieces.getCant(); i++) {
				if(pieces.getPiece(i).getType().equals(type) && pieces.getPiece(i).getCode().equals(countries.getCountry(j).getTypeCode())) {
					System.out.println("[" + (cantP + 1) + "] " + countries.getCountry(j).getCountryName() + " ---> " + pieces.getPiece(i).getName() + " | Stock: " + countries.getCountry(j).getCant());
					cantCountries++;
				}
			}
		}
		
		if(cantCountries == 0) {
			System.out.println();
			System.out.println("Ningún país tiene una pieza de ese tipo.");
		}
	}
	
	/**
	 * It asks the user to enter the material name.
	 * If it exists, the origin country and stock is displayed on screen.
	 * If it doesn't exist, a message is displayed on screen.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param materials The material list built in the main method.
	 * @param countries The country list built in the main method.
	 */
	public static void findMaterial(Scanner read, MaterialsList materials, CountryList countries) {
		System.out.println();
		System.out.print("Ingrese el material que desea buscar: ");
		String material = read.nextLine();
		System.out.println();
		
		int cant = 0;
		for(int i = 0; i < materials.getCant(); i++) {
			if(materials.getMaterial(i).getName().equals(material)) {
				System.out.println(materials.getMaterial(i).getOriginCountry() + " | Stock: " + materials.getMaterial(i).getStock());
				cant++;
			}
		}
		if(cant == 0) {
			System.out.println("No se encontraron materiales.");
		}
	}
	
	/**
	 * It creates models for each robot in the robot list, based on specific requirements.
	 * 
	 * @param robots The robot list built in the main method.
	 * @param people The people list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param models The model list built in the main method.
	 */
	public static void createModel(RobotsList robots, PersonList people, PieceList pieces, ModelList models) {
		System.out.println();
		
		for(int i = 0; i < robots.getCant(); i++) {
			Robot r = robots.getRobot(i);
			
			String armsCode = "";
			for(int j = 0; j < pieces.getCant(); j++) {
				if(r.getArmsName().equals(pieces.getPiece(j).getName())) {
					armsCode = pieces.getPiece(j).getCode();
				}
			}
			int armsCodeI = Integer.parseInt(armsCode);
			
			String legsCode = "";
			for(int j = 0; j < pieces.getCant(); j++) {
				if(r.getLegsName().equals(pieces.getPiece(j).getName())) {
					legsCode = pieces.getPiece(j).getCode();
				}
			}
			int legsCodeI = Integer.parseInt(legsCode);
			
			String chestCode = "";
			for(int j = 0; j < pieces.getCant(); j++) {
				if(r.getChestName().equals(pieces.getPiece(j).getName())) {
					chestCode = pieces.getPiece(j).getCode();
				}
			}
			int chestCodeI = Integer.parseInt(chestCode);
			
			String headCode = "";
			for(int j = 0; j < pieces.getCant(); j++) {
				if(r.getHeadName().equals(pieces.getPiece(j).getName())) {
					headCode = pieces.getPiece(j).getCode();
				}
			}
			int headCodeI = Integer.parseInt(headCode);
			
			String extraCode = "";
			for(int j = 0; j < pieces.getCant(); j++) {
				if(r.getExtraQuality().equals(pieces.getPiece(j).getName())) {
					extraCode = pieces.getPiece(j).getCode();
				}
			}
			int extraCodeI = Integer.parseInt(extraCode);
			
			int sum = armsCodeI + legsCodeI + chestCodeI + headCodeI + extraCodeI;
			String sumString = String.valueOf(sum);
			
			if(sumString.length() == 1) {
				sumString = "0000" + sumString;
			} else if(sumString.length() == 2) {
				sumString = "000" + sumString;
			} else if(sumString.length() == 3) {
				sumString = "00" + sumString;
			} else if(sumString.length() == 4) {
				sumString = "0" + sumString;
			}
			
			String newRobotName = r.getTeam();
			
			for(int j = 0; j < people.getCant(); j++) {
				if(people.getPersonWithI(j).getTeam().equals(r.getTeam())) {
					String[] name = people.getPersonWithI(j).getName().split("");
					newRobotName += name[0];
				}
			}
			
			Model m = new Model(sumString, newRobotName);
			boolean added = models.add(m);
			
			if(added) {
				System.out.println("El modelo para el robot " + robots.getRobot(i).getRobotName() + " ha sido agregado exitosamente.");
			} else {
				System.out.println("No ha sido posible agregar el modelo del robot " + robots.getRobot(i).getRobotName() + ".");
			}
		}
	}
	
	/**
	 * It asks the user for a robot name, then shows all the pieces.
	 * A menu is displayed and the user has the decision to change a piece if it's not
	 * in the right position.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param pieces The piece list built in the main method.
	 */
	public static void checkPieces(Scanner read, RobotsList robots, PieceList pieces) {
		System.out.println();
		System.out.print("Ingrese el NOMBRE del robot que desea revisar: ");
		String checkRobot = read.nextLine();
		
		Robot r = robots.getRobotName(checkRobot);
		System.out.println();
		
		if(r == null) {
			System.out.println("Robot no encontrado. Intentelo nuevamente.");
		} else {
			showRobotImage();
			System.out.println(r.toString());
			System.out.println();
			System.out.print("¿Desea cambiar alguna pieza? (y/n): ");
			String option = read.nextLine();
			
			while(!option.equals("y") && !option.equals("n")) {
				System.out.println();
				System.out.println("Ingrese una opción válida.");
				System.out.println();
				System.out.print("¿Desea cambiar alguna pieza? (y/n): ");
				option = read.nextLine();
			}
			
			if(option.equals("n")) {
				System.out.println();
				System.out.println("Revisión de robot finalizada. Ninguna pieza fue cambiada.");
			}
			else if(option.equals("y")) {
				boolean checker = true;
				
				while(checker) {
					System.out.println();
					System.out.println("¿Qué pieza desea cambiar?");
					System.out.println("[1] Brazos");
					System.out.println("[2] Piernas");
					System.out.println("[3] Tórax");
					System.out.println("[4] Cabeza");
					System.out.println("[5] Extra");
					System.out.println("[6] Salir de la revisión");
					System.out.print("N°: ");
					int pieceI = Integer.parseInt(read.nextLine());
					
					switch(pieceI) {
					case 1:
						changePiece(read, robots, pieces, "brazos", r);
						break;
					case 2:
						changePiece(read, robots, pieces, "piernas", r);
						break;
					case 3:
						changePiece(read, robots, pieces, "tórax", r);
						break;
					case 4: 
						changePiece(read, robots, pieces, "cabeza", r);
						break;
					case 5:
						changePiece(read, robots, pieces, "extra", r);
						break;
					case 6:
						System.out.println();
						System.out.println("Finalizando revisión.");
						checker = false;
						break;
					default:
						System.out.println();
						System.out.println("Ingrese una opción válida.");
						break;
					}
				}
			}
		}	
	}
	
	/**
	 * Used in the checkPieces method.
	 * Depending on the piece type, it shows the user the available pieces.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param type The piece type entered in the checkPieces method.
	 * @param r The robot entered by the user.
	 */
	private static void changePiece(Scanner read, RobotsList robots, PieceList pieces, String type, Robot r) {
		int cantPieces = 0;
		for(int i = 0; i < pieces.getCant(); i++) {
			if(pieces.getPiece(i).getType().equals(type)) {
				cantPieces++;
			}
		}
		if(cantPieces == 0) {
			System.out.println();
			System.out.println("No hay piezas de este tipo. Modificación imposible.");
		} else {
			System.out.println();
			System.out.println("Piezas para intercambiar:");
			for(int j = 0; j < pieces.getCant(); j++) {
				if(pieces.getPiece(j).getType().equals(type)) {
					System.out.println("[" + j + "] " + pieces.getPiece(j).getName());

				}
			}
			System.out.println();
			System.out.print("Ingrese el n° de la pieza que desea intercambiar: ");
			int cPiece = Integer.parseInt(read.nextLine());
			
			String pieceName = pieces.getPiece(cPiece).getName();

			if(type.equals("brazos")) {
				r.setArmsName(pieceName);
			} else if(type.equals("piernas")) {
				r.setLegsName(pieceName);
			} else if(type.equals("tórax")) {
				r.setChestName(pieceName);
			} else if(type.equals("cabeza")) {
				r.setHeadName(pieceName);
			} else if(type.equals("extra")) {
				r.setExtraQuality(pieceName);
			}
			
			System.out.println("");
			System.out.println("Pieza cambiada exitosamente.");
		}
	}
	
	/**
	 * Used in the changePieces method.
	 * Works similar as the changePiece method, but for weapons.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param r The robot entered by the user.
	 */
	public static void changeWeapon(Scanner read, RobotsList robots, WeaponsList weapons, Robot r) {
		System.out.println();
		
		if(weapons.getCant() == 0) {
			System.out.println("No hay armas con las que intercambiar.");
		} else {
			System.out.println("Armas para intercambiar:");
			int cont = 0;
			for(int i = 0; i < weapons.getCant(); i++) {
				System.out.println("[" + (cont + 1) + "] " + weapons.getWeapon(i).getName());
				cont++;
			}
			System.out.println();
			System.out.print("Ingrese el n° del arma que desea intercambiar: ");
			int option = Integer.parseInt(read.nextLine());
			
			while(option < 1 || option > cont) {
				System.out.println();
				System.out.println("Ingrese una opción válida.");
				System.out.println();
				System.out.print("Ingrese el n° del arma que desea intercambiar: ");
				option = Integer.parseInt(read.nextLine());
			}
			int newOption = option - 1;
			
			r.setWeaponName(weapons.getWeapon(newOption).getName());
			System.out.println();
			System.out.println("Arma cambiada exitosamente.");
		}
	}
	
	/**
	 * Shows the entire staff, separating the assemblers from the pilots.
	 * If there's no personal, a message is displayed on screen.
	 * 
	 * @param people The people list built in the main method.
	 */
	public static void showPeople(PersonList people) {
		System.out.println("");
		System.out.println("Ensambladores:");
		
		int cantE = 0;
		for(int i = 0; i < people.getCant(); i++) {
			if(people.getPersonWithI(i).getSpecialty().equals("ensamblador")) {
				System.out.println("[" + (cantE + 1) + "] " + people.getPersonWithI(i).toString());
				cantE++;
			}
		}
		if(cantE == 0) {
			System.out.println("No hay ensambladores.");
		}
		System.out.println();
		System.out.println("Pilotos:");
		
		int cantP = 0;
		for(int j = 0; j < people.getCant(); j++) {
			if(people.getPersonWithI(j).getSpecialty().equals("piloto")) {
				System.out.println("[" + (cantP + 1) + "] " + people.getPersonWithI(j).toString());
				cantP++;
			}
		}
		if(cantP == 0) {
			System.out.println("No hay pilotos.");
		}
	}
	
	/**
	 * Shows all registered teams.
	 * If there's no teams, a message is displayed on screen.
	 * 
	 * @param people The people list built in the main method.
	 */
	public static void showGroups(PersonList people) {
		System.out.println();
		System.out.println("Grupos:");
		
		String[] groups = new String[100];

		int contAdded = 0;
		for(int i = 0; i < people.getCant(); i++) {
			int cont = 0;
			
			for(int j = 0; j < 100; j++) {
				if(people.getPersonWithI(i).getTeam().equals(groups[j])) {
					cont++;
				}
			}
			if(cont == 0) {
				groups[contAdded++] = people.getPersonWithI(i).getTeam();
			}
		}
		if(contAdded == 0) {
			System.out.println("No hay grupos en el registro de los datos.");
			return;
		}
		for(int i = 0; i < 100; i++) {
			int cont = 0;
			
			if(groups[i] != null) {
				System.out.println();
				System.out.println(groups[i]);
				
				for(int j = 0; j < people.getCant(); j++) {
					if(people.getPersonWithI(j).getTeam().equals(groups[i])) {
						System.out.println("[" + (cont + 1) + "]" + "[Nombre: " + people.getPersonWithI(j).getName() + " | ID: " + people.getPersonWithI(j).getID() + " | Especialidad: " + people.getPersonWithI(j).getSpecialty() + "]");
						cont++;
					}
				}
			}
		}
	}
	
	/**
	 * Shows all registered robots.
	 * If there's no robots, a message is displayed on screen.
	 * 
	 * @param robots The robot list built in the main method.
	 */
	public static void showRobots(RobotsList robots) {
		System.out.println();
		System.out.println("Robots:");
		
		int cantR = 0;
		for(int i = 0; i < robots.getCant(); i++) {
			Robot r = robots.getRobot(i);
			System.out.println("[" + (cantR + 1) + "] " + r.getRobotName() + " | Código Piloto: " + r.getPilotCode() + " | Equipo: " + r.getTeam());
			cantR++;
		}
		if(cantR == 0) {
			System.out.println("No hay robots en el registro.");
		}
	}
	
	/**
	 * Shows all registered robots, then asks to choose one from the list and adds
	 * ammo to the respective robot weapon.
	 * If it wasn't possible to add ammo, a message is displayed on screen.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 */
	public static void checkAmmo(Scanner read, RobotsList robots, WeaponsList weapons) {
		System.out.println();
		System.out.println("Robots:");
		
		int cantR = 0;
		for(int i = 0; i < robots.getCant(); i++) {
			Robot r = robots.getRobot(i);
			System.out.println("[" + (cantR + 1) + "] [" + r.getRobotName() + " | Arma: " + r.getWeaponName() + "]");
			cantR++;
		}
		System.out.println();
		System.out.print("Ingrese el n° del robot al que desea aumentar su munición: ");
		int option = Integer.parseInt(read.nextLine()) - 1;
		
		for(int i = 0; i < weapons.getCant(); i++) {
			if(weapons.getWeapon(i).getName().equals(robots.getRobot(option).getWeaponName())) {
				System.out.print("Ingrese la cantidad de munición que desea agregar: ");
				int ammo = Integer.parseInt(read.nextLine());
				
				while(ammo < 0) {
					System.out.println();
					System.out.println("Ingrese una cantidad válida.");
					System.out.println();
					System.out.print("Ingrese la cantidad de munición que desea agregar: ");
					ammo = Integer.parseInt(read.nextLine());
				}
				weapons.getWeapon(i).setAmmo(weapons.getWeapon(i).getAmmo() + ammo);
				System.out.println();
				System.out.println("Munición agregada exitosamente.");
				return;
			}
		}
		System.out.println();
		System.out.println("No ha sido posible agregar la munición.");
	}
	
	/**
	 * Shows all registered countries, except those that are repeated.
	 * 
	 * @param countries The country list built in the main method.
	 */
	public static void showCountries(CountryList countries) {
		System.out.println();
		System.out.println("Países:");
		
		String[] shownCountries = new String[100];
		int cantP = 0;

		int contAdded = 0;
		for(int i = 0; i < countries.getCant(); i++) {
			int cont = 0;
			
			for(int j = 0; j < 100; j++) {
				if(countries.getCountry(i).getCountryName().equals(shownCountries[j])) {
					cont++;
				}
			}
			if(cont == 0) {
				shownCountries[contAdded++] = countries.getCountry(i).getCountryName();
				cantP++;
			}
		}
		
		for(int k = 0; k < 100; k++) {
			if(shownCountries[k] != null) {
				System.out.println(shownCountries[k]);
			}
		}
		
		if(cantP == 0) {
			System.out.println("No hay países registrados.");
		}
	}
	
	/**
	 * Shows all registered countries, asking the user to choose one.
	 * Then it shows all the pieces from that country and adds stock only if it's possible.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param materials The material list built in the main method.
	 */
	public static void addPiecesStock(Scanner read, CountryList countries, PieceList pieces, MaterialsList materials) {
		System.out.println();
		System.out.println("Países:");
		
		String[] shownCountries = new String[100];
		int cantP = 0;

		int contAdded = 0;
		for(int i = 0; i < countries.getCant(); i++) {
			int cont = 0;
			
			for(int j = 0; j < 100; j++) {
				if(countries.getCountry(i).getCountryName().equals(shownCountries[j])) {
					cont++;
				}
			}
			if(cont == 0 && countries.getCountry(i).getType().equals("pieza")) {
				shownCountries[contAdded++] = countries.getCountry(i).getCountryName();
				cantP++;
			}
		}
		if(cantP == 0) {
			System.out.println("No hay países registrados.");
			return;
		}
		
		int q = 0;
		for(int k = 0; k < 100; k++) {
			if(shownCountries[k] != null) {
				System.out.println("[" + (q + 1) + "] " + shownCountries[k]);
				q++;
			}
		}
		System.out.println();
		System.out.print("Ingrese el n° del país al que desea agregarle stock: ");
		int option = Integer.parseInt(read.nextLine()) - 1;
		
		for(int i = 0; i < countries.getCant(); i++) {
			if(countries.getCountry(i).getCountryName().equals(shownCountries[option]) && countries.getCountry(i).getType().equals("pieza")) {
				System.out.println();
				
				String pieceCode = countries.getCountry(i).getTypeCode();
				Piece p = pieces.getPieceCode(pieceCode);
				
				if(materials.getMaterialName(countries.getCountry(i).getMaterial()).getStock() < p.getCantMaterial()) {
					System.out.println("Imposible agregar stock de la pieza. Cantidad de material insuficiente.");
					return;
				}
				
				System.out.println();
				System.out.println("[Pieza] ---> " + p.getName() + " | Stock: " + countries.getCountry(i).getCant() + " | " + countries.getCountry(i).getMaterial()
									+ " disponible: " + materials.getMaterialName(countries.getCountry(i).getMaterial()).getStock() + " (Usa " + p.getCantMaterial() + ")");
				System.out.println();
				System.out.print("Ingrese la cantidad que desea agregar: ");
				int cantPieces = Integer.parseInt(read.nextLine());
				int materialUsed = p.getCantMaterial() * cantPieces;
				
				while(cantPieces < 0 || materialUsed > materials.getMaterialName(countries.getCountry(i).getMaterial()).getStock()) {
					System.out.println();
					System.out.println("Ingrese una cantidad válida.");
					System.out.println();
					System.out.print("Ingrese la cantidad que desea agregar: ");
					cantPieces = Integer.parseInt(read.nextLine());
					materialUsed = p.getCantMaterial() * cantPieces;
				}

				System.out.println();
				countries.getCountry(i).setCant(countries.getCountry(i).getCant() + cantPieces);
				materials.getMaterialName(countries.getCountry(i).getMaterial()).setStock(materials.getMaterialName(countries.getCountry(i).getMaterial()).getStock() - materialUsed);
				System.out.println("Stock agregado exitosamente.");
			}
		}
	}
	
	/**
	 * If there's at least one material in the material list, it asks the user to
	 * add stock to one of them.
	 * If it wasn't possible to add stock, a message is displayed on screen.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param materials The material list built in the main method.
	 */
	public static void addMaterialStock(Scanner read, MaterialsList materials) {
		if(materials.getCant() == 0) {
			System.out.println();
			System.out.println("No hay materiales para agregar stock.");
		} else {
			System.out.println();
			System.out.println("¿A qué material desea agregar stock?");
			System.out.println();
			
			int cont = 0;
			for(int i = 0; i < materials.getCant(); i++) {
				System.out.println("[" + (cont + 1) + "] " + materials.getMaterial(i).getName());
				cont++;
			}
			System.out.println();
			System.out.print("Opción: ");
			int option = Integer.parseInt(read.nextLine()) - 1;
			Material m = materials.getMaterial(option);
			
			System.out.print("Ingrese la cantidad de material que desea agregar: ");
			int cantM = Integer.parseInt(read.nextLine());
			
			if(cantM >= 0) {
				m.setStock(m.getStock() + cantM);
				
				System.out.println();
				System.out.println("Cantidad ingresada exitosamente.");
			} else {
				System.out.println();
				System.out.println("Ingrese una cantidad válida.");
			}
		}
	}
	
	/**
	 * If there's at least one piece, it shows all the registered pieces.
	 * Same for weapons.
	 * 
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 */
	public static void showPiecesAndWeapons(PieceList pieces, WeaponsList weapons) {
		System.out.println();
	  	System.out.println("Piezas:");

	    int cantP = 0;
	    for(int i = 0; i < pieces.getCant(); i++) {
	    	Piece p = pieces.getPiece(i);
			System.out.println("[" + (cantP + 1) + "] [" + p.getName() + " | Código: " + p.getCode() + "] Creado por " + p.getOriginCountry());
			cantP++;
	    }
	    if(cantP == 0) {
	      System.out.println("No hay piezas.");
	    }
	    
	    System.out.println();
	    System.out.println("Armas:");
	    
	    int cantW = 0;
	    for(int i = 0; i < weapons.getCant(); i++) {
	    	Weapon w = weapons.getWeapon(i);
	    	System.out.println("[" + (cantW + 1) + "] [" + w.getName() + " | Código: " + w.getCode() + " | AMMO: " + w.getAmmo() + "] Creado por " + w.getOriginCountry());
	    	cantW++;
	    }
	    if(cantW == 0) {
	    	System.out.println("No hay armas.");
	    }
	}
	
	/**
	 * Works similar as the checkPieces method, but for weapons too.
	 * It asks the user for a robot name, then shows all the pieces and it's weapon.
	 * A menu is displayed and the user has the decision to change a piece.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 */
	public static void changePieces(Scanner read, RobotsList robots, PieceList pieces, WeaponsList weapons) {
		System.out.println();
		System.out.print("Ingrese el NOMBRE del robot al que desea cambiar sus piezas: ");
		String checkRobot = read.nextLine();
		
		Robot r = robots.getRobotName(checkRobot);
		System.out.println();
		
		if(r == null) {
			System.out.println("Robot no encontrado. Intentelo nuevamente.");
		} else {
			showRobotImage();
			System.out.println(r.toString());
			
			boolean checker = true;
			while(checker) {
				System.out.println();
				System.out.println("¿Qué pieza desea cambiar?");
				System.out.println("[1] Brazos");
				System.out.println("[2] Piernas");
				System.out.println("[3] Tórax");
				System.out.println("[4] Cabeza");
				System.out.println("[5] Extra");
				System.out.println("[6] Arma");
				System.out.println("[7] Volver al menú");
				System.out.print("N°: ");
				int pieceI = Integer.parseInt(read.nextLine());
				
				switch(pieceI) {
				case 1:
					changePiece(read, robots, pieces, "brazos", r);
					break;
				case 2:
					changePiece(read, robots, pieces, "piernas", r);
					break;
				case 3:
					changePiece(read, robots, pieces, "tórax", r);
					break;
				case 4: 
					changePiece(read, robots, pieces, "cabeza", r);
					break;
				case 5:
					changePiece(read, robots, pieces, "extra", r);
					break;
				case 6:
					changeWeapon(read, robots, weapons, r);
					break;
				case 7:
					System.out.println();
					System.out.println("Cambios finalizados.");
					checker = false;
					break;
				default:
					System.out.println();
					System.out.println("Ingrese una opción válida.");
					break;
				}
			}
		}	
	}
	
	/**
	 * Menu where you can activate all the emergency options, this menu can only be accessible
	 * by entering "empanadas" as name and "porotosconriendas" as ID.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 * @throws IOException If input/output values are misinterpreted or fail.
	 */
	public static void secretMenu(Scanner read, RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) throws IOException {
		System.out.println();
		System.out.println("Se ha ingresado al menú secreto de manera exitosa.");
		
		boolean checker = true;
		while(checker) {
			System.out.println();
			System.out.println("==============================================");
			System.out.println("[1] Activar producción de recursos nucleares");
			System.out.println("[2] Destruir todo..");
			System.out.println("==============================================");
			System.out.println();
			System.out.print("Ingrese una opción: ");
			int opcion = Integer.parseInt(read.nextLine());
			
			switch(opcion) {
			case 1:
				uranium(materials);
				uraniumPieces(read, pieces, countries, materials);
				fileWriting(robots, countries, pieces, weapons, materials, people, models);
				checker = false;
				break;
			case 2:
				System.out.println();
				System.out.print("Confirmación necesaria, presione 1 para continuar: ");
				int confirmation = Integer.parseInt(read.nextLine());
				
				switch(confirmation) {
				case 1:
					fileWritingEX(robots, countries, pieces, weapons, materials, people, models);
					deleteAll(robots, countries, pieces, weapons, materials, people, models);
					System.out.println();
					System.out.println("Que Dios nos ampare..");
					System.out.println();
					showExplotionImage();
					checker = false;
					break;
				default:
					System.out.println();
					System.out.println("Eliminación mundial cancelada.");
					break;
				}
				break;
			default:
				System.out.println();
				System.out.println("Opción no disponible.");
				break;
			}
		}
	}
	
	/**
	 * Method used in the secret menu.
	 * Creates uranium, with a stock of 100000, coming from area 51.
	 * 
	 * @param materials The material list built in the main method.
	 */
	public static void uranium(MaterialsList materials) {
		Material m = new Material("Uranio", 100000, "area51");
		materials.add(m);
		
		System.out.println();
		System.out.println("=======================================================");
		System.out.println("Uranio agregado exitosamente a la lista de materiales.");
		System.out.println("=======================================================");
	}
	
	/**
	 * Method used in the secret menu.
	 * Creates a set of nuclear pieces, with characteristics given by the user.
	 * 
	 * @param read The scanner built in the main method. Saves values entered by the user.
	 * @param pieces The piece list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param materials The material list built in the main method.
	 */
	public static void uraniumPieces(Scanner read, PieceList pieces, CountryList countries, MaterialsList materials) {
		System.out.println();
		System.out.println("Procedimiento === CREACIÓN DE PIEZAS NUCLEARES === inicializado.");
		System.out.println();
		System.out.println("===== Brazos =====");
		
		System.out.print("Ingrese el nombre: ");
		String name = read.nextLine();

		System.out.print("Ingrese el código: ");
		String code = read.nextLine();
		
		System.out.print("Ingrese la cantidad de Uranio necesario: ");
		int cantMaterial = Integer.parseInt(read.nextLine());
		
			Piece p = new Piece(name, code, "brazos", "area51", cantMaterial);
			pieces.add(p);
			
			Country c = new Country("area51", "pieza", code, 1, "Uranio");
			countries.add(c);
			
			materials.getMaterialName("Uranio").setStock(materials.getMaterialName("Uranio").getStock() - cantMaterial);
		
		System.out.println();
		System.out.println("==== Piernas ====");
		
		System.out.print("Ingrese el nombre: ");
		name = read.nextLine();

		System.out.print("Ingrese el código: ");
		code = read.nextLine();
		
		System.out.print("Ingrese la cantidad de Uranio necesario: ");
		cantMaterial = Integer.parseInt(read.nextLine());
		
			p = new Piece(name, code, "piernas", "area51", cantMaterial);
			pieces.add(p);
		
			c = new Country("area51", "pieza", code, 1, "Uranio");
			countries.add(c);
			
			materials.getMaterialName("Uranio").setStock(materials.getMaterialName("Uranio").getStock() - cantMaterial);
			
		System.out.println();
		System.out.println("==== Tórax ====");
			
		System.out.print("Ingrese el nombre: ");
		name = read.nextLine();

		System.out.print("Ingrese el código: ");
		code = read.nextLine();
			
		System.out.print("Ingrese la cantidad de Uranio necesario: ");
		cantMaterial = Integer.parseInt(read.nextLine());
			
			p = new Piece(name, code, "tórax", "area51", cantMaterial);
			pieces.add(p);
			
			c = new Country("area51", "pieza", code, 1, "Uranio");
			countries.add(c);
			
			materials.getMaterialName("Uranio").setStock(materials.getMaterialName("Uranio").getStock() - cantMaterial);
			
		System.out.println();	
		System.out.println("==== Cabeza ====");
			
		System.out.print("Ingrese el nombre: ");
		name = read.nextLine();

		System.out.print("Ingrese el código: ");
		code = read.nextLine();
			
		System.out.print("Ingrese la cantidad de Uranio necesario: ");
		cantMaterial = Integer.parseInt(read.nextLine());
			
			p = new Piece(name, code, "cabeza", "area51", cantMaterial);
			pieces.add(p);
			
			c = new Country("area51", "pieza", code, 1, "Uranio");
			countries.add(c);
			
			materials.getMaterialName("Uranio").setStock(materials.getMaterialName("Uranio").getStock() - cantMaterial);
			
		System.out.println();
		System.out.println("==== Extra ====");
			
		System.out.print("Ingrese el nombre: ");
		name = read.nextLine();

		System.out.print("Ingrese el código: ");
		code = read.nextLine();
			
		System.out.print("Ingrese la cantidad de Uranio necesario: ");
		cantMaterial = Integer.parseInt(read.nextLine());
			
			p = new Piece(name, code, "extra", "area51", cantMaterial);
			pieces.add(p);
			
			c = new Country("area51", "pieza", code, 1, "Uranio");
			countries.add(c);
			
			materials.getMaterialName("Uranio").setStock(materials.getMaterialName("Uranio").getStock() - cantMaterial);
		
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("Set de piezas nucleares agregado exitosamente.");
		System.out.println("==============================================");
	}
	
	/**
	 * Method used in the secret menu.
	 * Deletes all the data registered in the lists created in the main method.
	 * 
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 */
	public static void deleteAll(RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) {
		robots.deleteEverything();
		countries.deleteEverything();
		pieces.deleteEverything();
		weapons.deleteEverything();
		materials.deleteEverything();
		people.deleteEverything();
		models.deleteEverything();
	}
	
	/**
	 * Overwrites all the data from the lists created in the main method in their
	 * respective txt files.
	 * 
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 * @throws IOException If input/output values are misinterpreted or fail.
	 */
	public static void fileWriting(RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) throws IOException {
		FileWriter save0 = new FileWriter(new File("robots.txt"));
		for(int i = 0; i < robots.getCant(); i++) {
			save0.write(robots.getRobot(i).getRobotName() + ", " + robots.getRobot(i).getArmsName() + ", "
					+ robots.getRobot(i).getLegsName() + ", " + robots.getRobot(i).getChestName() + ", "
					+ robots.getRobot(i).getHeadName() + ", " + robots.getRobot(i).getExtraQuality() + ", "
					+ robots.getRobot(i).getWeaponName() + ", " + robots.getRobot(i).getTeam() + ", "
					+ robots.getRobot(i).getPilotCode());
			save0.write("\r\n");
		}
		save0.close();
		
		FileWriter save1 = new FileWriter(new File("Países.txt"));
		for(int i = 0; i < countries.getCant(); i++) {
			save1.write(countries.getCountry(i).getCountryName() + ", " + countries.getCountry(i).getType() + ", "
					+ countries.getCountry(i).getTypeCode() + ", " + countries.getCountry(i).getCant() + ", "
					+ countries.getCountry(i).getMaterial());
			save1.write("\r\n");
		}
		save1.close();
		
		FileWriter save2 = new FileWriter(new File("Piezas.txt"));
		for(int i = 0; i < pieces.getCant(); i++) {
			save2.write(pieces.getPiece(i).getName() + ", " + pieces.getPiece(i).getCode() + ", "
					+ pieces.getPiece(i).getType() + ", " + pieces.getPiece(i).getOriginCountry() + ", "
					+ pieces.getPiece(i).getCantMaterial());
			save2.write("\r\n");
		}
		save2.close();
		
		FileWriter save3 = new FileWriter(new File("Armas.txt"));
		for(int i = 0; i < weapons.getCant(); i++) {
			save3.write(weapons.getWeapon(i).getName() + ", " + weapons.getWeapon(i).getCode() + ", "
					+ weapons.getWeapon(i).getAmmo() + ", " + weapons.getWeapon(i).getOriginCountry() + ", "
					+ weapons.getWeapon(i).getCantMaterial());
			save3.write("\r\n");
		}
		save3.close();
		
		FileWriter save4 = new FileWriter(new File("Materiales.txt"));
		for(int i = 0; i < materials.getCant(); i++) {
			save4.write(materials.getMaterial(i).getName() + "," + materials.getMaterial(i).getStock() + ","
					+ materials.getMaterial(i).getOriginCountry());
			save4.write("\r\n");
		}
		save4.close();
		
		FileWriter save5 = new FileWriter(new File("Personas.txt"));
		for(int i = 0; i < people.getCant(); i++) {
			save5.write(people.getPersonWithI(i).getName() + ", " + people.getPersonWithI(i).getID() + ", "
					+ people.getPersonWithI(i).getSpecialty() + ", " + people.getPersonWithI(i).getTeam());
			save5.write("\r\n");
		}
		save5.close();
		
		FileWriter save6 = new FileWriter(new File("modelos.txt"));
		for(int i = 0; i < models.getCant(); i++) {
			save6.write(models.getModelI(i).getModelCode() + ", " + models.getModelI(i).getRobotName());
			save6.write("\r\n");
		}
		save6.close();
	}
	
	/**
	 * Similar as the fileWriting method.
	 * Deletes all the information in the txt files.
	 * 
	 * @param robots The robot list built in the main method.
	 * @param countries The country list built in the main method.
	 * @param pieces The piece list built in the main method.
	 * @param weapons The weapon list built in the main method.
	 * @param materials The material list built in the main method.
	 * @param people The people list built in the main method.
	 * @param models The model list built in the main method.
	 * @throws IOException If input/output values are misinterpreted or fail.
	 */
	public static void fileWritingEX(RobotsList robots, CountryList countries, PieceList pieces, WeaponsList weapons, MaterialsList materials, PersonList people, ModelList models) throws IOException {
		FileWriter save0 = new FileWriter(new File("robots.txt"));
		for(int i = 0; i < robots.getCant(); i++) {
			save0.write("");
			save0.write("\r\n");
		}
		save0.close();
		
		FileWriter save1 = new FileWriter(new File("Países.txt"));
		for(int i = 0; i < countries.getCant(); i++) {
			save1.write("");
			save1.write("\r\n");
		}
		save1.close();
		
		FileWriter save2 = new FileWriter(new File("Piezas.txt"));
		for(int i = 0; i < pieces.getCant(); i++) {
			save2.write("");
			save2.write("\r\n");
		}
		save2.close();
		
		FileWriter save3 = new FileWriter(new File("Armas.txt"));
		for(int i = 0; i < weapons.getCant(); i++) {
			save3.write("");
			save3.write("\r\n");
		}
		save3.close();
		
		FileWriter save4 = new FileWriter(new File("Materiales.txt"));
		for(int i = 0; i < materials.getCant(); i++) {
			save4.write("");
			save4.write("\r\n");
		}
		save4.close();
		
		FileWriter save5 = new FileWriter(new File("Personas.txt"));
		for(int i = 0; i < people.getCant(); i++) {
			save5.write("");
			save5.write("\r\n");
		}
		save5.close();
		
		FileWriter save6 = new FileWriter(new File("modelos.txt"));
		for(int i = 0; i < models.getCant(); i++) {
			save6.write("");
			save6.write("\r\n");
		}
		save6.close();
	}
	
	/**
	 * Shows a robot.
	 */
	private static void showRobotImage() {
		System.out.println("           ___\r\n"
				+ "          |_|_|\r\n"
				+ "          |_|_|              _____\r\n"
				+ "          |_|_|     ____    |*_*_*|\r\n"
				+ " _______   _\\__\\___/ __ \\____|_|_   _______\r\n"
				+ "/ ____  |=|      \\  <_+>  /      |=|  ____ \\\r\n"
				+ "~|    |\\|=|======\\\\______//======|=|/|    |~\r\n"
				+ " |_   |    \\      |      |      /    |    |\r\n"
				+ "  \\==-|     \\     |  2D  |     /     |----|~~/\r\n"
				+ "  |   |      |    |      |    |      |____/~/\r\n"
				+ "  |   |       \\____\\____/____/      /    / /\r\n"
				+ "  |   |         {----------}       /____/ /\r\n"
				+ "  |___|        /~~~~~~~~~~~~\\     |_/~|_|/\r\n"
				+ "   \\_/        |/~~~~~||~~~~~\\|     /__|\\\r\n"
				+ "   | |         |    ||||    |     (/|| \\)\r\n"
				+ "   | |        /     |  |     \\       \\\\\r\n"
				+ "   |_|        |     |  |     |\r\n"
				+ "              |_____|  |_____|\r\n"
				+ "              (_____)  (_____)\r\n"
				+ "              |     |  |     |\r\n"
				+ "              |     |  |     |\r\n"
				+ "              |/~~~\\|  |/~~~\\|\r\n"
				+ "              /|___|\\  /|___|\\\r\n"
				+ "             <_______><_______>");
		
	}
	
	/**
	 * Shows an explosion.
	 */
	private static void showExplotionImage() {
		System.out.println("                               ________________\r\n"
				+ "                          ____/ (  (    )   )  \\___\r\n"
				+ "                         /( (  (  )   _    ))  )   )\\\r\n"
				+ "                       ((     (   )(    )  )   (   )  )\r\n"
				+ "                     ((/  ( _(   )   (   _) ) (  () )  )\r\n"
				+ "                    ( (  ( (_)   ((    (   )  .((_ ) .  )_\r\n"
				+ "                   ( (  )    (      (  )    )   ) . ) (   )\r\n"
				+ "                  (  (   (  (   ) (  _  ( _) ).  ) . ) ) ( )\r\n"
				+ "                  ( (  (   ) (  )   (  ))     ) _)(   )  )  )\r\n"
				+ "                 ( (  ( \\ ) (    (_  ( ) ( )  )   ) )  )) ( )\r\n"
				+ "                  (  (   (  (   (_ ( ) ( _    )  ) (  )  )   )\r\n"
				+ "                 ( (  ( (  (  )     (_  )  ) )  _)   ) _( ( )\r\n"
				+ "                  ((  (   )(    (     _    )   _) _(_ (  (_ )\r\n"
				+ "                   (_((__(_(__(( ( ( |  ) ) ) )_))__))_)___)\r\n"
				+ "                   ((__)        \\\\||lll|l||///          \\_))\r\n"
				+ "                            (   /(/ (  )  ) )\\   )\r\n"
				+ "                          (    ( ( ( | | ) ) )\\   )\r\n"
				+ "                           (   /(| / ( )) ) ) )) )\r\n"
				+ "                         (     ( ((((_(|)_)))))     )\r\n"
				+ "                          (      ||\\(|(|)|/||     )\r\n"
				+ "                        (        |(||(||)||||        )\r\n"
				+ "                          (     //|/l|||)|\\\\ \\     )\r\n"
				+ "                        (/ / //  /|//||||\\\\  \\ \\  \\ _)\r\n"
				+ "-------------------------------------------------------------------------------");
		
	}
}




