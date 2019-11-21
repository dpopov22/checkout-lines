/**
 * File: Pick2Customer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Random; 
/**
 * File: Pick2Customer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.ArrayList; 
public class Pick2Customer extends Customer
{

	//constructor that calls the super class's constructor 
	public Pick2Customer( int num_items)
	{
		super(num_items, 2); 
	}
	//has the customer choose a line based on one of two shorter lines 
	public int chooseLine(ArrayList<CheckoutAgent> checkouts) 
	{

		Random rand = new Random(); 
		int rand1 = rand.nextInt(checkouts.size()); 
		int rand2 = rand.nextInt(checkouts.size()); 
		//if the lines are the same, one line has to be assigned to a new line
		while(rand1 == rand2)
		{
			rand1 = rand.nextInt(checkouts.size()); 
		}
		//returns the first line if it is less than the second line 
		if (checkouts.get(rand1).getNumInQueue() < checkouts.get(rand2).getNumInQueue())
		{
			return rand1;
		}
		
		//returns the second line if it is less than the first one
		else
		{
			return rand2 ; 
		}
	

			
	}




}