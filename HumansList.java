/**
 * List where the humans that were created will be inserted.
 *
 * @author      Juan Castro Cortés. <juan.castro@alumnos.ucn.cl>
 * @author      Carlos Leal Serrano. <carlos.leal@alumnos.ucn.cl>
 */
public class HumansList {

  private Human[] humans;
  private int cant;
  private int max;

  /**
   * A new humans list is built using the parameter inserted, which
   * represents the max amount of objects of the list.
   * This list starts out empty until objects are added to it.
   * 
   * @param max The max amount of objects of the list.
   *
   */
  public HumansList(int max) {
    this.max = max;
    humans = new Human[max];
    cant = 0;
  }

  /**
   * A human is inserted
   * If the human list doesn't exceeds the maximum elements of the list,
   * this human is inserted in the list.
   * 
   * @param h The human object to add to the list.
   *
   */
  public boolean add(Human h) {
    if (cant < max) {
      humans[cant] = h;
      cant++;
      return true;
    } else {
      return false;
    }
  }

  /**
   * If the human object is found, the position of that object
   * in the list is returned. If it's not found it returns a -1.
   * 
   * @param h The human object to be found.
   * @return -1 The object was not found.
   * @return i The object was found and returns the position.
   *
   */
  public int index(Human h) {
    int i;
    for (i = 0; i < cant; i++) {
      if (humans[i] == h) {
        break;
      }
    }
    if (i == cant) {
      return -1;
    } else {
      return i;
    }
  }

  /**
   * If the inserted human object is found, it is deleted and the number
   * of elements decreases by one.
   * 
   * @param h The human object to be deleted.
   * @return true The object was deleted.
   * @return false The object was not deleted.
   *
   */
  public boolean delete(Human h) {
    int i;
    for (i = 0; i < cant; i++) {
      if (humans[i] == h) {
        break;
      }
    }
    if (i == cant) {
      return false;
    } else {
      for (int j = i; j < cant; j++) {
        humans[j] = humans[j + 1];
      }
      cant--;
      return true;
    }
  }

  /**
   * A value (representing a position in the list) is inserted.
   * Returns the human belongs that position inserted in the list.
   * If the number exceeds the maximum of the list, this method
   * returns a null object.
   *
   * @return humans[i] The human object that is returned if
   * the ID belongs to a human
   * @return null Null object.
   *
   */
  public Human getHuman(int i) {
    if (i < cant) {
      return humans[i];
    } else {
      return null;
    }
  }

  /**
   * An identification is inserted.
   * Returns the human belongs that identification inserted.
   * If the ID doesn't belong to any object in the list, this method
   * returns a null object.
   *
   * @return humans[i] The human object that is returned if
   * the ID belongs to a human.
   * @return null Null object.
   *
   */
  public Human getHumanID(int ID) {
    for (int i = 0; i < cant; i++) {
      if (humans[i].getID() == ID) {
        return humans[i];
      }
    }
    return null;
  }

  /**
   * Returns the amount of elements in the list
   * at the time this method is called
   *
   * @return cant The amount of elements in the list.
   *
   */
  public int getCant() {
    return cant;
  }

  /**
   * An amount of elements is inserted.
   * The inserted value replaces the amount of elements of the list.
   *
   * @param cant New amount of elements of the list.
   *
   */
  public void setCant(int cant) {
    this.cant = cant;
  }

  /**
   * Returns the size of the list each time this method is called.
   *
   * @return max The size of the list.
   *
   */
  public int getMax() {
    return max;
  }

  /**
   * The size of the list is inserted.
   * The inserted value replaces the max elements of the list.
   * This value should not be lower than the amount of objects in
   * the list.
   * 
   * @param max The new max amount of elementos of the list.
   *
   */
  public void setMax(int max) {
    this.max = max;
  }
}
