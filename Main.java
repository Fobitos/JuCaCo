import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main class where all the main code is implemented.
 *
 * @author      Juan Castro Cortés. <juan.castro@alumnos.ucn.cl>
 * @author      Carlos Leal Serrano. <carlos.leal@alumnos.ucn.cl>
 */
public class Main {

  /**
   * The main method. Scanner and two lists are built, the aliens list and the humans list.
   * It calls two other methods, the first one read the txt files and the other one start the menu.
   *
   * @param args The command line arguments.
   * @throws FileNotFoundException If the file is not found.
   * @throws IOException If input/output values are misinterpreted or fail.
   *
   **/
  public static void main(String[] args) throws FileNotFoundException, IOException {
    Scanner read = new Scanner(System.in);

    AliensList aliensList = new AliensList(1000);
    HumansList humansList = new HumansList(1000);

    fileReading(aliensList, humansList);
    menu(read, humansList, aliensList);
  }
  
  /**
   * Two lists are inserted.
   * This method open two different txt files, which can be empty or filled with information.
   * It also build and add the objects in their respective lists.
   * 
   * @param aliensList The aliens list built in the main method.
   * @param humansList The humans list list built in the main method.
   * @throws FileNotFoundException If the files are not found.
   * 
   */
  public static void fileReading(AliensList aliensList, HumansList humansList) throws FileNotFoundException {
    int cantLinesX = 0;
    Scanner arch0 = new Scanner(new File("x.txt"));
    while (arch0.hasNextLine()) {
      String line = arch0.nextLine();
      String[] parts = line.split(", ");

      String speciesName = parts[0];
      speciesName = translateAlienWord(speciesName);

      String name = parts[1];
      name = translateAlienWord(name);

      int UI = Integer.parseInt(parts[2]);

      String homePlanet = parts[3];
      homePlanet = translateAlienWord(homePlanet);
 
      int age = Integer.parseInt(parts[4]) * 8; // From alien age to human age.
      double height = Double.valueOf(parts[5]) / 100; // Centimeters to meters.
      double weight = Double.valueOf(parts[6]) / 1000; // Grams to kilograms.
      String type = parts[7];

      Alien a = new Alien(speciesName, name, UI, homePlanet, age, height, weight, type);
      aliensList.add(a);

      cantLinesX++;
    }
    if (cantLinesX == 0) {
      System.out.println("No hay datos dentro del archivo de texto: x.txt");
    }
    arch0.close();

    int cantLinesH = 0;
    Scanner arch1 = new Scanner(new File("h.txt"));
    while (arch1.hasNextLine()) {
      String line = arch1.nextLine();
      String[] parts = line.split(",");

      String nationality = parts[0];
      String name = parts[1];
      int ID = Integer.parseInt(parts[2]);
      String region = parts[3];
      String city = parts[4];
      int age = Integer.parseInt(parts[5]);
      double height = Double.valueOf(parts[6]) / 100; // [Centimeters] to [Meters]
      double weight = Double.valueOf(parts[7]) / 1000; // [Grams] to [Kilograms]
      String workPlanets = parts[8];

      Human h = new Human(nationality, name, ID, region, city, age, height, weight, workPlanets);
      humansList.add(h);

      cantLinesH++;
    }
    if (cantLinesH == 0) {
      System.out.println("No hay datos dentro del archivo de texto: h.txt");
    }
    arch1.close();
  }

  /**
   * A word is inserted.
   * Splits the word into its characters, decodes it, and then joins them into a new word.
   * 
   * @param word The word you want to translate into spanish.
   * @return translatedWord The final word finally translated from the alien language.
   * 
   */
  public static String translateAlienWord(String word) {
    String translatedWord = "";
    String[] splittedWord = word.split("");

    for (int i = 0; i < splittedWord.length; i++) {
    	
      if (splittedWord[i].equals("a")) {
        splittedWord[i] = "e";
      } else if (splittedWord[i].equals("A")) {
        splittedWord[i] = "E";
      } else if (splittedWord[i].equals("e")) {
        splittedWord[i] = "a";
      } else if (splittedWord[i].equals("E")) {
        splittedWord[i] = "A";
      } else if (splittedWord[i].equals("o")) {
        splittedWord[i] = "i";
      } else if (splittedWord[i].equals("O")) {
        splittedWord[i] = "I";
      } else if (splittedWord[i].equals("i")) {
        splittedWord[i] = "o";
      } else if (splittedWord[i].equals("I")) {
        splittedWord[i] = "O";
      }
      translatedWord += splittedWord[i];
    }
    return translatedWord;
  }

