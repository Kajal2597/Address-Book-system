/*
Author -Kajal Gaikwad
Purpose-Ability to add a new
Contact to Address Book
*/
package com.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String email;
    private long phoneNumber;
    private String pinCode;

    public Contact(String firstName, String lastName, String city, String state, String email, long phoneNumber, String pinCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public Contact findContactByName(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contacts=" + contacts +
                '}';
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNewContact(scanner, addressBook);
                    break;
                case 2:
                    viewAllContacts(addressBook);
                    break;
                case 3:
                    editContact(scanner, addressBook);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addNewContact(Scanner scanner, AddressBook addressBook) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Pin Code: ");
        String pinCode = scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, city, state, email, phoneNumber, pinCode);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    private static void viewAllContacts(AddressBook addressBook) {
        System.out.println(addressBook);
    }

    private static void editContact(Scanner scanner, AddressBook addressBook) {
        System.out.print("Enter the First Name of the contact to edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the Last Name of the contact to edit: ");
        String lastName = scanner.nextLine();

        Contact contact = addressBook.findContactByName(firstName, lastName);

        if (contact != null) {
            System.out.println("Editing contact: " + contact);

            System.out.print("Enter new City (leave blank to keep current): ");
            String city = scanner.nextLine();
            if (!city.isBlank()) {
                contact.setCity(city);
            }

            System.out.print("Enter new State (leave blank to keep current): ");
            String state = scanner.nextLine();
            if (!state.isBlank()) {
                contact.setState(state);
            }

            System.out.print("Enter new Email (leave blank to keep current): ");
            String email = scanner.nextLine();
            if (!email.isBlank()) {
                contact.setEmail(email);
            }

            System.out.print("Enter new Phone Number (leave blank to keep current): ");
            String phoneNumberStr = scanner.nextLine();
            if (!phoneNumberStr.isBlank()) {
                long phoneNumber = Long.parseLong(phoneNumberStr);
                contact.setPhoneNumber(phoneNumber);
            }

            System.out.print("Enter new Pin Code (leave blank to keep current): ");
            String pinCode = scanner.nextLine();
            if (!pinCode.isBlank()) {
                contact.setPinCode(pinCode);
            }

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}