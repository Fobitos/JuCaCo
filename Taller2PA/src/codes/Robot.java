/**
* Class that represents a robot with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Robot {
	
	private String robotName, armName, legName, chestName, headName, extraQuality;
	private String weaponName, team;
	private String pilotCode;
	
	/**
	 * Builds a robot object using all the parameters indicated in the
	 * Robot class.
	 * 
	 * @param robotName The name of the new robot.
	 * @param armsName The name of the robot arms.
	 * @param legsName The name of the robot legs.
	 * @param chestName The name of the robot chest.
	 * @param headName The name of the robot head.
	 * @param extraQuality The name of the extra quality of the new robot.
	 * @param weaponName The name of the robot weapon.
	 * @param team The name of the robot team.
	 * @param pilotCode The code of the robot pilot.
	 */
	public Robot(String robotName, String armsName, String legsName, String chestName, String headName,
			String extraQuality, String weaponName, String team, String pilotCode) {
		this.robotName = robotName;
		this.armName = armsName;
		this.legName = legsName;
		this.chestName = chestName;
		this.headName = headName;
		this.extraQuality = extraQuality;
		this.weaponName = weaponName;
		this.team = team;
		this.pilotCode = pilotCode;
	}

	/**
	 * Returns the name of a robot.
	 * 
	 * @return The name of a robot.
	 */
	public String getRobotName() {
		return robotName;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot name.
	 * 
	 * @param robotName The new robot name.
	 */
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	/**
	 * Returns the name of the robot arms.
	 * 
	 * @return The name of the robot arms.
	 */
	public String getArmsName() {
		return armName;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot arms name.
	 * 
	 * @param armsName The new robot arms name.
	 */
	public void setArmsName(String armsName) {
		this.armName = armsName;
	}

	/**
	 * Returns the name of the robot legs.
	 * 
	 * @return The name of the robot legs.
	 */
	public String getLegsName() {
		return legName;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot legs name.
	 * 
	 * @param legsName The new robot legs name.
	 */
	public void setLegsName(String legsName) {
		this.legName = legsName;
	}

	/**
	 * Returns the name of the robot chest.
	 * 
	 * @return The name of the robot chest.
	 */
	public String getChestName() {
		return chestName;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot chest name.
	 * 
	 * @param chestName The new robot chest name.
	 */
	public void setChestName(String chestName) {
		this.chestName = chestName;
	}

	/**
	 * Returns the name of the robot head.
	 * 
	 * @return The name of the robot head.
	 */
	public String getHeadName() {
		return headName;
	}
 
	/**
	 * A name is inserted.
	 * The inserted word replaces the robot head name.
	 * 
	 * @param headName The new robot head name.
	 */
	public void setHeadName(String headName) {
		this.headName = headName;
	}

	/**
	 * Returns the name of the robot extra quality.
	 * 
	 * @return The name of the robot extra quality.
	 */
	public String getExtraQuality() {
		return extraQuality;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot extra quality name.
	 * 
	 * @param extraQuality The new robot extra quality name.
	 */
	public void setExtraQuality(String extraQuality) {
		this.extraQuality = extraQuality;
	}

	/**
	 * Returns the name of the robot weapon.
	 * 
	 * @return The name of the robot weapon.
	 */
	public String getWeaponName() {
		return weaponName;
	}

	/**
	 * A name is inserted.
	 * The inserted word replaces the robot weapon name.
	 * 
	 * @param weaponName The new robot weapon name.
	 */
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	/**
	 * Returns the name of the robot team.
	 * 
	 * @return The name of the robot team.
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * A team is inserted.
	 * The inserted word replaces the robot team.
	 * 
	 * @param team The new robot team.
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * Returns the code of the robot pilot.
	 * 
	 * @return The code of the robot pilot.
	 */
	public String getPilotCode() {
		return pilotCode;
	}

	/**
	 * A code is inserted.
	 * The inserted code replaces the robot pilot code.
	 * 
	 * @param pilotCode The new robot pilot code.
	 */
	public void setPilotCode(String pilotCode) {
		this.pilotCode = pilotCode;
	}

	@Override
	/**
	 * Returns a String that represents a robot.
	 * 
	 * @return A String that represents a robot.
	 */
	public String toString() {
		return "\n"
				+ "[" + robotName +  " | Código del piloto: " + pilotCode + " | Equipo: " + team + "]" + "\n"
				+ "Brazos: " + armName + "\n"
				+ "Piernas: " + legName + "\n"
				+ "Tórax: " + chestName + "\n"
				+ "Cabeza: " + headName + "\n"
				+ "Extra: " + extraQuality + "\n"
				+ "Arma: " + weaponName;
	}
}