  /**
   * Translate 3 alien variables to their original language, which were translated into 
   * spanish before.
   * 
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void translateBackToAlien(AliensList aliensList) {
	  for(int i = 0; i < aliensList.getCant(); i++) {
		  for(int j = 0; j < 3; j++) {
			  if(j == 0) {
				  String word = aliensList.getAlien(i).getSpeciesName();
				  String[] splittedWord = word.split("");
				  word = "";
				  
				  for(int k = 0; k < splittedWord.length; k++) {
					  if (splittedWord[k].equals("a")) {
					        splittedWord[k] = "e";
					  } else if (splittedWord[k].equals("A")) {
					        splittedWord[k] = "E";
					  } else if (splittedWord[k].equals("e")) {
					        splittedWord[k] = "a";
					  } else if (splittedWord[k].equals("E")) {
					        splittedWord[k] = "A";
					  } else if (splittedWord[k].equals("o")) {
					        splittedWord[k] = "i";
					  } else if (splittedWord[k].equals("O")) {
					        splittedWord[k] = "I";
					  } else if (splittedWord[k].equals("i")) {
					        splittedWord[k] = "o";
					  } else if (splittedWord[k].equals("I")) {
					        splittedWord[k] = "O";
					  }
					  word += splittedWord[k];
				  }
				  aliensList.getAlien(i).setSpeciesName(word);
			  }
			  else if(j == 1) {
				  String word = aliensList.getAlien(i).getName();
				  String[] splittedWord = word.split("");
				  word = "";
				  
				  for(int k = 0; k < splittedWord.length; k++) {
					  if (splittedWord[k].equals("a")) {
					        splittedWord[k] = "e";
					  } else if (splittedWord[k].equals("A")) {
					        splittedWord[k] = "E";
					  } else if (splittedWord[k].equals("e")) {
					        splittedWord[k] = "a";
					  } else if (splittedWord[k].equals("E")) {
					        splittedWord[k] = "A";
					  } else if (splittedWord[k].equals("o")) {
					        splittedWord[k] = "i";
					  } else if (splittedWord[k].equals("O")) {
					        splittedWord[k] = "I";
					  } else if (splittedWord[k].equals("i")) {
					        splittedWord[k] = "o";
					  } else if (splittedWord[k].equals("I")) {
					        splittedWord[k] = "O";
					  }
					  word += splittedWord[k];
				  }
				  aliensList.getAlien(i).setName(word);
			  }
			  else if(j == 2) {
				  String word = aliensList.getAlien(i).getHomePlanet();
				  String[] splittedWord = word.split("");
				  word = "";
				  
				  for(int k = 0; k < splittedWord.length; k++) {
					  if (splittedWord[k].equals("a")) {
					        splittedWord[k] = "e";
					  } else if (splittedWord[k].equals("A")) {
					        splittedWord[k] = "E";
					  } else if (splittedWord[k].equals("e")) {
					        splittedWord[k] = "a";
					  } else if (splittedWord[k].equals("E")) {
					        splittedWord[k] = "A";
					  } else if (splittedWord[k].equals("o")) {
					        splittedWord[k] = "i";
					  } else if (splittedWord[k].equals("O")) {
					        splittedWord[k] = "I";
					  } else if (splittedWord[k].equals("i")) {
					        splittedWord[k] = "o";
					  } else if (splittedWord[k].equals("I")) {
					        splittedWord[k] = "O";
					  }
					  word += splittedWord[k];
				  }
				  aliensList.getAlien(i).setHomePlanet(word);
			  }
		  }
	  }
  }

  /**
   * If one of the lists is empty or the user ends the cycle, it shows all the program options
   * to the user on the screen and executes the chosen option inserted, displaying the result on the 
   * screen.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param humansList The humans list built in the main method.
   * @param aliensList The aliens list built in the main method.
   * @throws IOException If input/output values are misinterpreted or fail.
   * 
   */
  public static void menu(Scanner read, HumansList humansList, AliensList aliensList) throws IOException {
    boolean exitMenu = false;

    while (!exitMenu && (aliensList.getCant() != 0 && humansList.getCant() != 0) ) {
      System.out.println("----- ¿Qué desea hacer? -----");
      System.out.println("");
      System.out.println("[1] Ingresar extraterrestre");
      System.out.println("[2] Modificar un extraterrestre");
      System.out.println("[3] Ingresar humano");
      System.out.println("[4] Modificar un humano");
      System.out.println("[5] Mostrar humanos por nacionalidad");
      System.out.println("[6] Eliminar extraterrestre");
      System.out.println("[7] Eliminar humano");
      System.out.println("[8] Buscar extraterrestre por identificación universal");
      System.out.println("[9] Mostrar por planeta");
      System.out.println("[10] Mostrar por nacionalidad + Porcentaje");
      System.out.println("[11] Mostrar una tabla con la cantidad de extraterrestres");
      System.out.println("[12] Cerrar sistema");
      System.out.println("");
      System.out.print("Opción: ");

      int option = Integer.parseInt(read.nextLine());
      try {
        switch (option) {
          case 1:
            addAlien(read, aliensList);
            break;
          case 2:
            modifyAlien(read, aliensList);
            break;
          case 3:
            addHuman(read, humansList);
            break;
          case 4:
            modifyHuman(read, humansList);
            break;
          case 5:
            showHumansByNationality(read, humansList);
            break;
          case 6:
            removeAlien(read, aliensList);
            break;
          case 7:
            removeHuman(read, humansList);
            break;
          case 8:
            findWithUI(read, aliensList);
            break;
          case 9:
            showByPlanet(read, aliensList, humansList);
            break;
          case 10:
            showByNationality(read, humansList);
            break;
          case 11:
            showAliensTable(aliensList);
            break;
          case 12:
            exitMenu = true;
            translateBackToAlien(aliensList);
            fileWriting(aliensList, humansList);
            
            System.out.println("");
            System.out.println("Bye bye!");
            break;
        }
      } catch (NumberFormatException ex) {
        System.out.println("Perro, perrits, perruno.. Te re equivocaste con el numerito.. Vuelve a intentarlo.");   // Easter egg para los ayudantes XD
      }
    }
  }

