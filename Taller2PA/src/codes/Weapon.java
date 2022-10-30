/**
* Class that represents a weapon with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Weapon {
	
	private String name;
	private String code;
	private int ammo;
	private String originCountry;
	private int cantMaterial;
	
	/**
	 * Builds a weapon object using all the parameters indicated in the
	 * Weapon class.
	 * 
	 * @param name The name of the new weapon.
	 * @param code The code of the new weapon.
	 * @param ammo The ammo of the new weapon.
	 * @param originCountry The origin country of the new weapon.
	 * @param cantMaterial The amount of material needed by the new weapon.
	 */
	public Weapon(String name, String code, int ammo, String originCountry, int cantMaterial) {
		this.name = name;
		this.code = code;
		this.ammo = ammo;
		this.originCountry = originCountry;
		this.cantMaterial = cantMaterial;
	}

	/**
	 * Returns the name of a weapon.
	 * 
	 * @return The name of a weapon.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the weapon name.
	 * 
	 * @param name The new weapon name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the code of a weapon.
	 * 
	 * @return The code of a weapon.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * A code is inserted.
	 * The inserted code replaces the weapon code.
	 * 
	 * @param code The new weapon code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
 
	/**
	 * Returns the ammo of a weapon.
	 * 
	 * @return The ammo of a weapon.
	 */
	public int getAmmo() {
		return ammo;
	}

	/**
	 * An amount of ammo is inserted.
	 * The inserted value replaces the amount of ammo of the weapon.
	 * 
	 * @param ammo The new amount of ammo of the weapon.
	 */
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	/**
	 * Returns the origin country of a weapon.
	 * 
	 * @return The origin country of a weapon.
	 */
	public String getOriginCountry() {
		return originCountry;
	}

	/**
	 * An origin country is inserted.
	 * The inserted word replaces the weapon origin country.
	 * 
	 * @param originCountry The new weapon origin country.
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	/**
	 * Returns the amount of material needed by the weapon.
	 * 
	 * @return The amount of material needed by the weapon.
	 */
	public int getCantMaterial() {
		return cantMaterial;
	}

	/**
	 * An amount of material is inserted.
	 * The inserted value replaces the amount of material needed by the weapon.
	 * 
	 * @param cantMaterial The new amount of material needed by the weapon.
	 */
	public void setCantMaterial(int cantMaterial) {
		this.cantMaterial = cantMaterial;
	}

	@Override
	/**
	 * Returns a String that represents a weapon.
	 * 
	 * @return A String that represents a weapon.
	 */
	public String toString() {
		return "Weapon [name=" + name + ", code=" + code + ", ammo=" + ammo + ", originCountry=" + originCountry
				+ ", cantMaterial=" + cantMaterial + "]";
	}
}
