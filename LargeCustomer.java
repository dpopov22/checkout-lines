
/**
 * File: LargeCustomer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Random; 
import java.util.ArrayList; 
public class LargeCustomer extends Customer
{
	//constructor that calls super class's constructor 
	public LargeCustomer( int num_items, int time_steps )
	{
		super(num_items, time_steps);
		
	}
	
	//choose line method that has the customer choose a line based on the number 
	//of items in each line instead of the number of customers in each line 
	public int chooseLine(ArrayList<CheckoutAgent>checkouts)
	{
		int currentMin = Integer.MAX_VALUE; 
		int currentMinIdx = 0;
		//loops through the size of the checkout 
		for( int i = 0; i <checkouts.size(); i++)
		{
			int numItems = 0; 
			//loops through the number of customers and adds the number of items to 
			//a variable getNumItems
			for (Customer c: checkouts.get(i).getCustomers())
			{
				numItems += c.getNumItems(); 
				
				
			}
			//if the number of items is less than the current minimum number of items, 
			//the current minimum number is set to that number 
			if (numItems < currentMin)
			{
				currentMin = numItems;
				currentMinIdx = i;  
			}
		}	
		return currentMinIdx; 
	}
}