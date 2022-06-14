(10.1.9 - Bacteria Cultures)

Desc.
A lesson from the recursive unit. This program will predict the number of bacterium on a surface based on the input of hours.

Assignment Desc:
A biology teacher asked her class to answer the following question:

If I put 7 bacteria on the classroom doorknob tonight, how many bacteria will be on the doorknob by the time we come to school tomorrow?
In order to answer this question, you need to know a few things:

Each bacterium (a single bacteria) can create 4 more bacteria every hour
This means that after one hour, the doorknob will have 7 + 7 * 4 = 35 bacteria, since we started with 7 bacteria and each of those created 4 more.
This means that after two hours, the doorknob will have 35 + 35 * 4 = 175, since there were 35 bacteria at the beginning of hour two, and during that hour each bacteria created 4 more bacteria.
Continuing this pattern, the number of bacteria on the doorknob after N hours is
numberOfBacteriaLastHour + numberOfBacteriaLastHour * 4
However, if we wanted to know how many bacteria are alive after 12 hours, we need to know how many bacteria were alive at hour 11. To find out how many bacteria are alive at hour 11, we need to figure out how many were alive at hour 10. Do you see how we can use recursion to solve this problem?

Write a recursive function that computes the number of bacteria alive after N hours.
The function signature is

public static int colonySize(int hour)
