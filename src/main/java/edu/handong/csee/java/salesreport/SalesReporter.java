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
	private double highestSales;
	private double averageSales=0;
	private int highestSalesIndex;
	private SalesAssociate[] team;
	private int numberOfAssociates; // same as team length
	
	public void getData() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter number of sales associates:");
		numberOfAssociates=keyboard.nextInt();
		
		team = new SalesAssociate [numberOfAssociates];
		
		for (int count=0; count < team.length; count++) {
			team[count] = new SalesAssociate();
			keyboard.nextLine();
			System.out.println("Enter data for associate number "+(count+1));
			System.out.print("Enter name of sales associate: ");
			team[count].name=keyboard.nextLine();
			System.out.print("Enter associate's sales: $");
			team[count].sales=keyboard.nextDouble();
		}
	}
	
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
	
	public void displayResults() {
		System.out.println("Average sales per associate is $"+averageSales);
		System.out.println("The highest sales figure is $"+highestSales);
		System.out.println("The following had the highest sales:");
		System.out.println("Name: "+team[highestSalesIndex].name);
		System.out.println("Sales: $"+team[highestSalesIndex].sales);
		System.out.println("$"+(team[highestSalesIndex].sales-averageSales)+" above the average.");
		System.out.println("The rest performed as follows:");
		for(int count=0; count<team.length; count++) {
			if (count==highestSalesIndex)
				continue;
			else {
					System.out.println("Name: "+team[count].name);
					System.out.println("Sales: $"+team[count].sales);
					if (team[count].sales>averageSales)
						System.out.println("$"+(team[count].sales-averageSales)+" above the average.");
					else
						System.out.println("$"+(averageSales-team[count].sales)+" below the average.");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesReporter salesAssociates = new SalesReporter();

		salesAssociates.getData();
		salesAssociates.computeStats();
		salesAssociates.displayResults();
	}

}
