package codes;

/**
* List where the countries will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class CountryList {
	
	private int cant, max;
	private Country[] countries;
	
	/**
	 * A new country list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public CountryList(int max) {
		cant = 0;
		this.max = max;
		countries = new Country[max];
	}
	
	/**
	 * A country is inserted.
	 * If the country list doesn't exceed the maximum amount of elements,
	 * the country is added.
	 * 
	 * @param c The country object to add to the list.
	 * @return True if the country was added. False if not.
	 */
	public boolean add(Country c) {
		if(cant < max) {
			countries[cant] = c;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the countries in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			countries[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the country to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A country if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Country getCountry(int i) {
		if(i < cant) {
			return countries[i];
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
	 * Checks if a country contributed with more than 0 pieces.
	 * 
	 * @param code A piece code.
	 * @return True if the amount of pieces that country gave is higher than 0. False if not.
	 */
	public boolean checkTotalIt(String code) {
		for(int i = 0; i < cant; i++) {
			if(code.equals(countries[i].getTypeCode())) {
				if(countries[i].getCant()>0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Subtracts a piece from a country if the code of the piece of that country
	 * equals to the given code.
	 * 
	 * @param code A piece code.
	 */
	public void subtractTotal(String code) {
		for(int i = 0; i < cant; i++) {
			if(code.equals(countries[i].getTypeCode())) {
				countries[i].setCant(countries[i].getCant()-1);
			}
		}
	}
}