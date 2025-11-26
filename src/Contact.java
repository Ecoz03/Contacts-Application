/*
 * Name: Jessie Sosniak
 * Date: 25 NOV 2025
 * Assignment: 2.2 Project
 * Description: Interface defining the contract for all contact types.
 */

public interface Contact {
    //Required getters
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getEmail();
    String getStreetAddress();
    String getCity();
    String getState();
    String getZipCode();
    String getRelation();

    //Display method (implemented differently by each subclass)
    void displayContact();
}