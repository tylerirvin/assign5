package csc322assignment5;

import java.util.Scanner;

public class CSC322Assignment5
{
    IBag<String> bag;                             /* Generic bag, as yet the type is to be determined */
    
    public static void main(String[] args)
    {
        CSC322Assignment5 assign = new CSC322Assignment5();      /* Need to use a non-static run so creating an instance */
        assign.run();
    }   /* End main method */
    
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        
        while (true)                                                                  /* Determine bag type loop. User must enter sorted or unsorted to escape */
        {
            System.out.print("Which type of bag do you want? (sorted/unsorted) ");
            String bagType = sc.nextLine();
        
            if (bagType.equalsIgnoreCase("sorted"))
            {
                bag = new SortedBag();                                                /* Set the bag type to Sorted and initialize */
                break;
            }
            else if (bagType.equalsIgnoreCase("unsorted"))
            {
                bag = new UnsortedBag();                                              /* Set the bag type to Unsorted and initialize */
                break;
            }
        }
        
        int bagSize;                           /* Bag size */
        
        while (true)                           /* Loop to get a positive integer for the bag size. The try statement catches non-integers and the if/else only allows the loop to break if the input is positive */
        {
            try
            {
                System.out.print("How many items to put in the bag? ");
                bagSize = Integer.parseInt(sc.nextLine());
                if (bagSize > 0)
                    break;
                else
                    System.out.println("Positive numbers only, please.");
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Integers only, please.");
            }
        }
        
        System.out.println();
        
        for (int i = 0; i < bagSize; i++)                      /* Add items to the bag. The individual classes determine how that is accomplished specifically. Note that this is setting all of the bags to contain String objects as that's what's being passed. However, other methods of passing in would allow any Comparable Object to be used */
        {
            System.out.print("Enter item " + (i+1) + ": ");
            bag.add(sc.nextLine());
        }
        
        System.out.println("\nYou can check if something is in the bag.");
        
        while(true)                                                   /* While loop for checking content. User may break if they enter "done" */
        {
            System.out.print("Check for (type done to stop): ");
            String item = sc.nextLine();
            if (item.equalsIgnoreCase("done"))
                break;
            else
            {
                if (bag.contains(item))                                   /* Check the bag for the item (each class determines how exactly). Print out the result */
                    System.out.println("Yes, it's in the bag.\n");
                else
                    System.out.println("No, it's not in the bag.\n");
            }
        }
        
        System.out.println("\nLet's remove stuff from the bag:");
        
        while (!bag.empty())                                         /* Continue until nothing is left in the bag */
        {
            Object o = bag.remove();                                 /* Remove the object (class detemines how/which) and save it */
            System.out.println("Removing item: " + o.toString());    /* Print the resulting object. NOTE: as mentioned, this program ensures all entities in the bag are Strings. Casting and/or toString may be necessary if other Comparable Objects are used for the bag's contents */
        }
    }   /* End run method */
}   /* End CSC322Assignment5 class */