/**
 * List where the aliens that were created will be inserted.
 *
 * @author      Juan Castro Cortés. <juan.castro@alumnos.ucn.cl>
 * @author      Carlos Leal Serrano. <carlos.leal@alumnos.ucn.cl>
 */
public class AliensList {
	
	private Alien[] aliens;
	private int cant;
	private int max;

  /**
   * A new aliens list is built using the parameter inserted, which
   * represents the max amount of objects of the list.
   * This list starts out empty until objects are added to it.
   * 
   * @param max The max amount of objects of the list.
   *
   */
	public AliensList(int max) {
		aliens = new Alien[max];
		cant = 0;
		this.max = max;
	}

  /**
   * An alien is inserted
   * If the alien list doesn't exceeds the maximum elements of the list,
   * this alien is inserted in the list.
   * 
   * @param a The alien object to add to the list.
   *
   */
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

  /**
   * If the alien object is found, the position of that object
   * in the list is returned. If it's not found it returns a -1.
   * 
   * @param a The alien object to be found.
   * @return -1 The object was not found.
   * @return i The object was found and returns the position.
   *
   */
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

  /**
   * If the inserted alien object is found, it is deleted and the number
   * of elements decreases by one.
   * 
   * @param a The alien object to be deleted.
   * @return true The object was deleted.
   * @return false The object was not deleted.
   *
   */
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

  /**
   * A value (representing a position in the list) is inserted.
   * Returns the alien belongs that position inserted in the list.
   * If the number exceeds the maximum of the list, this method
   * returns a null object.
   *
   * @return aliens[i] The alien object that is returned if
   * the ID belongs to an alien
   * @return null Null object.
   *
   */
	public Alien getAlien(int i) {
		if(i < cant) {
			return aliens[i];
		}
		else { 
			return null;
		}
	}

  /**
   * An universal identification is inserted.
   * Returns the alien belongs that UI inserted.
   * If the UI doesn't belong to any object in the list, this method
   * returns a null object.
   *
   * @return aliens[i] The alien object that is returned if the 
   * UI belongs to an alien.
   * @return null Null object.
   *
   */
	public Alien getAlienUI(int UI) {
		for(int i = 0; i < cant; i++) {
			if(aliens[i].getUI() == UI) {
				return aliens[i];
			}
		}
		return null;
	}

  /**
   * Returns the amount of elements in the list
   * at the time this method is called
   *
   * @return cant The The amount of elements in the list.
   *
   */
	public int getCant() {
		return cant;
	}

  /**
   * Returns the size of the list each time this method is called.
   *
   * @return max The size of the list.
   *
   */
	public void setCant(int cant) {
		this.cant = cant;
	}

  /**
   * Returns the size of the list each time this method is called.
   *
   * @return max The size of the list.
   *
   */
	public int getMax() {
		return max;
	}

  /**
   * The size of the list is inserted.
   * The inserted value replaces the max elements of the list.
   * This value should not be lower than the amount of objects in
   * the list.
   * 
   * @param max The new max amount of elementos of the list.
   *
   */
	public void setMax(int max) {
		this.max = max;
	}
}
