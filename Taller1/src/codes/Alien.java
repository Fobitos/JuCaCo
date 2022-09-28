package codes;

public class Alien {
	
	private String speciesName;
	private String name;
	private int universalIdentification;
	private String homePlanet;
	private int age;
	private int height;
	private int weight;
	private char type;
	
	public Alien(String speciesName, String name, int universalIdentification, String homePlanet, int age, int height,
			int weight, char type) {
		this.speciesName = speciesName;
		this.name = name;
		this.universalIdentification = universalIdentification;
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

	public int getUniversalIdentification() {
		return universalIdentification;
	}

	public void setUniversalIdentification(int universalIdentification) {
		this.universalIdentification = universalIdentification;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Alien [speciesName=" + speciesName + ", name=" + name + ", universalIdentification="
				+ universalIdentification + ", homePlanet=" + homePlanet + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", type=" + type + "]";
	}
	
}
