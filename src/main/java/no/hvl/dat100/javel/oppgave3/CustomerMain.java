package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        /*
            Oppgave e)
        */

        // 1. Opprett et nytt Customer-objekt
        System.out.println("--- 1. Oppretter kundeobjekt ---");
        Customer kunde1 = new Customer(
            "Alice Smith", 
            "alice@example.com", 
            1001, 
            PowerAgreementType.SPOTPRICE
        );
        
        // 2. Test toString()-metoden ved å skrive ut oobjektet
        System.out.println("Utskrift av kundeobjektet (toString-test):");
        System.out.println(kunde1);
        System.out.println();

        // 3. Test Get-metodene
        System.out.println("--- 3. Testing av Get-metoder ---");
        System.out.println("ID: " + kunde1.getCustomer_id());
        System.out.println("Avtale: " + kunde1.getAgreement());
        System.out.println();
        
        // 4. Test Set-metodene (Oppdaterer data)
        System.out.println("--- 4. Testing av Set-metoder (Oppdatering) ---");
        
        // Simuler at kunden bytter avtale
        kunde1.setAgreement(PowerAgreementType.POWERSUPPORT);
        // Simuler at e-posten oppdateres
        kunde1.setEmail("alice.smith.ny@example.com");
        
        System.out.println("Kunden har nå ny avtale: " + kunde1.getAgreement());
        System.out.println("Kunden har nå ny e-post: " + kunde1.getEmail());
        System.out.println();

        // 5. Verifiser endringene med toString()
        System.out.println("--- 5. Verifiserer endringer med toString() ---");
        System.out.println(kunde1);
    }
}

