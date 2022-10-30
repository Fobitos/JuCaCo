package codes;

/**
* Class that represents a person with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Person {
	
	private String name;
	private String ID;
	private String specialty, team;
	
	/**
	 * Builds a person object using all the parameters indicated in the
	 * Person class.
	 * 
	 * @param name The name of the new person.
	 * @param ID The identification of the new person.
	 * @param specialty The specialty of the new person.
	 * @param team The team of the new person.
	 */
	public Person(String name, String ID, String specialty, String team) {
		this.name = name;
		this.ID = ID;
		this.specialty = specialty;
		this.team = team;
	}

	/**
	 * Returns the name of a person.
	 * 
	 * @return The name of a person.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the person name.
	 * 
	 * @param name The new name of a person.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the ID of a person.
	 * 
	 * @return The ID of a person.
	 */
	public String getID() {
		return ID;
	}

	/**
	 * An ID is inserted.
	 * The inserted word replaces the person ID.
	 * 
	 * @param ID The new ID of the person.
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * Returns the specialty of a person.
	 * 
	 * @return The specialty of a person.
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * A specialty is inserted.
	 * The inserted word replaces the person specialty.
	 * 
	 * @param specialty The new specialty of the person.
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * Returns the team of a person.
	 * 
	 * @return The team of a person.
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * A team is inserted.
	 * The inserted word replaces the person team.
	 * 
	 * @param team The new team of the person.
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	/**
	 * Returns a String that represents a person.
	 * 
	 * @return A String that represents a person.
	 */
	public String toString() {
		return "[Nombre: " + name + " | ID: " + ID + " | Equipo: " + team + "]";
	}
}
