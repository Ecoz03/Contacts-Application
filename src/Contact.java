/*
 * Name: Jessie Sosniak
 * Date: 20 NOV 2025
 * Assignment: 2.2 Project
 * Description: Base class for all contact types, now implementing Verifiable.
 */

public class Contact implements Verifiable {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    protected String streetAddress;
    protected String city;
    protected String state;
    protected String zipCode;

    public Contact(String firstName, String lastName, String phone, String email,
                   String streetAddress, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public void displayContact() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + streetAddress + ", " + city + ", " + state + " " + zipCode);
    }

    @Override
    public boolean isVerified() {
        // Demonstrates interface implementation
        return firstName != null && !firstName.isEmpty()
            && lastName != null && !lastName.isEmpty()
            && email != null && email.contains("@");
    }
}