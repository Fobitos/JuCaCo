public class AliensList {
	
	private Alien[] aliens;
	private int cant;
	private int max;
	
	public AliensList(int max) {
		aliens = new Alien[max];
		cant = 0;
		this.max = max;
	}
	
	public boolean add(Alien a) {
		if(cant < max) {
			aliens[cant] = a;
			cant++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int index(Alien a) {
		int i;
		for(i = 0; i < cant; i++) {
			if(aliens[i] == a) {
				break;
			}
		}
		if(i == cant) {
			return -1;
		}
		else { 
			return i;
		}
	}
	
	public boolean delete(Alien a) {
		int i;
		for(i = 0; i < cant; i++) {
			if(aliens[i] == a) {
				break;
			}
		}
		if(i == cant) {
			return false;
		}
		else {
			for(int j = i; j < cant; j++) {
				aliens[j] = aliens[j + 1];
			}
			cant--;
			return true;
		}
	}
	
	public Alien getAlien(int i) {
		if(i < cant) {
			return aliens[i];
		}
		else { 
			return null;
		}
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
