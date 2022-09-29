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
	
	public Human(String nationality, String name, int identification, String region, String city, int age, double height,
			double weight, String workPlanets) {
		this.nationality = nationality;
		this.name = name;
		this.ID = identification;
		this.region = region;
		this.city = city;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.workPlanets = workPlanets;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdentification() {
		return ID;
	}

	public void setIdentification(int identification) {
		this.ID = identification;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getWorkPlanets() {
		return workPlanets;
	}

	public void setWorkPlanets(String workPlanets) {
		this.workPlanets = workPlanets;
	}

	@Override
	public String toString() {
		return "Humano [nationality=" + nationality + ", name=" + name + ", identification=" + ID
				+ ", region=" + region + ", city=" + city + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", workPlanets=" + workPlanets + "]";
	}

}
