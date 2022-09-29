import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		fileReading();

	}
	
	public static void fileReading() throws FileNotFoundException {
		Scanner arch0 = new Scanner(new File("x.txt"));
		while(arch0.hasNextLine()) {
			String line = arch0.nextLine();
			String[] parts = line.split(", ");
			
			String speciesName = parts[0];
			String[] splittedSpeciesName = speciesName.split("");
			speciesName = translateAlienWord(splittedSpeciesName);
			
			String name = parts[1];
			String[] splittedName = name.split("");
			name = translateAlienWord(splittedName);
			
			int UI = Integer.parseInt(parts[2]);
			String homePlanet = parts[3];
			int age = Integer.parseInt(parts[4]);
			int height = Integer.parseInt(parts[5]);
			int weight = Integer.parseInt(parts[6]);
			String type = parts[7];
		}
	}
	
	public static String translateAlienWord(String[] splittedWord) {
		String translatedWord = "";
		
		for(int i = 0; i < splittedWord.length; i++) {
			if(splittedWord[i].equals("a")) {
				splittedWord[i] = "e";
			}
			else if(splittedWord[i].equals("A")) {
				splittedWord[i] = "E";
			}
			else if(splittedWord[i].equals("e")) {
				splittedWord[i] = "a";
			}
			else if(splittedWord[i].equals("E")) {
				splittedWord[i] = "A";
			}
			else if(splittedWord[i].equals("o")) {
				splittedWord[i] = "i";
			}
			else if(splittedWord[i].equals("O")) {
				splittedWord[i] = "I";
			}
			else if(splittedWord[i].equals("i")) {
				splittedWord[i] = "o";
			}
			else if(splittedWord[i].equals("I")) {
				splittedWord[i] = "O";
			}
			translatedWord += splittedWord[i];
		}
		return translatedWord;
	}
	
	public static int convertAlienAge(int number) {
		return number;
	}
	
	public static void menu() {
		
	}
	
	public static boolean addAlien() {
		return true;
	}

	public static void modifyAlien() {
		
	}
	
	public static boolean addHuman() {
		return true;
	}
	
	public static void modifyHuman() {
		
	}
	
	public static void showHumansByNationality() {
		
	}
	
	public static boolean removeAlien() {
		return true;
	}
	
	public static boolean removeHuman() {
		return true;
	}
	
	public static void findWithUI() {
		
	}
	
	public static void showByPlanet() {
		
	}
	
	public static void showByNationality() {
		
	}
	
	public static void showAliensTable() {
		
	}
	
	public static void fileWriting() {
		
	}
}
