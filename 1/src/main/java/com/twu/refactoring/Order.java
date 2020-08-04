package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineList;

    public Order(String customerName, String address, List<LineItem> lineList) {
        this.customerName = customerName;
        this.address = address;
        this.lineList = lineList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineList;
    }
}
