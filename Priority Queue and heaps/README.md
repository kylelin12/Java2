#Priority Queue
###Def.                 
A **priority queue** is an abstract data type for storing a collection of prioritized elements that supports arbitrary element insertion but supports removal of elements in order of priority, that is, the element with first priority can be removed at any time.

###Applications:                               
1. Boarding an airplane. First class has the highest priority than parents with small children, etc...
2. Emergency room waiting list
3. Print jobs, administrators before teachers, teachers before students.

###Java Collections PriorityQueue < E >                                   
Java provides a PriorityQueue < E > that utilizes a head to store the data.

To use it, you need to import java.util.PriorityQueue

A subset of the methods:
1. Constructor:
* public PriorityQueue();
* public PriorityQueue(Comparator < E > comp);
2. Accessors:
* public int size();
* E peek();
3. Mutators:
* boolean add(E obj);
* E poll(); // Removes the element with highest priority

A priority Queue needs a comparison rule to determine the priority of removal.

For integers, the smallest entry has the highest priority.            
Strings use lexiographic ordering. "a" before "b", etc...

###Demo.java                                     
```
import java.util.PriorityQueue;

public class Demo {
	public static void main(String[] args) {
		String[] fruits = {
			"kiwi",
			"pear",
			"apple",
			"banana",
			"watermelon",
			"grapes",
			"cantalope",
			"orange"
		};
		PriorityQueue < String > pq = new PriorityQueue < String > ();
		for (String fruit: fruits)
		pq.add(fruit);
		while (pq.size() != 0) {
			System.out.println("Peek: " + pq.peek());
			System.out.println("Remove: " + pq.poll());
		}
	}
}
```

###Implement Priority Sort                           
```
public static void pqSort(String[] list) {
	PriorityQueue < String > temp = new PriorityQueue < String > ();
	for (String item: list) {
		temp.add(item);
	}
	for (int i = 0; i < list.length; i++) {
		list[i] = temp.poll();
	}
}
```

**If both the add() and poll() methods of the Priority Queue class are O(logN) what is the expected runtime of the pqSort?**             
`O(nLogn)`

**On what order is the additional memory required for the pqSort?**                
`O(n)`

#Heaps                         
###Def.                    
A **full binary tree** is a tree in which every node other than the leaves have two children.

###Def.                            
A binary tree is a **complete binary tree** if the binary tree (excluding the last level) is completely filled, and on the last level all the leaves are as far left as possible.

###Def.                    
A **heap** is a complete binary tree in which each parent node is less than (greater than) or equal to each of its children.
