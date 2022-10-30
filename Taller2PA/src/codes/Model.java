/**
* Class that represents a model with all his characteristics.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class Model {
	
	private String modelCode, robotName;

	/**
	 * Builds a model object using all the parameters indicated in the
	 * Model class.
	 * 
	 * @param modelCode The code of the new model.
	 * @param robotName The robot name of the new model.
	 */
	public Model(String modelCode, String robotName) {
		this.modelCode = modelCode;
		this.robotName = robotName;
	}

	/**
	 * Returns the code of a model.
	 * 
	 * @return The code of a model.
	 */
	public String getModelCode() {
		return modelCode;
	}

	/**
	 * A code is inserted.
	 * The inserted word replaces the model code.
	 * 
	 * @param modelCode The new model code.
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	/**
	 * Returns the robot name of a model.
	 * 
	 * @return The robot name of a model.
	 */
	public String getRobotName() {
		return robotName;
	}

	/**
	 * A robot name is inserted.
	 * The inserted word replaces the robot name of a model.
	 * 
	 * @param robotName The new robot name of a model.
	 */
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
}
