# Hash tables

### Objective
Storying a collection of entries where finding, adding, and removing an entry is O(1)

---

### Density Dependent Search Techniques
A hashing function is a key to address transformation. It acts on a given key in such a way as to return the relative position in the array where we expect to find the key.             
```hash(key) -> position within an array```

---

Ex.
 
Let the length of the array(table) be 4.                       
Let hash(key) = key % 4                       

Keys are 3, 5, 8, and 10.

[0] -> 8                  
[1] -> 5                     
[2] -> 10                       
[3] -> 3                       

What if the keys are 3, 4, 8, and 10?

[0] -> 8 or 4                    
[1] ->                       
[2] -> 10                   
[3] -> 3                   

4 and 8 hash to the same position. They are said to be synnyms and the result is termed a collision.

One of the goals of developing a hashing function hould be to reduce the numbr of collisions as much as possible.

---

### Dealing with collisions:

1. Linear Probing: N objects are stored in a table(array) of size M where M > N.
 
 Hash the keys to a position i within the table. (0 <= i < table.length)
 
 If the position is free, store the key at this position i. Otherwise, start searching from i for the first available open position. (Wrap around if necessary.)

 Ex.

 hash(key) = key % 7                           
 table_size = 7                      
 add 18, 31, 32, 36, 19, 34

 [0] -> 34                            
 [1] -> 36                            
 [2] ->                                   
 [3] -> 31                                
 [4] -> 18                            
 [5] -> 32                                
 [6] -> 19                              

 hash(18) = 4                           
 hash(31) = 3                            
 hash(32) = 4                          
 hash(36) = 1                                      
 hash(19) = 5                               
 hash(34) = 6                                       
 
2. Bucket Hashing:

 Use an array of buckets (linked lists).
 
 Hash a key to a bucket if the bucket is empty and add the key, otherwise add the key to bucket (end of linked list).
 
 Ex. Number of buckets is 8
 
 [0] ->                        
 [1] -> 36                       
 [2] ->                        
 [3] -> 31                         
 [4] -> 18 -> 32                     
 [5] -> 19                   
 [6] -> 34                         
