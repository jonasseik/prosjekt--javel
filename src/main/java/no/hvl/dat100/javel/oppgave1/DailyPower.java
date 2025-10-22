package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    public static void printPowerPrices(double[] prices) {

        for (double price : prices) {
            System.out.printf("%.2f NOK ", price);
        }
        System.out.println();
    }

    public static void printPowerUsage(double[] usage) {

        for (double consumption : usage) {
            System.out.printf("%.2f kWh ", consumption);
        }
        System.out.println();
    }

    public static double computePowerUsage(double[] usage) {

        double sum = 0;

        for (double consumption : usage) {
            sum += consumption;
        }

        return sum;
    }

    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;
        
        if (usage.length != prices.length) {
             throw new IllegalArgumentException("Usage and prices arrays must have the same length (24 timer).");
        }

        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * prices[i];
        }

        return price;
    }

    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    private static double getSupport(double usage, double price) {

        double support = 0;

        if (price > THRESHOLD) {
            double supportPerKWh = (price - THRESHOLD) * PERCENTAGE;
            support = supportPerKWh * usage;
        }

        return support;
    }

    public static double computePowerSupport(double[] usage, double[] prices) {

        double support = 0;

        if (usage.length != prices.length) {
             throw new IllegalArgumentException("Usage and prices arrays must have the same length (24 timer).");
        }
        
        for (int i = 0; i < usage.length; i++) {
            support += getSupport(usage[i], prices[i]);
        }

        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    public static double computeNorgesPrice(double[] usage) {

        double price = 0;
        
        double totalUsage = computePowerUsage(usage);
        price = totalUsage * NORGESPRIS_KWH;

        return price;
    }

    public static double findPeakUsage(double[] usage) {

        if (usage == null || usage.length == 0) {
            return 0;
        }

        double temp_max = usage[0];

        for (int i = 1; i < usage.length; i++) {
            if (usage[i] > temp_max) {
                temp_max = usage[i];
            }
        }

        return temp_max;
    }

    public static double findAvgPower(double[] usage) {

        if (usage == null || usage.length == 0) {
            return 0;
        }

        double totalUsage = computePowerUsage(usage);
        double average = totalUsage / usage.length;

        return average;
    }
}