  /**
   * If the amount of objects is lower than the maximum elements of the list, the user 
   * will have to enter the new data of the new alien.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void addAlien(Scanner read, AliensList aliensList) {
	System.out.println();
	
	if(aliensList.getCant() == aliensList.getMax()) {
		System.out.println("Lista llena. No se pueden agregar más extraterrestres.");
		System.out.println();
	}
	else {
		System.out.print("Nombre Especie: ");
	    String speciesName = read.nextLine();
	    System.out.print("Nombre: ");
	    String name = read.nextLine();
	    System.out.print("Identificación Universal: ");
	    int UI = Integer.parseInt(read.nextLine());
	    System.out.print("Planeta de Origen: ");
	    String homePlanet = read.nextLine();
	    System.out.print("Edad (en años humanos): ");
	    int age = Integer.parseInt(read.nextLine());
	    System.out.print("Altura (en metros): ");
	    double height = Double.valueOf(read.nextLine());
	    System.out.print("Peso (en kilogramos): ");
	    double weight = Double.valueOf(read.nextLine());
	    System.out.print("Tipo: ");
	    String type = read.nextLine();

	    Alien a = new Alien(speciesName, name, UI, homePlanet, age, height, weight, type);
	    aliensList.add(a);
	}
	System.out.println();
  }

  /**
   * This method analyzes if there are any aliens in the list, if there are, it displays all the 
   * aliens in the list, then it display the alien that is at the entered position and displays all 
   * the data of the alien object and changes the parameter that the user enters.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void modifyAlien(Scanner read, AliensList aliensList) {
	System.out.println();
	
	if(aliensList.getCant() == 0) {
		System.out.println("No es posible modificar extraterrestres, ya que no hay ninguno ingresado.");
		System.out.println();
	}
	else {
		System.out.println("Lista de Extraterrestres:");
	    for(int i = 0; i < aliensList.getCant(); i++) {
	    	System.out.println();
			System.out.println("[" + i + "] " + aliensList.getAlien(i).toString());
		}
	    System.out.println();
	    System.out.print("Ingrese el número del extraterrestre que desea modificar: ");
	    int modOption = Integer.parseInt(read.nextLine());
	    
	    if(modOption < 0 || modOption > aliensList.getCant()) {
	    	System.out.println("Extraterrestre no existente.");
	    }
	    else {
	    	Alien alienToMod = aliensList.getAlien(modOption);
	    	
	    	System.out.println("Usted ha escogido a:");
	    	System.out.println(alienToMod.toString());
	    	System.out.println();
	    	System.out.println("¿Qué dato desea modificar?");
	    	System.out.println("[1] Nombre de la Especie");
	        System.out.println("[2] Nombre del Extraterrestre");
	        System.out.println("[3] Identificación Universal");
	        System.out.println("[4] Planeta de Origen");
	        System.out.println("[5] Edad");
	        System.out.println("[6] Altura");
	        System.out.println("[7] Peso");
	        System.out.println("[8] Tipo");
	        System.out.println();
	        System.out.print("Opción: ");
	        
	        int option = Integer.parseInt(read.nextLine());
	        try {
	          switch (option) {
	            case 1:
	                System.out.print("Ingrese el nuevo nombre de la especie: ");
	                String newSpeciesName = read.nextLine();
	                alienToMod.setSpeciesName(newSpeciesName);
	                break;
	            case 2:
	                System.out.print("Ingrese el nuevo nombre del extraterrestre: ");
	                String newName = read.nextLine();
	                alienToMod.setName(newName);
	                break;
	            case 3:
	                System.out.print("Ingrese la nueva identificación universal: ");
	                int newUI = Integer.parseInt(read.nextLine());
	                alienToMod.setUI(newUI);
	                break;
	            case 4:
	                System.out.print("Ingrese el nuevo planeta de origen: ");
	                String newHomePlanet = read.nextLine();
	                alienToMod.setHomePlanet(newHomePlanet);
	                break;
	            case 5:
	                System.out.print("Ingrese la nueva edad (en años humanos): ");
	                int newAge = Integer.parseInt(read.nextLine());
	                alienToMod.setAge(newAge);
	                break;
	            case 6:
	                System.out.print("Ingrese la nueva altura (en metros): ");
	                double newHeight = Double.valueOf(read.nextLine());
	                alienToMod.setHeight(newHeight);
	                break;
	            case 7:
	                System.out.print("Ingrese el nuevo peso (en kilogramos): ");
	                double newWeight = Double.valueOf(read.nextLine());
	                alienToMod.setWeight(newWeight);
	                break;
	            case 8:
	                System.out.print("Ingrese el nuevo tipo: ");
	                String newType = read.nextLine();
	                alienToMod.setType(newType);
	                break;
	          }
	        } catch (NumberFormatException ex) {
	            System.out.println("Opcion invalida.");
	        }
	    }
	}
    System.out.println();
  }

  /**
   * If the amount of objects is lower than the maximum elements of the list, the user 
   * will have to enter the new data of the new human.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param humansList The humans list built in the main method.
   *
   */
  public static void addHuman(Scanner read, HumansList humansList) {
	System.out.println();
	
	if(humansList.getCant() == humansList.getMax()) {
		System.out.println("Lista llena. No se pueden agregar más humanos.");
		System.out.println();
	}
	else {
		System.out.print("Nacionalidad: ");
	    String nationality = read.nextLine();
	    System.out.print("Nombre: ");
	    String name = read.nextLine();
	    System.out.print("ID: ");
	    int ID = Integer.parseInt(read.nextLine());
	    System.out.print("Region: ");
	    String region = read.nextLine();
	    System.out.print("Ciudad: ");
	    String city = read.nextLine();
	    System.out.print("Edad humana: ");
	    int age = Integer.parseInt(read.nextLine());
	    System.out.print("Altura (en metros): ");
	    double height = Double.valueOf(read.nextLine());
	    System.out.print("Peso (en kilogramos): ");
	    double weight = Double.valueOf(read.nextLine());
	    System.out.print("Planetas de trabajo (Separados con / para más de 1): ");
	    String workPlanets = read.nextLine();

	    Human a = new Human(nationality, name, ID, region, city, age, height, weight, workPlanets);
	    humansList.add(a);
	}
	System.out.println();
  }

