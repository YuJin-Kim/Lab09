package edu.handong.csee.java.salesreport; // package

import java.util.ArrayList; // For using ArrayList
import java.util.Scanner; // For using Scanner

/**
 * This class define SalesReporter object. </br>
 * The SalesReporter class has four members.</br>
 * => highestSales, averageSales, highestSalesIndex and team</br>
 * The SalesReporter class has getData(), computeStats() and displayResults() methods.</br>
 * 
 * @author YuJin
 *
 */

public class SalesReporter {
	private double highestSales; // create private double member highestSales
	private double averageSales=0; // create private double member averageSales and initialize zero
	private int highestSalesIndex; // create private int member highestSalesIndex
	private ArrayList<SalesAssociate> team; // create private SalesAssociate class arrayList member team
	
	/**
	 * This method is getting data method</br>
	 * 
	 */
	
	public void getData() { // for getting data method
		
		Scanner keyboard = new Scanner(System.in); // for scanner
		team = new ArrayList<SalesAssociate>(); // ready to use ArrayList team
		boolean answer = false; // create boolean type variable 'answer' and initialize false
		int count=1; // create int type variable 'count' and initialize one
		
		while (!answer) { // repeat size of team(number of associates) times this for loop
			SalesAssociate s = new SalesAssociate(); // create SalesAssociate object 's'
			
			System.out.println("Enter data for associate number "+count); // print out ""
			System.out.print("Enter name of sales associate: "); // print out ""
			s.name=keyboard.nextLine(); // input String type variable s.name by keyboard
			System.out.print("Enter associate's sales: $"); // print out ""
			s.sales=keyboard.nextDouble(); // input double type variable s.sales by keyboard
			team.add(s); // add a to ArrayList team
			System.out.print ("More sales associates for the list? "); // print out ""
			String ans = keyboard.next(); // create String type variable 'ans' and input String type variable by keyboard
			if (!ans.equalsIgnoreCase ("yes")) // if ans isn't yes
				answer = true; // put "true" to answer
			count++; // count increase one
            System.out.println(); // new line
            keyboard.nextLine(); // input " " or "\n" and so on
		}
	}
	
	/**
	 * This method is computing status method</br>
	 * This method is calculating highestSales and averageSales</br>
	 * 
	 */
	
	public void computeStats() { // for computing highestSales and averageSales method
		
		SalesAssociate s = new SalesAssociate(); // create SalesAssociate object 's'
		s=team.get(0); // put team's 0th array to s
		averageSales+=s.sales; // add s.sales to averageSales
		highestSales=s.sales; // add s.sales to highestSales
		
		for (int count=1; count<team.size(); count++) { // repeat (size of team-1)times this for loop because set up the highestSales with sales value of team's 0th array
			s=team.get(count); // put team's (count)array to s
			averageSales+=s.sales; // add s.sales to averageSales
			if (highestSales<s.sales) { // if s.sales is bigger than highestSales
				highestSales=s.sales; // put s.sales to highestSales
				highestSalesIndex=count; // put count to highestSalesIndex
			}
		}
		
		averageSales=averageSales/(double)team.size(); // put the value which divide team.size from averageSales to averageSales
	}

	/**
	 * This method is displaying result of status method</br>
	 * 
	 */
	
	public void displayResults() { // display the values of members method
		SalesAssociate s = new SalesAssociate(); // create SalesAssociate object 's'
		s=team.get(highestSalesIndex); // put team's (highestSalesIndex)array to s
		System.out.println("Average sales per associate is $"+averageSales); // print out ""
		System.out.println("The highest sales figure is $"+highestSales); // print out ""
		System.out.println("The following had the highest sales:"); // print out ""
		System.out.println("Name: "+s.name); // print out ""
		System.out.println("Sales: $"+s.sales); // print out ""
		System.out.println("$"+(s.sales-averageSales)+" above the average."); // print out ""
		System.out.println("The rest performed as follows:"); // print out ""
		for(int count=0; count<team.size(); count++) { // repeat size of team times this for loop
			s=team.get(count); // put team's (count)array to s
			if (count==highestSalesIndex) // if value of count equals value of highestSalesIndes
				continue; // pass once
			else { // else
					System.out.println("Name: "+s.name); // print out ""
					System.out.println("Sales: $"+s.sales); // print out ""
					if (s.sales>averageSales) // if s.sales is bigger than averageSales
						System.out.println("$"+(s.sales-averageSales)+" above the average."); // print out ""
					else // else
						System.out.println("$"+(averageSales-s.sales)+" below the average."); // print out ""
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesReporter salesAssociates = new SalesReporter(); // create SalesReporter object 'salesAssociates'

		salesAssociates.getData(); // execute salesAssociates.getData() method
		salesAssociates.computeStats(); // execute salesAssociates.computeStats() method
		salesAssociates.displayResults(); // execute salesAssociates.displayResults() method
	}

}
