public class HashTable {
	private Integer [] _table;
	private int _tableSize;
	private final static double LOADFACTOR = 0.75;
	
	
	public HashTable(int size) {
		_table = new Integer [size];
		_tableSize = 0;
	}
	
	public boolean isFull() {
		return _tableSize >= _table.length;
	}
	
	public boolean isEmpty() {
		return _tableSize == 0;
	}
	
	public int hash(int key) {
		return hash(key, _table.length);
	}
	
	public int hash(int key, int len) {
		return key % len;
	}
	
	public int find(int key) {
		int i = hash(key);
		if (_table[i] == null)
			return -1;
		for (int j = 0; j < _table.length; j++) {
			int tempPos = (i + j) % _table.length;
			if (_table[tempPos] != null && _table[tempPos] == key)
				return tempPos;
		}
		return -1;
	}
	
	public void add(int x) {
		if (_tableSize * 1.0 / _table.length >= LOADFACTOR)
	    	resize();
	    if (find(x) != -1)
	    	remove(x);
	    int i = hash(x);
		while (true) {
	    	if (_table[i] == null) {
				_table[i] = x;
				break;
	    	}
	    	i = (i + 1) % _table.length;
		}
		_tableSize++;
    }
	
	public boolean remove(int key) {
		int pos = find(key);
		if (pos == -1) return false;
		else {
			_table[pos] = null;
			_tableSize--;
			pos++;
			while (_table[pos] != null) {
				int temp = _table[pos];
				int index = 0;
				_table[pos] = null;
				add(temp);
				if (index < _table.length) {
					pos = (pos + 1) % _table.length;
					index++;
				}
			}
			return true;
		}
	}
	
	public void resize() {
		int len = _table.length * 2;
		Integer[] temp = new Integer[len];
		for(Integer x : _table) {
	   		if (x != null) { 
				int i = hash(x, len);
				while (true) {
		    		if (temp[i] == null) {
						temp[i] = x;
						break;
		    		}
		    		i = (i + 1) % len;
				}
	    	}
		}
		_table = temp;
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
