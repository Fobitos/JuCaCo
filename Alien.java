public class Alien {
	
	private String speciesName;
	private String name;
	private int UI;
	private String homePlanet;
	private int age;
	private double height;
	private double weight;
	private String type;
	
	public Alien(String speciesName, String name, int universalIdentification, String homePlanet, int age, double height,
			double weight, String type) {
		this.speciesName = speciesName;
		this.name = name;
		this.UI = universalIdentification;
		this.homePlanet = homePlanet;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.type = type;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUI() {
		return UI;
	}

	public void setUI(int UI) {
		this.UI = UI;
	}

	public String getHomePlanet() {
		return homePlanet;
	}

	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name + " | Identificacion Universal: " + UI + " | Tipo: " + type + "\n"
				+ "[Especie: " + speciesName + " | Planeta de Origen: " + homePlanet + " | Edad (convertida a humanos): " + age + " | Altura (en m): " + height
				+ " | Peso (en kg): " + weight + "]";
	}
	
}
