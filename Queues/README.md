# Round Robin Schedulers
A popular use of a queue data struture is to implement a round robin scheduler, where we iterate through a collection of elements in a circular fashion and "service" each element by performing a given action on it.
Such a scheduler is used to fairly allocate a resource that must bes hared by a collection of clients.

## Example
Allocate a slice of cpu time to varous applications running concurrently.

## To Do
Implement a round robin scheduler using a queue, Q, by repeating these 3 steps.
1. `e <- q.dequeue()`
2. `service element e`
3. `q.enqueue(e)`

## Hot Potato Game
In the children's game "Hot Potato", a group of n children sit in a circle passing an object, called the potato, around the circle. 
An adult randomly shouts "hot potato", upon which the child with the potato is removed from the circle after the child hands off the potato to the next child in the circle.
Repeat until 1 child is left.

## The Josephus Problem
If the adult uses the strategy of calling "hot potato" after the potato has been passed k times, then determining the winner for a list of children is known as the ***Josephus Problem***.

Ex. Implement the Josephus Problem using a round robin scheduler.
