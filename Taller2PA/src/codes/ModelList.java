package codes;

/**
* List where the models will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class ModelList {
	
	private int cant, max;
	private Model[] models;
	
	/**
	 * A new model list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public ModelList(int max) {
		this.max = max;
		cant = 0;
		models = new Model[max];
	}
	
	/**
	 * A model is inserted.
	 * If the model list doesn't exceed the maximum amount of elements,
	 * the model is added.
	 * 
	 * @param c The model object to add to the list.
	 * @return True if the model was added. False if not.
	 */
	public boolean add(Model m) {
		if(cant < max) {
			models[cant] = m;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the model to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A model if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Model getModelI(int i) {
		if(i < cant) {
			return models[i];
		}
		return null;
	}
	
	/**
	 * Deletes all the models in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			models[i] = null;
		}
		cant = 0;
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
