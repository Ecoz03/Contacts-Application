# Project Name: Contacts Application
## Project Description
This application serves to function as a "digital rolodex", where users can utilize CRUD operations to alter information that saves to a SQLite database. User interaction involves a series of menus driven by character input. This application allows users to store and manage personal and business contacts with persistence, making it useful for small businesses, students, or anyone who needs a lightweight contact manager without relying on corporate platforms.
## Project Tasks
- **Task 1: Include at least 3 contact types**
- Implements Personal and Business contacts, where Personal includes Family or Other.
- Business contacts can be notated as "Work-Related".
- **Task 2: Ability to add and remove contacts**
- Handled within main menu.
- Includes fillable fields to add a contact, for database table information.
- **Task 3: Ability to display contact information**
- Can display all contacts.
- Can display contacts searched by last initial.
- **Ability to update a contact**
- Can update specific portions of a contact through submenu selection.
- **Task 5: Inheritance implementation**
- FamilyContact and OtherContact extend PersonalContact, demonstrating specialzation of personal contacts.
- BusinessContact inherits from AbstractContact.
- **Task 6: Composition implementation**
- AddressBook composes DatabaseHelper to manage persistence operations.
- AddressBook delegates persistance operations to DatabaseHelper, separating concerns.
- **Task 7: Polymorphism implementation**
- displayContact() is overridden in each subclass, allowing the app to call the same method on different objects.
- App interacts with contacts via the Contact interface, regardless of type.
- **Task 8: Interface creation**
- User interface is implemented via CLI.
- **Task 9: Constructor implementation**
- Each contact type defines constructors to initialize shared and specific fields.
- **Task 10: Access specifier utilization**
- Fields are private and accessed through public getters, ensuring encapsulation.
- **Task 11: Abstract class implementation**
- AbstractContact defines shared fields and enforces displayContact().
- PersonalContact adds personal-specific fields but remains abstract.
- **Task 12: Database implementation**
- Database implementation achieved using SQLite database.
- "contacts.db" file included to showcase database functionality.
## Project Skills Learned
- Inheritance and composition concepts implemented within phase 1.
- Polymorphism and interface creation implemented within phase 2.
- Constructors, access specifiers, and abstract classes included within phase 3.
- Learned to integrate SQLite with JDBC in Java and debug SQL queries directly from VSCode.
- Utilization of VSCode to achieve all project goals and structure.
- Familiarization with GitHub to implement tagging and versions, as well as proper commits.
- Error handling for invalid user input and SQL exceptions.
- Designing a menu-driven CLI that balances usability and robustness.
- Transitioning from in-memory storage to persistent storage.
## Language Used
- **Java**: For front and backend development, as well as OOP principles.
- **SQL**: For database implementation using a SQLite database.
## Development Process Used
- **Iterative Development**: The project was developed iteratively in phases. Phase 1 focused on inheritance and composition, Phase 2 on polymorphism and interfaces, Phase 3 on constructors and abstract classes, and Phase 4 on database integration.
## Notes
- Application can be launched via compiling the main file: "App.java" and executing it from the CLI.
- SQLite database file (contacts.db) is auto-created if not present.
- Currently CLI-only, could be extended with a GUI.
## Link to Project
[GitHub Project Link](https://github.com/Ecoz03/Contacts-Application/releases/tag/Phase-Final)
## Link to Video
[Google Drive Link](https://drive.google.com/file/d/1oYb9ZAcbdpF_xKeRBOXyHIv1G-3jqisF/view?usp=sharing)


