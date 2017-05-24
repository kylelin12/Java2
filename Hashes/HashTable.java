public class HashTable {
	private Integer [] _table;
	private int _tableSize;
	
	
	public HashTable(int size) {
		_table = new Integer [size];
		_tableSize = 0;
	}
	
	public int hash(int key) {
		return key % _table.length;
	}
	
	public int find(int key) {
		int i = hash(key);
		if (_table[i] == null)
			return -1;
		for (int j = 0; j < _table.length; j++) {
			int tempPos = i + j;
			if (_table[tempPos] == key)
				return tempPos;
		}
		return -1;
	}
	
	public void add(int key) {
	/*	if (_size >= _table.length) {
			resize();
			rehash();
		}*/
		int i = hash(key);
		while (_table[i] != null) {
			i = (i + 1) % _table.length;
		}
		_table[i] = key;
		_tableSize++;
	}
	
	public void remove(int key) {
		int pos = find(key);
		if (pos == -1) return;
		else {
			_table[pos] = null;
			_tableSize--;
		}
	}
	
	public String toString() {
		String ans = "[ ";
		for (int i = 0; i < _table.length; i++) {
			if (_table[i] != null)
				ans += _table[i] + " ";
			else
				ans += "* ";
		}
		ans += "]";
		return ans;
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable(10);
		int[] array = {13, 66, 60, 76, 76, 27, 79, 81};
		for (int x: array)
			table.add(x);
		System.out.println(table.toString());
		table.remove(76);
		System.out.println(table.toString());
		table.remove(76);
		System.out.println(table.toString());
	}
}
