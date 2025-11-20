/*
 * Name: Jessie Sosniak
 * Date: 20 NOV 2025
 * Assignment: 2.2 Project
 * Description: Demonstrates menu-driven console application with interface (Verifiable)
 * and polymorphism (Contact vs BusinessContact).
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("======================================");
        System.out.println("   Project Week 2: Contacts System    ");
        System.out.println("   Author: Jessie Sosniak             ");
        System.out.println("======================================\n");

        System.out.println("Welcome to the Contacts Application!");
        System.out.println("Instructions:");
        System.out.println(" - Type the number of the action you want to perform.");
        System.out.println(" - Type 'X' to exit the application from the main menu.");
        System.out.println(" - Type 'R' to return to the main menu from any submenu.");
        System.out.println(" - Input is not case sensitive.\n");

        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Add a Contact");
            System.out.println("2. Remove a Contact");
            System.out.println("3. Update a Contact");
            System.out.println("4. Display Contacts");
            System.out.println("X. Exit Application");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    // Example: add a BusinessContact for demonstration
                    System.out.println("\nAdding a sample Business Contact...");
                    BusinessContact colleague = new BusinessContact(
                        "Bob", "Smith", "555-5678", "bob@company.com",
                        "100 Market Ave", "Norfolk", "VA", "23510",
                        "Smith Consulting"
                    );
                    addressBook.addContact(colleague);
                    System.out.println("Contact added!\n");
                    break;

                case "2":
                    System.out.println("\nRemove Contact feature not yet implemented.\n");
                    break;

                case "3":
                    System.out.println("\nUpdate Contact feature not yet implemented.\n");
                    break;

                case "4":
                    System.out.println("\nDisplaying all contacts:\n");
                    addressBook.displayAllContacts();
                    break;

                case "X":
                    System.out.print("\nAre you sure you want to exit the program? (Y/N): ");
                    String confirm = scanner.nextLine().trim().toUpperCase();
                    if (confirm.equals("Y")) {
                        running = false;
                        System.out.println("Exiting program. Goodbye!");
                    } else {
                        System.out.println("Exit cancelled.\n");
                    }
                    break;

                default:
                    System.out.println("\nInvalid input. Please try again.\n");
                    break;
            }
        }

        scanner.close();
    }
}