  /**
   * This method analyzes if there are any humans in the list, if there are, it displays all the 
   * humans in the list, then it display the humans that is at the entered position and displays all 
   * the data of the human object and changes the parameter that the user enters.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param humansList The humans list built in the main method.
   *
   */
  public static void modifyHuman(Scanner read, HumansList humansList) {
	  System.out.println();
	  
	  if(humansList.getCant() == 0) {
		  System.out.println("No es posible modificar humanos, ya que no hay ninguno ingresado.");
		  System.out.println();
	  }
	  else {
		  System.out.println("Lista de Humanos:");
		  for(int i = 0; i < humansList.getCant(); i++) {
			  System.out.println();
			  System.out.println("[" + i + "] " + humansList.getHuman(i).toString());
		  }
		  System.out.println();
		  System.out.print("Ingrese el número del humano que desea modificar: ");
		  int modOption = Integer.parseInt(read.nextLine());
		    
		  if(modOption < 0 || modOption > humansList.getCant()) {
			  System.out.println("Extraterrestre no existente.");
		  }
		  else {
			  Human humanToMod = humansList.getHuman(modOption);
		    	
		    	System.out.println("Usted ha escogido a:");
		    	System.out.println(humanToMod.toString());
		    	System.out.println();
		    	System.out.println("¿Qué dato desea modificar?");
		    	System.out.println("[1] Nacionalidad");
		        System.out.println("[2] Nombre");
		        System.out.println("[3] Identificación");
		        System.out.println("[4] Región");
		        System.out.println("[5] Ciudad");
		        System.out.println("[6] Edad");
		        System.out.println("[7] Altura");
		        System.out.println("[8] Peso");
		        System.out.println("[9] Planetas de Trabajo");
		        System.out.println();
		        System.out.print("Opción: ");
		        
		        int option = Integer.parseInt(read.nextLine());
		        try {
		          switch (option) {
		            case 1:
		                System.out.print("Ingrese la nueva nacionalidad: ");
		                String newNationality = read.nextLine();
		                humanToMod.setNationality(newNationality);
		                break;
		            case 2:
		                System.out.print("Ingrese el nuevo nombre del humano: ");
		                String newName = read.nextLine();
		                humanToMod.setName(newName);
		                break;
		            case 3:
		                System.out.print("Ingrese la nueva identificación: ");
		                int newID = Integer.parseInt(read.nextLine());
		                humanToMod.setID(newID);
		                break;
		            case 4:
		            	System.out.print("Ingrese la nueva región: ");
		                String newRegion = read.nextLine();
		                humanToMod.setRegion(newRegion);
		                break;
		            case 5:
		            	System.out.print("Ingrese la nueva ciudad: ");
		                String newCity = read.nextLine();
		                humanToMod.setCity(newCity);
		                break;
		            case 6:
		            	System.out.print("Ingrese la nueva edad: ");
		                int newAge = Integer.parseInt(read.nextLine());
		                humanToMod.setAge(newAge);
		                break;
		            case 7:
		                System.out.print("Ingrese la nueva altura (en metros): ");
		                double newHeight = Double.valueOf(read.nextLine());
		                humanToMod.setHeight(newHeight);
		                break;
		            case 8:
		                System.out.print("Ingrese el nuevo peso (en kilogramos): ");
		                double newWeight = Double.valueOf(read.nextLine());
		                humanToMod.setWeight(newWeight);
		                break;
		            case 9:
		            	System.out.print("Ingrese el/los nuevo(s) planeta(s) de trabajo (separados con /): ");
		                String newWorkPlanets = read.nextLine();
		                humanToMod.setWorkPlanets(newWorkPlanets);
		            	break;
		          }
		        } catch (NumberFormatException ex) {
		            System.out.println("Opcion invalida.");
		        }
		  }
	  }
	  System.out.println();
  }

