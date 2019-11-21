/**
 * File: Customer.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.ArrayList; 

public abstract class Customer 
{
	private int num_items; 
	private int time_steps; 
	public int xposition; 
	public int yposition; 

	//constructor with a number of items parameter
	public Customer(int num_items)
	{
		this.num_items = num_items; 
		this.time_steps = 0; 
		
	} 
	//constructor with a number of items and time steps parameter
	public Customer(int num_items, int time_steps) 
	{
		this.num_items = num_items; 
		this.time_steps = time_steps; 
	}
	//constructor with a number of items, time step, and position parameter 
	public Customer(int num_items, int time_steps, int x, int y) 
	{
		this.num_items = num_items; 
		this.time_steps = time_steps; 
		xposition = x; 
		yposition = y; 
	}
	//increments the time 
	public void incrementTime() 
	{
		this.time_steps++; 
	}
	//gets the number of time steps
	public int getTime()
	{
		return this.time_steps; 
	} 
	//decrements the number of items
	public void giveUpItem()
	{
		this.num_items--; 
	}
	//returns the number of items 
	public int getNumItems()
	{
		return this.num_items; 
	} 
	//abstract method for choosing a line
	public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts); 	
	
}



