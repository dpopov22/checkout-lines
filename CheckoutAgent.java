/**
 * File: CheckoutAgent.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.awt.Graphics; 
import java.awt.Color; 
import java.util.Random; 
import java.util.ArrayList; 

public class CheckoutAgent
{
	private int xposition; 
	private int yposition; 
	private MyQueue<Customer>customers; 
	private ArrayList<Color> color; 
	private Color[] colorScheme; 
	private int colID; 


	//constructor that initializes the x and y positions, the queue of customers, 
	//and the color objects, along with the color id
	public CheckoutAgent(int x, int y) 
	{
		xposition = x; 
		yposition = y; 
		this.customers = new MyQueue<Customer>();
		this.color = new ArrayList<Color>(); 
		this.colorScheme = new Color[4]; 
		colorScheme[0] = new Color(0, 0, 0); 
		colorScheme[1] = new Color(255, 0, 0); 
		colorScheme[2] = new Color(0, 255, 0); 
		colorScheme[3] = new Color(0, 0, 255); 
		this.colID = 0; 
		
	}
	
	
	
 	/**
 	*Updates the state for each time step
 	*/
	public void updateState( Landscape scape)
	{
		//loops through the customers in its queue, calling incrementTime
		for (Customer c: customers)
		{
			c.incrementTime(); 
		} 
		//examines the customer at the front of the queue and determines if there is 
		//any more to do 
		if (customers.peek() == null)
		{
			return; 
		}
		//has the customer give up an item
		customers.peek().giveUpItem(); 
		//if number of items is zero, adds the customer to the list of finished customers
		if (customers.peek().getNumItems() == 0)
		{
			scape.addFinishedCustomer(customers.poll()); 
			color.remove(0); 
		}
		

	}
	//returns the customers
	public MyQueue<Customer> getCustomers()
	{
		return this.customers; 
	}
	
	//adds a customer to the queue, while simultaneously adding a color
	public void addCustomerToQueue( Customer c )
	{
		customers.offer(c); 
		color.add(this.nextColor()); 
	}
	//returns the size of the queue
	public int getNumInQueue()
	{
		return customers.size(); 
	} 
	//sets the next color for the customers in the queue
	public Color nextColor()
	{
		Color c = this.colorScheme[colID]; 
		this.colID++; 
		//resets the ID for the color if it is greater than or equal to 4, as that means
		//it has gone through the list of colors 
		if (colID >= 4)
		{
			colID = 0; 
		}
		return c; 
	}
	/**
	/draws the customers as individual customers, varying their size based on the number
	/of items that they have 
	*/
	public void draw(Graphics g) 
	{
		int n = getNumInQueue(); 

		int totalHeight = 0; 
		int idx = 0; 
	 	// g.drawRect(xposition, yposition -10*n, 10, 10*n); 	
	 	for (Customer c: customers)
		{

			g.setColor(this.color.get(idx)); 
			idx++; 
			int currHeight = c.getNumItems()*10; 
			totalHeight += currHeight; 
			g.fillRect(xposition, yposition-totalHeight, 10, currHeight); 
 	
		} 
	}
	
	
}
