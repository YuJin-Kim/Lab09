package edu.handong.csee.java.salesreport;

import java.util.Scanner;

/**
 * This class define SalesReporter object. </br>
 * The SalesReporter class has five members.</br>
 * => highestSales, averageSales, highestSalesIndex, team and numberOfAssociates</br>
 * The SalesReporter class has getData(), computeStats() and displayResults() methods.</br>
 * 
 * @author YuJin
 *
 */

public class SalesReporter {
	private double highestSales; // create private double member highestSales
	private double averageSales=0; // create private double member averageSales and initialize zero
	private int highestSalesIndex; // create private int member highestSalesIndex
	private SalesAssociate[] team; // create private SalesAssociate class array member team
	private int numberOfAssociates; // create private int numberOfAssociates, same as team length
	
	/**
	 * This method is getting data method</br>
	 * 
	 */
	
	public void getData() {
		Scanner keyboard = new Scanner(System.in); // for scanner
		
		System.out.println("Enter number of sales associates:"); // print out ""
		numberOfAssociates=keyboard.nextInt(); // input int type variable numberOfAssociates by keyboard
		
		team = new SalesAssociate [numberOfAssociates]; // 
		
		for (int count=0; count < team.length; count++) {
			team[count] = new SalesAssociate(); // create SalesAssociate object 'team'array that has size
			keyboard.nextLine();
			System.out.println("Enter data for associate number "+(count+1));
			System.out.print("Enter name of sales associate: ");
			team[count].name=keyboard.nextLine();
			System.out.print("Enter associate's sales: $");
			team[count].sales=keyboard.nextDouble();
		}
	}
	
	/**
	 * This method is computing status method</br>
	 * This method is calculating highestSales and averageSales</br>
	 * 
	 */
	
	public void computeStats() {
		
		highestSales=team[0].sales;
		
		for (int count=1; count<team.length; count++)
			if (highestSales<team[count].sales) {
				highestSales=team[count].sales;
				highestSalesIndex=count;
			}
		
		for(int count=0; count<team.length; count++)
			averageSales+=team[count].sales;
		
		averageSales=averageSales/3.0;
	}
	
	/**
	 * This method is displaying result of status method</br>
	 * 
	 */
	
	public void displayResults() {
		System.out.println("Average sales per associate is $"+averageSales); // print out ""
		System.out.println("The highest sales figure is $"+highestSales); // print out ""
		System.out.println("The following had the highest sales:"); // print out ""
		System.out.println("Name: "+team[highestSalesIndex].name); // print out ""
		System.out.println("Sales: $"+team[highestSalesIndex].sales); // print out ""
		System.out.println("$"+(team[highestSalesIndex].sales-averageSales)+" above the average."); // print out ""
		System.out.println("The rest performed as follows:"); // print out ""
		for(int count=0; count<team.length; count++) {
			if (count==highestSalesIndex)
				continue;
			else {
					System.out.println("Name: "+team[count].name); // print out ""
					System.out.println("Sales: $"+team[count].sales); // print out ""
					if (team[count].sales>averageSales)
						System.out.println("$"+(team[count].sales-averageSales)+" above the average."); // print out ""
					else
						System.out.println("$"+(averageSales-team[count].sales)+" below the average."); // print out ""
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesReporter salesAssociates = new SalesReporter(); // create SalesReporter object 'salesAssociates

		salesAssociates.getData(); // execute salesAssociates.getData() method
		salesAssociates.computeStats(); // execute salesAssociates.computeStats() method
		salesAssociates.displayResults(); // execute salesAssociates.displayResults() method
	}

}
