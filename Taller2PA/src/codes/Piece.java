/**
* Class that represents a piece with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Piece {
	
	private String name;
	private String code;
	private String type;
	private String originCountry;
	private int cantMaterial;
	
	/**
	 * Builds a piece object using all the parameters indicated in the
	 * Piece class.
	 * 
	 * @param name The name of the new piece.
	 * @param code The code of the new piece.
	 * @param type The type of the new piece.
	 * @param originCountry The origin country of the new piece.
	 * @param cantMaterial The amount of material needed by the new piece.
	 */
	public Piece(String name, String code, String type, String originCountry, int cantMaterial) {
		this.name = name;
		this.code = code;
		this.type = type;
		this.originCountry = originCountry;
		this.cantMaterial = cantMaterial;
	}

	/**
	 * Returns the name of a piece.
	 * 
	 * @return The name of a piece.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the piece name.
	 * 
	 * @param name The new name of the piece.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the code of a piece.
	 * 
	 * @return The code of a piece.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * A code is inserted.
	 * The inserted word replaces the piece code.
	 * 
	 * @param code The new code of the piece.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Returns the type of a piece.
	 * 
	 * @return The type of a piece.
	 */
	public String getType() {
		return type;
	}

	/**
	 * A type is inserted.
	 * The inserted word replaces the piece type.
	 * 
	 * @param type The new type of the piece.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the origin country of a piece.
	 * 
	 * @return The origin country of a piece.
	 */
	public String getOriginCountry() {
		return originCountry;
	}

	/**
	 * An origin country is inserted.
	 * The inserted word replaces the piece origin country.
	 * 
	 * @param originCountry The new origin country of the piece.
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	/**
	 * Returns the amount of material needed by a piece.
	 * 
	 * @return The amount of material needed by a piece.
	 */
	public int getCantMaterial() {
		return cantMaterial;
	}

	/**
	 * A value is inserted.
	 * The inserted value replaces the amount of material needed by the piece.
	 * 
	 * @param cantMaterial The new amount of material needed by the piece.
	 */
	public void setCantMaterial(int cantMaterial) {
		this.cantMaterial = cantMaterial;
	}

	@Override
	/**
	 * Returns a String that represents a piece.
	 * 
	 * @return A String that represents a piece.
	 */
	public String toString() {
		return "[Nombre: " + name + " | Código: " + code + " | Tipo: " + type + " | " + "País de origen: "
				+ originCountry + " | Cantidad de material requerido: " + cantMaterial + "]";
	}
}
