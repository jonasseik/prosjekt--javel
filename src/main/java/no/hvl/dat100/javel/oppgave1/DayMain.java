package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        double[] powerusage_day = DayPowerData.powerusage_day;
        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1 TESTER");
        System.out.println("==============");
        System.out.println();

        System.out.println("a) Strømpriser (NOK):");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println();

        System.out.println("b) Strømforbruk (kWh):");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println();

        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.printf("c) Totalt Forbruk: %.2f kWh\n", totalUsage);
        System.out.println();

        double spotPriceCost = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("d) Spotpriskostnad (uten støtte): %.2f NOK\n", spotPriceCost);
        
        double totalSupport = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("f) Total Strømstøtte: %.2f NOK\n", totalSupport);
        
        double finalSpotPrice = spotPriceCost - totalSupport;
        System.out.printf("   Spotpriskostnad (med støtte): %.2f NOK\n", finalSpotPrice);
        System.out.println();

        double norgesPriceCost = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("g) Norgespriskostnad: %.2f NOK\n", norgesPriceCost);
        System.out.println();

        double peakUsage = DailyPower.findPeakUsage(powerusage_day);
        System.out.printf("h) Størst Forbruk (Peak Usage): %.2f kWh\n", peakUsage);
        System.out.println();

        double avgUsage = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("i) Gjennomsnittlig Forbruk: %.2f kWh/time\n", avgUsage);
    }
}