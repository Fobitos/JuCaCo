package codes;

/**
* List where the materials will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class MaterialsList {
	
	private int cant, max;
	private Material[] materials;
	
	/**
	 * A new material list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public MaterialsList(int max) {
		cant = 0;
		this.max = max;
		materials = new Material[max];
	}
	
	/**
	 * A material is inserted.
	 * If the material list doesn't exceed the maximum amount of elements,
	 * the material is added.
	 * 
	 * @param m The material object to add to the list.
	 * @return True if the material was added. False if not.
	 */
	public boolean add(Material m) {
		if(cant < max) {
			materials[cant] = m;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the materials in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			materials[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the material to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A material if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Material getMaterial(int i) {
		if(i < cant) {
			return materials[i];
		}
		return null;
	}
	
	/**
	 * Similar as the getMaterial method, but with a name given.
	 * 
	 * @param name The name of the material.
	 * @return A material if it exists in the list. Null if doesn't.
	 */
	public Material getMaterialName(String name) {
		for(int i = 0; i < cant; i++) {
			if(materials[i].getName().equals(name)) {
				return materials[i];
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
	
	/**
	 * Checks if the name matches with a material in the list.
	 * Also checks if the amount given is lower than the stock.
	 * 
	 * @param nameOfMaterial The name of a material.
	 * @param cantOfMaterial The amount of a material.
	 * @return True if the material exists in the list and if the stock of that material
	 * is bigger than or equal to the amount given. False if not.
	 */
	public boolean canDoPiece(String nameOfMaterial, int cantOfMaterial) {
		for(int i = 0; i < cant; i++) {
			if(nameOfMaterial.equals(materials[i].getName())) {
				if(materials[i].getStock()>=cantOfMaterial) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}