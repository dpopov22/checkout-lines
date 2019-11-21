/**
 * File: MixedSimulation.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Random;
import java.util.ArrayList;

//Allows for a mixed simulation of different customer types 
public class MixedSimulation {
	//main method
    public static void main(String[] args) throws InterruptedException {
        Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);
		
		//loops through number of checkout agents 
        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
            
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        //determines the number of customers and iterations, and type of customer
        //by creating a random number between 0 and 1
        for (int j = 0; j < 1000; j++) {
        	double rand = gen.nextDouble(); 
        	Customer cust; 
        	
        	//if the random number is less than .3, the random customer simulation occurs
        	if (rand <.2)
        	{
        	cust = new RandomCustomer(1+gen.nextInt(5));	
        	}
        	//if the number is between .3 and .6, the picky customer simulation occurs
        	else if (rand >= .2 && rand <.5)
        	{
        	cust = new PickyCustomer(1+gen.nextInt(5), 5);	
        	}
        	//otherwise, the pick 2 customer simulation occurs
        	else if (rand >= .5 && rand <.7)
        	{
        	cust = new Pick2Customer(1+gen.nextInt(5));
        	}
        	else
        	{
        	cust = new LargeCustomer(1+gen.nextInt(5), 10); 
        	}
           
            int choice = cust.chooseLine( checkouts );
            checkouts.get(choice).addCustomerToQueue( cust );
            scape.updateCheckouts(); 
            display.repaint();
            //prints statistics for every 100 time steps
            if (j%100 ==0)
            {
            	 scape.printFinishedCustomerStatistics(); 
            }
            Thread.sleep( 20 );
        }

    }

}