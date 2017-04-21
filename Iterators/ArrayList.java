


public class ArrayList<E> implements List<E>{

    private E[] _data;
    private int _size;


    // constructor
    public ArrayList(){
	_data = (E[]) new Object[10];
	_size = 0;
    }


    public int size(){
	return _size;
    }

    private void resize(){
	if (size() != _data.length) return;
	E[] temp = (E[]) new Object[size() * 2];
	for (int i = 0; i < size(); i++)
	    temp[i] = _data[i];
	_data = temp;
    }
    

    public boolean add(E obj){
	if (size() == _data.length) resize();
	_data[_size++] = obj;
	return true;
   }
    // Question 1 **********************
    public void add(int index, E obj){
	if (index < 0 || index > size())
	    throw new IndexOutOfBoundsException("index: " + index);
	if (size() == _data.length) resize();
	add(obj);// add to end
	
	for (int i = size() - 1; i > index; i--)
	    set(i,set(i-1, get(i)));
    }		

    
    public E get(int index){
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException("index : " + index);
	return _data[index];
    }

    public E set(int index, E obj){
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException("index : " + index);
	E ans =  _data[index];
	_data [index] = obj;
	return ans;
    }
    
    // Question: 2************************
    public E remove(int index){
	E ans = get(index);
	while(index < size() - 1){
	    _data[index] = _data[index + 1];
	    index++;
	}
	_data[--_size] = null;
	return ans;
    }


    public String toString(){
	String ans = "[";
	for (int i = 0; i < size(); i++)
	    ans += get(i) + ", ";
	if (ans.length() > 2)
	    ans = ans.substring(0, ans.length() - 2);
	ans += "]";
	return ans + "size: " + size();
    }


    public static void main(String [] args){
	ArrayList<Integer> L = new ArrayList<Integer>();
	System.out.println("L: " + L);

	for (int i = 0; i < 10; i++){
	    L.add(i);
	    System.out.println("L: " + L);

	}
	for (int i = 10; i < 20; i++){
	    int r = (int)(Math.random() * L.size() + 1);
	    System.out.println("r: " + r);
	    L.add(r, i);
	    System.out.println("L: " + L);
	}
	/*
	  System.out.println("************ REMOVING **********");
	  while (L.size() > 0){
	  int r = (int)(Math.random() * L.size());
	  System.out.println(" remove " + L.remove(r));
	  System.out.println("L: " + L);
	  }
	*/
	/*
	  for (Integer x : L)
	  System.out.println(x);

	*/

	/*
	  System.out.println("L : " + L);
	  Iterator <Integer> itr = L.iterator();
	  // remove evens
	  while (itr.hasNext()){
	  if (itr.next() % 2 == 0)
	  itr.remove();
	  }
	  itr.remove(); // throws an exception
	  System.out.println("L : " + L);
	*/
    }

    }
