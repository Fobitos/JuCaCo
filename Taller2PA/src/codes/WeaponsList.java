/**
* List where the weapons will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class WeaponsList {
	
	private int cant, max;
	private Weapon[] weapons;
	
	/**
	 * A new weapon list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public WeaponsList(int max) {
		cant = 0;
		this.max = max;
		weapons = new Weapon[max];
	}
	
	/**
	 * A weapon is inserted.
	 * If the weapon list doesn't exceed the maximum amount of elements,
	 * the weapon is added.
	 * 
	 * @param w The weapon object to add to the list.
	 * @return True if the weapon was added. False if not.
	 */
	public boolean add(Weapon w) {
		if(cant < max) {
			weapons[cant] = w;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the weapons in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			weapons[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the weapon to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A weapon if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Weapon getWeapon(int i) {
		if(i < cant) {
			return weapons[i];
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
