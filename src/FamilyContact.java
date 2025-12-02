/*
 * Name: Jessie Sosniak
 * Date: 02 DEC 2025
 * Assignment: 4.2 Project
 * Description: Represents a family contact with relation fixed as "Family".
 */

public class FamilyContact extends PersonalContact {

    //Constructor
    public FamilyContact(String firstName, String lastName, String phoneNumber, String email,
                         String streetAddress, String city, String state, String zipCode,
                         String birthday, String nickname) {
        super(firstName, lastName, phoneNumber, email,
              streetAddress, city, state, zipCode,
              "Family", birthday, nickname);
    }

    //Display method
    @Override
    public void displayContact() {
        System.out.println("Relation: " + getRelation());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getStreetAddress() + ", " + getCity() + ", " + getState() + " " + getZipCode());
        System.out.println("Birthday: " + (getBirthday() != null ? getBirthday() : "N/A"));
        System.out.println("Nickname: " + (getNickname() != null ? getNickname() : "N/A"));
    }
}