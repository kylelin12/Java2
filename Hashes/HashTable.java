public class HashTable {
	private Integer [] _table;
	private int _tableSize;
	
	
	public HashTable(int size) {
		_table = new Integer [size];
		_tableSize = size;
	}
	
	public int hash(Integer key) {
		return key % _tableSize;
	}
	
	public boolean find(Integer key) {
		int pos = hash(key);
		if (_table[pos].equals(key)) {
			return true;
		} else {
			for (int i = 0; i < table.length; i++) {
				int tempPos = pos + i;
				tempPos = tempPos % table.length;
				if (_table[tempPos].equals(key))
					return true;
			}
			return false;
		}
	}
	
	public void add(Integer key) {
		int pos = hash(key);
		if (_table[pos] != null) {
			_table[pos] = key;
		} else {
			for (int i = 0; i < table.length; i++) {
				int tempPos = pos + i;
				tempPos = tempPos % table.length;
				if (_table[tempPos] == null)
					_table[tempPos] = key;
			}
		}
	}
	
	public void remove(Integer key) {
		int pos = hash(key);
		if (_table[pos].equals(key)) {
			_table[pos] = null;
			return;
		} else {
			for (int i = 0; i < table.length; i++) {
				int tempPos = pos + i;
				tempPos = tempPos % table.length;
				if (_table[tempPos].equals(key)) {
					_table[tempPos] = null;
					break;
				}
			}
		}
	}
}
