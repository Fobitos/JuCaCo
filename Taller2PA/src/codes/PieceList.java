/**
* List where the pieces will be inserted.
*
* @author      Juan Castro Cortés.   ||  21.219.278-3
* @author      Carlos Leal Serrano.  ||  20.785.431-k
*/
public class PieceList {
	
	private int cant, max;
	private Piece[] pieces;
	
	/**
	 * A new piece list is built.
	 * This list starts out empty until objects are added to it.
	 * 
	 * @param max The max amount of objects of the list.
	 */
	public PieceList(int max) {
		cant = 0;
		this.max = max;
		pieces = new Piece[max];
	}
	
	/**
	 * A piece is inserted.
	 * If the piece list doesn't exceed the maximum amount of elements,
	 * the piece is added.
	 * 
	 * @param p The piece object to add to the list.
	 * @return True if the piece was added. False if not.
	 */
	public boolean add(Piece p) {
		if(cant < max) {
			pieces[cant] = p;
			cant++;
			return true;
		}
		return false;
	}
	
	/**
	 * A value, representing a position in the list, is inserted.
	 * If that value is lower than the actual amount of elements in the list,
	 * it deletes the piece and rearrange the list.
	 * 
	 * @param i A position in the list.
	 * @return True if the piece was deleted. False if not.
	 */
	public boolean delete(int i) {
		if(i < cant) {
			for(int j = i; j < max; j++) {
				pieces[j] = pieces[j+1];
			}
			cant--;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes all the pieces in the list.
	 */
	public void deleteEverything() {
		for(int i = 0; i < cant; i++) {
			pieces[i] = null;
		}
		cant = 0;
	}
	
	/**
	 * A value (representing a position in the list) is inserted as parameter.
	 * Returns the piece to which the delivered position belongs.
	 * If the position exceeds the amount of elements in the list, returns null.
	 * 
	 * @param i A position in the list.
	 * @return A piece if it exists in the list. Null if the position exceeds
	 * the actual amount of elements in the list.
	 */
	public Piece getPiece(int i) {
		if(i < cant) {
			return pieces[i];
		}
		return null;
	}
	
	/**
	 * Returns a piece if the piece code equals to the code given.
	 * Null is returned if they don't match.
	 * 
	 * @param code A piece code.
	 * @return A piece if the code equals to a piece code in the list. Null if not.
	 */
	public Piece getPieceCode(String code) {
		for(int i = 0; i < cant; i++) {
			if(pieces[i].getCode().equals(code)) {
				return pieces[i];
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
	 * Returns a piece if the piece type matches with the type given.
	 * If not, a null object is returned.
	 * 
	 * @param Position A position in the list.
	 * @param type A piece type.
	 * @return A piece if the piece type equals to the type given. Null if not.
	 */
	public Piece getPieceType(int Position, String type) {
		if (pieces[Position].getType().equals(type)) {
			return pieces[Position];
		}
		return null;
	}
}
