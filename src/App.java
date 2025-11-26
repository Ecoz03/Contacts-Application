/*
 * Name: Jessie Sosniak
 * Date: 25 NOV 2025
 * Assignment: 3.2 Project
 * Description: Main application with menu-driven interface for managing contacts.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean running = true;

        //Title and instructions
        System.out.println("Author: Jessie Sosniak");
        System.out.println("Program: Week 3 Contacts Application Project\n");
        System.out.println("Instructions:");
        System.out.println(" - Type the number of the action you want to perform.");
        System.out.println(" - Type 'X' at the main menu to exit the application.");
        System.out.println(" - Type 'R' in any submenu to return to the main menu.");
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
                    System.out.println("Type 'R' to return to the main menu at any time.\n");

                    System.out.print("Is this a Business or Personal contact? (B/P or R): ");
                    String type = scanner.nextLine().trim().toUpperCase();
                    if (type.equals("R")) break;

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    if (firstName.equalsIgnoreCase("R")) break;

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    if (lastName.equalsIgnoreCase("R")) break;

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();
                    if (phone.equalsIgnoreCase("R")) break;

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (email.equalsIgnoreCase("R")) break;

                    System.out.print("Street Address: ");
                    String streetAddress = scanner.nextLine();
                    if (streetAddress.equalsIgnoreCase("R")) break;

                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    if (city.equalsIgnoreCase("R")) break;

                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    if (state.equalsIgnoreCase("R")) break;

                    System.out.print("Zip Code: ");
                    String zipCode = scanner.nextLine();
                    if (zipCode.equalsIgnoreCase("R")) break;

                    if (type.equals("B")) {
                        System.out.print("Company Name: ");
                        String companyName = scanner.nextLine();
                        if (companyName.equalsIgnoreCase("R")) break;

                        System.out.print("Fax (optional, press Enter to skip): ");
                        String fax = scanner.nextLine();
                        if (fax.equalsIgnoreCase("R")) break;
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
                        if (birthday.equalsIgnoreCase("R")) break;
                        if (birthday.isEmpty()) birthday = null;

                        System.out.print("Nickname (optional, press Enter to skip): ");
                        String nickname = scanner.nextLine();
                        if (nickname.equalsIgnoreCase("R")) break;
                        if (nickname.isEmpty()) nickname = null;

                        System.out.print("Is this a Family or Other contact? (F/O or R): ");
                        String relationType = scanner.nextLine().trim().toUpperCase();
                        if (relationType.equals("R")) break;

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
                    System.out.println("Remove Contact feature coming soon (Week 4).\n");
                    break;

                case "3":
                    System.out.println("Update Contact feature coming soon (Week 4).\n");
                    break;

                case "4":
                    System.out.println("\n--- Display Contacts ---");
                    addressBook.displayAllContacts();
                    System.out.println("Type 'R' to return to the main menu.\n");
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
                        System.out.println("Exiting Address Book. Goodbye!");
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