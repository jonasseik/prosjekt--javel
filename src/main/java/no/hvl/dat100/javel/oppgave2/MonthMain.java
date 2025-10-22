package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DayPowerData;

public class MonthMain {
    public static void main(String[] args) {

        double[][] power_prices_month = MonthPowerData.powerprices_month;
        double[][] power_usage_month = MonthPowerData.powerusage_month;
        
        final double GRENSE_HYTTE = 1000.0;
        final double GRENSE_BOLIG = 5000.0;

        System.out.println("===============");
        System.out.println("OPPGAVE 2 TESTER");
        System.out.println("===============");
        System.out.println();

        System.out.println("a) Månedlig strømforbruk (kWh):");
        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println();

        System.out.println("b) Månedlige strømpriser (NOK/kWh):");
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.println();

        double totalUsageMonth = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("c) Totalt Månedlig Forbruk: %.2f kWh\n", totalUsageMonth);
        System.out.println();

        boolean exceededHytte = MonthlyPower.exceedThreshold(power_usage_month, GRENSE_HYTTE);
        boolean exceededBolig = MonthlyPower.exceedThreshold(power_usage_month, GRENSE_BOLIG);
        System.out.printf("d) Overskrider hyttegrense (%.0f kWh): %b\n", GRENSE_HYTTE, exceededHytte);
        System.out.printf("   Overskrider boliggrense (%.0f kWh): %b\n", GRENSE_BOLIG, exceededBolig);
        System.out.println();

        double totalSpotPrice = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("e) Total Spotpriskostnad (uten støtte): %.2f NOK\n", totalSpotPrice);
        System.out.println();

        double totalSupport = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("f) Total Strømstøtte: %.2f NOK\n", totalSupport);
        
        double finalSpotPrice = totalSpotPrice - totalSupport;
        System.out.printf("   Spotpriskostnad (med støtte): %.2f NOK\n", finalSpotPrice);
        System.out.println("===============================");
    }
}