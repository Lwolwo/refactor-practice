package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuffer result = new StringBuffer("Rental Record for " + getName() + "\n");

		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			thisAmount += each.getThisAmount();
			frequentRenterPoints += each.getFrequentRenterPointsIncrements();

			// show figures for this rental
			result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
			totalAmount += thisAmount;
		}


		// add footer lines
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

}
