/*
 * Name: Jessie Sosniak
 * Date: 25 NOV 2025
 * Assignment: 3.2 Project
 * Description: Abstract class for personal contacts, adds birthday and nickname fields.
 */

public abstract class PersonalContact extends AbstractContact {
    private String birthday;   //optional, can be null
    private String nickname;   //optional, can be null

    //Constructor
    public PersonalContact(String firstName, String lastName, String phoneNumber, String email,
                           String streetAddress, String city, String state, String zipCode,
                           String relation, String birthday, String nickname) {
        super(firstName, lastName, phoneNumber, email, streetAddress, city, state, zipCode, relation);
        this.birthday = birthday;
        this.nickname = nickname;
    }

    //Getters
    public String getBirthday() { return birthday; }
    public String getNickname() { return nickname; }

    //Subclasses (FamilyContact, OtherContact) will implement displayContact()
    @Override
    public abstract void displayContact();
}