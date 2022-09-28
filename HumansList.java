package codes;

public class HumansList {
	
	private Human[] humans;
	private int cant;
	private int max;
	
	public HumansList(int max) {
		this.max = max;
		humans = new Human[max];
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
	
	public void getHuman() {
		
	}
	
	public boolean index() {
		return true;
	}
	
	public boolean search() {
		return true;
	}
	
	public boolean delete() {
		return true;
	}

}
