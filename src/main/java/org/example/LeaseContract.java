package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract{


    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);

    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal vehiclePrice = getVehicleSold().getPrice();
        BigDecimal expectedEndingValue = vehiclePrice.multiply(new BigDecimal("0.50"));
        BigDecimal leaseFee = vehiclePrice.multiply(new BigDecimal("0.07"));

        return expectedEndingValue.add(leaseFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        BigDecimal price = getVehicleSold().getPrice();

        BigDecimal annualRate = new BigDecimal("0.04");
        int months = 36;

        double r = annualRate.divide(new BigDecimal("12.0"), 10 , RoundingMode.HALF_UP).doubleValue();

        double p = price.doubleValue();

        double payment = p * (r * Math.pow(1 + r, months)) / (Math.pow(1 + r, months) - 1);

        return BigDecimal.valueOf(payment).setScale(2,RoundingMode.HALF_UP);
    }
}