  /**
   * If the humans list has one or more human objects, the user will be able to enter a nationality.
   * All humans that have that nationality will be displayed on the screen.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param humansList The humans list built in the main method.
   *
   */
  public static void showHumansByNationality(Scanner read, HumansList humansList) {
	  System.out.println();
	  
	  if(humansList.getCant() == 0) {
		  System.out.println("No hay humanos ingresados.");
		  System.out.println();
	  }
	  else {
		  System.out.print("Ingrese la nacionalidad: ");
		  String nationality = read.nextLine();
		  
		  for(int i = 0; i < humansList.getCant(); i++) {
			  if(humansList.getHuman(i).getNationality().equals(nationality)) {
				  System.out.println();
				  System.out.println("[" + i + "] " + humansList.getHuman(i).toString());
			  }
		  }
		  System.out.println();
	  }
  }

  /**
   * If the aliens list has one or more alien objects, all the aliens inside the list are displayed.
   * The user will be able to input an universal identification, if it's the same as one of the aliens
   * displayed, the alien is removed from the list.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void removeAlien(Scanner read, AliensList aliensList) {
	  System.out.println();
	  
	  if(aliensList.getCant() == 0) {
		  System.out.println("No es posible eliminar extraterrestres, ya que no hay ninguno ingresado.");
		  System.out.println();
	  }
	  else {
		  System.out.println("Lista de Extraterrestres:");
		  for(int i= 0; i < aliensList.getCant(); i++) {
			  System.out.println();
			  System.out.println("[" + i + "] " + aliensList.getAlien(i).toString());
		  }
		  System.out.println();
		  System.out.print("Ingrese la identificación universal del extraterrestre que desea eliminar: ");
		  int removeUI = Integer.parseInt(read.nextLine());
		  aliensList.delete(aliensList.getAlienUI(removeUI));
		  System.out.println();
	  }
  }

  /**
   * If the humans list has one or more human objects, all the humans inside the list are displayed.
   * The user will be able to input an identification, if it's the same as one of the humans
   * displayed, the human is removed from the list.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void removeHuman(Scanner read, HumansList humansList) {
	  System.out.println();
	  
	  if(humansList.getCant() == 0) {
		  System.out.println("No es posible eliminar humanos, ya que no hay ninguno ingresado.");
		  System.out.println();
	  }
	  else {
		  System.out.println("Lista de Humanos:");
		  for(int i= 0; i < humansList.getCant(); i++) {
			  System.out.println();
			  System.out.println("[" + i + "] " + humansList.getHuman(i).toString());
		  }
		  System.out.println();
		  System.out.print("Ingrese la identificación del humano que desea eliminar: ");
		  int removeUI = Integer.parseInt(read.nextLine());
		  humansList.delete(humansList.getHumanID(removeUI));
		  System.out.println();
	  }
  }

  /**
   * If the aliens list has one or more alien objects, the user will be able to input a
   * identification, if this UI match with one of the aliens UI, the alien will be displayed.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void findWithUI(Scanner read, AliensList aliensList) {
	  System.out.println();
	  
	  if(aliensList.getCant() == 0) {
		  System.out.println("No hay extraterrestres ingresados.");
		  System.out.println();
	  }
	  else {
		  System.out.print("Ingrese la identificación universal del extraterrestre que desea ver: ");
		  int findUI = Integer.parseInt(read.nextLine());
		  Alien a = aliensList.getAlienUI(findUI);
		  
		  if(a == null) {
			  System.out.println();
			  System.out.println("La identificación universal no coincide con ninguno de los extraterrestres ingresados.");
			  System.out.println();
		  }
		  else {
			  System.out.println();
			  System.out.println(a.toString());
			  System.out.println();
		  }
	  }
  }

  /**
   * If the aliens list has one or more alien objects, the user will be able to enter a planet.
   * All the aliens that live on that planet will be displayed on the screen.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param aliensList The aliens list built in the main method.
   * @param humansList The humans list built in the main method.
   *
   */
  public static void showByPlanet(Scanner read, AliensList aliensList, HumansList humansList) {
	  System.out.println();
	  
	  if(aliensList.getCant() == 0) {
		  System.out.println("No hay extraterrestres registrados.");
		  System.out.println();
	  }
	  else {
		  System.out.print("Ingrese el planeta: ");
		  String planet = read.nextLine();
		  double cantAliensInPlanet = 0;
		  
		  for(int i = 0; i < aliensList.getCant(); i++) {
			  if(aliensList.getAlien(i).getHomePlanet().equals(planet)) {
				  System.out.println();
				  System.out.println("[" + i + "] " + aliensList.getAlien(i).toString());
				  cantAliensInPlanet++;
			  }
		  }
		  System.out.println();
		  double percAliens = (cantAliensInPlanet/aliensList.getCant()) * 100;
		  System.out.println("El porcentaje de aliens que viven en ese planeta es de " + percAliens + "%" + "\n"
				  			 + "con respecto al total de aliens.");
		  System.out.println();
		  
		  int cantWorkers = cantWorkersInPlanet(planet, humansList);
		  System.out.println("En el planeta escogido trabajan " + cantWorkers + " humanos.");
		  System.out.println();
	  }
  }

