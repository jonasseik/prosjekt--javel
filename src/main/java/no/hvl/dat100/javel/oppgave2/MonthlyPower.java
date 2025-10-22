package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    public static void print_PowerUsage(double[][] usage) {
        for (int day = 0; day < usage.length; day++) {
            System.out.printf("Day %d:", day + 1);
            DailyPower.printPowerUsage(usage[day]);
        }
    }

    public static void print_PowerPrices(double[][] prices) {
        for (int day = 0; day < prices.length; day++) {
            System.out.printf("Day %d:", day + 1);
            DailyPower.printPowerPrices(prices[day]);
        }
    }

    public static double computePowerUsage(double[][] usage) {
        double totalMonthlyUsage = 0;
        
        for (double[] dailyUsage : usage) {
            totalMonthlyUsage += DailyPower.computePowerUsage(dailyUsage);
        }

        return totalMonthlyUsage;
    }

    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        double currentUsage = 0;
        int day = 0;
        
        while (day < powerusage.length) {
            currentUsage += DailyPower.computePowerUsage(powerusage[day]);
            
            if (currentUsage > threshold) {
                return true;
            }
            day++;
        }
        
        return false;
    }

    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        double totalSpotPrice = 0;
        
        if (usage.length != prices.length) {
            throw new IllegalArgumentException("Usage and prices arrays must have the same number of days.");
        }

        for (int day = 0; day < usage.length; day++) {
            totalSpotPrice += DailyPower.computeSpotPrice(usage[day], prices[day]);
        }

        return totalSpotPrice;
    }

    public static double computePowerSupport(double[][] usage, double[][] prices) {
        double totalSupport = 0;
        
        if (usage.length != prices.length) {
            throw new IllegalArgumentException("Usage and prices arrays must have the same number of days.");
        }

        for (int day = 0; day < usage.length; day++) {
            totalSupport += DailyPower.computePowerSupport(usage[day], prices[day]);
        }

        return totalSupport;
    }

    public static double computeNorgesPrice(double[][] usage) {
        double totalNorgesPrice = 0;

        for (double[] dailyUsage : usage) {
            totalNorgesPrice += DailyPower.computeNorgesPrice(dailyUsage);
        }

        return totalNorgesPrice;
    }
}