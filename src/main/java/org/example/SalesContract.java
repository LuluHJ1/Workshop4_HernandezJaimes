package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {

    private boolean finance;
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);

        this.finance = finance;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal vehiclePrice = getVehicleSold().getPrice();

       BigDecimal salesTax = vehiclePrice.multiply(new BigDecimal("0.05"));
       BigDecimal recordingFee = new BigDecimal("100.00");
       BigDecimal processingFee;

       if(vehiclePrice.compareTo(new BigDecimal("10_000.00")) < 0) {
           processingFee = new BigDecimal("295.00");
       }
       else {
           processingFee = new BigDecimal("495.00");

       }
        return vehiclePrice.add(salesTax).add(recordingFee).add(processingFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if(!finance){
            return BigDecimal.ZERO;
        }
        BigDecimal totalPrice = getTotalPrice();
        BigDecimal annualRate;
        int months;

        if(totalPrice.compareTo(new BigDecimal("10000.00")) >= 0) {
            annualRate = new BigDecimal("0.0425");
            months = 48;
        }else {
            annualRate = new BigDecimal("0.0525");
            months = 24;
        }
        BigDecimal monthlyRate = annualRate.divide(new BigDecimal("12.0"), 10, RoundingMode.HALF_UP);
        double loanAmount = totalPrice.doubleValue();
        double rate = monthlyRate.doubleValue();

        double payment =
                loanAmount *
                        (rate * Math.pow(1 + rate , months)) /
                        (Math.pow (1 + rate, months) - 1);

        return BigDecimal.valueOf(payment)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
