/**
 * Represents a foreigner with different characteristics that distinguish him.
 *
 * @author      Juan Castro Cortés. <juan.castro@alumnos.ucn.cl>
 * @author      Carlos Leal Serrano. <carlos.leal@alumnos.ucn.cl>
 */
public class Alien {
	
	private String speciesName;
	private String name;
	private int UI;
	private String homePlanet;
	private int age;
	private double height;
	private double weight;
	private String type;

  /**
   * Build an object alien using all the parameters indicated
   * in the Alien class.
   * 
   * @param speciesName The species name of the new alien.
   * @param name The name of the new alien.
   * @param UI The universal identification of the new alien.
   * @param homePlanet The home planet of the new alien.
   * @param age The age of the new alien.
   * @param height The height of the new alien.
   * @param weight The weight of the new alien.
   * @param type The type of the new alien.
   * 
   */
	public Alien(String speciesName, String name, int UI, String homePlanet, int age, double height,
			double weight, String type) {
		this.speciesName = speciesName;
		this.name = name;
		this.UI = UI;
		this.homePlanet = homePlanet;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.type = type;
	}
  
  /**
   * Returns the species name of an alien each time it is called.
   *
   * @return speciesName The species name of the alien that is returned.
   *
   */
	public String getSpeciesName() {
		return speciesName;
	}
  
  /**
   * A species name is inserted.
   * The inserted word replaces the species name of the alien.
   *
   * @param speciesName New species name.
   *
   */
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
  
  /**
   * Returns the name of an alien each time it is called.
   *
   * @return name The name of the alien that is returned.
   *
   */
	public String getName() {
		return name;
	}
  
  /**
   * A name is inserted.
   * The inserted word replaces the name of the alien.
   *
   * @param name New alien name.
   *
   */
	public void setName(String name) {
		this.name = name;
	}
  
  /**
   * Returns the universal identification of an alien each time it is called.
   *
   * @return UI The universal identification of the alien that is returned.
   *
   */
	public int getUI() {
		return UI;
	}
  
  /**
   * An universal identification is inserted.
   * The inserted value replaces the UI of an alien.
   *
   * @param UI New universal identification of the alien.
   *
   */
	public void setUI(int UI) {
		this.UI = UI;
	}
  
  /**
   * Returns the home planet an alien each time it is called.
   *
   * @return homePlanet The home planet of the alien that is returned.
   *
   */
	public String getHomePlanet() {
		return homePlanet;
	}
  
  /**
   * A home planet is inserted.
   * The inserted word replaces the home planet of an alien.
   *
   * @param homePlanet New home planet of the alien.
   *
   */
	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}
  
  /**
   * Returns the age of an alien each time it is called.
   *
   * @return age The age of the alien that is returned.
   *
   */
	public int getAge() {
		return age;
	}
  
  /**
   * An age is inserted.
   * The inserted value replaces the age of an alien.
   *
   * @param age New age of the alien.
   *
   */
	public void setAge(int age) {
		this.age = age;
	}
  
  /**
   * Returns the height of an alien each time it is called.
   *
   * @return height The height of the alien that is returned.
   *
   */
	public double getHeight() {
		return height;
	}
  
  /**
   * A height is inserted.
   * The inserted value replaces the height of an alien.
   *
   * @param height New height of the alien.
   *
   */
	public void setHeight(double height) {
		this.height = height;
	}
  
  /**
   * Returns the weight of an alien each time it is called.
   *
   * @return weight The weight of the alien that is returned.
   *
   */
	public double getWeight() {
		return weight;
	}
  
  /**
   * A weight is inserted.
   * The inserted value replaces the weight of an alien.
   *
   * @param weight New weight of the alien.
   *
   */
	public void setWeight(double weight) {
		this.weight = weight;
	}
  
  /**
   * Returns the type of an alien each time it is called.
   *
   * @return type The type of the alien that is returned.
   *
   */
	public String getType() {
		return type;
	}
  
  /**
   * A type of alien is inserted.
   * The inserted character replaces the type of an alien.
   *
   * @param type New type of the alien.
   *
   */
	public void setType(String type) {
		this.type = type;
	}
  
  /**
   * Returns a string representation of the object alien.
   *
   * @return a string representation of the object.    
   *
   */
	@Override
	public String toString() {
		return name + " | Identificacion Universal: " + UI + " | Tipo: " + type + "\n"
				+ "[Especie: " + speciesName + " | Planeta de Origen: " + homePlanet + " | Edad (convertida a humanos): " + age + " | Altura (en m): " + height
				+ " | Peso (en kg): " + weight + "]";
	}
	
}
