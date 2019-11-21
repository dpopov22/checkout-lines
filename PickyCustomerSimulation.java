/**
 * File: PickyCustomerSimulation.java
 * Author: Domnika Popov
 * Date: 03/20/2019
 */
import java.util.Random;
import java.util.ArrayList;

public class PickyCustomerSimulation {
    //creates a new LandscapeDisplay and populates it with checkouts and customers.
    public static void main(String[] args) throws InterruptedException {
        Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

		//loops through number of checkout agents and creates them
        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
            
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        //determines the number of customers, type of customer, and iterations
        for (int j = 0; j < 1000; j++) {
            Customer cust = new PickyCustomer(1+gen.nextInt(4), 4);
            int choice = cust.chooseLine( checkouts );
            checkouts.get(choice).addCustomerToQueue( cust );
            scape.updateCheckouts(); 
            display.repaint();
            //prints customer statistics for every 100 time steps 
            if (j%100 ==0)
            {
            	 scape.printFinishedCustomerStatistics(); 
            }
            Thread.sleep( 20 );
        }

    }

}