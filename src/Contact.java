/*
 * Name: Jessie Sosniak
 * Date: 13 NOV 2025
 * Assignment: 1.5 Project
 * Description: Base class for all contact types in the Contacts Application
 */

public class Contact {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    protected String streetAddress;
    protected String city;
    protected String state;
    protected String zipCode;

    //Constructor
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

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipCode() {
        return zipCode;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //Method to display contact info
    public void displayContact(){
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + streetAddress + ", " + city + ", " + state + " " + zipCode);
    }
}