package codes;

/**
* List where the models will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class RobotsList {
	
	private int cant, max;
	private Robot[] robots;
	
	/**
	 * A new robot list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public RobotsList(int max) {
		cant = 0;
		this.max = max;
		robots = new Robot[max];
	}
	
	/**
	 * A robot is inserted.
	 * If the robot list doesn't exceed the maximum amount of elements,
	 * the robot is added.
	 * 
	 * @param r The robot object to add to the list.
	 * @return True if the robot was added. False if not.
	 */
	public boolean add(Robot r) {
		if(cant < max) {
			robots[cant] = r;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the robots in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			robots[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the robot to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A robot if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Robot getRobot(int i) {
		if(i < cant) {
			return robots[i];
		}
		return null;
	}
	
	/**
	 * Returns a piece if the piece name equals to the name given.
	 * Returns null if not.
	 * 
	 * @param name A robot name.
	 * @return A piece if the piece name equals to the name given. Null if not.
	 */
	public Robot getRobotName(String name) {
		for(int i = 0; i < cant; i++) {
			if(robots[i].getRobotName().equals(name)) {
				return robots[i];
			}
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
}
