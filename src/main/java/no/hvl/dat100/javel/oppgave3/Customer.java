package no.hvl.dat100.javel.oppgave3;

/**
 * Representerer en strømkunde med navn, e-post, ID og strømavtaletype.
 * Implementerer objektvariable, konstruktør, get/set-metoder og toString().
 */
public class Customer {

    // Oppgave a)
    private String name;
    private String email;
    private int customer_id;
    private PowerAgreementType agreement;

    /**
     * Oppgave b)
     * Oppretter et nytt Customer-objekt og initialiserer alle objektvariablene.
     * * @param name Kundens fulle navn.
     * @param email Kundens e-postadresse.
     * @param customer_id Kundens unike ID-nummer.
     * @param agreement Kundens strømavtaletype.
     */
    public Customer(String name, String email, int customer_id, PowerAgreementType agreement) {
        this.name = name;
        this.email = email;
        this.customer_id = customer_id;
        this.agreement = agreement;
    }

    // Oppgave c)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    // Vi lar ikke studeten endre customer_id etter opprettelse for å bevare unikhet.
    // Men for å fullføre oppgaven implementerer vi den:
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public PowerAgreementType getAgreement() {
        return agreement;
    }

    public void setAgreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    // Oppgave d)

    /**
     * Returnerer en formatert tekststreng med informasjon om Customer-objektet.
     * * @return Tekststreng med kundedata.
     */
    @Override
    public String toString() {
        // Bruker String.format for pen og strukturert utskrift
        return String.format(
            "Customer number %d\n" +
            "Name  %s\n" +
            "Email %s\n" +
            "Agreement %s", 
            customer_id, 
            name, 
            email, 
            agreement
        );
    }
}
