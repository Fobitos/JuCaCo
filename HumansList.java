public class HumansList {
	
	private Human[] humans;
	private int cant;
	private int max;
	
	public HumansList(int max) {
		this.max = max;
		humans = new Human[max];
		cant = 0;
	}
	
	public boolean add(Human h) {
		if(cant < max) {
			humans[cant] = h;
			cant++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int index(Human h) {
		int i;
		for(i = 0; i < cant; i++) {
			if(humans[i] == h) {
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
	
	public boolean delete(Human h) {
		int i;
		for(i = 0; i < cant; i++) {
			if(humans[i] == h) {
				break;
			}
		}
		if(i == cant) {
			return false;
		}
		else {
			for(int j = i; j < cant; j++) {
				humans[j] = humans[j + 1];
			}
			cant--;
			return true;
		}
	}
	
	public Human getHuman(int i) {
		if(i < cant) {
			return humans[i];
		}
		else {
			return null;
		}
	}
	
	public Human getHumanID(int ID) {
		for(int i = 0; i < cant; i++) {
			if(humans[i].getID() == ID) {
				return humans[i];
			}
		}
		return null;
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
