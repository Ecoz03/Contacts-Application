/*
 * Name: Jessie Sosniak
 * Date: 13 NOV 2025
 * Assignment: 1.5 Project
 * Description: Derived class representing a business contact; demonstrates
 * inheritance from Contact
 */

public class BusinessContact extends Contact{
    private String companyName;

    //Constructor
    public BusinessContact(String firstName, String lastName, String phone, String email,
    String streetAddress, String city, String state, String zipCode, String companyName) {
        //Inheritance: calling the base class constructor
        super(firstName, lastName, phone, email, streetAddress, city, state, zipCode);
        this.companyName = companyName;
    }

    //Getter
    public String getCompanyName() {
        return companyName;
    }

    //Setter
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //Override display method to include company name
    @Override
    public void displayContact() {
        super.displayContact(); //Call base method
        System.out.println("Relation: Work");
        System.out.println("Company: " + companyName);
    }
}
