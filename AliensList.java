package codes;

public class AliensList {
	
	private Alien[] aliens;
	private int cant;
	private int max;
	
	public AliensList(int max) {
		this.max = max;
		aliens = new Alien[max];
		cant = 0;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
