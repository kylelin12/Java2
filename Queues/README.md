###Round Robin Schedulers
A popular use of a queue data struture is to implement a round robin scheduler, where we iterate through a collection of elements in a circular fashion and "service" each element by performing a given action on it.
Such a scheduler is used to fairly allocate a resource that must bes hared by a collection of clients.

##Example
Allocate a slice of cpu time to varous applications running concurrently.

##To Do
Implement a round robin scheduler using a queue, Q, by repeating these 3 steps.
