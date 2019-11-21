/**
 * File: PickyCustomer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */

import java.util.Random; 
import java.util.ArrayList; 

public class PickyCustomer extends Customer
{

	//constructor that calls super class's constructor 
	public PickyCustomer(int numitems, int num_lines)
	{
		super(numitems, num_lines); 

	}
	//returns the index of the checkout agent with the shortest line
	public int chooseLine(ArrayList<CheckoutAgent>checkouts)
	{
		int currentMin = Integer.MAX_VALUE; 
		int currentMinIdx = 0; 
		for( int i = 0; i <checkouts.size(); i++)
		{
			//sets the minimum number to the number in queue if that number is less than 
			//the current minimum
			if (checkouts.get(i).getNumInQueue() < currentMin)
			{
				currentMin = checkouts.get(i).getNumInQueue();
				currentMinIdx = i;  
			}
		}	
		return currentMinIdx; 
	}
}