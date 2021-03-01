Problem description:
The purpose of the project is to implement a Stack ADT in the two most common ways, an array and a
linked list. Your stack implementation will be used to manipulate a string of number to solve the
pancake flipping problem (ACM-ICPC contest problem).
The cook at the Frobbozz Magic Pancake House sometimes falls asleep on the job while cooking
pancakes. As a result, one side of a stack of pancakes is often burned. Clearly, it is bad business to
serve visibly burned pancakes to the patrons. Before serving, the waitress will arrange the stacks of
pancakes so that the burned sides are facing down. You must write a program to aid the waitress in
stacking the pancakes correctly.
We start with a stack of N pancakes of distinct sizes, each of which is burned on one side. The
problem is to convert the stack to one in which the pancakes are in size order with the smallest on the
top and the largest on the bottom and burned side down for each pancake. To do this, we are allowed to
flip the top k pancakes over as a unit (so the kth pancake is now on top and the pancake previously on
top is now in the kth position and the burned side goes from top to bottom and vice versa). For example
(+ indicates burned bottom, - a burned top):
+1 -3 -2 [flip 2] => +3 -1 -2 [flip 1] => -3 -1 -2 [flip 3] => +2 +1 +3 [flip 1] => -2 +1 +3 [flip 2]
=> -1 +2 +3 [flip 1] => +1 +2 +3