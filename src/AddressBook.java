/*
 * Name: Jessie Sosniak
 * Date: 13 NOV 2025
 * Assignment: 1.5 Project
 * Description: Demonstrates composition by managing a list of Contact objects.
 */

import java.util.ArrayList;

public class AddressBook {
    //Composition: AddressBook contains Contact objects.
    private ArrayList<Contact> contacts;

    //Constructor
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    //Method to add a contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    //Method to display all contacts
    public void displayAllContacts() {
        int count = 1;
        for (Contact contact : contacts) {
            System.out.println("Contact " + count);
            contact.displayContact();
            System.out.println(); //Blank line between contacts
            count++;
        }
    }

    //Getter for contact list (optional for future use)
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
