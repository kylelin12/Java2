import java.util.ArrayList;

public class ArrayListStack<E> implements Stack<E> {
	private ArrayList<E> list;
	
	public ArrayListStack() {
		list = new ArrayList<E>();
	}
	
	public int size() {
		return list.size();
	}
	
	public void push(E item) {
		list.add(item);
	}
	
	public E pop() {
		if (empty())
			throw new EmptyStackException("Don't pop an empty stack");
		return list.remove(list.size() - 1);
	}
	
	public E peek() {
		if (empty())
			throw new EmptyStackException("Don't peek at an empty stack");
		return list.get(list.size() - 1);
	}
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	public String toString() {
		return list.toString();
	}
	
	public static void fillArrayList(int[] nums, ArrayListStack<Integer> numbers) {
		for (int x : nums)
			numbers.push(x);
	}
	
	public static void main(String[] args) {
		ArrayListStack<Integer> numbers = new ArrayListStack<Integer>();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		fillArrayList(nums, numbers);
		System.out.println(numbers.toString());
		while (!numbers.empty())
			System.out.println(numbers.pop());
		fillArrayList(nums, numbers);
		while (!numbers.empty())
			System.out.println("" + numbers.peek() + " " + numbers.pop());
	}
}
