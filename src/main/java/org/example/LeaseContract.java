package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract{

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("1800.00");
        return totalPrice;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal monthlyPayment = new BigDecimal("350.00");
        return monthlyPayment;
    }
}