  /**
   * A planet is inserted.
   * This method splits and insert the work planets of a human into a String list. If the work planet
   * is the same as the planet inserted, the counter of workers in that planet increases by one.
   * This last value is returned when the cycles end.
   * 
   * @param planet Name of a planet.
   * @param humansList The humans list built in the main method.
   * @return cantWorkers The amount of workers in the planet inserted.
   *
   */
  public static int cantWorkersInPlanet(String planet, HumansList humansList) {
	  int cantWorkers = 0;
	  
	  for(int i = 0; i < humansList.getCant(); i++) {
		  String[] workPlanets = humansList.getHuman(i).getWorkPlanets().split("/");
		  
		  for(int j = 0; j < workPlanets.length; j++) {
			  System.out.println(workPlanets[j]);
			  if(workPlanets[j].equals(planet)) {
				  cantWorkers++;
			  }
		  }
	  }
	  return cantWorkers;
  }

  /**
   * If the humans list has one or more human objects, the user will be able to enter a nationality.
   * All humans that have that nationality will be displayed on the screen.
   * It also shows the percentage of humans that belongs to that nationality.
   * 
   * @param read The scanner built in the main method. Saves the values entered by the user.
   * @param humansList The humans list built in the main method.
   *
   */
  public static void showByNationality(Scanner read, HumansList humansList) {
	  System.out.println();
	  
	  if(humansList.getCant() == 0) {
		  System.out.println("No es posible buscar humanos, ya que no hay ninguno ingresado.");
		  System.out.println();
	  }
	  else {
		  System.out.print("Ingrese la nacionalidad de los humanos que desea ver: ");
		  String nationality = read.nextLine();
		  double cantHumans = 0;
		  
		  for(int i = 0; i < humansList.getCant(); i++) {
			  if(humansList.getHuman(i).getNationality().equals(nationality)) {
				  System.out.println();
				  System.out.println("[" + i + "] " + humansList.getHuman(i).toString());
				  cantHumans++;
			  }
		  }
		  System.out.println();
		  double percHumans = (cantHumans/humansList.getCant()) * 100;
		  System.out.println("El promedio de humanos de nacionalidad " + nationality + " es de " + percHumans + "%" + "\n"
				  			  + "con respecto al total de humanos.");
		  System.out.println();
	  }
  }

