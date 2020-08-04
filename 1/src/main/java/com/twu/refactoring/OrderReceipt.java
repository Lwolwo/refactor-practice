package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printOrderInfo() {
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append(order.getCustomerName());
    	stringBuffer.append(order.getCustomerAddress());
    	return stringBuffer.toString();
	}

	public String printLineItems() {
    	StringBuffer output = new StringBuffer();
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription()).append('\t');
			output.append(lineItem.getPrice()).append('\t');
			output.append(lineItem.getQuantity()).append('\t');
			output.append(lineItem.totalAmount()).append('\n');

			// calculate sales tax @ rate of 10%
			double salesTax = lineItem.totalAmount() * .10;
			totSalesTx += salesTax;

			// calculate total amount of lineItem = price * quantity + 10 % sales tax
			tot += lineItem.totalAmount() + salesTax;
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totSalesTx);

		// print total amount
		output.append("Total Amount").append('\t').append(tot);
		return output.toString();
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

        output.append(printOrderInfo());

		// prints lineItems
		output.append(printLineItems());

		return output.toString();
	}


}