package edu.handong.csee.java.salesreport;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales=0;
	private int highestSalesIndex;
	private SalesAssociate[] team;
	private int numberOfAssociates; // same as team length
	
	public void getData(SalesReporter salesAssociates) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter number of sales associates:");
		salesAssociates.numberOfAssociates=keyboard.nextInt();
		
		team = new SalesAssociate [salesAssociates.numberOfAssociates];
		
		for (int count=0; count < team.length; count++) {
			System.out.println("Enter data for associate number "+(count+1));
			System.out.print("Enter name of sales associate: ");
			team[count].name=keyboard.next();
			System.out.print("Enter associate's sales: $");
			team[count].sales=keyboard.nextDouble();
		}
	}
	
	public void computeStats(SalesReporter salesAssociates) {
		
		salesAssociates.highestSales=team[0].sales;
		
		for (int count=1; count<team.length; count++)
			if (salesAssociates.highestSales<team[count].sales) {
				salesAssociates.highestSales=team[count].sales;
				salesAssociates.highestSalesIndex=count;
			}
		
		for(int count=0; count<team.length; count++)
			salesAssociates.averageSales+=team[count].sales;
		
		salesAssociates.averageSales=salesAssociates.averageSales/3.0;
	}
	
	public void displayResults(SalesReporter salesAssociates) {
		System.out.println("Average sales per associate is $"+salesAssociates.averageSales);
		System.out.println("The highest sales figure is $"+salesAssociates.highestSales);
		System.out.println("The following had the highest sales:");
		System.out.println("Name: "+team[salesAssociates.highestSalesIndex].name);
		System.out.println("Sales: $"+team[salesAssociates.highestSalesIndex].sales);
		System.out.println("$"+"below the average.");
		System.out.println("The rest performed as follows:");
		for(int count=0; count<team.length; count++) {
			if (count==salesAssociates.highestSalesIndex)
				continue;
			else {
				System.out.println("Name: "+team[salesAssociates.highestSalesIndex].name);
				System.out.println("Sales: $"+team[salesAssociates.highestSalesIndex].sales);
				System.out.println("$"+"below the average.");
			}
		}
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesReporter salesAssociates = new SalesReporter();

		getData(salesAssociates);
		computeStats(salesAssociates);
		displayResults(salesAssociates);
	}

}
