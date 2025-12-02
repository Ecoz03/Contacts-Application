/*
 * Name: Jessie Sosniak
 * Date: 02 DEC 2025
 * Assignment: 4.2 Project
 * Description: Manages a collection of contacts using composition.
 */

public class AddressBook {

    public AddressBook() {
        //No in-memory list needed anymore
    }

    public void addContact(Contact contact) {
        DatabaseHelper.insertContact(contact);
    }

    public void displayAllContacts() {
        DatabaseHelper.displayAllContacts();
    }

    public void searchByLastInitial(String initial) {
        DatabaseHelper.searchByLastInitial(initial);
    }

    public void removeContact(int id) {
        DatabaseHelper.removeContact(id);
    }

    public void updateContact(int id, Contact updatedContact) {
        DatabaseHelper.updateContact(id, updatedContact);
    }
}