  /**
   * If the aliens list has one or more alien objects, it displays a table with all aliens
   * organized by type, showing the amount and percentages.
   * 
   * @param aliensList The aliens list built in the main method.
   *
   */
  public static void showAliensTable(AliensList aliensList) {
	  System.out.println();
	  
	  if(aliensList.getCant() == 0) {
		  System.out.println("No pueden mostrarse extraterrestres, ya que no hay ninguno ingresado.");
		  System.out.println();
	  }
	  else {
		  double cantAliensI = aliensPerType("I", aliensList);
		  double cantAliensV = aliensPerType("V", aliensList);
		  double cantAliensF = aliensPerType("F", aliensList);
		  
		  double percI = (cantAliensI/aliensList.getCant()) * 100;
		  double percV = (cantAliensV/aliensList.getCant()) * 100;
		  double percF = (cantAliensF/aliensList.getCant()) * 100;
		  
		  System.out.println(1/2);
		  
		  System.out.println("                   |    I    |    V    |    F    |");
		  System.out.println("--------------------------------------------------");
		  System.out.println("  Cant. por tipo   |   " + cantAliensI + "   |   " + cantAliensV + "   |   " + cantAliensF + "   |");
		  System.out.println("--------------------------------------------------");
		  System.out.println("    Porcentaje     |  " + percI + "%  |  " + percV + "%  |  " + percF + "%  |");
		  System.out.println("--------------------------------------------------");
		  System.out.println();
	  }
  }

