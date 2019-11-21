/**
 * File: RandomCustomer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Random; 
import java.util.ArrayList; 
public class RandomCustomer extends Customer
{
	//constructor that calls super class's constructor 
	public RandomCustomer( int num_items )
	{
		super(num_items, 1);
		
	}
	//randomly chooses a line
	public int chooseLine(ArrayList checkouts)
	{
		Random rand = new Random(); 
		return (rand.nextInt(checkouts.size())); 
	}

}