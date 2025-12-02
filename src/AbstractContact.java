/*
 * Name: Jessie Sosniak
 * Date: 02 DEC 2025
 * Assignment: 4.2 Project
 * Description: Abstract base class implementing Contact interface and holding shared fields.
 */

public abstract class AbstractContact implements Contact {
    //Shared fields for all contacts
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String relation;

    //Constructor
    public AbstractContact(String firstName, String lastName, String phoneNumber, String email,
                           String streetAddress, String city, String state, String zipCode,
                           String relation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.relation = relation;
    }

    //Getters (required by Contact interface)
    @Override
    public String getFirstName() { return firstName; }

    @Override
    public String getLastName() { return lastName; }

    @Override
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String getEmail() { return email; }

    @Override
    public String getStreetAddress() { return streetAddress; }

    @Override
    public String getCity() { return city; }

    @Override
    public String getState() { return state; }

    @Override
    public String getZipCode() { return zipCode; }

    @Override
    public String getRelation() { return relation; }

    //Abstract methods to be implemented by subclasses
    @Override
    public abstract void displayContact();
}