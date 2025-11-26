/*
 * Name: Jessie Sosniak
 * Date: 25 NOV 2025
 * Assignment: 3.2 Project
 * Description: Represents a business contact with additional fields.
 */

public class BusinessContact extends AbstractContact {
    private String companyName;
    private String fax; //optional, can be null
    private boolean workRelated;

    //Constructor
    public BusinessContact(String firstName, String lastName, String phoneNumber, String email,
                           String streetAddress, String city, String state, String zipCode,
                           String companyName, String fax, boolean workRelated) {
        super(firstName, lastName, phoneNumber, email, streetAddress, city, state, zipCode, "Business");
        this.companyName = companyName;
        this.fax = fax;
        this.workRelated = workRelated;
    }

    //Getters
    public String getCompanyName() { return companyName; }
    public String getFax() { return fax; }
    public boolean isWorkRelated() { return workRelated; }

    //Display method
    @Override
    public void displayContact() {
        System.out.println("Relation: " + getRelation());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getStreetAddress() + ", " + getCity() + ", " + getState() + " " + getZipCode());
        System.out.println("Company: " + companyName);
        System.out.println("Fax: " + (fax != null ? fax : "N/A"));
        System.out.println("Work Related: " + (workRelated ? "Yes" : "No"));
    }
}