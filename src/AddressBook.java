/*
 * Name: Jessie Sosniak
 * Date: 25 NOV 2025
 * Assignment: 3.2 Project
 * Description: Manages a collection of contacts using composition.
 */

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        int count = 1;
        for (Contact contact : contacts) {
            System.out.println("Contact " + count);
            //Polymorphism: calls displayContact() on interface type
            contact.displayContact();
            System.out.println();
            count++;
        }
    }
}