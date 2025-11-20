/*
 * Name: Jessie Sosniak
 * Date: 20 NOV 2025
 * Assignment: 2.2 Project
 * Description: Derived class representing business contacts, extending Contact and
 * implementing additional verification rules.
 */

public class BusinessContact extends Contact {
    private String companyName;

    public BusinessContact(String firstName, String lastName, String phone, String email,
                           String streetAddress, String city, String state, String zipCode,
                           String companyName) {
        super(firstName, lastName, phone, email, streetAddress, city, state, zipCode);
        this.companyName = companyName;
    }

    @Override
    public void displayContact() {
        super.displayContact();
        System.out.println("Relation: Work");
        System.out.println("Company: " + companyName);
    }

    @Override
    public boolean isVerified() {
        // Demonstrates polymorphism: overrides interface method with specialized rules
        return super.isVerified() && companyName != null && !companyName.isEmpty();
    }
}