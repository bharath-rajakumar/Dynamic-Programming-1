Split into k sets to minimize discord
-------------------------------------
N political delegates from two parties, Daredevils (D) and Razorbacks (R) 
arrive at a conference to make decisions on K issues.  Each issue is
decided by creating a panel of delegates and they will debate the
issue and vote on it.  You have the task of forming these K panels
satisfying the following conditions:

1. Each panel must contain at least (2N)/(3K) delegates (rounded up) and
   at most (4N)/(3K) delegates (rounded down)

2. The delegates have received a number upon arrival, ordering them as
   per their arrival time.  The panels must be formed with the
   condition that no delegate can sit on a smaller numbered panel than
   a delegate who arrived earlier than him/her.  In other words, the
   first n_1 delegates (by arrival order) are assigned to panel 1, the
   next n_2 delegates to panel 2, and so on, where the sizes
   n_1,n_2,... have to satisfy condition 1 above.

3. Ideally, each panel should be balanced between the two parties, by
   having roughly the same number of delegates from each.  For panel i, 
   we define discord(i) to be the difference between the number of D
   delegates in it and the number of R delegates in it.  Note that
   discord(i) is always a nonnegative number.  It is not always
   possible to have discord(i)=0 for all i=1..K.  Find a way to
   seat the delegates in panels satisfying above conditions that
   minimizes the sum of squares of discords in all panels.

Input specification:
A sequence of problems is given.  Each problem in the sequence is as
follows.  The first line of input has 2 integers, N and K respectively.
The second line of input has N characters identifying the party of the
delegates (D or R), in the order of their arrival.  An input with N=0
signals the end.  Assume that N is between 3 and 200.

Output:
One line with K integers each.  The first integer in the output is the
value of the objective being minimized.  The remaining K-1 integers
are the sizes of the first K-1 panels.

Sample input:
20 3
RRRDDDRRRRDDDDRDRRDD
20 5
RRRDDDRRRRDDDDRDRRDD
0 0

Sample output:
0 6 8
4 5 3 4 3


In the output, the panels in the first solution correspond to
RRRDDD RRRRDDDD RDRRDD, and the panels in the second solution
correspond to RRRDD DRR RRDD DDR DRRDD.