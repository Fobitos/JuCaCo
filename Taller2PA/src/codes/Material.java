/**
* Class that represents a material with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Material {
	
	private String name;
	private int stock;
	private String originCountry;
	
	/**
	 * Builds a material object using all the parameters indicated in the
	 * Material class.
	 * 
	 * @param name The name of the new material.
	 * @param stock The stock of the new material.
	 * @param originCountry The origin country of the new material.
	 */
	public Material(String name, int stock, String originCountry) {
		this.name = name;
		this.stock = stock;
		this.originCountry = originCountry;
	}
	
	/**
	 * Returns the name of a material.
	 * 
	 * @return The name of a material.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the material name.
	 * 
	 * @param name The new material name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the stock of a material.
	 * 
	 * @return The stock of a material.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * A value is inserted.
	 * The inserted value replaces the material stock.
	 * 
	 * @param stock The new material stock.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Returns the origin country of a material.
	 * 
	 * @return The origin country of a material.
	 */
	public String getOriginCountry() {
		return originCountry;
	}

	/**
	 * An origin country is inserted.
	 * The inserted word replaces the material origin country.
	 * 
	 * @param originCountry The new material origin country.
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	@Override
	/**
	 * Returns a String that represents a material.
	 * 
	 * @return A String that represents a material.
	 */
	public String toString() {
		return "Material [name=" + name + ", stock=" + stock + ", originCountry=" + originCountry + "]";
	}
}
