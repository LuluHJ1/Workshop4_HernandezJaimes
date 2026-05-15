package org.example;

import java.math.BigDecimal;

public class SalesContract extends Contract {

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);


    }

    @Override
    public BigDecimal getTotalPrice() {
       BigDecimal tax =
        return totalPrice;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal monthlyPayment = new BigDecimal("450.00");
        return monthlyPayment;
    }
}
