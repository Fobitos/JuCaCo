/**
 * Represents a foreigner with different characteristics that distinguish him.
 *
 * @author      Juan Castro Cortés. <juan.castro@alumnos.ucn.cl>
 * @author      Carlos Leal Serrano. <carlos.leal@alumnos.ucn.cl>
 */
public class Human {
	
	private String nationality;
	private String name;
	private int ID;
	private String region;
	private String city;
	private int age;
	private double height;
	private double weight;
	private String workPlanets;

  /**
   * Build an object human using all the parameters indicated
   * in the Human class.
   * 
   * @param nationality The nationality of the new human.
   * @param name The name of the new human.
   * @param ID The identification of the new human.
   * @param region The region of the new human.
   * @param city The city of the new human.
   * @param age The age of the new human.
   * @param height The height of the new human.
   * @param weight The weight of the new human.
   * @param workPlanets The work planets of the new human.
   * 
   */
	public Human(String nationality, String name, int ID, String region, String city, int age, double height,
			double weight, String workPlanets) {
		this.nationality = nationality;
		this.name = name;
		this.ID = ID;
		this.region = region;
		this.city = city;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.workPlanets = workPlanets;
	}
  
  /**
   * Returns the nationality of a human each time it is called.
   *
   * @return nationality The nationality of the human that is returned.
   *
   */
	public String getNationality() {
		return nationality;
	}
  
  /**
   * A nationality is inserted.
   * The inserted word replaces the nationality of a human.
   *
   * @param nationality New human nationality.
   *
   */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

  /**
   * Returns the name of a human each time it is called.
   *
   * @return name The name of the human that is returned.
   *
   */
	public String getName() {
		return name;
	}
  
  /**
   * A name is inserted.
   * The inserted word replaces the name of a human.
   *
   * @param name New human name.
   *
   */
	public void setName(String name) {
		this.name = name;
	}

  /**
   * Returns the identidicaction of a human each time it is called.
   *
   * @return ID The identification of the human that is returned.
   *
   */
	public int getID() {
		return ID;
	}

  /**
   * An identification is inserted.
   * The inserted value replaces the ID of a human.
   *
   * @param ID New identification of the human.
   *
   */
	public void setID(int ID) {
		this.ID = ID;
	}

  /**
   * Returns the region of a human each time it is called.
   *
   * @return region The region of the human that is returned.
   *
   */
	public String getRegion() {
		return region;
	}
  
  /**
   * A region is inserted.
   * The inserted word replaces the region of a human.
   *
   * @param region New region of the human.
   *
   */
	public void setRegion(String region) {
		this.region = region;
	}

  /**
   * Returns the city of a human each time it is called.
   *
   * @return region The region of the human that is returned.
   *
   */
	public String getCity() {
		return city;
	}

  /**
   * A city is inserted.
   * The inserted word replaces the city of a human.
   *
   * @param city New city of the human.
   *
   */
	public void setCity(String city) {
		this.city = city;
	}
  
  /**
   * Returns the age of a human each time it is called.
   *
   * @return age The age of the human that is returned.
   *
   */
	public int getAge() {
		return age;
	}

  /**
   * An age is inserted.
   * The inserted value replaces the age of a human.
   *
   * @param age New age of the human.
   *
   */
	public void setAge(int age) {
		this.age = age;
	}

  /**
   * Returns the height of a human each time it is called.
   *
   * @return height The height of the human that is returned.
   *
   */
	public double getHeight() {
		return height;
	}

  /**
   * A height is inserted.
   * The inserted value replaces the height of a human.
   *
   * @param height New height of the human.
   *
   */
	public void setHeight(double height) {
		this.height = height;
	}

  /**
   * Returns the weight of a human each time it is called.
   *
   * @return weight The weight of the human that is returned.
   *
   */
	public double getWeight() {
		return weight;
	}

  /**
   * A weight is inserted.
   * The inserted value replaces the weight of a human.
   *
   * @param weight New weight of the human.
   *
   */
	public void setWeight(double weight) {
		this.weight = weight;
	}

  /**
   * Returns the work planet(s) of a human each time it is called.
   *
   * @return workPlanets The work planets of the human that is returned.
   *
   */
	public String getWorkPlanets() {
		return workPlanets;
	}

  /**
   * A work planet (or planets, it can be more than 1) 
   * of a human is inserted.
   * The inserted word replaces the work planet(s) of a human.
   *
   * @param workPlanets New work planet(s) of the human.
   *
   */  
	public void setWorkPlanets(String workPlanets) {
		this.workPlanets = workPlanets;
	}

  /**
   * Returns a string representation of the object human.
   *
   * @return a string representation of the object.    
   *
   */
	@Override
	public String toString() {
		return name + " | Identificación: " + ID + " | Nacionalidad: " + nationality + "\n"
				+ "[Region: " + region + " | Ciudad: " + city + " | Edad: " + age + " | Altura (en m): " + height
				+ " | Peso (en kg): " + weight + " | Planetas de trabajo: " + workPlanets + "]";
	}
}
