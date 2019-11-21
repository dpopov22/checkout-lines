# checkout-lines
In order to run this project you will need java installed. Please use the command javac *.java to compile all of the classes. Then to run the program, use the command "java MixedSimulations". This will run the simulation for all of the different checkout lines, and will display the stats for each type of check-out line in the terminal. If you would like to run the simulation for each type of customer, use the command "java PickyCustomerSimulation", "java Pick2CustomerSimulation" , "java RandomCustomerSimulation" or "java LargeCustomerSimulation". 

In this project I used queue implementation to simulate shoppers picking which check-out line to use. 
In the end, I created 4 types of strategies for selecting a queue. I also used Nodes, Linked Lists, and Array Lists 
to implement my strategies. One of the strategies was to select the shortest line, which would be optimal but would 
take a lot of time as the customer has to examine each queue (line). Another strategy was to pick a queue at random, 
which would not require a lot of time, but would leave the customer at risk of being in a longer line. The last required 
strategy was picking two queues randomly and then choosing the shorter one, which was time efficient, but still left the 
customer with the risk of not being in the shortest line. I made a fourth type of strategy, which was 
picking the shortest line based on the number of items in the line, which ended up taking the most time and was inefficient. 
It was interesting to analyze the different strategies upon completion of the project, and my results were as expected. 

The first task was to create a Customer class, which was an abstract class with private fields that kept track 
of how many items were in the customers basket and the number of time steps it takes for the customer to leave. 
Both of these fields were integers. This class is the parent class from which all of the other classes that have 
line choosing methods were derived. The next task was to make a CheckoutAgent class which had fields for its x and 
y positions so it can be drawn and a queue of Customers. It had an addCustomerToQueue method to add a customer to the queue, 
a getNumInQueue to get the number of customers and a draw method that drew the checkout agents as rectangles with a 
height proportional to the number of of Customers in the queue. I also created a Landscape class that looped through 
all of the checkout agents and drew them on the landscape, and had an ArrayList of checkout agents and a LinkedList 
of customers who have left the queue. 

Then I started to make my Customers that used different types of strategies. 

First I made a Random Customer, which extended the Customer class. I had a chooseLine method 
that generated a random integer between 0 and the size of the checkouts list and then had the customer choose 
that random line. 

Then I made a Picky Customer, which extended the Customer class and had a chooseLine method 
that had the customer choose the shortest line. If the number in the queue was less than the current 
minimum variable then that number was set to be the minimum and then returned. 

I then made the Pick 2 Customer, which randomly chose two lines and then picked the shorter of the two. 
This was basically a combination of the first two strategies. I had to create a while loop that stated while 
the first randomly generated line and the second generated line equaled each other, one of the lines would have 
to be a new generated integer. Then, I created a conditional statement that said if the first line was smaller 
than the second line to return the first line, and otherwise to return the second line. 

Then I created an update state method in checkout agent that would update the landscape. 
It looped through the customers in the queue and incremented the time and called the giveUpItem method 
on the Customer in the front of the queue until it had zero items, and then moved that customer from the 
queue and added it to the list of finished customers. I also created an updateCheckouts method in the landscape 
class that looped through all of the checkout agents and called update state. I then made simulations for each of 
the classes to test if them. I also made a printFinishedCustomerStatistics() method and added it to the landscape 
which computed and printed the average and standard deviation of the time to leave for all of the Customers in the
finished customer list. 

I found that running the simulations with a range of 1-10 items per customer was too big of a range because 
the lines would become unmanageable. I found that any number less than or equal to 7 seemed to be manageable 
so the lines would not get too long. My statistics, which are shown below, and include a new type of customer 
that chose a line based on the number of items in the line, which took a very long time. The customer with the 
fastest time seemed to be the Pick 2 Customer, following with Random, then Picky, and then the customer that 
I called "Large Customer." These results make sense, as it takes more time steps for a customer to pick the 
shortest line because they have to review all of the lines before choosing one. The random one took the shortest 
amount of time for choosing, but ultimately took longer because there was a high risk of being in a longer line. 
The Pick 2 customer was very efficient because it used a combination of Random and Picky, taking only two time steps 
to choose a line and then picking the shortest one out of those two. 