  /**
   * A word is inserted
   * Counts all aliens with that word as type and returns the value.
   * 
   * @param structure Type of alien.
   * @param aliensList The aliens list built in the main method.
   * @return cantAliens The amount of aliens with the same type as the one inserted.
   *
   */
  public static int aliensPerType(String structure, AliensList aliensList) {
	  int cantAliens = 0;
	  
	  for(int i = 0; i < aliensList.getCant(); i++) {
		  if(aliensList.getAlien(i).getType().toUpperCase().equals(structure)) {
			  cantAliens++;
		  }
	  }
	  return cantAliens;
  }

  /**
   * This method overwrites the two existing lists, encode them in their respective formats,
   * transforming only the aliens age back to their system, and changing meters to centimeters and 
   * grams to kilograms. It writes the two text files with the new information on a new line.
   * 
   * @param aliensList The aliens list built in the main method.
   * @param humansList The humans list built in the main method.
   * @throws IOException If input/output values are misinterpreted or fail.
   *
   */
  public static void fileWriting(AliensList aliensList, HumansList humansList) throws IOException {
    FileWriter save0 = new FileWriter(new File("x.txt"));
    for (int i = 0; i < aliensList.getCant(); i++) {
      save0.write(aliensList.getAlien(i).getSpeciesName() + ", " + aliensList.getAlien(i).getName() + ", "
          + aliensList.getAlien(i).getUI() + ", " + aliensList.getAlien(i).getHomePlanet() + ", "
          + aliensList.getAlien(i).getAge()/8 + ", " + aliensList.getAlien(i).getHeight()*100 + ", "
          + aliensList.getAlien(i).getWeight()*1000 + ", " + aliensList.getAlien(i).getType());
      save0.write("\r\n");
    }
    save0.close();

    FileWriter save1 = new FileWriter(new File("h.txt"));
    for (int i = 0; i < humansList.getCant(); i++) {
      save1.write(humansList.getHuman(i).getNationality() + "," + humansList.getHuman(i).getName() + ","
          + humansList.getHuman(i).getID() + "," + humansList.getHuman(i).getRegion() + ","
          + humansList.getHuman(i).getCity() + "," + humansList.getHuman(i).getAge() + ","
          + humansList.getHuman(i).getHeight()*100 + "," + humansList.getHuman(i).getWeight()*1000 + ","
          + humansList.getHuman(i).getWorkPlanets());
      save1.write("\r\n");
    }
    save1.close();
  }
}
