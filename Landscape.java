/**
 * File: Landscape.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.ArrayList; 
import java.awt.Graphics; 
public class Landscape
{
	private int width; 
	private int height; 
	private ArrayList<CheckoutAgent> checkouts; 
	private LinkedList<Customer> finished_p2; 
	private LinkedList<Customer> finished_picky; 
	private LinkedList<Customer> finished_random; 
	private LinkedList<Customer> finished_large; 
	
	

	//constructor that has width hight, and checkouts array list parameters
	//initializes linked lists for each type of customer for a mixed simulation
	public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts )
	{
		width = w; 
		height = h; 
		this.checkouts = checkouts; 
		this.finished_p2 = new LinkedList<Customer>(); 
		this.finished_picky = new LinkedList<Customer>(); 
		this.finished_random = new LinkedList<Customer>(); 
		this.finished_large = new LinkedList<Customer>();

	} 
	
	//returns the height of the landscape
	public int getHeight()
	{
		return height; 
	} 
	
	//returns the width of the landscape
	public int getWidth()
	{
		return width; 
	}
	//to string method that returns the number of checkouts and finished customers 
// 	public String toString()
// 	{
// 		String s = ""; 
// 		s = "checkouts" + checkouts; 
// 		s = "finished customers" + finishedCustomers; 
// 		return s; 
// 	} 

	/**
	/adds customers to different linked lists of finished customers depending on their 
	//type
	*/
	public void addFinishedCustomer(Customer c )
	{
		if (c instanceof PickyCustomer)
		{
		finished_picky.addFirst(c);
		}
		if (c instanceof Pick2Customer)
		{
		finished_p2.addFirst(c);
		}
		if (c instanceof RandomCustomer)
		{
		finished_random.addFirst(c);	
		}
		if (c instanceof LargeCustomer)
		{
		finished_large.addFirst(c);
		}
	} 
	

	/**
	/Private method for printing the statistics with a parameter for the type of 
	//linked list, which allows for different types of customers to have statistics
	//printed out
	*/
	private void printFinishedCustomerStatistics( LinkedList<Customer> finished)
	{
		double standDev =0;
		double mean =0;
		
		double sum = 0.0; 
			for(Customer c: finished)
			{
				sum += c.getTime();
			}
			if (finished.size() > 0)
			{
			System.out.println("The average is:" + String.format( "%.2f",sum/finished.size()));
			}
		double average = sum/finished.size(); 
		
		double addSquareDiff = 0.0; 
		for (Customer c: finished)
		{
			addSquareDiff += Math.pow((c.getTime() - average), 2); 	
		}
		if (finished.size() >0)
		{
			mean = addSquareDiff/finished.size(); 
		}
		standDev = Math.sqrt(mean); 
		System.out.println("The stand dev:" + String.format("%.2f", standDev)); 
	}
	//Public method for printing statistics out that calls the private method for 
	//each type of possible customer and prints the stats out for each type
	public void printFinishedCustomerStatistics()
	{
		
		if(finished_picky.size() > 0)
		{
			System.out.println("Picky Stats"); 
			printFinishedCustomerStatistics(finished_picky); 	
		}
		if (finished_p2.size() > 0)
		{
			System.out.println("Pick 2 Stats");
			printFinishedCustomerStatistics(finished_p2); 
		}
		if (finished_random.size() > 0)
		{
			System.out.println("Random Stats");
			printFinishedCustomerStatistics(finished_random); 	
		}
		if (finished_large.size() > 0)
		{
			System.out.println("Large Customer Stats");
			printFinishedCustomerStatistics(finished_large); 	
		}
		
	}
		

	//loops through all of the checkout agents and calls update state on them with the given
	//landscape
	public void updateCheckouts()
	{
		for(CheckoutAgent c: checkouts)
		{
			c.updateState(this); 
		}
	}
	//draws all of the checkout agents 
	public void draw( Graphics g )
	{
		for(CheckoutAgent c: checkouts)
		{
			c.draw(g); 
		}
	}
}