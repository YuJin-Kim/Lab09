package edu.handong.csee.java.salesreport;

/**
 * 
 * This class define SalesAssociate object. </br>
 * The SalesAssociate class has name and sales members.</br>
 * The SalesAssociate class has setName(), setSales(), getName() and getSales() methods.</br>
 * 
 * @author YuJin
 *
 */

public class SalesAssociate {

	String name; // create String member name
	double sales; // create double member sales
	
	/**
	 * This method is setting name method with one parameter, name</br>
	 * @param name
	 */
	
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * This method is setting sales method with one parameter, sales</br>
	 * @param sales
	 */
	
	public void setSales(double sales) {
		this.sales=sales;
	}
	
	/**
	 * This method is getting name method with return value, name</br>
	 * @return
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * This method is getting sales method with return value, sales</br>
	 * @return
	 */
	
	public double getSales() {
		return sales;
	}
}
