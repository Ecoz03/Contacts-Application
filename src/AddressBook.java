/*
 * Name: Jessie Sosniak
 * Date: 20 NOV 2025
 * Assignment: 2.2 Project
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
        int count = 1;
        for (Contact contact : contacts) {
            System.out.println("Contact " + count);
            // Demonstrates polymorphism: calls displayContact() on base type
            contact.displayContact();
            // Demonstrates interface use: calls isVerified() polymorphically
            System.out.println("Verified: " + contact.isVerified());
            System.out.println();
            count++;
        }
    }
}