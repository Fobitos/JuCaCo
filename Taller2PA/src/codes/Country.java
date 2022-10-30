/**
* Class that represents a country with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Country {
	
	private String countryName, type;
	private String typeCode;
	private int cant;
	private String material;
	
	/**
	 * Builds a country object using all the parameters indicated in the
	 * Country class.
	 * 
	 * @param countryName The name of the new country.
	 * @param type The piece type of the new country.
	 * @param typeCode The piece code of the new country.
	 * @param cant The amount of pieces that the new country made.
	 * @param material The material of the piece made by the country.
	 */
	public Country(String countryName, String type, String typeCode, int cant, String material) {
		this.countryName = countryName;
		this.type = type;
		this.typeCode = typeCode;
		this.cant = cant;
		this.material = material;
	}
	
	/**
	 * Returns the name of a country.
	 * 
	 * @return The name of a country.
	 */
	public String getCountryName() {
		return countryName;
	}
	
	/**
	 * A country name is inserted.
	 * The inserted word replaces the country name.
	 * 
	 * @param countryName The new country name.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	/**
	 * Returns the piece type of a country.
	 * 
	 * @return The piece type of a country.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * A piece type is inserted.
	 * The inserted word replaces the piece type of a country.
	 * 
	 * @param type The new piece type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the piece code of a country.
	 * 
	 * @return The piece code of a country.
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * A piece code is inserted.
	 * The inserted word replaces the piece code of a country.
	 * 
	 * @param typeCode The new piece code.
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * Returns the amount of pieces that a country made.
	 * 
	 * @return The amount of pieces that a country made.
	 */
	public int getCant() {
		return cant;
	}

	/**
	 * A value is inserted.
	 * The inserted value replaces the amount of pieces of a country.
	 * 
	 * @param cant The new amount of pieces that a country made.
	 */
	public void setCant(int cant) {
		this.cant = cant;
	}

	/**
	 * Returns the material used by a country.
	 * 
	 * @return The material used by a country.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * A material is inserted.
	 * The inserted word replaces the material that a country used.
	 * 
	 * @param material The new material that a country used for their pieces.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	/**
	 * Returns a String that represents a country.
	 * 
	 * @return A String that represents a country.
	 */
	public String toString() {
		return "Country [countryName=" + countryName + ", type=" + type + ", typeCode=" + typeCode + ", cant=" + cant
				+ ", material=" + material + "]";
	}
}
