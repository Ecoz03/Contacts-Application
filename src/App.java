/*
 * Name: Jessie Sosniak
 * Date: 02 DEC 2025
 * Assignment: 4.2 Project
 * Description: Main application with menu-driven interface for managing contacts.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean running = true;

        //Initialize database
        DatabaseHelper.initializeDatabase();

        //Title and instructions
        System.out.println("Author: Jessie Sosniak");
        System.out.println("Contacts Application Project\n");
        System.out.println("Instructions:");
        System.out.println(" - Type the number of the action you want to perform.");
        System.out.println(" - Type 'X' at the main menu to exit the application.");
        System.out.println(" - Type '<' in any submenu to return to the main menu.");
        System.out.println(" - Input is not case sensitive.\n");

        while (running) {
            //Main menu
            System.out.println("===== Address Book Menu =====");
            System.out.println("1. Add a Contact");
            System.out.println("2. Remove a Contact");
            System.out.println("3. Update a Contact");
            System.out.println("4. Display Contacts");
            System.out.println("X. Exit Application");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "1":
                    //Add Contact submenu
                    System.out.println("\n--- Add a Contact ---");
                    System.out.println("Type '<' to return to the main menu at any time.\n");

                    System.out.print("Is this a Business or Personal contact? (B/P or <): ");
                    String type = scanner.nextLine().trim().toUpperCase();
                    if (type.equals("<")) break;

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    if (firstName.equalsIgnoreCase("<")) break;

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    if (lastName.equalsIgnoreCase("<")) break;

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();
                    if (phone.equalsIgnoreCase("<")) break;

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (email.equalsIgnoreCase("<")) break;

                    System.out.print("Street Address: ");
                    String streetAddress = scanner.nextLine();
                    if (streetAddress.equalsIgnoreCase("<")) break;

                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    if (city.equalsIgnoreCase("<")) break;

                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    if (state.equalsIgnoreCase("<")) break;

                    System.out.print("Zip Code: ");
                    String zipCode = scanner.nextLine();
                    if (zipCode.equalsIgnoreCase("<")) break;

                    if (type.equals("B")) {
                        System.out.print("Company Name: ");
                        String companyName = scanner.nextLine();
                        if (companyName.equalsIgnoreCase("<")) break;

                        System.out.print("Fax (optional, press Enter to skip): ");
                        String fax = scanner.nextLine();
                        if (fax.equalsIgnoreCase("<")) break;
                        if (fax.isEmpty()) fax = null;

                        System.out.print("Work Related? (Y/N): ");
                        boolean workRelated = scanner.nextLine().trim().equalsIgnoreCase("Y");

                        BusinessContact businessContact = new BusinessContact(
                                firstName, lastName, phone, email,
                                streetAddress, city, state, zipCode,
                                companyName, fax, workRelated
                        );
                        addressBook.addContact(businessContact);
                        System.out.println("Business contact added successfully!\n");

                    } else if (type.equals("P")) {
                        System.out.print("Birthday (optional, press Enter to skip): ");
                        String birthday = scanner.nextLine();
                        if (birthday.equalsIgnoreCase("<")) break;
                        if (birthday.isEmpty()) birthday = null;

                        System.out.print("Nickname (optional, press Enter to skip): ");
                        String nickname = scanner.nextLine();
                        if (nickname.equalsIgnoreCase("<")) break;
                        if (nickname.isEmpty()) nickname = null;

                        System.out.print("Is this a Family or Other contact? (F/O or <): ");
                        String relationType = scanner.nextLine().trim().toUpperCase();
                        if (relationType.equals("<")) break;

                        if (relationType.equals("F")) {
                            FamilyContact familyContact = new FamilyContact(
                                    firstName, lastName, phone, email,
                                    streetAddress, city, state, zipCode,
                                    birthday, nickname
                            );
                            addressBook.addContact(familyContact);
                            System.out.println("Family contact added successfully!\n");
                        } else {
                            OtherContact otherContact = new OtherContact(
                                    firstName, lastName, phone, email,
                                    streetAddress, city, state, zipCode,
                                    birthday, nickname
                            );
                            addressBook.addContact(otherContact);
                            System.out.println("Other contact added successfully!\n");
                        }
                    } else {
                        System.out.println("Invalid contact type.\n");
                    }
                    break;
                case "2":
                    //Remove Contact submenu
                    System.out.println("\n--- Remove a Contact ---");
                    System.out.println("Type '<' to return to the main menu.\n");
                    addressBook.displayAllContacts();
                    System.out.print("Enter the ID of the contact to remove: ");
                    String idInput = scanner.nextLine().trim();
                    if (idInput.equals("<")) break;
                    try {
                        int id = Integer.parseInt(idInput);
                        addressBook.removeContact(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.\n");
                    }
                    break;

                case "3":
                    //Update Contact submenu
                    System.out.println("\n--- Update a Contact ---");
                    System.out.println("Type '<' to return to the main menu.\n");
                    addressBook.displayAllContacts();
                    System.out.print("Enter the ID of the contact to update: ");
                    String updateIdInput = scanner.nextLine().trim();
                    if (updateIdInput.equals("<")) break;
                    try {
                        int id = Integer.parseInt(updateIdInput);

                        System.out.print("Is this a Business or Personal contact? (B/P or <): ");
                        String typeUpdate = scanner.nextLine().trim().toUpperCase();
                        if (typeUpdate.equals("<")) break;

                        System.out.print("First Name: ");
                        String firstNameU = scanner.nextLine();
                        if (firstNameU.equalsIgnoreCase("<")) break;

                        System.out.print("Last Name: ");
                        String lastNameU = scanner.nextLine();
                        if (lastNameU.equalsIgnoreCase("<")) break;

                        System.out.print("Phone Number: ");
                        String phoneU = scanner.nextLine();
                        if (phoneU.equalsIgnoreCase("<")) break;

                        System.out.print("Email: ");
                        String emailU = scanner.nextLine();
                        if (emailU.equalsIgnoreCase("<")) break;

                        System.out.print("Street Address: ");
                        String streetAddressU = scanner.nextLine();
                        if (streetAddressU.equalsIgnoreCase("<")) break;

                        System.out.print("City: ");
                        String cityU = scanner.nextLine();
                        if (cityU.equalsIgnoreCase("<")) break;

                        System.out.print("State: ");
                        String stateU = scanner.nextLine();
                        if (stateU.equalsIgnoreCase("<")) break;

                        System.out.print("Zip Code: ");
                        String zipCodeU = scanner.nextLine();
                        if (zipCodeU.equalsIgnoreCase("<")) break;

                        if (typeUpdate.equals("B")) {
                            System.out.print("Company Name: ");
                            String companyNameU = scanner.nextLine();
                            if (companyNameU.equalsIgnoreCase("<")) break;

                            System.out.print("Fax (optional, press Enter to skip): ");
                            String faxU = scanner.nextLine();
                            if (faxU.equalsIgnoreCase("<")) break;
                            if (faxU.isEmpty()) faxU = null;

                            System.out.print("Work Related? (Y/N): ");
                            boolean workRelatedU = scanner.nextLine().trim().equalsIgnoreCase("Y");

                            BusinessContact updatedBusiness = new BusinessContact(
                                    firstNameU, lastNameU, phoneU, emailU,
                                    streetAddressU, cityU, stateU, zipCodeU,
                                    companyNameU, faxU, workRelatedU
                            );
                            addressBook.updateContact(id, updatedBusiness);
                        } else if (typeUpdate.equals("P")) {
                            System.out.print("Birthday (optional, press Enter to skip): ");
                            String birthdayU = scanner.nextLine();
                            if (birthdayU.equalsIgnoreCase("<")) break;
                            if (birthdayU.isEmpty()) birthdayU = null;

                            System.out.print("Nickname (optional, press Enter to skip): ");
                            String nicknameU = scanner.nextLine();
                            if (nicknameU.equalsIgnoreCase("<")) break;
                            if (nicknameU.isEmpty()) nicknameU = null;

                            System.out.print("Is this a Family or Other contact? (F/O or <): ");
                            String relationTypeU = scanner.nextLine().trim().toUpperCase();
                            if (relationTypeU.equals("<")) break;

                            if (relationTypeU.equals("F")) {
                                FamilyContact updatedFamily = new FamilyContact(
                                        firstNameU, lastNameU, phoneU, emailU,
                                        streetAddressU, cityU, stateU, zipCodeU,
                                        birthdayU, nicknameU
                                );
                                addressBook.updateContact(id, updatedFamily);
                            } else {
                                OtherContact updatedOther = new OtherContact(
                                        firstNameU, lastNameU, phoneU, emailU,
                                        streetAddressU, cityU, stateU, zipCodeU,
                                        birthdayU, nicknameU
                                );
                                addressBook.updateContact(id, updatedOther);
                            }
                        } else {
                            System.out.println("Invalid contact type.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.\n");
                    }
                    break;

                case "4":
                    boolean displayRunning = true;
                    while (displayRunning) {
                        System.out.println("\n--- Display Contacts ---");
                        System.out.println("1. Display All Contacts");
                        System.out.println("2. Search by Last Initial");
                        System.out.println("<. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        String displayChoice = scanner.nextLine().trim().toUpperCase();

                        switch (displayChoice) {
                            case "1":
                                addressBook.displayAllContacts();
                                break;
                            case "2":
                                System.out.print("Enter last initial: ");
                                String initial = scanner.nextLine().trim().toUpperCase();
                                addressBook.searchByLastInitial(initial);
                                break;
                            case "<":
                                displayRunning = false;
                                break;
                            default:
                                System.out.println("Invalid choice.\n");
                        }
                    }
                    break;

                case "X":
                    boolean confirmExit = false;
                    while (true) {
                        System.out.print("Are you sure you want to exit the program? (Y/N): ");
                        String confirm = scanner.nextLine().trim().toUpperCase();
                        if (confirm.equals("Y")) {
                            confirmExit = true;
                            break;
                        } else if (confirm.equals("N")) {
                            confirmExit = false;
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter Y or N.");
                        }
                    }
                    if (confirmExit) {
                        System.out.println("Exiting Contacts Application. Goodbye!");
                        running = false;
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }

}
