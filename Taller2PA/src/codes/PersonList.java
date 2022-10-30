package codes;

/**
* List where the people will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class PersonList {
	
	private int cant, max;
	private Person[] people;
	
	/**
	 * A new person list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public PersonList(int max) {
		cant = 0;
		this.max = max;
		people = new Person[max];
	}
	
	/**
	 * A person is inserted.
	 * If the person list doesn't exceed the maximum amount of elements,
	 * the person is added.
	 * 
	 * @param p The person object to add to the list.
	 * @return True if the person was added. False if not.
	 */
	public boolean add(Person p) {
		if(cant < max) {
			people[cant] = p;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the people in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			people[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * Checks if the name given equals to a person name registered in the list.
	 * 
	 * @param name A name.
	 * @return True if the name matches with a person name in the list. False if not.
	 */
	public boolean existName(String name) {
		for(int i = 0; i < cant; i++) {
			if(people[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Similar as the existName method, but with an ID.
	 * 
	 * @param ID An identification.
	 * @return True if the ID matches with a person ID in the list. False if not. 
	 */
	public boolean existID(String ID) {
		for(int i = 0; i < cant; i++) {
			if(people[i].getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a person in the list if the ID matches with the ID given.
	 * 
	 * @param ID An identification.
	 * @return A person if the ID equals to a person ID in the list. Null if it doesn't.
	 */
	public Person getPerson(String ID) {
		for(int i = 0; i < cant; i++) {
			if(people[i].getID().equals(ID)) {
				return people[i];
			}
		}
		return null;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the person to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A person if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Person getPersonWithI(int i) {
		if(i < cant) {
			return people[i];
		}
		return null;
	}

	/**
	 * Returns the amount of elements in the list.
	 * 
	 * @return The amount of elements in the list.
	 */
	public int getCant() {
		return cant;
	}
	
	/**
	 * An amount of elements is inserted.
	 * The inserted value replaces the amount of elements of the list.
	 * 
	 * @param cant The new amount of elements of the list.
	 */
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return The size of the list.
	 */
	public int getMax() {
		return max;
	}
	
	/**
	 * The size of the list is inserted.
	 * The inserted value replaces the max elements of the list.
	 * 
	 * @param max The new max amount of elements of the list.
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * Returns a person if they're a pilot.
	 * 
	 * @param i A position in the list.
	 * @return A person if their specialty equals to "pilot". Null if doesn't.
	 */
	public Person showTeams(int i) {
		if(people[i].getSpecialty().equals("piloto")) {
			return people[i];
		}
		return null;
	}
}
