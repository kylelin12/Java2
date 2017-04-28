public class SparseArray {
	private int numRows;
	private int numCols;
	
	private List<SparseArrayEntry> entries;
	
	public SparseArray() {
		entries = new ArrayList<SparseArrayEntry>();
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	// Returns the value of the element at row row and col col.
	public int getValueAt(int row, int col) {
		for (SparseArrayEntry x : entries) {
			if (x.getRow() == row && x.getCol() == col)
				return x.getValue();
		}
	}
	
	// Removes the col col from the Sparse Array.
	public void removeColumn(int col) {
		for (SparseArrayEntry x : entries) {
			if (x.getCol() == col)
				x = null;
			if (x.getCol() > col)
				x = new SparseArrayEntry(x.getRow(), x.getCol() - 1, x.getValue());
		}
	}
}
