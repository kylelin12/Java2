import java.util.ArrayList;

public class SLTester{


    public static void main(String [] args){
	List list = new SLinkedList();
	ArrayList aL = new ArrayList();
	String[] s = {"cat","bat", "mat", "sat", "fat","rat"};
      
	System.out.println("arraylist size: " + aL.size());
	System.out.println("array list: " + aL);
	
	System.out.println("linked size: " + list.size());
	System.out.println("linked list: " + list);

	/* testing add(String) */ 
	/*
	for ( String a : s){
	    aL.add(a);
	    list.add(a);
	    System.out.println("arraylist size: " + aL.size());
	    System.out.println("array list: " + aL);
	    System.out.println("linked size: " + list.size());
	    System.out.println("linked list: " + list);	
	}
    */   

	/* testing add(int,String) */
	  for (String a : s){
	  int i = (int) (Math.random() * aL.size());
	  aL.add(i,a);
	  list.add(i,a);
	  System.out.println("***Testing add(int,String) ****");
	  System.out.println("insert " + a + " at pos: " + i);
	  System.out.println("arraylist size: " + aL.size());
	  System.out.println("array list : " + aL);
	  System.out.println("linked size: " + list.size());
	  System.out.println("linked list: " + list);	
	  list.reverse();
	  System.out.println("reversed list: " + list);
    }
	/*
	int n = list.size();
	int r1 = (int)(Math.random() * n);
	int r2 = (int)(Math.random() * n);
	System.out.println("***Testing get(int) and  set(int,String) ****");
	System.out.println("arraylist  : " + aL);
	System.out.println("linked list: " + list);	
	System.out.println("swap pos " + r1 + " with " + r2);
	aL.set(r1, aL.set(r2, aL.get(r1)));
	System.out.println("arraylist  : " + aL);
	list.set(r1, list.set(r2, list.get(r1)));
	System.out.println("linked list: " + list);	
	*/
	/*

	while (aL.size() > 0){
	    int r3 = (int)(Math.random() * aL.size());
	    System.out.println("***Testing remove(int) *****************");
	    System.out.println("arraylist removed  : " + aL.remove(r3));
	    System.out.println("linkedlist removed : " + list.remove(r3));
	    System.out.println("arraylist  : " + aL);
	    System.out.println("linked list: " + list);	
	}
	*/
    }
    
    

}
