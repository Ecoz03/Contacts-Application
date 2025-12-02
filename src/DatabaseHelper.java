/*
 * Name: Jessie Sosniak
 * Date: 02 DEC 2025
 * Assignment: 4.2 Project
 * Description: Attaches the application to SQLite and handles initialization,
 * insert, display, search, remove, and update.
 */

import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:contacts.db";

    //Initialize database and create table if not exists
    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "firstName TEXT NOT NULL," +
                    "lastName TEXT NOT NULL," +
                    "phoneNumber TEXT NOT NULL," +
                    "email TEXT," +
                    "streetAddress TEXT," +
                    "city TEXT," +
                    "state TEXT," +
                    "zipCode TEXT," +
                    "relation TEXT NOT NULL," +
                    "companyName TEXT," +
                    "fax TEXT," +
                    "workRelated INTEGER," +
                    "birthday TEXT," +
                    "nickname TEXT" +
                    ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }

    //Insert a contact
    public static void insertContact(Contact contact) {
        String sql = "INSERT INTO contacts (firstName, lastName, phoneNumber, email, streetAddress, city, state, zipCode, relation, companyName, fax, workRelated, birthday, nickname) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contact.getFirstName());
            pstmt.setString(2, contact.getLastName());
            pstmt.setString(3, contact.getPhoneNumber());
            pstmt.setString(4, contact.getEmail());
            pstmt.setString(5, contact.getStreetAddress());
            pstmt.setString(6, contact.getCity());
            pstmt.setString(7, contact.getState());
            pstmt.setString(8, contact.getZipCode());
            pstmt.setString(9, contact.getRelation());

            if (contact instanceof BusinessContact) {
                BusinessContact bc = (BusinessContact) contact;
                pstmt.setString(10, bc.getCompanyName());
                pstmt.setString(11, bc.getFax());
                pstmt.setInt(12, bc.isWorkRelated() ? 1 : 0);
                pstmt.setNull(13, Types.VARCHAR);
                pstmt.setNull(14, Types.VARCHAR);
            } else if (contact instanceof PersonalContact) {
                PersonalContact pc = (PersonalContact) contact;
                pstmt.setNull(10, Types.VARCHAR);
                pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.INTEGER);
                pstmt.setString(13, pc.getBirthday());
                pstmt.setString(14, pc.getNickname());
            } else {
                pstmt.setNull(10, Types.VARCHAR);
                pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.INTEGER);
                pstmt.setNull(13, Types.VARCHAR);
                pstmt.setNull(14, Types.VARCHAR);
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }

    //Display all contacts (with ID shown)
    public static void displayAllContacts() {
        String sql = "SELECT * FROM contacts";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.isBeforeFirst()) {
                System.out.println("No contacts found.\n");
                return;
            }

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Relation: " + rs.getString("relation"));
                System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
                System.out.println("Phone: " + rs.getString("phoneNumber"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("streetAddress") + ", " + rs.getString("city") + ", " + rs.getString("state") + " " + rs.getString("zipCode"));
                if ("Business".equals(rs.getString("relation"))) {
                    System.out.println("Company: " + rs.getString("companyName"));
                    System.out.println("Fax: " + (rs.getString("fax") != null ? rs.getString("fax") : "N/A"));
                    System.out.println("Work Related: " + (rs.getInt("workRelated") == 1 ? "Yes" : "No"));
                } else {
                    System.out.println("Birthday: " + (rs.getString("birthday") != null ? rs.getString("birthday") : "N/A"));
                    System.out.println("Nickname: " + (rs.getString("nickname") != null ? rs.getString("nickname") : "N/A"));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Display error: " + e.getMessage());
        }
    }

    //Search by last initial (with ID shown)
    public static void searchByLastInitial(String initial) {
        String sql = "SELECT * FROM contacts WHERE lastName LIKE ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, initial + "%");
            ResultSet rs = pstmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("No contacts found with last initial '" + initial + "'.\n");
                return;
            }

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Relation: " + rs.getString("relation"));
                System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
                System.out.println("Phone: " + rs.getString("phoneNumber"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("streetAddress") + ", " + rs.getString("city") + ", " + rs.getString("state") + " " + rs.getString("zipCode"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    }

    //Remove a contact by ID
    public static void removeContact(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Contact removed successfully.\n");
            } else {
                System.out.println("No contact found with that ID.\n");
            }
        } catch (SQLException e) {
            System.out.println("Remove error: " + e.getMessage());
        }
    }

    //Update a contact by ID
    public static void updateContact(int id, Contact updatedContact) {
        String sql = "UPDATE contacts SET firstName=?, lastName=?, phoneNumber=?, email=?, streetAddress=?, city=?, state=?, zipCode=?, relation=?, companyName=?, fax=?, workRelated=?, birthday=?, nickname=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, updatedContact.getFirstName());
            pstmt.setString(2, updatedContact.getLastName());
            pstmt.setString(3, updatedContact.getPhoneNumber());
            pstmt.setString(4, updatedContact.getEmail());
            pstmt.setString(5, updatedContact.getStreetAddress());
            pstmt.setString(6, updatedContact.getCity());
            pstmt.setString(7, updatedContact.getState());
            pstmt.setString(8, updatedContact.getZipCode());
            pstmt.setString(9, updatedContact.getRelation());

            if (updatedContact instanceof BusinessContact) {
                BusinessContact bc = (BusinessContact) updatedContact;
                pstmt.setString(10, bc.getCompanyName());
                pstmt.setString(11, bc.getFax());
                pstmt.setInt(12, bc.isWorkRelated() ? 1 : 0);
                pstmt.setNull(13, Types.VARCHAR);
                pstmt.setNull(14, Types.VARCHAR);
            } else if (updatedContact instanceof PersonalContact) {
                PersonalContact pc = (PersonalContact) updatedContact;
                pstmt.setNull(10, Types.VARCHAR);
                pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.INTEGER);
                pstmt.setString(13, pc.getBirthday());
                pstmt.setString(14, pc.getNickname());
            } else {
                pstmt.setNull(10, Types.VARCHAR);
                pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.INTEGER);
                pstmt.setNull(13, Types.VARCHAR);
                pstmt.setNull(14, Types.VARCHAR);
            }

            pstmt.setInt(15, id);

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Contact updated successfully.\n");
            } else {
                System.out.println("No contact found with that ID.\n");
            }
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }
}