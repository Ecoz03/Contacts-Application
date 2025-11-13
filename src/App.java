/*
 * Name: Jessie Sosniak
 * Date: 13 NOV 2025
 * Assignment: 1.5 Project
 * Description: Week 1 demo application for Contacts project; demonstrates
 * inheritance, composition, and user interaction.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("======================================");
        System.out.println("   Sosniak's Digital Contact System   ");
        System.out.println("======================================\n");

        System.out.println("Instructions:");
        System.out.println("Type the number corresponding to the action you wish to perform.");
        System.out.println("Use 'X' to exit the application at any time from the main menu.");
        System.out.println("Use 'R' to return to the previous menu from any submenu.\n");

        boolean running = true;

        //Following loop ensures user can loop back to main menu.
        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Add a Sample Contact"); //Sample Contact for demo purposes
            System.out.println("2. Display All Contacts");
            System.out.println("X. Exit Application"); //Non-numeric to avoid accidental closure

            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    //Sample contact for Week 1 demo
                    BusinessContact sample = new BusinessContact(
                        "Jane", "Doe", "867-5309", "jane@email.com", "123 Main St.",
                        "Norfolk", "VA", "23510", 
                        "Doe Enterprises"
                    );
                    addressBook.addContact(sample);
                    System.out.println("Sample contact added. Input implementation to be added.\n");
                    break;
                case "2":
                    addressBook.displayAllContacts();
                    break;
                case "x":
                    System.out.print("Are you sure you want to exit the program? (Y/N)");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("y")) {
                        running = false; //exits the while loop and pushes to scanner.close();
                    }
                    else {
                        System.out.println("Exit canceled. Returning to main menu.\n");
                    }
                    break;
                default: 
                    System.out.println("Invalid input. Please try again.\n");
            }
        }

        scanner.close();
    }
}
